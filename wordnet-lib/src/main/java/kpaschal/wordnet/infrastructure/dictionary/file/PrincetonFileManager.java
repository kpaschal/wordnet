package kpaschal.wordnet.infrastructure.dictionary.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 */
public class PrincetonFileManager {

    private Map<PrincetonFileType, PrincetonBufferedIndexedRandomAccessFile> fileSet_;
    private boolean isOpen_;

    public PrincetonFileManager(String filesPath) {
        fileSet_ = new HashMap<>();
        PrincetonBufferedIndexedRandomAccessFileFactory.getInstance().setPath(filesPath);
        for (PrincetonFileType fileType : PrincetonFileType.values()) {
            // fileSet_.add(fileType, create(fileType, filesPath));
            fileSet_.put(fileType, PrincetonBufferedIndexedRandomAccessFileFactory.getInstance().create(fileType));
        }
        isOpen_ = false;
    }

    public void open() throws IOException {
        for (PrincetonBufferedIndexedRandomAccessFile t : fileSet_.values()) {
            t.open();
        }
        isOpen_ = true;
    }

    public boolean isOpen() {
        return isOpen_;
    }

    public void close() {
        for (PrincetonBufferedIndexedRandomAccessFile t : fileSet_.values()) {
            t.close();
        }
        isOpen_ = false;
    }

    public List<PrincetonBufferedIndexedRandomAccessFile> getSources() {
        return (List) fileSet_.values();
    }

    public PrincetonBufferedIndexedRandomAccessFile getSource(PrincetonFileType type) {
        return fileSet_.get(type);
    }
}
