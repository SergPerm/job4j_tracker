package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, MemTracker memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int index = 0;
        for (UserAction action : actions) {
            out.println(index + ". " + action.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ShowItemsAction(out));
        actions.add(new EditAction(out));
        actions.add(new FindItemByIDAction(out));
        actions.add(new FindItemByNameAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
    }
}
