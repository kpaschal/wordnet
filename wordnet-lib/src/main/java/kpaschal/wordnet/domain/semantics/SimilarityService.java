package kpaschal.wordnet.domain.semantics;

import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.path.IRelationPath;
import kpaschal.wordnet.domain.semantics.path.RelationCAPath;
import kpaschal.wordnet.domain.semantics.path.RelationPathList;
import kpaschal.wordnet.domain.semantics.similarity.WordSimilarityResult;
import kpaschal.wordnet.domain.semantics.similarity.measures.HirstAndStOngeMeasure;
import kpaschal.wordnet.domain.semantics.similarity.measures.LeacockAndChodorowMeasure;
import kpaschal.wordnet.domain.semantics.similarity.measures.PathLengthMeasure;
import kpaschal.wordnet.domain.semantics.similarity.measures.SimilarityMeasure;
import kpaschal.wordnet.domain.semantics.similarity.measures.WuAndPalmerMeasure;

/**
 *
 * @author
 */
public class SimilarityService {

    
    public static WordSimilarityResult getPathLengthSimilarity(Synset source, Synset target, int depth) {
        RelationPathList paths = new RelationPathList();
        paths.addAll(RelationshipsService.getHorizontalPaths(source, target, depth));
        paths.addAll(RelationshipsService.getDownwardPaths(source, target, depth));
        paths.addAll(RelationshipsService.getUpwardPaths(source, target, depth));
        WordSimilarityResult sim = new WordSimilarityResult(SimilarityMeasure.PATH_LENGTH);
        IRelationPath shortestPath = RelationPathList.getShortestPath(paths);
        if (null != shortestPath) {
            sim.setValue(getPathLengthSimilarity(shortestPath));
            sim.setPath(shortestPath);
        }
        return sim;
    }

    public static double getPathLengthSimilarity(IRelationPath path) {
        if (null == path) {
            return 0;
        }
        return PathLengthMeasure.calculate(path.getLength());
    }

   public static WordSimilarityResult getHirstAndStOngeSimilarity(Synset source, Synset target, int maxDistance, int maxDirectionChanges, int depth) {
        RelationPathList paths = new RelationPathList();
        paths.addAll(RelationshipsService.getHorizontalPaths(source, target, depth));
        paths.addAll(RelationshipsService.getDownwardPaths(source, target, depth));
        paths.addAll(RelationshipsService.getUpwardPaths(source, target, depth));
        WordSimilarityResult sim = new WordSimilarityResult(SimilarityMeasure.HIRST_AND_ST_ONGE);
        IRelationPath shortestPath = RelationPathList.getShortestPath(paths);
        if (null != shortestPath) {
            sim.setValue(getHirstAndStOngeSimilarity(shortestPath, maxDistance, maxDirectionChanges, depth));
            sim.setPath(shortestPath);
        }
        return sim;
    }

    public static double getHirstAndStOngeSimilarity(IRelationPath path, int maxDistance, int maxDirectionChanges, int depth) {
        if (null == path) {
            return 0;
        }
        return HirstAndStOngeMeasure.calculate(maxDistance, maxDirectionChanges, path.getLength(), HirstAndStOngeMeasure.getDirectionChanges(path));
    }
 
    public static WordSimilarityResult getLeacockAndChodorowSimilarity(Synset source, Synset target, int maxTaxonomyDepth, int depth) {
        RelationPathList paths = RelationshipsService.getCommonParentsPaths(source, target, depth);
        WordSimilarityResult sim = new WordSimilarityResult(SimilarityMeasure.LEACOCK_AND_CHODOROW);
        IRelationPath shortestPath = RelationPathList.getShortestPath(paths);
        if (null != shortestPath) {
            sim.setValue(getLeacockAndChodorowSimilarity(shortestPath, maxTaxonomyDepth, depth));
            sim.setPath(shortestPath);
        }
        return sim;
    }

    public static double getLeacockAndChodorowSimilarity(IRelationPath path, int maxTaxonomyDepth, int depth) {
        if (null == path) {
            return 0;
        }
        return LeacockAndChodorowMeasure.calculate(path.getLength(), maxTaxonomyDepth);
    }
 
    public static WordSimilarityResult getWuAndPalmerSimilarity(Synset source, Synset target, int depth) {
        RelationPathList paths = RelationshipsService.getCommonParentsPaths(source, target, depth);
        WordSimilarityResult sim = new WordSimilarityResult(SimilarityMeasure.WU_AND_PALMER);
        IRelationPath shortestPath = RelationPathList.getShortestPath(paths);
        if (null != shortestPath) {
            sim.setValue(getWuAndPalmerSimilarity(shortestPath));
            sim.setPath(shortestPath);
        }
        return sim;
    }

    public static double getWuAndPalmerSimilarity(IRelationPath path) {
        if (null == path) {
            return 0;
        }
        double sim = -1;
        if (path instanceof RelationCAPath) {
            int lsaDepth = RelationshipsService.getDistanceToMaxRoot(path.getCommonAnchestor().getNode());
            int sourceDepth = RelationshipsService.getDistanceToMaxRoot(path.getSource().getNode());
            int targetDepth = RelationshipsService.getDistanceToMaxRoot(path.getTarget().getNode());
            sim = WuAndPalmerMeasure.calculate(lsaDepth, sourceDepth, targetDepth);
        }
        return sim;
    }

    private SimilarityService() {
    }
}
