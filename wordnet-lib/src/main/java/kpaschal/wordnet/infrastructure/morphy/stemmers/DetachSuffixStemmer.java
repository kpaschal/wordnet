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
public class DetachSuffixStemmer implements IStemmer {

    private Map<Pos, String[][]> rules_;

    public DetachSuffixStemmer() {
        this(new EnumMap<Pos, String[][]>(Pos.class));
    }

    public DetachSuffixStemmer(Map<Pos, String[][]> rules) {
        rules_ = rules;
    }

    public void setRules(Map<Pos, String[][]> rules) {
        rules_ = rules;
    }

    public String[][] getRules(Pos pos) {
        return rules_.get(pos);
    }

    public Map<Pos, String[][]> getRules() {
        return rules_;
    }

    @Override
    public List<String> stem(Pos pos, String derivation) {
        List<String> baseForms = new ArrayList<String>();
        for (String[] rule : rules_.get(pos)) {
            if (derivation.endsWith(rule[0])) {
                baseForms.add(derivation.substring(0, derivation.length() - rule[0].length()) + rule[1]);
            }
        }
        return baseForms;
    }
}
