package kpaschal.wordnet.common.message;

/**
 *
 * @author
 */
public interface IMessageType {

    public IMessageType getLevel();

    public String getLabel();

    @Override
    public boolean equals(Object obj);
}
