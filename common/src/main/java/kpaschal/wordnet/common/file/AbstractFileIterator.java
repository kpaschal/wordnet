package kpaschal.wordnet.common.file;

import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author
 */
public abstract class AbstractFileIterator<T> implements Iterator<T> {

    protected String currentLine;
    protected long nextOffset;
    protected IRandomAccessFile fileAccess;

    public AbstractFileIterator(IRandomAccessFile fileAccess) throws IOException {
        this.fileAccess = fileAccess;
        currentLine = fileAccess.readNext();
        nextOffset = fileAccess.getFilePointer();
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public long getNextOffset() {
        return nextOffset;
    }

    public IRandomAccessFile getFileAccess() {
        return fileAccess;
    }

    @Override
    public boolean hasNext() {
        try {
            if (null != currentLine) {
                return true;
            } else if (nextOffset == fileAccess.getLength()) { // end of file
                return false;
            } else { // get next line
                String line = fileAccess.readLine(nextOffset);
                nextOffset = fileAccess.getFilePointer();
                if (null == line) { // end of file
                    return false;
                } else { // save line
                    currentLine = line;
                    return true;
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException(ex.toString());
        }
    }

    @Override
    public T next() {
        String line = currentLine;
        currentLine = null;
        T t = parseLine(line);
        return t;
    }

    public abstract T parseLine(String line);

    @Override
    public abstract void remove();
}
