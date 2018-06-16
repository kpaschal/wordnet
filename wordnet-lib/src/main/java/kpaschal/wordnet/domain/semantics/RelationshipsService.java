package kpaschal.wordnet.domain.semantics;

import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;
import java.util.ArrayList;
import java.util.List;
import kpaschal.wordnet.domain.dictionary.Relation;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.path.IRelationPath;
import kpaschal.wordnet.domain.semantics.path.RelationPath;
import kpaschal.wordnet.domain.semantics.path.RelationPathFinder;
import kpaschal.wordnet.domain.semantics.path.RelationPathList;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeFactory;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeNode;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeNodeList;

/**
 *
 * @author
 */
public class RelationshipsService {

    public static int getDistanceToMaxRoot(Synset node) {
        List<RelationTreeNodeList> treeNodeList = RelationTreeFactory.createTree(node, RelationType.HYPERNYM).toList();
        if (treeNodeList.isEmpty()) {
            return -1;
        }
        int max = treeNodeList.get(0).size();
        for (int i = 1; i < treeNodeList.size(); i++) {
            if (treeNodeList.get(i).size() > max) {
                max = treeNodeList.get(i).size();
            }
        }
        return max;
    }

    public static int getDistanceToMinRoot(Synset node) {
        List<RelationTreeNodeList> treeNodeList = RelationTreeFactory.createTree(node, RelationType.HYPERNYM).toList();
        if (treeNodeList.isEmpty()) {
            return -1;
        }

        int min = treeNodeList.get(0).size();
        for (int i = 1; i < treeNodeList.size(); i++) {
            if (treeNodeList.get(i).size() < min) {
                min = treeNodeList.get(i).size();
            }
        }
        return min;
    }

    public static Synset getMaxRoot(Synset synset) {
        IRelationPath path = getPathToMaxRoot(synset);
        if (null == path) {
            return null;
        }
        return path.getTarget().getNode().synset();
    }

    public static Synset getMinRoot(Synset synset) {
        IRelationPath path = getPathToMinRoot(synset);
        if (null == path) {
            return null;
        }
        return path.getTarget().getNode().synset();
    }

