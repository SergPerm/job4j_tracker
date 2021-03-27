package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {
    private final Output out;

    public FindItemByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter id for search : ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            out.println(rsl.toString());
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
