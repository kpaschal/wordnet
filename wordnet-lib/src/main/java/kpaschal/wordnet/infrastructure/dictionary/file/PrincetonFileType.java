package kpaschal.wordnet.infrastructure.dictionary.file;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kpaschal.wordnet.domain.dictionary.Pos;

/**
 *
 *
 * @author
 */
public class PrincetonFileType {

    public static final PrincetonFileType WORD_INDEX_NOUN = new PrincetonFileType("WORD_INDEX_NOUN", PrincetonElementType.WORD_INDEX, "index.noun", Pos.NOUN);
    public static final PrincetonFileType WORD_INDEX_VERB = new PrincetonFileType("WORD_INDEX_VERB", PrincetonElementType.WORD_INDEX, "index.verb", Pos.VERB);
    public static final PrincetonFileType WORD_INDEX_ADJECTIVE = new PrincetonFileType("WORD_INDEX_ADJECTIVE", PrincetonElementType.WORD_INDEX, "index.adj", Pos.ADJECTIVE);
    public static final PrincetonFileType WORD_INDEX_ADVERB = new PrincetonFileType("WORD_INDEX_ADVERB", PrincetonElementType.WORD_INDEX, "index.adv", Pos.ADVERB);
    public static final PrincetonFileType DATA_NOUN = new PrincetonFileType("DATA_NOUN", PrincetonElementType.SYNSET, "data.noun", Pos.NOUN);
    public static final PrincetonFileType DATA_VERB = new PrincetonFileType("DATA_VERB", PrincetonElementType.SYNSET, "data.verb", Pos.VERB);
    public static final PrincetonFileType DATA_ADJECTIVE = new PrincetonFileType("DATA_ADJECTIVE", PrincetonElementType.SYNSET, "data.adj", Pos.ADJECTIVE);
    public static final PrincetonFileType DATA_ADVERB = new PrincetonFileType("DATA_ADVERB", PrincetonElementType.SYNSET, "data.adv", Pos.ADVERB);
    public static final PrincetonFileType EXCEPTION_NOUN = new PrincetonFileType("EXCEPTION_NOUN", PrincetonElementType.EXCEPTION, "noun.exc", Pos.NOUN);
    public static final PrincetonFileType EXCEPTION_VERB = new PrincetonFileType("EXCEPTION_VERB", PrincetonElementType.EXCEPTION, "verb.exc", Pos.VERB);
    public static final PrincetonFileType EXCEPTION_ADJECTIVE = new PrincetonFileType("EXCEPTION_ADJECTIVE", PrincetonElementType.EXCEPTION, "adj.exc", Pos.ADJECTIVE);
    public static final PrincetonFileType EXCEPTION_ADVERB = new PrincetonFileType("EXCEPTION_ADVERB", PrincetonElementType.EXCEPTION, "adv.exc", Pos.ADVERB);
    public static final PrincetonFileType FRAME = new PrincetonFileType("FRAME", PrincetonElementType.FRAME, "frames.vrb", null);
    public static final PrincetonFileType SENSE_EXAMPLE = new PrincetonFileType("sents", PrincetonElementType.SENSE_EXAMPLE, "sents.vrb", null);
    public static final PrincetonFileType SENSE_INDEX = new PrincetonFileType("SENSE_INDEX", PrincetonElementType.SENSE_INDEX, "index.sense", null);
    public static final PrincetonFileType SENSE_EXAMPLE_INDEX = new PrincetonFileType("SENSE_EXAMPLE_INDEX", PrincetonElementType.SENSE_EXAMPLE_INDEX, "sentidx.vrb", null);
    private static final PrincetonFileType[] values_ = new PrincetonFileType[]{
        WORD_INDEX_NOUN, WORD_INDEX_VERB, WORD_INDEX_ADJECTIVE, WORD_INDEX_ADVERB,
        DATA_NOUN, DATA_VERB, DATA_ADJECTIVE, DATA_ADVERB,
        EXCEPTION_NOUN, EXCEPTION_VERB, EXCEPTION_ADJECTIVE, EXCEPTION_ADVERB,
        FRAME, SENSE_EXAMPLE, SENSE_INDEX, SENSE_EXAMPLE_INDEX};
    private static final Map<PrincetonElementType, PrincetonFileType> elementTypeMap_;
    private static final Map<PrincetonElementType, Map<Pos, PrincetonFileType>> elementTypePosMap_;

