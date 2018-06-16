package kpaschal.wordnet.infrastructure.dictionary.file;

/**
 *
 * @author
 */
public class PrincetonElementType {

    public static final PrincetonElementType WORD_INDEX = new PrincetonElementType("WORD_INDEX");
    public static final PrincetonElementType SYNSET = new PrincetonElementType("SYNSET");
    public static final PrincetonElementType EXCEPTION = new PrincetonElementType("EXCEPTION");
    public static final PrincetonElementType FRAME = new PrincetonElementType("FRAME");
    public static final PrincetonElementType SENSE_EXAMPLE = new PrincetonElementType("SENSE_EXAMPLE");
    public static final PrincetonElementType SENSE_INDEX = new PrincetonElementType("SENSE_INDEX");
    public static final PrincetonElementType SENSE_EXAMPLE_INDEX = new PrincetonElementType("SENSE_EXAMPLE_INDEX");
    private static final PrincetonElementType[] types_ = new PrincetonElementType[]{
        WORD_INDEX, SYNSET, EXCEPTION, FRAME, SENSE_EXAMPLE,
        SENSE_INDEX, SENSE_EXAMPLE_INDEX};

    public static PrincetonElementType[] values() {
        return types_;
    }

    public String getName() {
        return name_;
    }
    private final String name_;

    private PrincetonElementType(String label) {
        name_ = label;
    }
}
