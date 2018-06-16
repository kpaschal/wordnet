package kpaschal.wordnet.common.message;

/**
 *
 * @author
 */
public class Message {

    private IMessageType level_;
    private String msg_;

    public Message(IMessageType level, String msg) {
        level_ = level;
        msg_ = msg;
    }

    public void setLevel(IMessageType level) {
        level_ = level;
    }

    public IMessageType getLevel() {
        return level_;
    }

    public void setMessage(String msg) {
        msg_ = msg;
    }

    public String getMessage() {
        return msg_;
    }

    @Override
    public String toString() {
        return level_.getLabel() + " " + msg_;
    }
}
