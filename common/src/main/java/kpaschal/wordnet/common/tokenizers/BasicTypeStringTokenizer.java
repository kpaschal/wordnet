package kpaschal.wordnet.common.tokenizers;

import java.util.StringTokenizer;

/**
 *
 * @author
 */
public class BasicTypeStringTokenizer extends StringTokenizer {

    public BasicTypeStringTokenizer(String str, String delim, boolean returnDelims) {
        super(str, delim, returnDelims);
    }

    public BasicTypeStringTokenizer(String str, String delim) {
        super(str, delim);
    }

    public BasicTypeStringTokenizer(String str) {
        super(str);
    }

    /**
     * Converts the next token into a byte
     *
     * @return next byte
     */
    public int nextByte() {
        return Byte.parseByte(nextToken());
    }

    /**
     * Converts the next token into a short
     *
     * @return next short
     */
    public int nextShort() {
        return Short.parseShort(nextToken());
    }

    /**
     * Converts the next token into an int
     *
     * @return next integer
     */
    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    /**
     * Converts the next token into an int with base <var>radix</var>
     *
     * @param radix the base into which to convert the next token
     * @return integer with base <var>radix</var>
     */
    public int nextInt(int radix) {
        return Integer.parseInt(nextToken(), radix);
    }

    /**
     * Converts the next token into a base 16 int.
     *
     * @return int of a base 16
     */
    public int nextHexInt() {
        return nextInt(16);
    }

    /**
     * Converts the next token into a long
     *
     * @return next long
     */
    public long nextLong() {
        return Long.parseLong(nextToken());
    }
}
