package kpaschal.wordnet.infrastructure.dictionary.file.utils;

/**
 *
 * @author
 */
public class PrincetonFileFormat {

    public static String formatOffset(long offset) {
        return addZerosRight(Long.toString(offset), 8);
    }

    public static String formatLexFileNum(int lexFileNum) {
        return addZerosRight(Integer.toString(lexFileNum), 2);
    }

    public static String formatWordsCnt(int wordsCnt) {
        return addZerosRight(Integer.toHexString(wordsCnt), 2);
    }

    public static String formatNodeIndex(int wordIndex) {
        return addZerosRight(Integer.toHexString(wordIndex), 2);
    }

    public static String formatLexId(int lexId) {
        return addZerosRight(Integer.toHexString(lexId), 1);
    }

    public static String formatPointersCnt(int ptrsCnt) {
        return addZerosRight(Integer.toString(ptrsCnt), 3);
    }

    public static String formatFramesCnt(int framesCnt) {
        return addZerosRight(Integer.toString(framesCnt), 2);
    }

    public static String formatFrameId(long frameId) {
        return addZerosRight(Long.toString(frameId), 2);
    }

    public static String formatPointersTypesCnt(int ptrTypesCnt) {
        return Integer.toString(ptrTypesCnt);
    }

    public static String addZerosRight(String str, int size) {
        if (str == null) { // if null return null
            return null;
        }
        if (str.length() == size) { // the str have the desirable size
            return str;
        }
        String rStr = "";
        int spaces = size - str.length();

        for (int i = 0; i < spaces; i++) { // add zeros 
            rStr += "0";
        }
        rStr += str; // add the original string

        return rStr;
    }
}