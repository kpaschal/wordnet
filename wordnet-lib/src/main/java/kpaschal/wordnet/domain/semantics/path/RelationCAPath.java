package kpaschal.wordnet.domain.semantics.path;

import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;

/**
 *
 * @author
 */
public class RelationCAPath extends RelationPath {

    int anchestorIndex_;

    public RelationCAPath() {
        this(new RelationNodeList());
    }

    public RelationCAPath(RelationNodeList path) {
        this(path, -1);
    }

    public RelationCAPath(RelationNodeList path, int anchestorIndex) {
        super(path);
        anchestorIndex_ = anchestorIndex;
    }

    public RelationCAPath(RelationPath path) {
        this(path.getPath(), -1);
    }

    public RelationCAPath(RelationPath path, int anchestorIndex) {
        super(path.getPath());
        anchestorIndex_ = anchestorIndex;
    }

    @Override
    public boolean hasCommonAnchestor() {
        return anchestorIndex_ != -1;
    }

    @Override
    public RelationNode getCommonAnchestor() {
        return hasCommonAnchestor() ? super.getPath().get(anchestorIndex_) : null;
    }

    public int getCommonAnchestorIndex() {
        return anchestorIndex_;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < super.getPath().size(); i++) {
            strBuilder.append("->").append(super.getPath().get(i).toString()).append(anchestorIndex_ == i ? "(ca)" : "");
        }
        return strBuilder.toString();
    }
}
