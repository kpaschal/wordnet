package kpaschal.wordnet.domain.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class SynsetVerb extends Synset {

    private List<Frame> frames = new ArrayList<>();

    public SynsetVerb(SynsetId synsetId, SynsetType synsetType) {
        super(synsetId, synsetType);
    }

    @Override
    public List<Frame> frames() {
        return Collections.unmodifiableList(frames);
    }

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private SynsetVerb() {
    }

}
