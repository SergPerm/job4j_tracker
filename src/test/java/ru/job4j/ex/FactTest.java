package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test
    public void when5Then120() {
        assertThat(Fact.calc(5), is(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThanZero() {
        Fact.calc(-5);
    }
}