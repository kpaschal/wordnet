package kpaschal.wordnet.domain.dictionary;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface SynsetRepository {

    public Synset find(SynsetId synsetId);

    public void save(Synset synset);

    public void remove(SynsetId synsetId);

    public SynsetId nextSynsetId();

}
