package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import kpaschal.wordnet.domain.dictionary.Pos;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class WordPos {

    private Pos pos;
    private String lemma;

    public WordPos(Pos pos, String lemma) {
        this.pos = pos;
        this.lemma = lemma;
    }

    public Pos getPos() {
        return pos;
    }

    public String getLemma() {
        return lemma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.pos);
        hash = 37 * hash + Objects.hashCode(this.lemma);
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
        final WordPos other = (WordPos) obj;
        if (!Objects.equals(this.lemma, other.lemma)) {
            return false;
        }
        if (this.pos != other.pos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private WordPos() {
    }

}
