package com.alpha.romeo;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User: achauhan
 * Date: 6/18/12
 */
public class StringKeyedAnagramFinderTest {

    private static final String WHITESPACE = " ";

    AnagramFinder anagramFinder;

    @Test
    public void testGetAnagramMap_blank() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "";
            }
        };
        anagramFinder = new StringKeyedAnagramFinder(reader);

        Assert.assertEquals(null, anagramFinder.getAnagramMap());
    }

    @Test
    public void testGetAnagramMap_null() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return null;
            }
        };
        anagramFinder = new StringKeyedAnagramFinder(reader);

        Assert.assertEquals(null, anagramFinder.getAnagramMap());
    }

    @Test
    public void testGetAnagramMap_oneWord() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "hello";
            }
        };
        anagramFinder = new StringKeyedAnagramFinder(reader);

        Assert.assertEquals(0, anagramFinder.getAnagramMap().size());
    }

    @Test
    public void testGetAnagramMap_regular_test() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "scare races cares another acres car arc kile like ikel none fun foobar barfoo ofoarb";
            }
        };
        anagramFinder = new StringKeyedAnagramFinder(reader);

        Map<String, List<String>> result = anagramFinder.getAnagramMap();
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void testIsBlank() {
        Assert.assertEquals(true, StringKeyedAnagramFinder.isBlank(null));
        Assert.assertEquals(true, StringKeyedAnagramFinder.isBlank(""));
        Assert.assertEquals(true, StringKeyedAnagramFinder.isBlank(WHITESPACE));
        Assert.assertEquals(false, StringKeyedAnagramFinder.isBlank("foo"));
        Assert.assertEquals(false, StringKeyedAnagramFinder.isBlank("  foo  "));
    }
}
