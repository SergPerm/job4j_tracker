package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByIDActionTest {

    @Test
    public void whenMockWithParameter() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemByIDAction findItemByIDAction = new FindItemByIDAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findItemByIDAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item by Id ====" + ln
                + item + ln));
    }

    @Test
    public void whenMockWithoutParameter() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindItemByIDAction findItemByIDAction = new FindItemByIDAction(out);

        Input input = mock(Input.class);

        findItemByIDAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item by Id ====" + ln
                + "Заявка с таким id не найдена" + ln));
    }
}