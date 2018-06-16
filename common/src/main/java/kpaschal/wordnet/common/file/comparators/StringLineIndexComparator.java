package kpaschal.wordnet.common.file.comparators;

import kpaschal.wordnet.common.file.ILineComparator;

/**
 *
 * @author
 */
public class StringLineIndexComparator implements ILineComparator {

    private static StringLineIndexComparator instance_;

    public static StringLineIndexComparator getInstance() {
        return instance_ != null ? instance_ : new StringLineIndexComparator();
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2.substring(0, o2.indexOf(" ")));
    }
}
