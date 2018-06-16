package kpaschal.wordnet.domain.dictionary;

import org.apache.commons.lang3.Validate;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class Lemma {

    private String text;

    public Lemma(String text) {
        Validate.notNull(text, "Text must be provided.");
        Validate.notEmpty(text, "Text must be provided.");
        this.text = text;
    }

    public String text() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    private Lemma() {
    }

}
