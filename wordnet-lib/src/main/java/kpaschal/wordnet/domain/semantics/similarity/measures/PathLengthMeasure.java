package kpaschal.wordnet.domain.semantics.similarity.measures;

/**
 *
 * @author
 */
public class PathLengthMeasure {

    public static double calculate(int pathLength) {
        if (0 == pathLength) {
            return 0;
        }
        return 1.0 / (double) pathLength;
    }

    public static double calculate(int pathLength, int taxonomyDepth) {
        return 2 * taxonomyDepth - pathLength;
    }
}
