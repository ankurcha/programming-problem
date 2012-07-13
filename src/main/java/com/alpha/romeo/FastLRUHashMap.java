package com.alpha.romeo;

import java.util.HashMap;

/**
 * User: achauhan
 * Date: 7/12/12
 */
public class FastLRUHashMap<K, V> implements LRUMap<K,V> {

    class Node<K, V> {
        Node next, prev;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int maxSize;
    HashMap<K, Node<K, V>> map;
    private static final int DEFAULT_MAP_SIZE = 100;

    public FastLRUHashMap(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<K, Node<K, V>>(this.maxSize);
        this.head = new Node<K, V>(null, null);
        this.tail = new Node<K, V>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node head;
    private Node tail;

    public V get(K key) {
        Node<K, V> node = this.map.get(key);

        if(node == null) {
            return null;
        }

        this.removeNode(node);
        this.addToHead(node);

        return node.value;
    }

    public void put(K key, V value) {
        if(maxSize <= 0) return;
        Node<K, V> node = this.map.get(key);
        if(node!=null) {
            removeNode(node);
            addToHead(node);
            node.key = key;
            node.value = value;
        } else {
            if(this.map.size() >= this.maxSize) {
                this.map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            node = new Node<K, V>(key, value);
            this.map.put(key, node);
            addToHead(node);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

}
