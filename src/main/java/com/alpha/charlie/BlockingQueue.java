package com.alpha.charlie;

import java.util.ArrayList;

/**
 *
 * Blocks callers of add if queue is of some max size
 * Blocks callers of remove if queue is empty
 * 
 * User: achauhan
 * Date: 10/10/12
 */
public class BlockingQueue<T> {
    private static final int MAX_DEFAULT = 10;

    ArrayList<T> queue;
    int maxSize; // Default max

    public BlockingQueue() {
        this(MAX_DEFAULT);
    }

    public BlockingQueue(int maxSize) {
        this(new ArrayList<T>(maxSize), maxSize);
    }

    public BlockingQueue(ArrayList<T> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }


    public synchronized void add(T value) {
        while(this.queue.size() == this.maxSize) {
            try {
                this.wait();
            } catch (InterruptedException ignored) { }
        }
        // Got the lock and capacity
        this.queue.add(value);
        notifyAll();
    }

    public synchronized T remove() {
        while(this.queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException ignored) { }
        }
        T retval = this.queue.remove(0);
        notifyAll();
        return retval;
    }
}
