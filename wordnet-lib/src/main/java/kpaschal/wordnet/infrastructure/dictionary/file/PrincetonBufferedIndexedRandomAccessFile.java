package kpaschal.wordnet.infrastructure.dictionary.file;

import java.io.File;
import kpaschal.wordnet.common.file.BufferedIndexedRandomAccessFile;
import kpaschal.wordnet.common.file.ILineComparator;

/**
 *
 * @author
 */
public class PrincetonBufferedIndexedRandomAccessFile extends BufferedIndexedRandomAccessFile{

    private PrincetonFileType type_;

    public PrincetonBufferedIndexedRandomAccessFile(PrincetonFileType type, File file, ILineComparator comparator) {
        super(file, comparator);
        type_ = type;
    }
 
    public PrincetonFileType getType() {
        return type_;
    }
    
}