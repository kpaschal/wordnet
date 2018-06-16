package kpaschal.wordnet.infrastructure.morphy.stemmers;

import java.util.List;
import kpaschal.wordnet.domain.dictionary.Pos;

/**
 *
 * @author
 */
public interface IStemmer {

    public List<String> stem(Pos pos, String derivation);
}
