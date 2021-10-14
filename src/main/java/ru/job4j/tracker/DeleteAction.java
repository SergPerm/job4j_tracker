package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete Item ====");
        int id = input.askInt("Enter id for delete : ");
        if (store.delete(id)) {
            out.println("Delete successfully");
        } else {
            out.println("Error. Wrong id :" + id);
        }
        return true;
    }
}
