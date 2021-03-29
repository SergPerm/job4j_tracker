package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleTrackerTest {

    @Test
    public void whenIsSingletonThenOneObject() {
        SingleTracker singleTracker1 = SingleTracker.getInstance();
        SingleTracker singleTracker2 = SingleTracker.getInstance();
        assertEquals(singleTracker1, singleTracker2);
    }
}