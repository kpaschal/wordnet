package kpaschal.wordnet.common.file;

import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author
 */
public interface IRandomAccessFile extends IRandomAccessFileReader {

    void edit() throws IOException;

    void save() throws IOException;

    void writeLine(String line) throws IOException;

    void writeLines(Collection<String> lines) throws IOException;
}
