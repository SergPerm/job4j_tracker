package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Store store = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        store.add(item);
        Item result = store.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Store store = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        store.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        store.replace(id, bugWithDesc);
        assertThat(store.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Store store = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        store.add(bug);
        int id = bug.getId();
        store.delete(id);
        assertThat(store.findById(id), is(nullValue()));
    }
}