package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
//    private final Item[] items = new Item[100];
    List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item[] findByName(String key) {
        Item[] itemsRes = new Item[size];
        int counter = 0;
        for (int index = 0; index < size; index++) {
            Item name = items.get(index);
            if (name.getName().equals(key)) {
                itemsRes[counter] = name;
                counter++;
            }
        }
        itemsRes = Arrays.copyOf(itemsRes, counter);
        return itemsRes;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
//            System.arraycopy(items, index + 1, items, index, size - index - 1);
//            items.set(size - 1, null);
//            size--;
            items.remove(index);
            size--;
        }
        return rsl;
    }
}