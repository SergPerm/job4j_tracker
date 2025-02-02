package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find Items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> rsl = store.findByName(name);
        if (rsl.size() > 0) {
            for (Item it : rsl) {
                out.println(it);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
