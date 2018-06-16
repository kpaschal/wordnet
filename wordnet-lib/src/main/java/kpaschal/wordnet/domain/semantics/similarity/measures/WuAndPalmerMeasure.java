package kpaschal.wordnet.domain.semantics.similarity.measures;

/**
 *
 * @author
 */
public class WuAndPalmerMeasure {

    public static double calculate(int lsaDepth, int sourceDepth, int targetDepth) {
        return (double) (2 * lsaDepth) / (double) (sourceDepth + targetDepth);
    }
}
