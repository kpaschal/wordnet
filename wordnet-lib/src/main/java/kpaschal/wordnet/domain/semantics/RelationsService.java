package kpaschal.wordnet.domain.semantics;

import kpaschal.wordnet.domain.dictionary.Relation;
import kpaschal.wordnet.domain.dictionary.RelationType;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeFactory;
import kpaschal.wordnet.domain.semantics.node.RelationNode;
import kpaschal.wordnet.domain.semantics.node.RelationNodeList;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeNode;
import kpaschal.wordnet.domain.semantics.tree.RelationTreeNodeList;

/**
 *
 * @author
 */
public class RelationsService {

    public static RelationNodeList getSynonyms(Synset synset) {
        RelationNodeList relations = new RelationNodeList();
        relations.addAll(getRelationTargetNodes(synset, RelationType.SIMILAR_TO));
        relations.addAll(getRelationTargetNodes(synset, RelationType.ALSO_SEE));
        return relations;
    }

    public static RelationTreeNodeList getSynonymsTree(Synset synset, int depth) {
        RelationTreeNodeList relations = new RelationTreeNodeList();
        relations.addAll(RelationTreeFactory.createTreeNodeList(synset, RelationType.SIMILAR_TO, depth));
        relations.addAll(RelationTreeFactory.createTreeNodeList(synset, RelationType.ALSO_SEE, depth));
        return relations;
    }

    public static RelationTreeNodeList getCoordinateTerms(Synset synset) {
        RelationTreeNodeList coorTerms = new RelationTreeNodeList();
        for (RelationNode hype : getRelationTargetNodes(synset, RelationType.HYPERNYM)) {
            RelationTreeNode treeNode = new RelationTreeNode(hype);
            for (RelationNode hypo : getRelationTargetNodes(hype.getNode(), RelationType.HYPONYM)) {
                treeNode.addChild(new RelationTreeNode(hypo));

            }
            coorTerms.add(treeNode);
        }
        return coorTerms;
    }

    public static RelationNodeList getAntonymsDirect(Synset node) {
        return getRelationTargetNodes(node, RelationType.ANTONYM);
    }

    public static RelationTreeNodeList getAntonymsIndirect(Synset synset) {
        RelationTreeNodeList iants = new RelationTreeNodeList();
        for (RelationNode synonym : getSynonyms(synset)) {
            iants.add(new RelationTreeNode(new RelationNode(synonym.getRelationType(), synonym.getNode()), null,
                    new RelationTreeNodeList(getRelationTargetNodes(synonym.getNode(), RelationType.ANTONYM))));
        }
        return iants;
    }

    public static RelationTreeNodeList getAntonyms(Synset synset) {
        RelationTreeNodeList list = new RelationTreeNodeList();
        list.addAll(getAntonymsDirect(synset));
        list.addAll(getAntonymsIndirect(synset));
        return list;
    }

