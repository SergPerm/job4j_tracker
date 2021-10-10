package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Edit Item ====");
        int id = input.askInt("Enter id for edit : ");
        String name = input.askStr("Enter new name : ");
        if (memTracker.replace(id, new Item(name))) {
            out.println("Edit successfully");
        } else {
            out.println("Error. Wrong id :" + id);
        }
        return true;
    }
}
