package ru.job4j.kiss;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MaxMinTest {

    private static List<String> attachments;
    private static Comparator<String> comparator;

    @BeforeClass
    public static void setUp() throws Exception {
        attachments = Arrays.asList(
                "Hello World",
                "I love Java language",
                "job4j"
        );
        comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
    }

    @Test
    public void whenMaxThenMaxLongString() {
        MaxMin maxMin = new MaxMin();
        String result = "I love Java language";
        assertThat(maxMin.max(attachments, comparator), is(result));
    }

    @Test
    public void whenMinThenMinLongString() {
        MaxMin maxMin = new MaxMin();
        String result = "job4j";
        assertThat(maxMin.min(attachments, comparator), is(result));
    }
}