package kpaschal.wordnet.domain.semantics.path;

import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;

/**
 *
 * @author
 */
public interface IRelationPath {

    public RelationNode getSource();

    public RelationNode getTarget();

    public void setPath(RelationNodeList path);

    public void addNode(RelationNode node);

    public RelationNodeList getPath();

    public int getLength();

    public boolean hasCommonAnchestor();

    public RelationNode getCommonAnchestor();

    @Override
    public String toString();

    public int compareTo(Object o);
}
