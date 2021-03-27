package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        int id = item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemByID() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item by ID"));
        int id = item.getId();
        String expected = "Menu." + ln
                        + "0. Find Item by Id" + ln
                        + "1. Exit" + ln
                        + "=== Find Item by Id ====" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find Item by Id" + ln
                        + "1. Exit" + ln
                        + "=== good bay ====" + ln;
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        UserAction[] actions = {
                new FindItemByIDAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenShowAllItems() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show Items"));
        String expected = "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ====" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== good bay ====" + ln;
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowItemsAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindItemByName() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item by Name"));
        String name = item.getName();
        String expected = "Menu." + ln
                        + "0. Find Item by Name" + ln
                        + "1. Exit" + ln
                        + "=== Find Items by name ====" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find Item by Name" + ln
                        + "1. Exit" + ln
                        + "=== good bay ====" + ln;
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(expected));
    }
}