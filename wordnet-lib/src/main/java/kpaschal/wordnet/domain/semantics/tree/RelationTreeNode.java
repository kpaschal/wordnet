package kpaschal.wordnet.domain.semantics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNode;

/**
 *
 * @author
 */
public class RelationTreeNode {

    private RelationNode node_;
    private RelationTreeNode parent_;
    private RelationTreeNodeList childs_;

    public RelationTreeNode() {
        this(null, null, new RelationTreeNodeList());
    }

    public RelationTreeNode(RelationNode node) {
        this(node, null);
    }

    public RelationTreeNode(RelationNode node, RelationTreeNode parent) {
        this(node, parent, new RelationTreeNodeList());
    }

    public RelationTreeNode(RelationNode node, RelationTreeNode parent, RelationTreeNodeList childs) {
        node_ = node;
        parent_ = parent;
        childs_ = childs;
    }

    public void setNode(RelationNode node) {
        node_ = node;
    }

    public RelationNode getNode() {
        return node_;
    }

    public void setParent(RelationTreeNode parent) {
        parent_ = parent;
    }

    public RelationTreeNode getParent() {
        return parent_;
    }

    public void addChild(RelationTreeNode child) {
        childs_.add(child);
    }

    public void setChilds(RelationTreeNodeList childs) {
        childs_ = childs;
    }

    public RelationTreeNodeList getChilds() {
        return childs_;
    }

    public List<RelationTreeNodeList> toList(RelationTreeNodeList treeNodeList) {
        List<RelationTreeNodeList> list = new ArrayList<RelationTreeNodeList>();
        treeNodeList.add(this);
        if (childs_.isEmpty()) {
            list.add(treeNodeList);
        } else {
            for (RelationTreeNode child : childs_) {
                list.addAll(child.toList((RelationTreeNodeList) treeNodeList.clone()));
            }
        }
        return list;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RelationTreeNode) {
            RelationTreeNode t = (RelationTreeNode) obj;
            if (this.getNode().equals(t.getNode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.node_);
        return hash;
    }
}
