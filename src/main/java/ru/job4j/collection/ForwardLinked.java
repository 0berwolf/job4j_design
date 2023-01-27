package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> l = head;
            while (l.next != null) {
                l = l.next;
            }
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.item;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value, null);
        newNode.next = head;
        head = newNode;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T element = head.item;
        Node<T> newNode = head.next;
        head.item = null;
        head.next = null;
        head = newNode;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.item;
                node = node.next;
                return value;
            }
        };
    }


    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
