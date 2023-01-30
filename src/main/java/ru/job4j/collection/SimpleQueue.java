package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int stackIn = 0;
    private int stackOut = 0;


    public T poll() {
        if (stackIn == 0 && stackOut == 0) {
            throw new NoSuchElementException();
        }
        if (stackOut == 0) {
            while (stackIn != 0) {
                out.push(in.pop());
                stackIn--;
                stackOut++;
            }
        }
        T rsl = out.pop();
        stackOut--;
        return rsl;
    }

    public void push(T value) {
        in.push(value);
        stackIn++;
    }
}
