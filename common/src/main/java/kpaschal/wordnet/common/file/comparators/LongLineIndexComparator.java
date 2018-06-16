package kpaschal.wordnet.common.file.comparators;

import kpaschal.wordnet.common.file.ILineComparator;

/**
 *
 * @author
 */
public class LongLineIndexComparator implements ILineComparator {

    private static LongLineIndexComparator instance_;

    public static LongLineIndexComparator getInstance() {
        return null != instance_ ? instance_ : new LongLineIndexComparator();
    }

    @Override
    public int compare(String o1, String o2) {
        Long o1Index = Long.parseLong(o1);
        Long o2Index = Long.parseLong(o2.substring(0,o2.indexOf(" ")));
        return o1Index.compareTo(o2Index);
    }
}
