package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instant = null;
    private MemTracker memTracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instant == null) {
            instant = new SingleTracker();
        }
        return instant;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}
