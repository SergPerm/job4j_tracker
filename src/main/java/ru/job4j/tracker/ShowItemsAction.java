package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
        return true;
    }
}
