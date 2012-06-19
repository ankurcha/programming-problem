package com.alpha.romeo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * A simple string based implementation of the Anagram finder
 *
 * User: achauhan
 * Date: 6/18/12
 */
public class StringKeyedAnagramFinder implements AnagramFinder {

    DataReader reader;

    public DataReader getReader() {
        return reader;
    }

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public StringKeyedAnagramFinder(DataReader reader) {
        this.reader = reader;
    }

    /**
     * Accepts a string of words( whitespace delimited ) and produces a list of words that are anagrams
     *
     * @return List of anagrams, if str is blank then an empty list is returned
     * @throws java.io.IOException if IO Exception occurs while reading the file
     */
    public Map getAnagramMap() throws IOException {

        String str = this.getReader().read();

        if(StringKeyedAnagramFinder.isBlank(str)) {
            return null;
        }

        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        HashSet<String> hasAnagrams = new HashSet<String>();

        // Tokenize the string
        String[] words = str.toLowerCase().split("\\b+");
        for(String word: words) {
            if(StringKeyedAnagramFinder.isBlank(word)) {
                continue;
            }
            // Sort the characters of the word
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String anagramKey = String.valueOf(characters);

            List<String> anagramList = null;
            if(anagramMap.containsKey(anagramKey)) {
                anagramList = anagramMap.get(anagramKey);
                hasAnagrams.add(anagramKey);
            }
            if(anagramList == null) {
                anagramList = new ArrayList<String>();
                anagramMap.put(anagramKey, anagramList);
            }

            if(!anagramList.contains(word)) {
                anagramList.add(word);
            }
        }

        // Now we get rid of all the entries that do not have anagrams
        String keys[] = new String[anagramMap.size()];
        for(String key: anagramMap.keySet().toArray(keys)) {
            if(!hasAnagrams.contains(key)) {
                anagramMap.remove(key);
            }
        }
        return anagramMap;
    }


    /**
     * Checks if a String is whitespace, empty ("") or null.
     * @param str String to check
     * @return <code>true</code> if the String is null or empty or is whitespace(s)
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

}
