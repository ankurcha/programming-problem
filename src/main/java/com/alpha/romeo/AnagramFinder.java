package com.alpha.romeo;

import java.io.IOException;
import java.util.Map;

/**
 * Generic interface that defines the anagramFinder class
 *
 * User: achauhan
 * Date: 6/19/12
 */
public interface AnagramFinder {
    public void setReader(DataReader reader);
    public DataReader getReader();

    public Map getAnagramMap() throws IOException;
}
