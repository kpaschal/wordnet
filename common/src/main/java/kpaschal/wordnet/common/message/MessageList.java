package kpaschal.wordnet.common.message;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class MessageList extends ArrayList<Message> {

    public MessageList() {
        super();
    }

    public MessageList(Message msg) {
        super();
        add(msg);
    }

    public MessageList get(IMessageType level) {
        MessageList list = new MessageList();
        for (Message msg : this) {
            if (msg.getLevel().equals(level)) {
                list.add(msg);
            }
        }
        return list;
    }

    public boolean has(IMessageType level) {
        return !get(level).isEmpty();
    }
}
