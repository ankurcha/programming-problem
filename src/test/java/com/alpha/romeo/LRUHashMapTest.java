package com.alpha.romeo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: achauhan
 * Date: 7/12/12
 */
public class LRUHashMapTest {

    LRUMap<Integer, String> lruHashMap = new LRUHashMap<Integer, String>(3);

    @Before
    public void setUp() throws Exception {
        this.lruHashMap.put(1, "Obj1");
        this.lruHashMap.put(2, "Obj2");
        this.lruHashMap.put(3, "Obj3");
        this.lruHashMap.put(4, "Obj4");
    }

    @Test
    public void test_LRU() throws Exception {

        Assert.assertNotNull(this.lruHashMap.get(2));
        Assert.assertNotNull(this.lruHashMap.get(3));
        Assert.assertNull(this.lruHashMap.get(1));

        Assert.assertNull(this.lruHashMap.get(5));

        Assert.assertNotNull(this.lruHashMap.get(4));
        this.lruHashMap.put(5, "Obj5");
        Assert.assertNull(this.lruHashMap.get(2));
        Assert.assertNotNull(this.lruHashMap.get(5));

    }
}
