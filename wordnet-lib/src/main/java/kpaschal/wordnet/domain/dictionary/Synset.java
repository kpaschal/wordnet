package kpaschal.wordnet.domain.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Synset {

    private SynsetId id;
    private SynsetType synsetType;
    private long lexFileNum;
    private TextRepresentation gloss;
    private List<WordSense> senses = new ArrayList<>();
    private List<Relation> relations = new ArrayList<>();

    public Synset(SynsetId synsetId, SynsetType synsetType) {
        Validate.notNull(synsetId, "SynsetId must be provided.");
        Validate.notNull(synsetType, "SynsetType must be provided.");
        this.id = synsetId;
        this.synsetType = synsetType;
    }

    public SynsetId id() {
        return id;
    }

    public SynsetType synsetType() {
        return synsetType;
    }

    public Synset synset() {
        return this;
    }

    public Pos pos() {
        return synsetType.getPos();
    }

    public long lexFileNum() {
        return lexFileNum;
    }

    public TextRepresentation gloss() {
        return gloss;
    }

    public void assignLexFileNum(long lexFileNum) {
        this.lexFileNum = lexFileNum;
    }

    public void updateGloss(TextRepresentation gloss) {
        this.gloss = gloss;
    }

    public boolean isAdjectiveSatellite() {
        throw new UnsupportedOperationException("Only for Adjective Synsets.");
    }

    public List<WordSense> senses() {
        return Collections.unmodifiableList(senses);
    }

    public List<Relation> relations() {
        return Collections.unmodifiableList(relations);
    }

    public List<Relation> relationsAll() {
        return Collections.unmodifiableList(relations);
    }

    public List<Relation> relationsAll(RelationType... relationTypes) {
        return Collections.unmodifiableList(relations);
    }

    public List<Relation> relations(RelationType relationType) {
        List<Relation> rRelations = new ArrayList<>();
        for (Relation relation : relations) {
            if (relation.type().equals(relationType)) {
                rRelations.add(relation);
            }
        }
        return rRelations;
    }

    public WordSense senseForLemma(Lemma lemma) {
        for (WordSense sense : senses) {
            if (sense.lemma().equals(lemma)) {
                return sense;
            }
        }
        return null;
    }

    public List<Frame> frames() {
        throw new UnsupportedOperationException("Only for Verb synsets.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Synset other = (Synset) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    protected Synset() {
    }

}
