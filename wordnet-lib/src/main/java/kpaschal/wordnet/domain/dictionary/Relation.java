package kpaschal.wordnet.domain.dictionary;

import org.apache.commons.lang3.Validate;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Relation {

    private RelationType type;
    private RelationTarget source;
    private RelationTarget target;

    public Relation(RelationType type, RelationTarget source, RelationTarget target) {
        Validate.notNull(type,"Relation's type must be provided.");
        Validate.notNull(source,"Relation's source must be provided.");
        Validate.notNull(target,"Relation's target must be provided.");
        this.type = type;
        this.source = source;
        this.target = target;
    }

    public RelationType type() {
        return type;
    }

    public RelationTarget source() {
        return source;
    }

    public RelationTarget target() {
        return target;
    }

    public boolean isSemmatic() {
        return source.lemma() == null && target.lemma() == null;
    }

    public boolean isLexical() {
        return source.lemma() != null && target.lemma() != null;
    }

    public boolean hasReflexive() {
        return RelationType.hasReflexivePointer(type);
    }

    private Relation() {
    }
    // For ORM
    private long id_;

}
