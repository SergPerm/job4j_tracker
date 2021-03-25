package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item it : items) {
                    System.out.println(it);
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                int id = input.askInt("Enter id for edit : ");
                String name = input.askStr("Enter new name : ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Edit successfully");
                } else {
                    System.out.println("Error. Wrong id :" + id);
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                int id = input.askInt("Enter id for delete : ");
                if (tracker.delete(id)) {
                    System.out.println("Delete successfully");
                } else {
                    System.out.println("Error. Wrong id :" + id);
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by Id ====");
                int id = input.askInt("Enter id for search : ");
                Item rsl = tracker.findById(id);
                if (rsl != null) {
                    System.out.println(rsl.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                System.out.println("=== good bay ====");
                run = false;
            } else {
                System.out.println("Такой команды нет, попробуйте снова");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:" + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
