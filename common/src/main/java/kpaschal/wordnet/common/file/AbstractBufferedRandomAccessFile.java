package kpaschal.wordnet.common.file;

import java.io.File;
import java.io.IOException;
import uk.ac.ebi.pride.tools.braf.BufferedRandomAccessFile;

/**
 *
 * @author
 */
public abstract class AbstractBufferedRandomAccessFile extends AbstractFile implements IRandomAccessFileReader {

    protected static int _DEFAULT_BUFFER_SIZE = 1024;
    protected BufferedRandomAccessFile braf_;
    protected static String _READ_MODE = "r";
    protected String mode_;
    protected int bufSize_;

    protected AbstractBufferedRandomAccessFile(File file) {
        this(file, _READ_MODE, _DEFAULT_BUFFER_SIZE);

    }

    protected AbstractBufferedRandomAccessFile(File file, String mode, int bufsize) {
        super(file);
        mode_ = mode;
        bufSize_ = bufsize;
    }

    public int getBufferSize() {
        return bufSize_;
    }

    @Override
    public void openFile() throws IOException {
        braf_ = new BufferedRandomAccessFile(super.getFile(), mode_, bufSize_);
    }

    @Override
    public boolean isOpen() {
        return null != braf_;
    }

    @Override
    public void closeFile() {
        if (null != braf_);
        {
            try {
                braf_.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public long getFilePointer() throws IOException {
        return braf_.getFilePointer();
    }

    @Override
    public long getLength() throws IOException {
        return braf_.length();
    }

    @Override
    public void seek(long offset) throws IOException {
        braf_.seek(offset);
    }

    @Override
    public void seekToEnd() throws IOException {
        braf_.seek(braf_.length());
    }

    @Override
    public void seekToStart() throws IOException {
        braf_.seek(0);
    }
}
