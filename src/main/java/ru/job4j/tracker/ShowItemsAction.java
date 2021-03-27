package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    private final Output out;

    public ShowItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item it : items) {
            out.println(it);
        }
        return true;
    }
}
