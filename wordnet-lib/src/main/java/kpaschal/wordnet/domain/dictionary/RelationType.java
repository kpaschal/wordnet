package kpaschal.wordnet.domain.dictionary;

import java.util.EnumMap;
import java.util.Map;

public enum RelationType {

    ANTONYM(1, "!", "ANTONYM", true, Pos.values()),
    HYPERNYM(2, "@", "HYPERNYM", false, new Pos[]{Pos.NOUN, Pos.VERB}),
    INSTANCE_HYPERNYM(3, "@i", "INSTANCE_HYPERNYM", false, new Pos[]{Pos.NOUN}),
    HYPONYM(4, "~", "HYPONYM", false, new Pos[]{Pos.NOUN, Pos.VERB}),
    INSTANCE_HYPONYM(5, "~i", "INSTANCE_HYPONYM", false, new Pos[]{Pos.NOUN}),
    MEMBER_HOLONYM(6, "#m", "MEMBER_HOLONYM", false, new Pos[]{Pos.NOUN}),
    SUBSTANCE_HOLONYM(7, "#s", "SUBSTANCE_HOLONYM", false, new Pos[]{Pos.NOUN}),
    PART_HOLONYM(8, "#p", "PART_HOLONYM", false, new Pos[]{Pos.NOUN}),
    HOLONYM(9, "#", "HOLONYM", false, new Pos[]{Pos.NOUN}),
    MEMBER_MERONYM(10, "%m", "MEMBER_MERONYM", false, new Pos[]{Pos.NOUN}),
    SUBSTANCE_MERONYM(11, "%s", "SUBSTANCE_MERONYM", false, new Pos[]{Pos.NOUN}),
    PART_MERONYM(12, "%p", "PART_MERONYM", false, new Pos[]{Pos.NOUN}),
    MERONYM(13, "%", "MERONYM", false, new Pos[]{Pos.NOUN}),
    ENTAILMENT(14, "*", "ENTAILMENT", false, new Pos[]{Pos.VERB}),
    CAUSE(15, ">", "CAUSE", false, new Pos[]{Pos.VERB}),
    VERB_GROUP(16, "$", "VERB_GROUP", false, new Pos[]{Pos.VERB}),
    PARTICIPLE_OF(17, "<", "PARTICIPLE_OF", true, new Pos[]{Pos.ADJECTIVE}),
    SIMILAR_TO(18, "&", "SIMILAR_TO", false, new Pos[]{Pos.ADJECTIVE}),
    ALSO_SEE(19, "^", "SEE_ALSO", true, new Pos[]{Pos.VERB, Pos.ADJECTIVE}),
    PERTAINYM(20, "\\", "PERTAINYM", true, new Pos[]{Pos.ADJECTIVE, Pos.ADVERB}),
    ATTRIBUTE(21, "=", "ATTRIBUTE", false, new Pos[]{Pos.NOUN, Pos.ADJECTIVE}),
    NOMINALIZATION(22, "+", "NOMINALIZATION", false, new Pos[]{Pos.NOUN, Pos.VERB}),
    CLASSIFICATION_CATEGORY(23, ";c", "CLASSIFICATION_CATEGORY", true, Pos.values()),
    CLASSIFICATION_USAGE(24, ";u", "CLASSIFICATION_USAGE", true, Pos.values()),
    CLASSIFICATION_REGION(25, ";r", "CLASSIFICATION_REGION", true, Pos.values()),
    CLASSIFICATION(26, ";", "CLASSIFICATION", true, Pos.values()),
    CLASS_CATEGORY(27, "-c", "CLASS_CATEGORY", false, new Pos[]{Pos.NOUN}),
    CLASS_USAGE(28, "-u", "CLASS_USAGE", false, new Pos[]{Pos.NOUN}),
    CLASS_REGION(29, "-r", "CLASS_REGION", false, new Pos[]{Pos.NOUN}),
    CLASS(30, "-", "CLASS", false, new Pos[]{Pos.NOUN});
    private final int key_;
    private final String symbol_;
    private final String label_;
    private final Pos[] pos_;
    private final boolean isLexical_;
    private static final Map<RelationType, RelationType> reflexivePointers_;

