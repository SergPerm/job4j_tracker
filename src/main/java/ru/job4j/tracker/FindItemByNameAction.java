package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {

    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (Item it : rsl) {
                System.out.println(it);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
