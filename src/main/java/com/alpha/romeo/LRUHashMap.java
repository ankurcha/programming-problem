package com.alpha.romeo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This is an implementation of LRU hashmap of fixed size
 * User: achauhan
 * Date: 7/12/12
 */
public class LRUHashMap<K, V> implements LRUMap<K, V>{

    private static final int DEFAULT_MAP_SIZE = 100;

    private Map<K, V> map;
    private LinkedList<K> evictionList;

    private int maxSize;

    public LRUHashMap() {
        this(LRUHashMap.DEFAULT_MAP_SIZE);
    }

    public LRUHashMap(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<K, V>(this.maxSize);
        this.evictionList = new LinkedList<K>();
    }

    public V get(K key) {
        V value = null;
        if(key != null) {
            // Find the value in the hashmap
            if(map.containsKey(key)) {
                value = this.map.get(key);
                // Update the eviction priority
                if(this.evictionList.contains(key)) {
                    this.evictionList.remove(key);
                }
                this.evictionList.addFirst(key);
            }
        }
        return value;
    }

    public void put(K key, V value) {
        if(key == null) {
            return;
        }

        if(map.size() >= maxSize) {
            // perform eviction
            this.performEviction();
        }
        this.evictionList.addFirst(key);
        this.map.put(key,  value);

    }

    /**
     * Performs LRU eviction on the map
     */
    private void performEviction() {
        if(this.map.size() == 0 || this.evictionList.size() == 0) {
            return;
        }
        this.map.remove(this.evictionList.removeLast());
    }

}
