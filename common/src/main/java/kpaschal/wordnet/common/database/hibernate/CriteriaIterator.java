package kpaschal.wordnet.common.database.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 */
public class CriteriaIterator<T> implements Iterator<T> {

    private int bufferSize;
    private Criteria criteria;
    private Iterator<T> resultIterator;
    private int currentResult;

    public CriteriaIterator(Criteria criteria, int bufferSize) {
        this.bufferSize = bufferSize;
        this.criteria = criteria;
        this.currentResult = 0;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = resultIterator == null ? false : resultIterator.hasNext();
        if (!hasNext) {
            hasNext = getNextResults();
        }
        return hasNext;
    }

    @Override
    public T next() {
        currentResult++;
        return resultIterator.next();
    }

    private boolean getNextResults() {
        List result = criteria.setFirstResult(currentResult)
                .setMaxResults(bufferSize).list();
        if (result.isEmpty()) {
            return false;
        }
        resultIterator = result.iterator();
        return true;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
