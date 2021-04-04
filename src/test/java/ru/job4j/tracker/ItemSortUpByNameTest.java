package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortUpByNameTest {

    @Test
    public void whenSortUp() {
        Item name1 = new Item("name1");
        Item name2 = new Item("name2");
        Item name3 = new Item("name3");
        Item name4 = new Item("name4");
        Item name5 = new Item("name5");

        List<Item> items = new ArrayList();
        items.add(name1);
        items.add(name5);
        items.add(name2);
        items.add(name4);
        items.add(name3);
        List<Item> rsl = new ArrayList();
        rsl.add(name1);
        rsl.add(name2);
        rsl.add(name3);
        rsl.add(name4);
        rsl.add(name5);
        Collections.sort(items, new ItemSortUpByName());
        assertThat(items, is(rsl));
    }
}