package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Example {

    private ExampleId id;
    private TextRepresentation text;

    public Example(ExampleId id, TextRepresentation text) {
        Validate.notNull(id, "Example Id must be provided.");
        Validate.notNull(text, "Example text must be provided.");
        this.id = id;
        this.text = text;
    }

    public ExampleId id() {
        return id;
    }

    public TextRepresentation text() {
        return text;
    }

    public void updateText(TextRepresentation text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Example other = (Example) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private Example() {
    }

}
