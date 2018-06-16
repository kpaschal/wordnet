package kpaschal.wordnet.domain.semantics.similarity.measures;

import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.semantics.path.IRelationPath;

/**
 *
 * @author
 */
public class HirstAndStOngeMeasure {

   
    public static double calculate(int maxDistance, int maxDirectionChanges, int pathLength, int directionChanges) {
        return maxDistance - pathLength - maxDirectionChanges * directionChanges;
    }

    public static int getDirectionChanges(IRelationPath path) {
        if (null == path || 1 >= path.getLength()) {
            return -1;
        }
        RelationType curRelType = path.getPath().get(1).getRelationType();
        int directionsCnt = 0;
        for (int i = 2; i < path.getPath().size(); i++) {
            if (null!=path.getPath().get(i).getRelationType() && !curRelType.equals(path.getPath().get(i).getRelationType())) {
                directionsCnt++;
                curRelType = path.getPath().get(i).getRelationType();
            }
        }
        return directionsCnt;
    }
}
