package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter id for edit : ");
        String name = input.askStr("Enter new name : ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Edit successfully");
        } else {
            System.out.println("Error. Wrong id :" + id);
        }
        return true;
    }
}
