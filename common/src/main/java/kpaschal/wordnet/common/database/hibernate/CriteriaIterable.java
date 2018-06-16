package kpaschal.wordnet.common.database.hibernate;

import java.util.Iterator;
import org.hibernate.Criteria;

/**
 * This class represents an {@link Iterable} for {@link CriteriaIterator}.
 *
 * @author
 *
 * @param <T> Class of the object that is iterated
 */
public class CriteriaIterable<T> implements Iterable<T> {

    private int bufferSize;
    private Criteria criteria;

    public CriteriaIterable(Criteria criteria, int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public Iterator<T> iterator() {

        return new CriteriaIterator<T>(criteria, bufferSize);
    }
}
