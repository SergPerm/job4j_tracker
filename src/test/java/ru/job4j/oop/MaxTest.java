package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void testMax2() {
        assertThat(Max.max(4, 5), is(5));
    }

    @Test
    public void testMax3() {
        assertThat(Max.max(8, 5, 3), is(8));
    }

    @Test
    public void testMax4() {
        assertThat(Max.max(4, 5, 8, 7), is(8));
    }
}