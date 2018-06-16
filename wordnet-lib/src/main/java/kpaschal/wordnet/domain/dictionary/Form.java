package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Form {

    private Pos pos;
    private String text;

    public Form(Pos pos, String text) {
        Validate.notNull(pos, "Form POS must be provided.");
        Validate.notNull(text, "Form text must be provided.");
        Validate.notEmpty(text, "Form text must be provided.");
        this.text = text;
    }

    public Pos pos() {
        return pos;
    }

    public String text() {
        return text;
    }

    public void changeText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.pos);
        hash = 17 * hash + Objects.hashCode(this.text);
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
        final Form other = (Form) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (this.pos != other.pos) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return text;
    }

    private Form() {
    }
    // For ORM
    private long id_;

}
