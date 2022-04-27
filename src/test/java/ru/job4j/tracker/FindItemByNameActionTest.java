package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByNameActionTest {

    @Test
    public void whenMockWithParameter() {
    Output out = new StubOutput();
    Store tracker = new MemTracker();
    Item item1 = new Item("Item1");
    tracker.add(item1);
    Item item2 = new Item("Item2");
    tracker.add(item2);

    FindItemByNameAction findItemByNameAction = new FindItemByNameAction(out);

    Input input = mock(Input.class);

    when(input.askStr(any(String.class))).thenReturn("Item2");

        findItemByNameAction.execute(input, tracker);

    String ln = System.lineSeparator();
    assertThat(out.toString(), is("=== Find Items by name ====" + ln
                + item2 + ln));
}

    @Test
    public void whenMockWithWrongParameter() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemByNameAction findItemByNameAction = new FindItemByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item3");

        findItemByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Items by name ====" + ln
                + "Заявки с таким именем не найдены" + ln));
    }
}