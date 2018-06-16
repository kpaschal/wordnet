package kpaschal.wordnet.application;

import java.util.List;
import kpaschal.wordnet.domain.dictionary.Pos;
import kpaschal.wordnet.domain.dictionary.WordPos;

/**
 *
 * @author
 */
public interface MorphologicalProcessor {

    List<WordPos> lookup(Pos pos, String derivation);

}
