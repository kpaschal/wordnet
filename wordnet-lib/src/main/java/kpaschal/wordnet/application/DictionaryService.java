package kpaschal.wordnet.application;

import kpaschal.wordnet.domain.dictionary.Example;
import kpaschal.wordnet.domain.dictionary.ExampleId;
import kpaschal.wordnet.domain.dictionary.Frame; 
import kpaschal.wordnet.domain.dictionary.FrameId;
import kpaschal.wordnet.domain.dictionary.Pos;
import kpaschal.wordnet.domain.dictionary.Synset;
import kpaschal.wordnet.domain.dictionary.SynsetId;
import kpaschal.wordnet.domain.dictionary.Word;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface DictionaryService {

    public Word findWord(String lemma);
    public Word createWord(String lemma);
    public void saveWord(Word word);
    public void removeWord(String lemma);
    
    public Synset findSynset(SynsetId synsetId);
    public Synset createSynset(Pos pos);
    public void saveSynset(Synset synset);
    public void removeSynset(SynsetId synsetId); 
    
    public Frame findFrame(FrameId frameId);
    public Frame createFrame(String text);
    public void saveFrame(Frame frame);
    public void removeFrame(FrameId frameId);
    
    public Example findExample(ExampleId exampleId);
    public Example createExample(String text);
    public void saveExample(Example example);
    public void removeExample(ExampleId exampleId);
    
}
