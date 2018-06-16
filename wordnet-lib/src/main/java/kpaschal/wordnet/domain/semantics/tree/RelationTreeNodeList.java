package kpaschal.wordnet.domain.semantics.tree;

import java.util.LinkedList;
import java.util.List;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;

/**
 *
 * @author
 */
public class RelationTreeNodeList extends LinkedList<RelationTreeNode> {

    public RelationTreeNodeList() {
        super();
    }

    public RelationTreeNodeList(RelationTreeNode node) {
        super();
        super.add(node);
    }

    public RelationTreeNodeList(List<RelationTreeNode> nodeList) {
        super(nodeList);
    }

    public RelationTreeNodeList(RelationType relType, List<Synset> nodes) {
        for (Synset node : nodes) {
            super.add(new RelationTreeNode(new RelationNode(relType, node)));
        }
    }

    public RelationTreeNodeList(RelationNodeList nodes) {
        for (RelationNode node : nodes) {
            super.add(new RelationTreeNode(node));
        }
    }

    public void add(RelationNode node) {
        super.add(new RelationTreeNode(node));
    }

    public void addAll(RelationNodeList nodes) {
        for (RelationNode node : nodes) {
            super.add(new RelationTreeNode(node));
        }
    }

    public RelationNodeList toRelationNodeList() {
        RelationNodeList relationNodeList = new RelationNodeList();
        for (RelationTreeNode treeNode : this) {
            relationNodeList.add(treeNode.getNode());
        }
        return relationNodeList;
    }
}
