package kpaschal.wordnet.infrastructure.dictionary.file.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class SenseExampleIndex {

    private String senseKey_;
    private List<Long> sentsIds_;

    public SenseExampleIndex(String senseKey) {
        this(senseKey, new ArrayList<Long>());
    }

    public SenseExampleIndex(String senseKey, List<Long> sentsIds) {
        senseKey_ = senseKey;
        sentsIds_ = sentsIds;
    }

    public String getSenseKey() {
        return senseKey_;
    }

    public boolean addSentenceId(Long sentId) {
        return sentsIds_.add(sentId);
    }

    public void setSentencesIds(List<Long> sentsIds) {
        sentsIds_ = sentsIds;
    }

    public List<Long> getSentencesIds() {
        return sentsIds_;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(senseKey_.toString()).append(" ");
        for (int i = 0; i < sentsIds_.size(); i++) {
            str.append(sentsIds_.get(i));
            if (sentsIds_.size() - 1 != i) {
                str.append(",");
            }
        }
        return str.toString();
    }
}
