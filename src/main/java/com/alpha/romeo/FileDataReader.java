package com.alpha.romeo;

import java.io.FileReader;
import java.io.IOException;

/**
 * A file based implementation of the data reader, this class accepts a file path
 * and reads the file into a string.
 *
 * User: achauhan
 * Date: 6/18/12
 */
public class FileDataReader implements DataReader {

    String filePath;

    public FileDataReader(String filePath) {
        this.filePath = filePath;
    }
    /**
     * Reads a file to a string
     * @return Contents of the file
     * @throws java.io.IOException if an I/O error occurs
     */
    public String read() throws IOException {
        FileReader in = new FileReader(this.filePath);
        StringBuilder contents = new StringBuilder();
        char[] buffer = new char[4096];
        int read = 0;
        do {
            contents.append(buffer, 0, read);
            read = in.read(buffer);
        } while (read >= 0);
        return contents.toString();
    }
}
