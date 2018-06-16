package kpaschal.wordnet.domain.ic;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface InformationContentRepository {

    public InformationContent find(long id);

    public void save(InformationContent ic);

    public void remove(long id);
}