    public static RelationNodeList getHypernymsDirect(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.HYPERNYM);
    }

    public static RelationNodeList getHypernymsInstance(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.INSTANCE_HYPERNYM);
    }

    public static RelationNodeList getHypernyms(Synset synset) {
        RelationNodeList list = new RelationNodeList();
        list.addAll(getHypernymsDirect(synset));
        list.addAll(getHypernymsInstance(synset));
        return list;
    }

    public static RelationTreeNodeList getHypernymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.HYPERNYM, RelationType.INSTANCE_HYPERNYM}, depth);
    }

    public static RelationNodeList getHyponymsDirect(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.HYPONYM);
    }

    public static RelationNodeList getHyponymsInstance(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.INSTANCE_HYPONYM);
    }

    public static RelationNodeList getHyponyms(Synset synset) {
        RelationNodeList list = new RelationNodeList();
        list.addAll(getHyponymsDirect(synset));
        list.addAll(getHyponymsInstance(synset));
        return list;
    }

    public static RelationTreeNodeList getHyponymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.HYPONYM, RelationType.INSTANCE_HYPONYM}, depth);
    }

    public static RelationNodeList getMemberHolonyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.MEMBER_HOLONYM);
    }

    public static RelationTreeNodeList getMemberHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.MEMBER_HOLONYM, depth);
    }

    public static RelationTreeNodeList getInheritedMemberHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, RelationType.MEMBER_HOLONYM, depth);
    }

    public static RelationNodeList getSubstanceHolonyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.SUBSTANCE_HOLONYM);
    }

    public static RelationTreeNodeList getSubstanceHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.SUBSTANCE_HOLONYM, depth);
    }

    public static RelationTreeNodeList getInheritedSubstanceHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, RelationType.SUBSTANCE_HOLONYM, depth);
    }

    public static RelationNodeList getPartHolonyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.PART_HOLONYM);
    }

    public static RelationTreeNodeList getPartHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.PART_HOLONYM, depth);
    }

    public static RelationTreeNodeList getInheritedPartHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, RelationType.PART_HOLONYM, depth);
    }

    public static RelationNodeList getHolonyms(Synset synset) {
        RelationNodeList relations = new RelationNodeList();
        relations.addAll(getRelationTargetNodes(synset, RelationType.MEMBER_HOLONYM));
        relations.addAll(getRelationTargetNodes(synset, RelationType.SUBSTANCE_HOLONYM));
        relations.addAll(getRelationTargetNodes(synset, RelationType.PART_HOLONYM));
        return relations;
    }

    public static RelationTreeNodeList getHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.MEMBER_HOLONYM, RelationType.SUBSTANCE_HOLONYM, RelationType.PART_HOLONYM}, depth);
    }

    public static RelationTreeNodeList getInheritedHolonymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, new RelationType[]{
            RelationType.MEMBER_HOLONYM, RelationType.SUBSTANCE_HOLONYM, RelationType.PART_HOLONYM}, depth);
    }

    public static RelationNodeList getMemberMeronyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.MEMBER_MERONYM);
    }

    public static RelationTreeNodeList getMemberMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.MEMBER_MERONYM, depth);
    }

    public static RelationTreeNodeList getInheritedMemberMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, RelationType.MEMBER_MERONYM, depth);
    }

    public static RelationNodeList getSubstanceMeronyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.SUBSTANCE_MERONYM);
    }

    public static RelationTreeNodeList getSubstanceMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.SUBSTANCE_MERONYM, depth);
    }

    public static RelationTreeNodeList getInheritedSubstanceMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.SUBSTANCE_MERONYM, depth);
    }

    public static RelationNodeList getPartMeronyms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.PART_MERONYM);
    }

    public static RelationTreeNodeList getPartMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.PART_MERONYM, depth);
    }

    public static RelationTreeNodeList getInheritedPartMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.PART_MERONYM, depth);
    }

    public static RelationNodeList getMeronyms(Synset synset) {
        RelationNodeList relations = new RelationNodeList();
        relations.addAll(getRelationTargetNodes(synset, RelationType.MEMBER_MERONYM));
        relations.addAll(getRelationTargetNodes(synset, RelationType.SUBSTANCE_MERONYM));
        relations.addAll(getRelationTargetNodes(synset, RelationType.PART_MERONYM));
        return relations;
    }

    public static RelationTreeNodeList getMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.MEMBER_MERONYM, RelationType.SUBSTANCE_MERONYM, RelationType.PART_MERONYM}, depth);
    }

    public static RelationTreeNodeList getInheritedMeronymsTree(Synset node, int depth) {
        return RelationTreeFactory.createInheritedTreeNodeList(node, new RelationType[]{
            RelationType.MEMBER_MERONYM, RelationType.SUBSTANCE_MERONYM, RelationType.PART_MERONYM}, depth);
    }

    public static RelationNodeList getEntailments(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.ENTAILMENT);
    }

    public static RelationTreeNodeList getEntailmentsTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.ENTAILMENT}, depth);
    }

    public static RelationNodeList getCauses(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.CAUSE);
    }

    public static RelationTreeNodeList getCausesTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, new RelationType[]{
            RelationType.CAUSE}, depth);
    }

    public static RelationNodeList getVerbGroup(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.VERB_GROUP);
    }

    public static RelationNodeList getParticipleOf(Synset node) {
        return getRelationTargetNodes(node, RelationType.PARTICIPLE_OF);
    }

    public static RelationNodeList getSimilarTo(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.SIMILAR_TO);
    }

    public static RelationTreeNodeList getSimilarityTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.SIMILAR_TO, depth);
    }

    public static RelationNodeList getAlsoSee(Synset node) {
        return getRelationTargetNodes(node, RelationType.ALSO_SEE);
    }

    public static RelationTreeNodeList getAlsoSeeTree(Synset node, int depth) {
        return RelationTreeFactory.createTreeNodeList(node, RelationType.ALSO_SEE, depth);
    }

    public static RelationNodeList getPertainyms(Synset node) {
        return getRelationTargetNodes(node, RelationType.PERTAINYM);
    }

    public static RelationNodeList getAttributes(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.ATTRIBUTE);
    }

    public static RelationNodeList getNominalizations(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.NOMINALIZATION);
    }

    public static RelationNodeList getCategoryDomain(Synset node) {
        return getRelationTargetNodes(node, RelationType.CLASSIFICATION_CATEGORY);
    }

    public static RelationNodeList getUsageDomain(Synset node) {
        return getRelationTargetNodes(node, RelationType.CLASSIFICATION_USAGE);
    }

    public static RelationNodeList getRegionDomain(Synset node) {
        return getRelationTargetNodes(node, RelationType.CLASSIFICATION_REGION);
    }

    public static RelationNodeList getDomain(Synset node) {
        RelationNodeList relations = new RelationNodeList();
        relations.addAll(getRelationTargetNodes(node, RelationType.CLASSIFICATION_CATEGORY));
        relations.addAll(getRelationTargetNodes(node, RelationType.CLASSIFICATION_USAGE));
        relations.addAll(getRelationTargetNodes(node, RelationType.CLASSIFICATION_REGION));
        return relations;
    }

    public static RelationNodeList getCategoryDomainTerms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.CLASS_CATEGORY);
    }

    public static RelationNodeList getUsageDomainTerms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.CLASS_USAGE);
    }

    public static RelationNodeList getRegionDomainTerms(Synset synset) {
        return getRelationTargetNodes(synset, RelationType.CLASS_REGION);
    }

    public static RelationNodeList getDomainTerms(Synset synset) {
        RelationNodeList relations = new RelationNodeList();
        relations.addAll(getRelationTargetNodes(synset, RelationType.CLASS_CATEGORY));
        relations.addAll(getRelationTargetNodes(synset, RelationType.CLASS_USAGE));
        relations.addAll(getRelationTargetNodes(synset, RelationType.CLASS_REGION));
        return relations;
    }

    private static RelationNodeList getRelationTargetNodes(Synset node, RelationType relType) {
        RelationNodeList relations = new RelationNodeList();
        for (Relation rel : node.relationsAll(relType)) {
            relations.add(new RelationNode(rel.type(), rel.target().synset()));
        }
        return relations;
    }

    private RelationsService() {
    }
}
