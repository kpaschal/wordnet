package kpaschal.wordnet.infrastructure.dictionary.file;

import java.io.File;
import kpaschal.wordnet.common.file.ILineComparator;
import kpaschal.wordnet.common.file.comparators.IntegerLineIndexComparator;
import kpaschal.wordnet.common.file.comparators.LongLineIndexComparator;
import kpaschal.wordnet.common.file.comparators.StringLineIndexComparator;

/**
 *
 * @author
 */
public class PrincetonBufferedIndexedRandomAccessFileFactory {

    private static String filesPath_;
    private static PrincetonBufferedIndexedRandomAccessFileFactory instance_;

    public static PrincetonBufferedIndexedRandomAccessFileFactory getInstance() {
        return null != instance_ ? instance_ : new PrincetonBufferedIndexedRandomAccessFileFactory();
    }

    public void setPath(String filesPath) {
        filesPath_ = filesPath;
    }

    public String getPath() {
        return filesPath_;
    }

    public PrincetonBufferedIndexedRandomAccessFile create(PrincetonFileType type) {
        return new PrincetonBufferedIndexedRandomAccessFile(type, new File(createFileName(type, filesPath_)), getComparator(type));
    }

    private String createFileName(PrincetonFileType fileType, String filePath) {
        String fileName = filePath + "/";

        if (null != fileType.getPos()) {
            if (PrincetonFileType.isWordIndex(fileType)) {
                fileName += "index." + fileType.getPos().getName();
            }
            if (PrincetonFileType.isData(fileType)) {
                fileName += "data." + fileType.getPos().getName();
            }
            if (PrincetonFileType.isException(fileType)) {
                fileName += fileType.getPos().getName() + ".exc";
            }

        } else {
            if (PrincetonFileType.SENSE_INDEX.equals(fileType)) {
                fileName += "index.sense";
            }
            if (PrincetonFileType.FRAME.equals(fileType)) {
                fileName += "frames.vrb";
            }
            if (PrincetonFileType.SENSE_EXAMPLE.equals(fileType)) {
                fileName += "sents.vrb";
            }
            if (PrincetonFileType.SENSE_EXAMPLE_INDEX.equals(fileType)) {
                fileName += "sentidx.vrb";
            }
        }
        return fileName;
    }

    private ILineComparator getComparator(PrincetonFileType fileType) {
        if (PrincetonFileType.isWordIndex(fileType)) {
            return StringLineIndexComparator.getInstance();
        } else if (PrincetonFileType.isData(fileType)) {
            return LongLineIndexComparator.getInstance();
        } else if (PrincetonFileType.isException(fileType)) {
            return StringLineIndexComparator.getInstance();
        } else if (PrincetonFileType.SENSE_INDEX.equals(fileType)) {
            return StringLineIndexComparator.getInstance();
        } else if (PrincetonFileType.FRAME.equals(fileType)) {
            return IntegerLineIndexComparator.getInstance();
        } else if (PrincetonFileType.SENSE_EXAMPLE.equals(fileType)) {
            return IntegerLineIndexComparator.getInstance();
        } else {
            return null;
        }
    }
}
