package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    private int indexOf(int id) {
        return tracker.indexOf(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
