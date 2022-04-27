package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenMockWithParameter() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        tracker.add(item1);
        Item item2 = new Item("Item2");
        tracker.add(item2);

        DeleteAction delete = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        delete.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete Item ====" + ln
                + "Delete successfully" + ln));
    }

    @Test
    public void whenMockWithWrongParameter() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        DeleteAction delete = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(3);

        delete.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete Item ====" + ln
                + "Error. Wrong id :3" + ln));
    }
}