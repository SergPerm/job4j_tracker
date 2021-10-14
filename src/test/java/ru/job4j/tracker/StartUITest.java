package ru.job4j.tracker;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Store store = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(out));
            actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(store.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Replaced item"));
        int id = item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(store.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Deleted item"));
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(store.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemByID() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Find item by ID"));
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
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIDAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenShowAllItems() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Show Items"));
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
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowItemsAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindItemByName() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item item = store.add(new Item("Find item by Name"));
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
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0"}
        );
        Store store = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, store, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                        + "=== good bay ====" + ln
                )
        );
    }
}