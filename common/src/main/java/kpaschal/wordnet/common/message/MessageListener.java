package kpaschal.wordnet.common.message;

import java.util.EventListener;
import kpaschal.wordnet.common.message.Message;

/**
 *
 * @author
 */
public interface MessageListener extends EventListener {

    public void newMessage(Message msg);
}
