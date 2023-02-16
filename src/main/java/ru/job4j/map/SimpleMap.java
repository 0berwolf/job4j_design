package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

   @Override
    public boolean put(K key, V value) {
        expand();
        boolean result = false;
        int index = xHash(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
       return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
       return hash & (capacity - 1);
    }

    private void expand() {
        if (count >= table.length * LOAD_FACTOR) {
            capacity *= 2;
            MapEntry<K, V>[] desc = new MapEntry[capacity];
            for (MapEntry<K, V> newMapEntry : table) {
                if (newMapEntry != null) {
                    int index = xHash(newMapEntry.key);
                        desc[index] = newMapEntry;
                }
            }
            table = desc;
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        int index = xHash(key);
        if (table[index] != null) {
            if (Objects.hashCode(key) == Objects.hashCode(table[index].key)
                    && Objects.equals(key, table[index].key)) {
                value = table[index].value;
            }
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = xHash(key);
        if (table[index] != null && Objects.hashCode(key) == Objects.hashCode(table[index].key)
                && Objects.equals(key, table[index].key)) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int pointer = 0;
            int expectModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                while (pointer < table.length && table[pointer] == null) {
                    pointer++;
                }
                return pointer < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[pointer++].key;
            }
        };
    }

    private int xHash(K key) {
       return key == null ? 0 : indexFor(hash(key.hashCode()));
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
