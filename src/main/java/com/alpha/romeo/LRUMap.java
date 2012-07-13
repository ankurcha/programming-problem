package com.alpha.romeo;

/**
 * User: achauhan
 * Date: 7/12/12
 */
public interface LRUMap<K, V> {
    V get(K key);

    void put(K key, V value);
}
