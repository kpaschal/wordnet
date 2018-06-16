package kpaschal.wordnet.common.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class BufferedIndexedRandomAccessFileReader extends AbstractBufferedRandomAccessFile implements IRandomAccessFileReader, IIndexedRandomAccessFile {

    private ILineComparator comparator_;

    public BufferedIndexedRandomAccessFileReader(File file, ILineComparator comparator) {
        super(file);
        comparator_ = comparator;
    }

    public BufferedIndexedRandomAccessFileReader(File file, String mode, int bufSize, ILineComparator comparator) {
        super(file, mode, bufSize);
        comparator_ = comparator;
    }

    @Override
    public void setComparator(ILineComparator comparator) {
        comparator_ = comparator;
    }

    @Override
    public ILineComparator getComparator() {
        return comparator_;
    }

    @Override
    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<String>();
        seekToStart();
        String line;
        while (null != (line = braf_.readLine())) {
            lines.add(line);
        }
        return lines;
    }

    @Override
    public String readLine(String key) throws IOException {
        String rLine = null;
        long top, mid, bot;
        String line;

        top = 0;
        bot = getLength();
        long tpos;
        while (top <= bot) {
            mid = (top + bot) / 2;
            braf_.seek(mid);

            while (getFilePointer() > 0 && (char) (braf_.read()) != '\n') { // file pointer at line's start
                tpos = getFilePointer() - 2;
                braf_.seek(0 > tpos ? 0 : tpos);
            }
            line = braf_.readLine();
            if (line == null) {
                break;
            }

            int cmp = comparator_.compare(key, line);
            if (cmp > 0) { // key is later 
                top = mid + 1;
            } else if (cmp < 0) { // key is before
                bot = mid - 1;
            } else { // key found
                rLine = line;
                break;
            }
        }
        return rLine;
    }

    @Override
    public String readLine(long offset) throws IOException {
        braf_.seek(offset);
        return braf_.readLine();
    }

    @Override
    public String readNext() throws IOException {
        return braf_.getNextLine();
    }
}
