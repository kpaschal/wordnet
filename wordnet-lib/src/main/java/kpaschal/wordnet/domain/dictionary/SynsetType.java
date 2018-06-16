package kpaschal.wordnet.domain.dictionary;

public enum SynsetType {

    NOUN(Pos.NOUN.getKey(), Pos.NOUN.getSymbol(), Pos.NOUN.getLabel(), Pos.NOUN),
    VERB(Pos.VERB.getKey(), Pos.VERB.getSymbol(), Pos.VERB.getLabel(), Pos.VERB),
    ADJECTIVE(Pos.ADJECTIVE.getKey(), Pos.ADJECTIVE.getSymbol(), Pos.ADJECTIVE.getLabel(), Pos.ADJECTIVE),
    ADVERB(Pos.ADVERB.getKey(), Pos.ADVERB.getSymbol(), Pos.ADVERB.getLabel(), Pos.ADVERB),
    ADJECTIVE_SATELLITE(5, "s", "Adjective Satellite", Pos.ADJECTIVE);
    private final int key_;
    private final String symbol_;
    private final String label_;
    private final Pos pos_;

    private SynsetType(int key, String symbol, String label, Pos pos) {
        key_ = key;
        symbol_ = symbol;
        label_ = label;
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

    public Pos getPos() {
        return pos_;
    }

    public static Pos getPosBySymbol(String symbol) {

        if (NOUN.getSymbol().equals(symbol)) {
            return NOUN.getPos();
        } else if (VERB.getSymbol().equals(symbol)) {
            return VERB.getPos();
        } else if (ADJECTIVE.getSymbol().equals(symbol)) {
            return ADJECTIVE.getPos();
        } else if (ADVERB.getSymbol().equals(symbol)) {
            return ADVERB.getPos();
        } else if (ADJECTIVE_SATELLITE.getSymbol().equals(symbol)) {
            return ADJECTIVE_SATELLITE.getPos();
        } else {
            return null;
        }
    }

    public static Pos getPosByKey(int key) {

        if (NOUN.getKey() == key) {
            return NOUN.getPos();
        } else if (VERB.getKey() == key) {
            return VERB.getPos();
        } else if (ADJECTIVE.getKey() == key) {
            return ADJECTIVE.getPos();
        } else if (ADVERB.getKey() == key) {
            return ADVERB.getPos();
        }else if (ADJECTIVE_SATELLITE.getKey() == key) {
            return ADJECTIVE_SATELLITE.getPos();
        } else {
            return null;
        }
    }
    public static SynsetType getBySymbol(String symbol) {

        if (NOUN.getSymbol().equals(symbol)) {
            return NOUN;
        } else if (VERB.getSymbol().equals(symbol)) {
            return VERB;
        } else if (ADJECTIVE.getSymbol().equals(symbol)) {
            return ADJECTIVE;
        } else if (ADVERB.getSymbol().equals(symbol)) {
            return ADVERB;
        } else if (ADJECTIVE_SATELLITE.getSymbol().equals(symbol)) {
            return ADJECTIVE_SATELLITE;
        } else {
            return null;
        }
    }

    public static SynsetType getByKey(int key) {

        if (NOUN.getKey() == key) {
            return NOUN;
        } else if (VERB.getKey() == key) {
            return VERB;
        } else if (ADJECTIVE.getKey() == key) {
            return ADJECTIVE;
        } else if (ADVERB.getKey() == key) {
            return ADVERB;
        }else if (ADJECTIVE_SATELLITE.getKey() == key) {
            return ADJECTIVE_SATELLITE;
        } else {
            return null;
        }
    }
}