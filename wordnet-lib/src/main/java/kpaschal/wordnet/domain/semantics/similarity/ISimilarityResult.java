package kpaschal.wordnet.domain.semantics.similarity;

import kpaschal.wordnet.domain.semantics.similarity.measures.SimilarityMeasure;

/**
 *
 * @author
 */
public interface ISimilarityResult {

    SimilarityMeasure getType();

    double getValue();

    void setType(SimilarityMeasure type);

    void setValue(double value);
}
