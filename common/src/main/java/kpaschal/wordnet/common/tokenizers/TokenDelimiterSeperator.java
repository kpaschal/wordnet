package kpaschal.wordnet.common.tokenizers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author
 */
public class TokenDelimiterSeperator {

    private static String _DEFAULT_DELIMITERS = "!@#$%^&*()-+:;/";
    private List<String> tokens_;
    private List<String> dels_;

    public TokenDelimiterSeperator(String str) {
        this(str, _DEFAULT_DELIMITERS);
    }

    public TokenDelimiterSeperator(String str, String dels) {
        tokens_ = new ArrayList<String>();
        dels_ = new ArrayList<String>();
        int lastDelPos = -1;
        for (int i = 0; i < str.length(); i++) {
            if (-1 < dels.indexOf(str.charAt(i))) {
                tokens_.add(str.substring(lastDelPos + 1, i));
                dels_.add(Character.toString(str.charAt(i)));
                lastDelPos = i;
            }
        }
    }

    public List<String> getTokens() {
        return tokens_;
    }

    public Iterator<String> getTokenIterator() {
        return tokens_.iterator();
    }

    public List<String> getDelimiters() {
        return dels_;
    }

    public Iterator<String> getDelimiterIterator() {
        return dels_.iterator();
    }
}
