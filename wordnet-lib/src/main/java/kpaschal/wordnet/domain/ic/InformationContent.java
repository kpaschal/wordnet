package kpaschal.wordnet.domain.ic;

import java.math.BigDecimal;
import kpaschal.wordnet.domain.dictionary.Pos;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author
 */
public class InformationContent {

    private long id;
    private Pos pos;
    private BigDecimal value;
    private boolean isRoot;

    public InformationContent(Pos pos, BigDecimal value, boolean isRoot) {
        this.pos = pos;
        this.value = value;
        this.isRoot = isRoot;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pos pos() {
        return pos;
    }

    public BigDecimal value() {
        return value;
    }

    public boolean isRoot() {
        return isRoot;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final InformationContent other = (InformationContent) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private InformationContent() {
    }

}
