package kpaschal.wordnet.infrastructure.dictionary;

import kpaschal.wordnet.application.DictionaryService;
import kpaschal.wordnet.domain.dictionary.Example;
import kpaschal.wordnet.domain.dictionary.ExampleId;
import kpaschal.wordnet.domain.dictionary.ExampleRepository;
import kpaschal.wordnet.domain.dictionary.Frame;
import kpaschal.wordnet.domain.dictionary.FrameId;
import kpaschal.wordnet.domain.dictionary.FrameRepository;
import kpaschal.wordnet.domain.dictionary.Lemma;
import kpaschal.wordnet.domain.dictionary.Pos;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.dictionary.SynsetAdjective;
import kpaschal.wordnet.domain.dictionary.SynsetId;
import kpaschal.wordnet.domain.dictionary.SynsetRepository;
import kpaschal.wordnet.domain.dictionary.SynsetType;
import kpaschal.wordnet.domain.dictionary.SynsetVerb;
import kpaschal.wordnet.domain.dictionary.TextRepresentation;
import kpaschal.wordnet.domain.dictionary.Word;
import kpaschal.wordnet.domain.dictionary.WordRepository;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class DictionaryServiceImpl implements DictionaryService {

    private final WordRepository wordRepository;
    private final SynsetRepository synsetRepository;
    private final FrameRepository frameRepository;
    private final ExampleRepository exampleRepository;

    public DictionaryServiceImpl(WordRepository wordRepository, SynsetRepository synsetRepository,
            FrameRepository frameRepository, ExampleRepository exampleRepository) {
        this.wordRepository = wordRepository;
        this.synsetRepository = synsetRepository;
        this.frameRepository = frameRepository;
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Word findWord(String lemma) {
        return wordRepository.find(lemma);
    }

    @Override
    public Word createWord(String lemma) {
        Word newWord = new Word(new Lemma(lemma));
        this.saveWord(newWord);
        return newWord;
    }

    @Override
    public void saveWord(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void removeWord(String lemma) {
        wordRepository.remove(lemma);
    }

    @Override
    public Synset findSynset(SynsetId synsetId) {
        return synsetRepository.find(synsetId);
    }

    @Override
    public Synset createSynset(Pos pos) {
        Synset newSynset;
        SynsetId newSynsetId = synsetRepository.nextSynsetId();
        switch (pos) {
            case VERB:
                newSynset = new SynsetVerb(newSynsetId, SynsetType.VERB);
                break;
            case ADJECTIVE:
                newSynset = new SynsetAdjective(newSynsetId, SynsetType.VERB);
                break;
            default:
                newSynset = new Synset(newSynsetId, SynsetType.VERB);
                break;
        }
        this.saveSynset(newSynset);
        return newSynset;
    }

    @Override
    public void saveSynset(Synset synset) {
        synsetRepository.save(synset);
    }

    @Override
    public void removeSynset(SynsetId synsetId) {
        synsetRepository.remove(synsetId);
    }

    @Override
    public Frame findFrame(FrameId frameId) {
        return frameRepository.find(frameId);
    }

    @Override
    public Frame createFrame(String text) {
        Frame newFrame = new Frame(frameRepository.nextFrameId(), new TextRepresentation(text));
        this.saveFrame(newFrame);
        return newFrame;
    }

    @Override
    public void saveFrame(Frame frame) {
        frameRepository.save(frame);
    }

    @Override
    public void removeFrame(FrameId frameId) {
        frameRepository.remove(frameId);
    }

    @Override
    public Example findExample(ExampleId exampleId) {
        return exampleRepository.find(exampleId);
    }

    @Override
    public Example createExample(String text) {
        Example newExample = new Example(exampleRepository.nextExampleId(), new TextRepresentation(text));
        this.saveExample(newExample);
        return newExample;
    }

    @Override
    public void saveExample(Example example) {
        exampleRepository.save(example);
    }

    @Override
    public void removeExample(ExampleId exampleId) {
        exampleRepository.remove(exampleId);
    }

}
