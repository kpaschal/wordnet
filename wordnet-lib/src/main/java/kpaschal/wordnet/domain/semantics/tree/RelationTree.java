package kpaschal.wordnet.domain.semantics.tree;

import java.util.List;

/**
 *
 * @author
 */
public class RelationTree {

    private RelationTreeNode root_;

    public RelationTree() {
        this(null);
    }

    public RelationTree(RelationTreeNode root) {
        root_ = root;
    }

    public void setRoot(RelationTreeNode root) {
        root_ = root;
    }

    public RelationTreeNode getRoot() {
        return root_;
    }

    public List<RelationTreeNodeList> toList() {
        return  root_.toList(new RelationTreeNodeList());
    }
}
