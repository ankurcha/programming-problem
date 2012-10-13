package com.alpha.charlie;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: achauhan
 * Date: 10/12/12
 */
public class TreeParserTest {
    TreeParser parser = new TreeParser();

    @Test
    public void testFind_depth() throws Exception {
        Assert.assertEquals(0, parser.find_depth("(00)"));
        Assert.assertEquals(1, parser.find_depth("((00)0)"));
        Assert.assertEquals(1, parser.find_depth("((00)(00))"));
        Assert.assertEquals(2, parser.find_depth("((00)(0(00)))"));
        Assert.assertEquals(3, parser.find_depth("((00)(0(0(00))))"));
        Assert.assertEquals(-1, parser.find_depth("x"));
        Assert.assertEquals(-1, parser.find_depth("0"));
        Assert.assertEquals(-1, parser.find_depth("()"));
        Assert.assertEquals(-1, parser.find_depth("(0)"));
        Assert.assertEquals(-1, parser.find_depth("(00)x"));
        Assert.assertEquals(-1, parser.find_depth("(0p)"));
    }
}
