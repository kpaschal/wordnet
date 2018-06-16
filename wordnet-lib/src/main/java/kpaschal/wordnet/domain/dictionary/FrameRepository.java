package kpaschal.wordnet.domain.dictionary;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public interface FrameRepository {

    public Frame find(FrameId frameId);

    public void save(Frame frame);

    public void remove(FrameId frameId);

    public FrameId nextFrameId();

}
