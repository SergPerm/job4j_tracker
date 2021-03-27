package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Enter id for delete : ");
        if (tracker.delete(id)) {
            System.out.println("Delete successfully");
        } else {
            System.out.println("Error. Wrong id :" + id);
        }
        return true;
    }
}