    static {
        reflexivePointers_ = new EnumMap<RelationType, RelationType>(RelationType.class);
        reflexivePointers_.put(ANTONYM, ANTONYM);
        reflexivePointers_.put(HYPONYM, HYPERNYM);
        reflexivePointers_.put(HYPERNYM, HYPONYM);
        reflexivePointers_.put(INSTANCE_HYPONYM, INSTANCE_HYPERNYM);
        reflexivePointers_.put(INSTANCE_HYPERNYM, INSTANCE_HYPONYM);
        reflexivePointers_.put(HOLONYM, MERONYM);
        reflexivePointers_.put(MERONYM, HOLONYM);
        reflexivePointers_.put(SIMILAR_TO, SIMILAR_TO);
        reflexivePointers_.put(ATTRIBUTE, ATTRIBUTE);
        reflexivePointers_.put(VERB_GROUP, VERB_GROUP);
        reflexivePointers_.put(NOMINALIZATION, NOMINALIZATION);// DERIVATIONALLY RELATED FORM
        //  reflexivePointers_.put(CLASSIFICATION_MEMBER, CLASSIFICATION_MEMBER);
    }

    private RelationType(int key, String symbol, String label, boolean isLexical, Pos[] pos) {
        key_ = key;
        symbol_ = symbol;
        label_ = label;
        isLexical_ = isLexical;
        pos_ = pos;
    }

    public int getKey() {
        return key_;
    }

    public String getSymbol() {
        return symbol_;
    }

    public String getLabel() {
        return label_;
    }

    public Pos[] getPos() {
        return pos_;
    }

    public boolean isLexical() {
        return isLexical_;
    }

    public boolean hasPos(Pos pos) {
        boolean rVal = false;
        for (Pos p : pos_) {
            if (p.equals(pos)) {
                rVal = true;
                break;
            }
        }
        return rVal;
    }

    public static RelationType getReflexivePointer(RelationType ptr) {
        return reflexivePointers_.get(ptr);
    }

    public static boolean hasReflexivePointer(RelationType ptr) {
        return reflexivePointers_.get(ptr) == null ? false : true;
    }

    public static RelationType getPointerTypeBySymbol(String symbol) {

        if (ANTONYM.getSymbol().equals(symbol)) {
            return ANTONYM;
        }
        if (HYPERNYM.getSymbol().equals(symbol)) {
            return HYPERNYM;
        }
        if (HYPONYM.getSymbol().equals(symbol)) {
            return HYPONYM;
        }
        if (ENTAILMENT.getSymbol().equals(symbol)) {
            return ENTAILMENT;
        }
        if (SIMILAR_TO.getSymbol().equals(symbol)) {
            return SIMILAR_TO;
        }
        if (MEMBER_HOLONYM.getSymbol().equals(symbol)) {
            return MEMBER_HOLONYM;
        }
        if (SUBSTANCE_HOLONYM.getSymbol().equals(symbol)) {
            return SUBSTANCE_HOLONYM;
        }
        if (PART_HOLONYM.getSymbol().equals(symbol)) {
            return PART_HOLONYM;
        }
        if (MEMBER_MERONYM.getSymbol().equals(symbol)) {
            return MEMBER_MERONYM;
        }
        if (SUBSTANCE_MERONYM.getSymbol().equals(symbol)) {
            return SUBSTANCE_MERONYM;
        }
        if (PART_MERONYM.getSymbol().equals(symbol)) {
            return PART_MERONYM;
        }
        if (CAUSE.getSymbol().equals(symbol)) {
            return CAUSE;
        }
        if (PARTICIPLE_OF.getSymbol().equals(symbol)) {
            return PARTICIPLE_OF;
        }
        if (ALSO_SEE.getSymbol().equals(symbol)) {
            return ALSO_SEE;
        }
        if (PERTAINYM.getSymbol().equals(symbol)) {
            return PERTAINYM;
        }
        if (ATTRIBUTE.getSymbol().equals(symbol)) {
            return ATTRIBUTE;
        }
        if (VERB_GROUP.getSymbol().equals(symbol)) {
            return VERB_GROUP;
        }
        if (NOMINALIZATION.getSymbol().equals(symbol)) {
            return NOMINALIZATION;
        }
        if (CLASSIFICATION.getSymbol().equals(symbol)) {
            return CLASSIFICATION;
        }
        if (CLASS.getSymbol().equals(symbol)) {
            return CLASS;
        }
        if (CLASSIFICATION_CATEGORY.getSymbol().equals(symbol)) {
            return CLASSIFICATION_CATEGORY;
        }
        if (CLASSIFICATION_USAGE.getSymbol().equals(symbol)) {
            return CLASSIFICATION_USAGE;
        }
        if (CLASSIFICATION_REGION.getSymbol().equals(symbol)) {
            return CLASSIFICATION_REGION;
        }
        if (CLASS_CATEGORY.getSymbol().equals(symbol)) {
            return CLASS_CATEGORY;
        }
        if (CLASS_USAGE.getSymbol().equals(symbol)) {
            return CLASS_USAGE;
        }
        if (CLASS_REGION.getSymbol().equals(symbol)) {
            return CLASS_REGION;
        }
        if (INSTANCE_HYPERNYM.getSymbol().equals(symbol)) {
            return INSTANCE_HYPERNYM;
        }
        if (INSTANCE_HYPONYM.getSymbol().equals(symbol)) {
            return INSTANCE_HYPONYM;
        }

        return null;
    }

