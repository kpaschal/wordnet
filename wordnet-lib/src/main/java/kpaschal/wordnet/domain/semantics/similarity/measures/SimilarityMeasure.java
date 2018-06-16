package kpaschal.wordnet.domain.semantics.similarity.measures;

/**
 *
 * @author 
 */
public enum SimilarityMeasure {
    NONE("None"),
    PATH_LENGTH("Path length"),
    HIRST_AND_ST_ONGE("Hirst & St Onge"),
    LEACOCK_AND_CHODOROW("Leacock & Chodorow"),
    WU_AND_PALMER("Wu & Palmer");
    
    private final String label_;
    
    private SimilarityMeasure(String label){
        label_ = label;
    }
    
    public String getLabel(){
        return label_;
    }
}
