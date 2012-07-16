package com.alpha.romeo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple implementation of a binary heap
 *
 * User: achauhan
 * Date: 7/12/12
 */
public class BinaryMaxHeap<V extends Comparable<V>> {

    List<V> h = new ArrayList<V>();

    public BinaryMaxHeap() { }

    public BinaryMaxHeap(V[] keys) {
        Collections.addAll(h, keys);

        for(int pos = h.size()/2 - 1; pos >=0 ;pos--) {
            moveDown(pos);
        }
    }

    void moveDown(int pos) {
        while(pos < h.size()/2) {
            int child = 2 * pos + 1;

            // find the larger of the two children
            if(child < h.size() - 1 && h.get(child).compareTo(h.get(child + 1)) > 0) {
                ++child;
            }

            // if root is between both of the children
            if(h.get(pos).compareTo(h.get(child)) <= 0) {
                break;
            }

            // swap larger child with root
            Collections.swap(h, pos, child);
            pos = child;
        }
    }

    void moveUp(int pos) {
        while(pos > 0) {
            int parent = (pos -1) / 2;
            if(h.get(pos).compareTo(h.get(parent)) >= 0) {
                break;
            }
            Collections.swap(h, pos, parent);
            pos = parent;
        }
    }

    public void add(V node) {
        this.h.add(node);
        this.moveUp(h.size() - 1);
    }

    public V remove() {
        V removedNode = h.get(0);
        V lastNode = h.remove(h.size() - 1);
        if(!h.isEmpty()) {
            h.set(0, lastNode);
            moveDown(0);
        }
        return removedNode;
    }
}
