package kpaschal.wordnet.infrastructure.dictionary.file.data;

import java.util.Objects;

public class SenseIndex {

    private String senseKey_;
    private int senseNum_;
    private int tagCnt_;
    private long synsetId_;

    public SenseIndex(String senseKey, long synsetId) {
        this(senseKey, synsetId, 0, 0);
    }

    public SenseIndex(String senseKey, long synsetId, int senseNum, int tagCnt) {
        senseKey_ = senseKey;
        synsetId_ = synsetId;
        senseNum_ = senseNum;
        tagCnt_ = tagCnt;
    }

    public void setSenseKey(String senseKey) {
        senseKey_ = senseKey;
    }

    public void setSenseNumber(int senseNum) {

        senseNum_ = senseNum;
    }

    public void setTaggedCount(int tagCnt) {
        tagCnt_ = tagCnt;
    }

    public void setSynsetId(long synsetId) {
        synsetId_ = synsetId;
    }

    public String getSenseKey() {
        return senseKey_;
    }

    public long getSynsetId() {
        return synsetId_;
    }

    public int getSenseNumber() {
        return senseNum_;
    }

    public int getTaggedCount() {
        return tagCnt_;
    }

    @Override
    public String toString() {
        String s = senseKey_.toString();
        s += " " + synsetId_
                + " " + senseNum_
                + " " + tagCnt_;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rVal = false;
        if (obj instanceof SenseIndex) {
            SenseIndex t = (SenseIndex) obj;
            if (this.senseKey_.equals(t.getSenseKey())) {
                rVal = true;
            }
        }
        return rVal;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.senseKey_);
        return hash;
    }
}