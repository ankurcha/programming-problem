package com.alpha.romeo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: achauhan
 * Date: 6/18/12
 */
public class PrettyPrintingMapTest {

    PrettyPrintingMap prettyPrintingMap;

    final Map<String, List<String>> testMap = new HashMap<String, List<String>>() {{
        put("test1", new ArrayList<String>() {{
            add("value1");
            add("value2");
        }});
        put("test2", new ArrayList<String>() {{
            add("value3");
        }});
        put("test3", new ArrayList<String>());
        put("test4", null);
    }};


    @Test
    public void testToString_WithMap() throws Exception {
        prettyPrintingMap = new PrettyPrintingMap(testMap);
        Assert.assertEquals("test1=\"[value1, value2]\", \n" +
                "test4=\"null\", \n" +
                "test2=\"[value3]\", \n" +
                "test3=\"[]\"\n", prettyPrintingMap.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testToString_Null() throws Exception {
        prettyPrintingMap = new PrettyPrintingMap(null);
        prettyPrintingMap.toString();
    }
}
