package kpaschal.wordnet.domain.dictionary;

public enum Pos {

    NOUN(1, "n", "Noun", "noun"),
    VERB(2, "v", "Verb", "verb"),
    ADJECTIVE(3, "a", "Adjective", "adj"),
    ADVERB(4, "r", "Adverb", "adv");
    private final int key_;
    private final String symbol_;
    private final String label_;
    private final String name_;

    private Pos(int key, String symbol, String label, String name) {
        key_ = key;
        symbol_ = symbol;
        label_ = label;
        name_ = name;
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

    public String getName() {
        return name_;
    }

    @Override
    public String toString() {
        return label_;
    }

    public static Pos getBySymbol(String symbol) {

        if (NOUN.getSymbol().equals(symbol)) {
            return NOUN;
        } else if (VERB.getSymbol().equals(symbol)) {
            return VERB;
        } else if (ADJECTIVE.getSymbol().equals(symbol)) {
            return ADJECTIVE;
        } else if (ADVERB.getSymbol().equals(symbol)) {
            return ADVERB;
        } else {
            return null;
        }
    }

    public static Pos getByKey(int key) {

        if (NOUN.getKey() == key) {
            return NOUN;
        } else if (VERB.getKey() == key) {
            return VERB;
        } else if (ADJECTIVE.getKey() == key) {
            return ADJECTIVE;
        } else if (ADVERB.getKey() == key) {
            return ADVERB;
        } else {
            return null;
        }
    }
}