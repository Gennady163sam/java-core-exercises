package com.bobocode;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tale;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
            tale = head;
        } else {
            tale.next = new Node<>(element);
            tale = tale.next;
        }
        size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<V> {
        private Node<V> next;
        private V value;

        Node(V value) {
            this.value = value;
        }
    }
}