    public static RelationType getPointerTypeByKey(int key) {

        if (ANTONYM.getKey() == key) {
            return ANTONYM;
        }
        if (HYPERNYM.getKey() == key) {
            return HYPERNYM;
        }
        if (HYPONYM.getKey() == key) {
            return HYPONYM;
        }
        if (ENTAILMENT.getKey() == key) {
            return ENTAILMENT;
        }
        if (SIMILAR_TO.getKey() == key) {
            return SIMILAR_TO;
        }
        if (MEMBER_HOLONYM.getKey() == key) {
            return MEMBER_HOLONYM;
        }
        if (SUBSTANCE_HOLONYM.getKey() == key) {
            return SUBSTANCE_HOLONYM;
        }
        if (PART_HOLONYM.getKey() == key) {
            return PART_HOLONYM;
        }
        if (MEMBER_MERONYM.getKey() == key) {
            return MEMBER_MERONYM;
        }
        if (SUBSTANCE_MERONYM.getKey() == key) {
            return SUBSTANCE_MERONYM;
        }
        if (PART_MERONYM.getKey() == key) {
            return PART_MERONYM;
        }
        if (CAUSE.getKey() == key) {
            return CAUSE;
        }
        if (PARTICIPLE_OF.getKey() == key) {
            return PARTICIPLE_OF;
        }
        if (ALSO_SEE.getKey() == key) {
            return ALSO_SEE;
        }
        if (PERTAINYM.getKey() == key) {
            return PERTAINYM;
        }
        if (ATTRIBUTE.getKey() == key) {
            return ATTRIBUTE;
        }
        if (VERB_GROUP.getKey() == key) {
            return VERB_GROUP;
        }
        if (NOMINALIZATION.getKey() == key) {
            return NOMINALIZATION;
        }
        if (CLASSIFICATION.getKey() == key) {
            return CLASSIFICATION;
        }
        if (CLASS.getKey() == key) {
            return CLASS;
        }
        if (CLASSIFICATION_CATEGORY.getKey() == key) {
            return CLASSIFICATION_CATEGORY;
        }
        if (CLASSIFICATION_USAGE.getKey() == key) {
            return CLASSIFICATION_USAGE;
        }
        if (CLASSIFICATION_REGION.getKey() == key) {
            return CLASSIFICATION_REGION;
        }
        if (CLASS_CATEGORY.getKey() == key) {
            return CLASS_CATEGORY;
        }
        if (CLASS_USAGE.getKey() == key) {
            return CLASS_USAGE;
        }
        if (CLASS_REGION.getKey() == key) {
            return CLASS_REGION;
        }
        if (INSTANCE_HYPERNYM.getKey() == key) {
            return INSTANCE_HYPERNYM;
        }
        if (INSTANCE_HYPONYM.getKey() == key) {
            return INSTANCE_HYPONYM;
        }

        return null;
    }

    @Override
    public String toString() {
        return label_;
    }
}