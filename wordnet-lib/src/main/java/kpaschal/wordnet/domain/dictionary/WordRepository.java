package kpaschal.wordnet.domain.dictionary;

import java.util.List;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface WordRepository {

    public Word find(String lemma);

    public List<String> findForDerivation(Pos pos, String derivation);

    public void save(Word word);

    public void remove(String lemma);
}