    static {
        elementTypeMap_ = new HashMap<PrincetonElementType, PrincetonFileType>();
        elementTypeMap_.put(PrincetonElementType.FRAME, FRAME);
        elementTypeMap_.put(PrincetonElementType.SENSE_EXAMPLE, SENSE_EXAMPLE);
        elementTypeMap_.put(PrincetonElementType.SENSE_INDEX, SENSE_INDEX);

        Map<Pos, PrincetonFileType> wordIndexPosMap = new EnumMap<Pos, PrincetonFileType>(Pos.class);
        wordIndexPosMap.put(Pos.NOUN, WORD_INDEX_NOUN);
        wordIndexPosMap.put(Pos.VERB, WORD_INDEX_VERB);
        wordIndexPosMap.put(Pos.ADJECTIVE, WORD_INDEX_ADJECTIVE);
        wordIndexPosMap.put(Pos.ADVERB, WORD_INDEX_ADVERB);

        Map<Pos, PrincetonFileType> dataPosMap = new EnumMap<Pos, PrincetonFileType>(Pos.class);
        dataPosMap.put(Pos.NOUN, DATA_NOUN);
        dataPosMap.put(Pos.VERB, DATA_VERB);
        dataPosMap.put(Pos.ADJECTIVE, DATA_ADJECTIVE);
        dataPosMap.put(Pos.ADVERB, DATA_ADVERB);

        Map<Pos, PrincetonFileType> excPosMap = new EnumMap<Pos, PrincetonFileType>(Pos.class);
        excPosMap.put(Pos.NOUN, EXCEPTION_NOUN);
        excPosMap.put(Pos.VERB, EXCEPTION_VERB);
        excPosMap.put(Pos.ADJECTIVE, EXCEPTION_ADJECTIVE);
        excPosMap.put(Pos.ADVERB, EXCEPTION_ADVERB);

        elementTypePosMap_ = new HashMap<PrincetonElementType, Map<Pos, PrincetonFileType>>();
        elementTypePosMap_.put(PrincetonElementType.WORD_INDEX, wordIndexPosMap);
        elementTypePosMap_.put(PrincetonElementType.SYNSET, dataPosMap);
        elementTypePosMap_.put(PrincetonElementType.EXCEPTION, excPosMap);
    }

    public static PrincetonFileType getWordIndexForPos(Pos pos) {
        switch (pos) {
            case NOUN:
                return WORD_INDEX_NOUN;
            case VERB:
                return WORD_INDEX_VERB;
            case ADJECTIVE:
                return WORD_INDEX_ADJECTIVE;
            case ADVERB:
                return WORD_INDEX_ADVERB;
            default:
                return null;
        }
    }

    public static PrincetonFileType getDataForPos(Pos pos) {
        switch (pos) {
            case NOUN:
                return DATA_NOUN;
            case VERB:
                return DATA_VERB;
            case ADJECTIVE:
                return DATA_ADJECTIVE;
            case ADVERB:
                return DATA_ADVERB;
            default:
                return null;
        }
    }

    public static PrincetonFileType getExceptionForPos(Pos pos) {
        switch (pos) {
            case NOUN:
                return EXCEPTION_NOUN;
            case VERB:
                return EXCEPTION_VERB;
            case ADJECTIVE:
                return EXCEPTION_ADJECTIVE;
            case ADVERB:
                return EXCEPTION_ADVERB;
            default:
                return null;
        }
    }

    public static PrincetonFileType[] getWordIndex() {
        return new PrincetonFileType[]{WORD_INDEX_NOUN, WORD_INDEX_VERB, WORD_INDEX_ADJECTIVE, WORD_INDEX_ADVERB};
    }

    public static PrincetonFileType[] getData() {
        return new PrincetonFileType[]{DATA_NOUN, DATA_VERB, DATA_ADJECTIVE, DATA_ADVERB};
    }

    public static PrincetonFileType[] getException() {
        return new PrincetonFileType[]{EXCEPTION_NOUN, EXCEPTION_VERB, EXCEPTION_ADJECTIVE, EXCEPTION_ADVERB};
    }

    public static boolean isWordIndex(PrincetonFileType type) {
        if (type.equals(WORD_INDEX_NOUN) || type.equals(WORD_INDEX_VERB)
                || type.equals(WORD_INDEX_ADJECTIVE) || type.equals(WORD_INDEX_ADVERB)) {
            return true;
        }
        return false;
    }

    public static boolean isData(PrincetonFileType type) {
        if (type.equals(DATA_NOUN) || type.equals(DATA_VERB)
                || type.equals(DATA_ADJECTIVE) || type.equals(DATA_ADVERB)) {
            return true;
        }
        return false;
    }

    public static boolean isException(PrincetonFileType type) {
        if (type.equals(EXCEPTION_NOUN) || type.equals(EXCEPTION_VERB)
                || type.equals(EXCEPTION_ADJECTIVE) || type.equals(EXCEPTION_ADVERB)) {
            return true;
        }
        return false;
    }

    public static PrincetonFileType getForElementTypePos(PrincetonElementType elementType, Pos pos) {
        if (null != pos) {
            return elementTypePosMap_.get(elementType).get(pos);
        } else {
            return elementTypeMap_.get(elementType);
        }
    }

    public static PrincetonFileType[] values() {
        return values_;
    }

    public static PrincetonFileType[] values(PrincetonElementType type) {
        List<PrincetonFileType> types = new ArrayList<PrincetonFileType>();
        for (PrincetonFileType t : values_) {
            if (t.getWNElementType().equals(type)) {
                types.add(t);
            }
        }
        return (PrincetonFileType[]) types.toArray();
    }

    public static PrincetonFileType[] values(Pos pos) {
        List<PrincetonFileType> types = new ArrayList<PrincetonFileType>();
        for (PrincetonFileType t : values_) {
            if (t.getPos().equals(pos)) {
                types.add(t);
            }
        }
        return (PrincetonFileType[]) types.toArray();
    }

    public String getName() {
        return name_;
    }

    public Pos getPos() {
        return pos_;
    }

    public PrincetonElementType getWNElementType() {
        return elementType_;
    }

    public String getHint() {
        return hint_;
    }
    private final String name_;
    private final Pos pos_;
    private final String hint_;
    private final PrincetonElementType elementType_;

    private PrincetonFileType(String name, PrincetonElementType elementType, String hint, Pos pos) {
        name_ = name;
        elementType_ = elementType;
        pos_ = pos;
        hint_ = hint;
    }
}
