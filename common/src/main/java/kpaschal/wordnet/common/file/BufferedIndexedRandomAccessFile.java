package kpaschal.wordnet.common.file;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import uk.ac.ebi.pride.tools.braf.BufferedRandomAccessFile;

/**
 *
 * @author
 */
public class BufferedIndexedRandomAccessFile extends BufferedIndexedRandomAccessFileReader implements IRandomAccessFile {

    private static final String _EDIT_MODE = "rw";
    private boolean isEditable_;

    public BufferedIndexedRandomAccessFile(File file, ILineComparator comparator) {
        this(file, _READ_MODE, _DEFAULT_BUFFER_SIZE, comparator);
    }

    public BufferedIndexedRandomAccessFile(File file, String mode, int bufsize, ILineComparator comparator) {
        super(file, mode, bufsize, comparator);
        isEditable_ = false;
    }

    @Override
    public void edit() throws IOException {
        if (!isEditable_) {
            closeFile();
            braf_ = new BufferedRandomAccessFile(getFile(), _EDIT_MODE, getBufferSize());
        }
    }

    public boolean isEditable() {
        return isEditable_;
    }

    @Override
    public void save() throws IOException {
        if (isEditable()) {
            braf_.close();
            braf_ = new BufferedRandomAccessFile(getFile(), _READ_MODE, getBufferSize());
        }
    }

    @Override
    public void writeLine(String line) throws IOException {
        braf_.write(line.getBytes());
        braf_.writeBytes("\n");
    }

    @Override
    public void writeLines(Collection<String> lines) throws IOException {
        for (String s : lines) {
            writeLine(s);
        }
    }
}
