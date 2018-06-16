package kpaschal.wordnet.infrastructure.dictionary.file.data;

import java.util.*;

/**
 *
 * @author
 */
public class WordIndex implements IWordIndex {

    private long id_;
    private String lemma_;
    private Pos pos_;
    protected List<Synset> synsets_;

    public WordIndex() {
        this("", null);
    }

    public WordIndex(String lemma, Pos pos) {
        id_ = -1;
        lemma_ = lemma;
        pos_ = pos;
        synsets_ = new ArrayList<Synset>();
    }

    @Override
    public void setId(long id) {
        id_ = id;
    }

    @Override
    public long getId() {
        return id_;
    }

    @Override
    public void setLemma(String lemma) {
        lemma_ = lemma;
    }

    @Override
    public String getLemma() {
        return lemma_;
    }

    @Override
    public void setPos(Pos pos) {
        pos_ = pos;
    }

    @Override
    public Pos getPos() {
        return pos_;
    }

    @Override
    public int getTaggedCount() {
        int taggedCnt = 0;
        for (Synset synset : synsets_) {
            taggedCnt += synset.getWordForLemma(lemma_).getTaggedCount();
        }
        return taggedCnt;
    }

    @Override
    public void addSynset(Synset synset) {
        synsets_.add(synset);
    }

    @Override
    public void setSynsets(List<Synset> synsets) {
        synsets_ = synsets;
    }

    @Override
    public List<Synset> getSynsets() {
        return synsets_;
    }

    @Override
    public List<RelationType> getRelationTypes() {
        List<RelationType> list = new ArrayList<RelationType>();
        for (Synset synset : synsets_) {
            ISense sense = synset.getWordForLemma(lemma_);
            for (IRelation rel : sense.getRelationsAll()) {
                if (!list.contains(rel.getRelationType())) {
                    list.add(rel.getRelationType());
                }
            }
        }
        return list;
    }

    public static class TaggedCountComparator implements java.util.Comparator {

        String lemma_;

        public TaggedCountComparator(String lemma) {
            lemma_ = lemma;
        }

        @Override
        public int compare(Object o1, Object o2) {
            int retVal = -1;
            if (o1 instanceof Synset && o2 instanceof Synset) {
                return ((Synset) o1).getWordForLemma(lemma_).getTaggedCount() - ((Synset) o2).getWordForLemma(lemma_).getTaggedCount();
            }
            return retVal;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id_).append(" ");
        builder.append(lemma_).append(" ");
        builder.append(pos_.getSymbol()).append(" ");
        builder.append(synsets_.size()).append(" ");
        List<RelationType> relTypes = getRelationTypes();
        builder.append(relTypes.size()).append(" ");
        for (RelationType ptr : relTypes) {
            builder.append(ptr.getSymbol()).append(" ");
        }
        builder.append(synsets_.size()).append(" ");

        builder.append(getTaggedCount()).append(" ");
        for (Synset synset : synsets_) {
            builder.append(synset.getId()).append(" ");
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean rVal = false;
        if (obj instanceof WordIndex) {
            WordIndex t = (WordIndex) obj;
            if ((this.lemma_.equals(t.getLemma())) && (this.pos_.equals(t.getPos()))) {
                rVal = true;
            }
        }
        return rVal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.lemma_);
        hash = 79 * hash + (this.pos_ != null ? this.pos_.hashCode() : 0);
        return hash;
    }
}