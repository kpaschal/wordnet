package kpaschal.wordnet.domain.semantics.tree;

import java.util.ArrayList;
import java.util.List;
import kpaschal.wordnet.domain.dictionary.Relation;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.node.RelationNode;

/**
 *
 * @author
 */
public class RelationTreeFactory {

    public static RelationTree createTree(Synset node) {
        return createTree(node, RelationType.values(), Integer.MAX_VALUE);
    }

    public static RelationTree createTree(Synset node, RelationType relType) {
        return createTree(node, new RelationType[]{relType}, Integer.MAX_VALUE);
    }

    public static RelationTree createTree(Synset node, RelationType[] relTypes) {
        return createTree(node, relTypes, Integer.MAX_VALUE);
    }

    public static RelationTree createTree(Synset node, int depth) {
        return createTree(node, RelationType.values(), depth);
    }

    public static RelationTree createTree(Synset node, RelationType relType, int depth) {
        return createTree(node, new RelationType[]{relType}, depth);
    }

    public static RelationTree createTree(Synset node, RelationType[] relTypes, int depth) {
        return new RelationTree(new RelationTreeNode(new RelationNode(null, node),
                null, createTreeNodeList(node, relTypes, depth, new ArrayList<Synset>())));
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node) {
        return createTreeNodeList(node, RelationType.values(), Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node, RelationType relType) {
        return createTreeNodeList(node, new RelationType[]{relType}, Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node, RelationType[] relTypes) {
        return createTreeNodeList(node, relTypes, Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node, int depth) {
        return createTreeNodeList(node, RelationType.values(), depth);
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node, RelationType relType, int depth) {
        return createTreeNodeList(node, new RelationType[]{relType}, depth);
    }

    public static RelationTreeNodeList createTreeNodeList(Synset node, RelationType[] relTypes, int depth) {
        return createTreeNodeList(node, relTypes, depth, new ArrayList<Synset>());
    }

    private static RelationTreeNodeList createTreeNodeList(Synset currentNode, RelationType[] relTypes, int depth, List<Synset> visited) {
        RelationTreeNodeList childs = new RelationTreeNodeList();
        depth--;
        if (depth > 0) {
            for (RelationType relType : relTypes) {
                for (Relation rel : currentNode.relationsAll(relType)) {
                    RelationTreeNode treeTargetNode = new RelationTreeNode(new RelationNode(rel.type(), rel.target().synset()));
                    if (!visited.contains(treeTargetNode.getNode().getNode())) {
                        //visited.add(treeTargetNode.getNode().getNode());

                        if (!childs.contains(treeTargetNode)) {
                            treeTargetNode.setChilds(createTreeNodeList(treeTargetNode.getNode().getNode(), relTypes, depth, visited));
                            childs.add(treeTargetNode);
                        }

                    }
                }
            }
        }
        return childs;
    }

    public static RelationTree createInheritedTree(Synset node) {
        return createInheritedTree(node, RelationType.values(), Integer.MAX_VALUE);
    }

    public static RelationTree createInheritedTree(Synset node, RelationType relType) {
        return createInheritedTree(node, new RelationType[]{relType}, Integer.MAX_VALUE);
    }

    public static RelationTree createInheritedTree(Synset node, RelationType[] relTypes) {
        return createInheritedTree(node, relTypes, Integer.MAX_VALUE);
    }

    public static RelationTree createInheritedTree(Synset node, int depth) {
        return createInheritedTree(node, RelationType.values(), depth);
    }

    public static RelationTree createInheritedTree(Synset node, RelationType relType, int depth) {
        return createInheritedTree(node, new RelationType[]{relType}, depth);
    }

    public static RelationTree createInheritedTree(Synset node, RelationType[] relTypes, int depth) {
        return new RelationTree(new RelationTreeNode(new RelationNode(null, node),
                null, createInheritedTreeNodeList(node, relTypes, depth)));
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node) {
        return createInheritedTreeNodeList(node, RelationType.values(), Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node, RelationType relType) {
        return createInheritedTreeNodeList(node, new RelationType[]{relType}, Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node, RelationType[] relTypes) {
        return createInheritedTreeNodeList(node, relTypes, Integer.MAX_VALUE);
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node, int depth) {
        return createInheritedTreeNodeList(node, RelationType.values(), depth);
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node, RelationType relType, int depth) {
        return createInheritedTreeNodeList(node, new RelationType[]{relType}, depth);
    }

    public static RelationTreeNodeList createInheritedTreeNodeList(Synset node, RelationType[] relTypes, int depth) {
        RelationTreeNodeList list = new RelationTreeNodeList();
        for (Relation rel : node.relationsAll(RelationType.HYPERNYM)) {
            RelationTreeNode hype = new RelationTreeNode(new RelationNode(rel.type(), rel.target().synset()));
            hype.setChilds(createInheritedTreeNodeList(rel.target().synset(), relTypes, depth));
            list.add(hype);
        }
        list.addAll(createTreeNodeList(node, relTypes, depth));
        return list;
    }
}
