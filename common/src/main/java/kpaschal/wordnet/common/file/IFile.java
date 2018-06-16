package kpaschal.wordnet.common.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author
 */
public interface IFile {

    File getFile();

    void open() throws IOException;

    boolean isOpen();

    void delete() throws IOException;

    void close();
}
