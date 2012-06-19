package com.alpha.romeo;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * User: achauhan
 * Date: 6/18/12
 */
public class FileDataReaderTest {

    DataReader reader;

    @Test
    public void testRead_text() throws Exception {
        reader = new FileDataReader("src" + File.separator + "test" + File.separator + "resources" + File.separator + "testFile1.txt");
        Assert.assertEquals("scare races cares another acres car arc kile like ikel none fun foobar barfoo ofoarb", reader.read());
    }

    @Test(expected = NullPointerException.class)
    public void testRead_null() throws Exception {
        reader = new FileDataReader(null);
        reader.read();
    }
}
