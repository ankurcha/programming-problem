package com.alpha.romeo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * This implemetation of the Anagram finder uses a prime number multiplicative hash for generating the keys for the
 * anagrams.
 *
 * User: achauhan
 * Date: 6/19/12
 */
public class PrimeLongKeyedAnagramFinder implements AnagramFinder {

    /**
     * This is a carefully selected series of prime number that is in no particular order.
     *
     * All characters appearing in this work are fictitious. Any resemblance to real persons, living or dead, is purely coincidental.
     *
     */
    final int[] PRIMES = { 2, 41, 37, 47, 3, 67, 71, 23, 5, 101, 61, 17, 19, 13, 31, 43, 97, 29, 11, 7, 73, 83, 79, 89, 59, 53 };

    DataReader reader;

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public DataReader getReader() {
        return this.reader;
    }

    public PrimeLongKeyedAnagramFinder(DataReader reader) {
        this.reader = reader;
    }

    public Map getAnagramMap() throws IOException {
        String str = this.getReader().read();

        if(StringKeyedAnagramFinder.isBlank(str)) {
            return null;
        }

        Map<Long, List<String>> anagramMap = new HashMap<Long, List<String>>();
        HashSet<Long> hasAnagrams = new HashSet<Long>();

        // Tokenize the string
        String[] words = str.toLowerCase().split("\\b+");
        for(String word: words) {
            if(StringKeyedAnagramFinder.isBlank(word)) {
                continue;
            }
            // Sort the characters of the word
            Long anagramKey = getKey(word);

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
        Long keys[] = new Long[anagramMap.size()];
        for(Long key: anagramMap.keySet().toArray(keys)) {
            if(!hasAnagrams.contains(key)) {
                anagramMap.remove(key);
            }
        }
        return anagramMap;
    }

    /**
     * Create a key by multiplying the PRIMES corresponding to the location
     * a -> PRIMES[0]
     * b -> PRIMES[1]
     *
     * @param str Word for which we want the key
     * @return key for the word
     */
    private Long getKey(String str) {
        Long key = 1l;

        for(char c: str.toCharArray()) {
            key *= this.PRIMES[c - 'a'];
        }

        return key;
    }
}
