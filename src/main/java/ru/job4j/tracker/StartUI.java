package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemByID(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("=== good bay ====");
                run = false;
            } else {
                System.out.println("Такой команды нет, попробуйте снова");
            }
        }
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter id for search : ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println(rsl.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Enter id for delete : ");
        if (tracker.delete(id)) {
            System.out.println("Delete successfully");
        } else {
            System.out.println("Error. Wrong id :" + id);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter id for edit : ");
        String name = input.askStr("Enter new name : ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Edit successfully");
        } else {
            System.out.println("Error. Wrong id :" + id);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    private void showMenu() {
        String ln = System.lineSeparator();
        System.out.println("Menu:" + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Edit item" + ln
                + "3. Delete item" + ln
                + "4. Find item by Id" + ln
                + "5. Find items by name" + ln
                + "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
