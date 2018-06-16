package kpaschal.wordnet.domain.semantics.similarity.measures;

/**
 *
 * @author
 */
public class LeacockAndChodorowMeasure {

    public static double calculate(int pathLength, int taxonomyDepth) {
        return -Math.log((double) pathLength / (2.0 * (double) taxonomyDepth));
    }
}
