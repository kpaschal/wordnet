package kpaschal.wordnet.domain.semantics.node;

import java.util.ArrayList;
import java.util.List;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;

/**
 *
 * @author
 */
public class RelationNodeList extends ArrayList<RelationNode> {

    public RelationNodeList() {
        super();
    }

    public RelationNodeList(RelationType relType, List<Synset> synsets) {
        for (Synset synset : synsets) {
            super.add(new RelationNode(relType, synset));
        }
    }

    public void add(RelationType relType, Synset synset) {
        super.add(new RelationNode(relType, synset));
    }

    public void addAll(RelationType relType, List<Synset> synsets) {
        for (Synset synset : synsets) {
            super.add(new RelationNode(relType, synset));
        }
    }
    
}
