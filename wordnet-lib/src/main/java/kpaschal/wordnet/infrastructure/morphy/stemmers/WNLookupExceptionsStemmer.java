package kpaschal.wordnet.infrastructure.morphy.stemmers;

import java.util.List;
import kpaschal.wordnet.domain.dictionary.Pos;
import kpaschal.wordnet.domain.dictionary.WordRepository;

/**
 *
 * @author
 */
/**
 *
 * @author
 */
public class WNLookupExceptionsStemmer implements IStemmer {

    private WordRepository wordRepository;

    public WNLookupExceptionsStemmer(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<String> stem(Pos pos, String derivation) {
        return wordRepository.findForDerivation(pos, derivation);
    }
}
