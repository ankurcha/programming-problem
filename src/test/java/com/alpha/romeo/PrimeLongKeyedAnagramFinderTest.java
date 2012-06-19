package com.alpha.romeo;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User: achauhan
 * Date: 6/19/12
 */
public class PrimeLongKeyedAnagramFinderTest {

    AnagramFinder anagramFinder;

    @Test
    public void testGetAnagramMap_blank() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "";
            }
        };
        anagramFinder = new PrimeLongKeyedAnagramFinder(reader);

        Assert.assertEquals(null, anagramFinder.getAnagramMap());
    }

    @Test
    public void testGetAnagramMap_null() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return null;
            }
        };
        anagramFinder = new PrimeLongKeyedAnagramFinder(reader);

        Assert.assertEquals(null, anagramFinder.getAnagramMap());
    }

    @Test
    public void testGetAnagramMap_oneWord() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "hello";
            }
        };
        anagramFinder = new PrimeLongKeyedAnagramFinder(reader);

        Assert.assertEquals(0, anagramFinder.getAnagramMap().size());
    }

    @Test
    public void testGetAnagramMap_regular_test() throws Exception {
        DataReader reader = new DataReader() {
            public String read() throws IOException {
                return "scare races cares another acres car arc kile like ikel none fun foobar barfoo ofoarb";
            }
        };
        anagramFinder = new PrimeLongKeyedAnagramFinder(reader);

        Map<String, List<String>> result = anagramFinder.getAnagramMap();
        Assert.assertEquals(4, result.size());
    }
}
