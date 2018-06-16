package kpaschal.wordnet.domain.dictionary;

/**
 *
 * @author Konstantinos Paschalides (paschalideskonstantinos@gmail.com)
 */
public class FrameId {

    private long id;

    public FrameId() {
    }

    public FrameId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }

}
