package kpaschal.wordnet.common.file;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author
 */
public interface IRandomAccessFileReader extends IFile {
    
     
    long getFilePointer() throws IOException;

    long getLength() throws IOException;

    void seek(long offset) throws IOException;

    void seekToEnd() throws IOException;

    void seekToStart() throws IOException;

    String readLine(long offset) throws IOException;

    List<String> readLines() throws IOException;

    String readNext() throws IOException;
}
