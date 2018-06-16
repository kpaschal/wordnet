package kpaschal.wordnet.domain.dictionary;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface ExampleRepository {

    public Example find(ExampleId exampleId);

    public void save(Example example);

    public void remove(ExampleId exampleId);

    public ExampleId nextExampleId();

}
