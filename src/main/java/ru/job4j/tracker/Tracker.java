package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = true;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = new Item(item.getName(), id);
        } else {
            rsl = false;
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsRes = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                itemsRes[size] = name;
                size++;
            }
        }
        itemsRes = Arrays.copyOf(itemsRes, size);
        return itemsRes;
    }

    public Item[] findByName(String key) {
        Item[] itemsRes = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null && name.getName().equals(key)) {
                itemsRes[size] = name;
                size++;
            }
        }
        itemsRes = Arrays.copyOf(itemsRes, size);
        return itemsRes;
    }
}