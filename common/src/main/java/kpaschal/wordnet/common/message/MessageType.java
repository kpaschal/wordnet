package kpaschal.wordnet.common.message;

public class MessageType implements IMessageType {

    public static MessageType NONE = new MessageType("");
    public static MessageType INFO = new MessageType("Info");
    public static MessageType ERROR = new MessageType("Error");
    public static MessageType WARNING = new MessageType("Warning");

    @Override
    public IMessageType getLevel() {
        return this;
    }

    @Override
    public String getLabel() {
        return label_;
    }
    private final String label_;

    private MessageType(String label) {
        label_ = label;
    }
}