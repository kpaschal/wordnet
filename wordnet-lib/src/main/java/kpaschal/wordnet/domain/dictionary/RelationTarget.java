package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class RelationTarget {

    private Synset synset;
    private Lemma lemma;

    public RelationTarget(Synset synset, Lemma lemma) {
        Validate.notNull(synset, "Relation target's Synset must be provided.");
        Validate.notNull(lemma, "Relation target's Lemma must be provided.");
        this.synset = synset;
        this.lemma = lemma;
    }

    public Synset synset() {
        return synset;
    }

    public Lemma lemma() {
        return lemma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.synset);
        hash = 11 * hash + Objects.hashCode(this.lemma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RelationTarget other = (RelationTarget) obj;
        if (!Objects.equals(this.synset, other.synset)) {
            return false;
        }
        if (!Objects.equals(this.lemma, other.lemma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RelationTarget{" + "synset=" + synset + ", lemma=" + lemma + '}';
    }

    private RelationTarget() {
    }

}
