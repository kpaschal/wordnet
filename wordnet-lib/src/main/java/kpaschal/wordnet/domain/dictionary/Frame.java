package kpaschal.wordnet.domain.dictionary;

import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Frame {

    private FrameId id;
    private TextRepresentation text;

    public Frame(FrameId id, TextRepresentation text) {
        Validate.notNull(id, "Frame id must be provided.");
        Validate.notNull(text, "Frame text must be provided.");
        this.id = id;
        this.text = text;
    }

    public FrameId id() {
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
        final Frame other = (Frame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private Frame() {
    }

}
