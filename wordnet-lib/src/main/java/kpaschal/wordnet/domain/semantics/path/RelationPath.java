package kpaschal.wordnet.domain.semantics.path;

import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;

/**
 *
 * @author
 */
public class RelationPath implements Comparable, IRelationPath {

    private RelationNodeList path_;

    public RelationPath() {
        this(new RelationNodeList());
    }

    public RelationPath(RelationNodeList path) {
        path_ = path;
    }

    @Override
    public RelationNode getSource() {
        return path_.get(0);
    }

    @Override
    public RelationNode getTarget() {
        return path_.get(path_.size() - 1);
    }

    @Override
    public void setPath(RelationNodeList path) {
        path_ = path;
    }

    @Override
    public void addNode(RelationNode node) {
        path_.add(node);
    }

    @Override
    public RelationNodeList getPath() {
        return path_;
    }

    @Override
    public int getLength() {
        return path_.size();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < path_.size(); i++) {
            strBuilder.append("->").append(path_.get(i).toString());
        }
        return strBuilder.toString();
    }

    @Override
    public boolean hasCommonAnchestor() {
        return false;
    }

    @Override
    public RelationNode getCommonAnchestor() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        if (getLength() < ((RelationPath) o).getLength()) {
            return -1;
        } else if (getLength() > ((RelationPath) o).getLength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
