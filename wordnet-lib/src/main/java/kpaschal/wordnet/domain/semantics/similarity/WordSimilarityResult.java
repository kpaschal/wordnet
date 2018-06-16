package kpaschal.wordnet.domain.semantics.similarity;

import kpaschal.wordnet.domain.semantics.similarity.measures.SimilarityMeasure;
import kpaschal.wordnet.domain.semantics.path.IRelationPath;
import kpaschal.wordnet.domain.semantics.path.RelationPath;

/**
 *
 * @author
 */
public class WordSimilarityResult implements ISimilarityResult {

    SimilarityMeasure type_;
    private double value_;
    private IRelationPath path_;

    public WordSimilarityResult() {
        this(SimilarityMeasure.NONE, 0.0, new RelationPath());
    }

    public WordSimilarityResult(SimilarityMeasure type ){
        this( type, 0.0, new RelationPath());
    }
    public WordSimilarityResult(SimilarityMeasure type, double value, IRelationPath path) {
        type_ = type;
        value_ = value;
        path_ = path;
    }

    @Override
    public void setType(SimilarityMeasure type) {
        type_ = type;
    }

    @Override
    public void setValue(double value) {
        value_ = value;
    }

    public void setPath(IRelationPath path) {
        path_ = path;
    }

    @Override
    public SimilarityMeasure getType() {
        return type_;
    }

    @Override
    public double getValue() {
        return value_;
    }

    public IRelationPath getPath() {
        return path_;
    }
}
