package ru.job4j.tracker;

import java.util.List;

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
    public boolean execute(Input input, Store store) {
        out.println("=== Show all items ====");
        List<Item> items = store.findAll();
        for (Item it : items) {
            out.println(it);
        }
        return true;
    }
}