    public static IRelationPath getPathToMaxRoot(Synset synset) {
        List<RelationTreeNodeList> list = RelationTreeFactory.createTree(synset, RelationType.HYPERNYM).toList();
        if (list.isEmpty()) {
            return null;
        }
        RelationTreeNodeList max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).size() > max.size()) {
                max = list.get(i);
            }
        }
        RelationPath path = new RelationPath();
        for (RelationTreeNode treeNode : max) {
            path.addNode(new RelationNode(RelationType.HYPERNYM, treeNode.getNode().getNode()));
        }
        return path;

    }

    public static IRelationPath getPathToMinRoot(Synset synset) {
        List<RelationTreeNodeList> list = RelationTreeFactory.createTree(synset, RelationType.HYPERNYM).toList();
        if (list.isEmpty()) {
            return null;
        }
        RelationTreeNodeList min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).size() < min.size()) {
                min = list.get(i);
            }
        }
        RelationPath path = new RelationPath();
        for (RelationTreeNode treeNode : min) {
            path.addNode(new RelationNode(RelationType.HYPERNYM, treeNode.getNode().getNode()));
        }
        return path;
    }

    public static List<Synset> getRoots(Synset synset) {
        List<Synset> roots = new ArrayList<>();
        List<RelationTreeNodeList> list = RelationTreeFactory.createTree(synset, RelationType.HYPERNYM).toList();
        if (!list.isEmpty()) {
            for (RelationTreeNodeList treeNodeList : list) {
                roots.add(treeNodeList.get(treeNodeList.size() - 1).getNode().getNode().synset());
            }
        }
        return roots;
    }

    public static RelationPathList getPathsToRoots(Synset synset) {
        List<RelationTreeNodeList> list = RelationTreeFactory.createTree(synset, RelationType.HYPERNYM).toList();
        if (list.isEmpty()) {
            return new RelationPathList();
        }

        RelationPathList pathList = new RelationPathList();
        for (RelationTreeNodeList treeNodeList : list) {
            RelationPath path = new RelationPath();
            for (RelationTreeNode treeNode : treeNodeList) {
                path.addNode(new RelationNode(RelationType.HYPERNYM, treeNode.getNode().getNode()));
            }
            pathList.add(path);
        }
        return pathList;
    }

    public static RelationPathList getPaths(Synset source, Synset target, RelationType[] relTypes, int depth) {
        return RelationPathFinder.getPaths(source, target, relTypes, depth);

    }

    public static RelationPathList getPaths(Synset source, Synset target, RelationType relType, int depth) {
        RelationPathList pathList = new RelationPathList();
        // source and target are equals
        if (source.equals(target)) {
            RelationPath path = new RelationPath();
            path.addNode(new RelationNode(null, source));
            pathList.add(path);
            return pathList;
        }

        if (RelationType.hasReflexivePointer(relType) && !RelationType.getReflexivePointer(relType).equals(relType)) {
            // CommonAnchestor search
            pathList.addAll(RelationPathFinder.getPathsWithCommonAnchestor(RelationTreeFactory.createTree(source, relType, depth), RelationTreeFactory.createTree(target, relType, depth), relType));
        } else if (RelationType.hasReflexivePointer(relType) && RelationType.getReflexivePointer(relType).equals(relType)) {
            // RelationPath search
            pathList = RelationPathFinder.getPaths(source, target, new RelationType[]{relType}, depth);
        } else {
            // Look for direct relation from source to target
            for (Relation rel : source.relationsAll(relType)) {
                if (rel.target().synset().equals(target)) {
                    RelationNodeList list = new RelationNodeList();
                    list.add(new RelationNode(null, source));
                    list.add(new RelationNode(relType, target));
                    pathList.add(new RelationPath(list));
                }
            }
        }

        return pathList;
    }

    public static RelationPathList getHorizontalPaths(Synset source, Synset target, int depth) {
        RelationPathList paths = new RelationPathList();
        RelationType[] relTypes = new RelationType[]{RelationType.ALSO_SEE, RelationType.ANTONYM, RelationType.ATTRIBUTE, RelationType.PERTAINYM, RelationType.SIMILAR_TO};
        for (RelationType relType : relTypes) {
            paths.addAll(getPaths(source, target, relType, depth));
        }
        return paths;
    }

    public static RelationPathList getUpwardPaths(Synset source, Synset target, int depth) {
        RelationPathList paths = new RelationPathList();
        RelationType[] relTypes = new RelationType[]{RelationType.HYPERNYM, RelationType.INSTANCE_HYPERNYM, RelationType.MEMBER_MERONYM, RelationType.SUBSTANCE_MERONYM, RelationType.PART_MERONYM, RelationType.MERONYM};
        for (RelationType relType : relTypes) {
            paths.addAll(getPaths(source, target, relType, depth));
        }
        return paths;
    }

    public static RelationPathList getDownwardPaths(Synset source, Synset target, int depth) {
        RelationPathList paths = new RelationPathList();
        RelationType[] relTypes = new RelationType[]{RelationType.CAUSE, RelationType.ENTAILMENT, RelationType.HYPONYM, RelationType.INSTANCE_HYPONYM, RelationType.HOLONYM, RelationType.MEMBER_HOLONYM, RelationType.SUBSTANCE_HOLONYM, RelationType.PART_HOLONYM};
        for (RelationType relType : relTypes) {
            paths.addAll(getPaths(source, target, relType, depth));
        }
        return paths;
    }

    public static List<Synset> getCommonParents(Synset source, Synset target, int depth) {
        List<Synset> synsets = new ArrayList<Synset>();
        List<IRelationPath> caPaths = getCommonParentsPaths(source, target, depth);
        for (IRelationPath caPath : caPaths) {
            synsets.add(caPath.getCommonAnchestor().getNode().synset());
        }
        return synsets;
    }

    public static RelationPathList getCommonParentsPaths(Synset source, Synset target, int depth) {
        return RelationPathFinder.getPathsWithCommonAnchestor(RelationTreeFactory.createTree(source, RelationType.HYPERNYM, depth), RelationTreeFactory.createTree(target, RelationType.HYPERNYM, depth), RelationType.HYPERNYM);
    }

    private RelationshipsService() {
    }
}
