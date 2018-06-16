package kpaschal.wordnet.domain.semantics.path;

import kpaschal.wordnet.domain.semantics.node.RelationNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Relation;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.tree.RelationTree;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeFactory;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeNodeList;

/**
 *
 * @author
 */
public class RelationPathFinder {

    public static RelationPathList getPaths(Synset source, Synset target, RelationType[] relTypes, int depth) {

        RelationPathList paths = new RelationPathList();
        Queue<IRelationPath> queue = new LinkedList<>();
        List<Synset> visitedNodes = new ArrayList<>();

        IRelationPath root = new RelationPath();
        root.addNode(new RelationNode(null, source));
        queue.add(root);
        while (!queue.isEmpty()) {
            IRelationPath currentPath = (IRelationPath) queue.remove();
            Synset currentNode = currentPath.getPath().get(currentPath.getPath().size() - 1).getNode();
            if (currentNode.synset().equals(target.synset())) {
                paths.add(currentPath);
            } else {
                if (currentPath.getPath().size() <= depth) {
                    for (Relation rel : currentNode.relationsAll(relTypes)) {
                        if (!visitedNodes.contains(rel.target().synset())) {
                            visitedNodes.add(rel.target().synset());
                            IRelationPath newPath = new RelationPath();
                            for (RelationNode relNode : currentPath.getPath()) {
                                newPath.addNode(new RelationNode(relNode.getRelationType(), relNode.getNode()));
                            }
                            newPath.addNode(new RelationNode(rel.type(), rel.target().synset()));

                            queue.add(newPath);
                        }
                    }
                }
            }

        }
        return paths;
    }

    public static RelationPathList getPathsWithCommonAnchestor(Synset source, Synset target, RelationType relType, int depth) {
        return getPathsWithCommonAnchestor(RelationTreeFactory.createTree(source, relType, depth), RelationTreeFactory.createTree(target, relType, depth), relType);
    }

    public static RelationPathList getPathsWithCommonAnchestor(RelationTree sourceTree, RelationTree targetTree, RelationType relType) {
        RelationPathList lcaList = new RelationPathList();
        List<RelationTreeNodeList> sourceTreePaths = sourceTree.toList();
        List<RelationTreeNodeList> targetTreePaths = targetTree.toList();

        for (RelationTreeNodeList sourceTreePath : sourceTreePaths) {
            for (RelationTreeNodeList targetTreePath : targetTreePaths) {

                RelationCAPath commonAnchestor = null;

                // if the trees not have the same taxonomy root, don't have common anchestor
                if (!sourceTreePath.get(sourceTreePath.size() - 1).getNode().equals(targetTreePath.get(targetTreePath.size() - 1).getNode())) {
                    return lcaList;
                }

                int anchestorIndex = -1;
                RelationCAPath path = new RelationCAPath();
                RelationType reflexiveRelationType = RelationType.getReflexivePointer(relType);
                for (int i = 0; i < sourceTreePath.size() - 1; i++) {

                    if (targetTreePath.contains(sourceTreePath.get(i))) {
                        anchestorIndex = i;
                        for (int j = targetTreePath.indexOf(sourceTreePath.get(i)); j >= 0; j--) {
                            path.addNode(new RelationNode(reflexiveRelationType, targetTreePath.get(j).getNode().getNode()));
                        }
                        break;
                    }
                    path.addNode(new RelationNode(relType, sourceTreePath.get(i).getNode().getNode()));
                }

                if (anchestorIndex > -1) {
                    commonAnchestor = new RelationCAPath(path, anchestorIndex);
                }
                if (commonAnchestor != null) {
                    lcaList.add(commonAnchestor);
                }
            }
        }
        return lcaList;
    }

    private RelationPathFinder() {
    }
}
