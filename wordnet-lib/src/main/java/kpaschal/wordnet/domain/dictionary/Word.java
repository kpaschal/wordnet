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
public class Word {

    private Lemma lemma;
    private List<Form> forms = new ArrayList<>();

    public Word(Lemma lemma) {
        Validate.notNull(lemma, "Word lemma must be provided.");
        this.lemma = lemma;
    }

    public Lemma lemma() {
        return lemma;
    }

    public List<Form> forms() {
        return Collections.unmodifiableList(forms);
    }

    public List<Form> forms(Pos pos) {
        List<Form> rForms = new ArrayList<>();
        for (Form form : forms) {
            if (form.pos().equals(pos)) {
                rForms.add(form);
            }
        }
        return rForms;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.lemma);
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
        final Word other = (Word) obj;
        if (!Objects.equals(this.lemma, other.lemma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    protected Word() {
    }
    // For ORM
    private long id_;

}
