package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class WordSense {

    private Pos pos;
    private Lemma lemma;
    private SynsetId synsetId;
    private int lexId;
    private int useCount;

    public WordSense(Pos pos, Lemma lemma, SynsetId synsetId) {
        Validate.notNull(pos, "Word's sense POS must be provided.");
        Validate.notNull(lemma, "Word's sense Lemma must be provided.");
        Validate.notNull(lemma, "Word's sense SynsetId must be provided.");
        this.pos = pos;
        this.lemma = lemma;
        this.synsetId = synsetId;
    }

    public Pos pos() {
        return pos;
    }

    public Lemma lemma() {
        return lemma;
    }

    public SynsetId synsetId() {
        return synsetId;
    }

    public int lexId() {
        return lexId;
    }

    public int useCount() {
        return useCount;
    }

    public void changeLexId(int lexId) {
        this.lexId = lexId;
    }

    public void updateUseCount(int useCount) {
        this.useCount = useCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.pos);
        hash = 53 * hash + Objects.hashCode(this.lemma);
        hash = 53 * hash + Objects.hashCode(this.synsetId);
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
        final WordSense other = (WordSense) obj;
        if (this.pos != other.pos) {
            return false;
        }
        if (!Objects.equals(this.lemma, other.lemma)) {
            return false;
        }
        if (!Objects.equals(this.synsetId, other.synsetId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private WordSense() {
    }
    // For ORM
    private long id_;

}
