package kpaschal.wordnet.common.file.comparators;

import kpaschal.wordnet.common.file.ILineComparator;

/**
 *
 * @author
 */
public class IntegerLineIndexComparator implements ILineComparator {

    private static IntegerLineIndexComparator instance_;

    public static IntegerLineIndexComparator getInstance() {
        return null != instance_ ? instance_ : new IntegerLineIndexComparator();
    }

    @Override
    public int compare(String o1, String o2) {
        Integer o1Index = Integer.parseInt(o1);
        Integer o2Index = Integer.parseInt(o2.substring(0, o2.indexOf(" ")));
        return o1Index.compareTo(o2Index);
    }
}