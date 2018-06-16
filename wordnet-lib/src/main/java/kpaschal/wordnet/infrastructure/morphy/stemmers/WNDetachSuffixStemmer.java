package kpaschal.wordnet.infrastructure.morphy.stemmers;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kpaschal.wordnet.domain.dictionary.Pos;

/**
 *
 * @author
 */
public class WNDetachSuffixStemmer extends DetachSuffixStemmer implements IStemmer {

    public WNDetachSuffixStemmer() {
        super(WNDetachmentRules.get());
    }

    @Override
    public List<String> stem(Pos pos, String derivation) {
        List<String> baseForms = new ArrayList<String>();
        String word = derivation;
        boolean nounsFulRule = false;
        // "ful" rule for nouns
        if (Pos.NOUN.equals(pos) && derivation.endsWith("ful")) {
            word = derivation.substring(0, derivation.length() - 3);
            nounsFulRule = true;
        }
        List<String> stems = super.stem(pos, word);
        for (String s : stems) {
            if (nounsFulRule) {
                s += "ful";
            }
            baseForms.add(s);
        }
        return baseForms;
    }

    public static class WNDetachmentRules {

        private static final String[][] _NOUN = new String[][]{{"s", ""},
        {"ses", "s"}, {"xes", "x"}, {"zes", "z"}, {"ches", "ch"}, {"shes", "sh"},
        {"men", "man"}, {"ies", "y"}};
        private static final String[][] _VERB = new String[][]{{"s", ""},
        {"ies", "y"}, {"es", "e"}, {"es", ""}, {"ed", "e"}, {"ed", ""},
        {"ing", "e"}, {"ing", ""}};
        private static final String[][] _ADJ = new String[][]{{"er", ""},
        {"est", ""}, {"er", "e"}, {"est", "e"}};
        private static final Map<Pos, String[][]> _RULES_MAP = new EnumMap<Pos, String[][]>(Pos.class);

        static {
            _RULES_MAP.put(Pos.NOUN, _NOUN);
            _RULES_MAP.put(Pos.VERB, _VERB);
            _RULES_MAP.put(Pos.ADJECTIVE, _ADJ);
        }

        public static String[][] get(Pos pos) {
            return _RULES_MAP.get(pos);
        }

        public static Map<Pos, String[][]> get() {
            return _RULES_MAP;
        }

        private WNDetachmentRules() {
        }
    }
}
