package kpaschal.wordnet.common.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author
 */
public abstract class AbstractFile implements IFile {

    private File file_;

    public AbstractFile(File file) {
        file_ = file;
    }

    protected abstract void openFile() throws IOException;

    protected abstract void closeFile();

    @Override
    public File getFile() {
        return file_;
    }

    @Override
    public void open() throws IOException {
        if (!isOpen()) {
            openFile();
        }
    }

    @Override
    public void delete() throws IOException {
        if (isOpen()) {
            close();
            delete();
        }
    }

    @Override
    public void close() {
        if (isOpen()) {
            closeFile();
        }
    }
}
