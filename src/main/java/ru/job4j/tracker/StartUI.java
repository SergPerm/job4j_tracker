package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                println("=== Create a new Item ====");
                print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                println("=== Show all items ====");
                Item[] items = tracker.findAll();
                showArray(items);
            } else if (select == 2) {
                println("=== Edit Item ====");
                print("Enter id for edit : ");
                int id = Integer.parseInt(scanner.nextLine());
                print("Enter new name : ");
                String name = scanner.nextLine();
                if (tracker.replace(id, new Item(name))) {
                    println("Edit successfully");
                } else {
                    println("Error. Wrong id :" + id);
                }
            } else if (select == 3) {
                println("=== Delete Item ====");
                print("Enter id for delete : ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    println("Delete successfully");
                } else {
                    println("Error. Wrong id :" + id);
                }
            } else if (select == 4) {
                println("=== Find Item by Id ====");
                print("Enter id for search : ");
                int id = Integer.parseInt(scanner.nextLine());
                Item rsl = tracker.findById(id);
                if (rsl != null) {
                    println(rsl.toString());
                } else {
                    println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                println("=== Find Items by name ====");
                print("Enter name: ");
                String name = scanner.nextLine();
                Item[] rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    showArray(rsl);
                } else {
                    println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                println("=== good bay ====");
                run = false;
            } else {
                println("Такой команды нет, попробуйте снова");
            }
        }
    }

    private void showMenu() {
        println("Menu:\n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }

    private void print(String s) {
        System.out.print(s);
    }

    private void println(String str) {
        System.out.println(str);
    }

    private void showArray(Item[] arrayShow) {
        for (Item it : arrayShow) {
            println(it.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
