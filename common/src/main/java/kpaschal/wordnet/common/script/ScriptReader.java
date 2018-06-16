package kpaschal.wordnet.common.script;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author
 */
public class ScriptReader implements Closeable, Iterable {

    private RandomAccessFile raf;
    private static String _DEFAULT_DELIMITER = ";";
    private String delimiter;
    private String currentCommand;
    private boolean eof;

    public ScriptReader(File file) throws IOException {
        this(file, _DEFAULT_DELIMITER);
    }

    public ScriptReader(File file, String delimiter) throws IOException {
        raf = new RandomAccessFile(file, "r");
        this.delimiter = delimiter;
    }

    @Override
    public void close() {
        try {
            raf.close();
        } catch (IOException ex) {
        }
    }

    public List<String> getCommands() {
        List<String> commands = new ArrayList<String>();
        Iterator<String> it = iterator();
        while (it.hasNext()) {
            commands.add(it.next());
        }
        return commands;
    }

    @Override
    public Iterator<String> iterator() {
        try {
            raf.seek(0);
            currentCommand = null;
            eof = false;
            return new ScriptIterator();
        } catch (IOException ex) {
        }
        return new ScriptIterator();
    }

    private class ScriptIterator implements Iterator<String> {

        ScriptIterator(){}
        @Override
        public boolean hasNext() {
            if (eof) {
                return false;
            } else if (currentCommand != null) {
                return true;
            } else {
                try {
                    String command = createCommand();
                    if (command == null) {
                        eof = true;
                        return false;
                    } else {
                        currentCommand = command;
                        return true;
                    }
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            }
        }

        @Override
        public String next() {
            if (hasNext()) {
                String command = currentCommand;
                currentCommand = null;
                return command;
            } else {
                throw new IllegalStateException("End of file");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * Create command by reading lines until the specified delimiter is found
     * While doesn't find the delimiter read lines until the end of file. If end
     * of file is riched return null;
     *
     * @return
     * @throws IOException IOException
     */
    private String createCommand() throws IOException {
        StringBuilder strBuilder = new StringBuilder();
        String line;
        while ((line = raf.readLine()) != null) {
            line = line.trim();
            if (line.length() > 0) {
                if (lineIsNotComment(line)) {
                    strBuilder.append(line);
                    if (line.endsWith(delimiter)) {
                        return strBuilder.toString();
                    }
                }
            }
        }
        eof = true;
        return null;
    }

    /**
     * Return true if line starts with --,//,/*, * /
     *
     * @param line Line to check if is a comment
     * @return True if line starts with --,//,/*, * /
     */
    private boolean lineIsNotComment(String line) {
        if (line.startsWith("--") || line.startsWith("//") || line.startsWith("/*") || line.startsWith("*/")) {
            return false;
        }
        return true;
    }
}
