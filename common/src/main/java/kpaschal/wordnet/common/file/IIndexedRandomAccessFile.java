package kpaschal.wordnet.common.file;

import java.io.IOException;

/**
 *
 * @author
 */
public interface IIndexedRandomAccessFile extends IRandomAccessFileReader {

    public void setComparator(ILineComparator comparator);

    public ILineComparator getComparator();

    public String readLine(String key) throws IOException;
}
