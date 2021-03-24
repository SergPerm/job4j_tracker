package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Boris");
        tracker.add(item);
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        Item bug1 = new Item();
        bug1.setName("Bug1");
        tracker.add(bug1);
        Item bug5 = new Item();
        bug5.setName("Bug5");
        tracker.add(bug5);
        Item bug7 = new Item();
        bug7.setName("Bug7");
        tracker.add(bug7);
        Item[] items = tracker.findAll();
        for (Item value : items) {
            System.out.println(value);
        }
        int id = bug1.getId();
        tracker.delete(id);
        System.out.println("delete bug1");
        items = tracker.findAll();
        for (Item value : items) {
            System.out.println(value);
        }
    }
}