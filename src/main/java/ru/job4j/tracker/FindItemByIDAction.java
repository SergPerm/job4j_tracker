package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter id for search : ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println(rsl.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
