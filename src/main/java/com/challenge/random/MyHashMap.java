package com.challenge.random;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<k, v> implements Map<k, v> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double MAX_LOAD_FACTOR = 0.75;
    private static final int GROWTH_FACTOR = 2;
    private int size = 0;
    private List<Entry<k, v>>[] slots;

    public MyHashMap(int initialCapacity) {
        slots = new LinkedList[initialCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public v get(Object key) {
        int position = getPosition((k) key);

        List<Entry<k, v>> slot = slots[position];

        if (slot != null) {
            for (Entry<k, v> existentEntry: slot) {
                Object existentEntryKey = existentEntry.getKey();
                if (Objects.equals(existentEntryKey, key)) {
                    return existentEntry.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public v put(k key, v value) {
        int position = getPosition(key);

        List<Entry<k, v>> slot = slots[position];
        if (slot == null) {
            slot = new LinkedList<>();
            Entry<k, v> newEntry = new SimpleEntry<k, v>(key, value);
            slot.add(newEntry);
            slots[position] = slot;
            size++;

            return value;
        }

        for (Entry<k, v> existentEntry: slot) {
            k existentEntryKey = existentEntry.getKey();

            if (Objects.equals(existentEntryKey, key)) {
                existentEntry.setValue(value);
                return value;
            }
        }

        Entry<k, v> newEntry = new SimpleEntry<k, v>(key, value);
        slot.add(newEntry);

        reHash();

        return value;
    }

    private void reHash() {
        double loadFactor = (double) size / slots.length;

        if (loadFactor >= MAX_LOAD_FACTOR) {
            List<Entry<k, v>>[] tmpSlots = slots;
            int capacity = slots.length * GROWTH_FACTOR;
            slots = new LinkedList[capacity];

            for (List<Entry<k, v>> slot: tmpSlots) {
                if (slot != null) {
                    for (Entry<k, v> existentEntry: slot) {
                        k existentEntryKey = existentEntry.getKey();
                        v existentEntryValue = existentEntry.getValue();

                        put(existentEntryKey, existentEntryValue);
                    }
                }
            }
        }
    }

    private int getPosition(k key) {
        int hashCode = Objects.hashCode(key);
        return hashCode % slots.length;
    }

    @Override
    public v remove(Object key) {
        int position = getPosition((k) key);

        List<Entry<k, v>> slot = slots[position];
        if (slot != null) {
            Entry<k, v> entryToRemove = null;
            for (Entry<k, v> existentEntry: slot) {
                Object existentEntryKey = existentEntry.getKey();
                if (Objects.equals(existentEntryKey, key)) {
                    entryToRemove = existentEntry;
                    break;
                }
            }

            if (entryToRemove != null) {
                if (slot.size() == 1) {
                    slots[position] = null;
                    size--;
                } else {
                    slot.remove(entryToRemove);
                }
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends k, ? extends v> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<k> keySet() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }

    @Override
    public Set<Entry<k, v>> entrySet() {
        return null;
    }

    public static void main(final String... args) {
        System.out.println("Hello!");

        Map<String, Integer> hashMap = new MyHashMap<>();

        hashMap.put(null, 0);
        hashMap.put("FB", 100);
        hashMap.put("Ea", 200);
        hashMap.put(null, 300);

        for (int i = 0; i < 100; i++) {
            hashMap.put("i" + i, i);
        }

        System.out.println(hashMap.get("FB"));  //100
        System.out.println(hashMap.get("Ea"));  //200
        System.out.println(hashMap.get(null));  //300
        System.out.println(hashMap.get("i91")); //91

        hashMap.remove(null);
        hashMap.remove("i91");

        System.out.println(hashMap.get(null));  //null
        System.out.println(hashMap.get("i91")); //null
    }
}
