package kpaschal.wordnet.domain.semantics.node;

import java.util.Objects;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author
 *
 */
public class RelationNode {

    private RelationType relationType;
    private Synset synset;
 
    public RelationNode(RelationType relType, Synset synset) {
        this.relationType = relType;
        this.synset = synset;
    }

    public void setRelationType(RelationType relType) {
        this.relationType = relType;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setNode(Synset synset) {
        this.synset = synset;
    }

    public Synset getNode() {
        return synset;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RelationNode) {
            RelationNode t = (RelationNode) o;
            if (getNode().equals(t.getNode()) && relationType == t.getRelationType()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.relationType != null ? this.relationType.hashCode() : 0);
        hash = 29 * hash + Objects.hashCode(this.synset);
        return hash;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
