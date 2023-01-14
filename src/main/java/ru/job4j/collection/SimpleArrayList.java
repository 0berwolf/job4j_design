package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        check(size);
        container[size++] = value;
        modCount++;
    }

    private void check(int size) {
        if (container.length <= size) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        if (container.length == 0) {
            container = Arrays.copyOf(container, 10);
        }
    }


    @Override
    public T set(int index, T newValue) {
        T stValue = get(index);
        container[index] = newValue;
        return stValue;
    }

    @Override
    public T remove(int index) {
        T value = get(index);
        if (index + 1 != size) {
            System.arraycopy(container, index + 1, container, index, size - index - 1);
        }
        container[--size] = null;
        modCount++;
        return value;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}
