package com.bobocode;

import java.util.Arrays;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size = 0;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    @SafeVarargs
    static <T> List<T> of(T... elements) {
        List<T> linkedList = new LinkedList<>();
        Arrays.stream(elements)
                .forEach(linkedList::add);
        return linkedList;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
            head.next = head;
            head.prev = head;
            size++;
        } else {
            insertNode(element, head);
        }
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index == 0) {
            if (isEmpty()) {
                add(element);
            } else {
                head = insertNode(element, head);
            }
        } else {
            insertNode(element, findNode(index - 1).next);
        }
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        Node<T> node = findNode(index);
        node.value = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        return findNode(index).value;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if (index == 0) {
            Node<T> newHead = head.next;
            newHead.prev = head.prev;
            head.prev.next = newHead;
            head = newHead;
            size--;
            return;
        }
        Node<T> node = findNode(index);
        Node<T> previousNode = node.prev;

        previousNode.next = node.next;
        node.next.prev = previousNode;
        size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        Node<T> node = head;
        while(node.next != head) {
            if (node.value == element) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private Node<T> findNode(int index) {
        if (size - 1 < index || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        while(index > 0) {
            index--;
            node = node.next;
        }
        return node;
    }

    private Node<T> insertNode(T element, Node<T> nextNode) {
        Node<T> newNode = new Node<>(element);
        Node<T> prevNode = nextNode.prev;

        newNode.prev = prevNode;
        newNode.next = nextNode;

        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;

        return newNode;
    }

    private class Node<V> {
        private V value;
        private Node<V> next;
        private Node<V> prev;

        Node(V value) {
            this.value = value;
        }
    }
}
