package com.bobocode;

import org.junit.platform.engine.support.hierarchical.Node;

import java.util.Arrays;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> lastNode;
    private int size = 0;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        LinkedList linkedList = new LinkedList();
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
        if (head == null) {
            head = new Node(element);
            head.setNext(head);
            lastNode = head;
        } else {
            Node newNode = new Node(element);
            newNode.setNext(head);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        size++;
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
            if (head == null) {
                add(element);
            } else {
                Node<T> newNode = new Node<>(element);
                newNode.setNext(head);
                head = newNode;
                size++;
            }
        } else {
            Node<T> node = findNode(index - 1);
            Node<T> next = node.getNext();
            Node<T> newNode = new Node<>(element);
            node.setNext(newNode);
            newNode.setNext(next);
            size++;
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
        node.setValue(element);
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
        return findNode(index).getValue();
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
            head = findNode(1);
            size--;
            return;
        }
        Node<T> node = findNode(index);
        Node<T> previousNode = findNode(index - 1);
        previousNode.setNext(node.getNext());
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
        while(node.getNext() != head) {
            if (node.getValue() == element) {
                return true;
            }
            node = node.getNext();
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

    private Node<T> findNode(int index) {
        if (index < 0 || index > size - 1 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        while(index > 0) {
            index--;
            node = node.getNext();
        }
        return node;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
