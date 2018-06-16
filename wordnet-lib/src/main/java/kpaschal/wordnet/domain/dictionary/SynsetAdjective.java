package kpaschal.wordnet.domain.dictionary;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class SynsetAdjective extends Synset {

    public SynsetAdjective(SynsetId synsetId, SynsetType synsetType) {
        super(synsetId, synsetType);
    }

    @Override
    public boolean isAdjectiveSatellite() {
        return super.synsetType().equals(SynsetType.ADJECTIVE_SATELLITE);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private SynsetAdjective() {
    }

}
