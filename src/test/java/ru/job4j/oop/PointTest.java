package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void testPoint2() {
        Point first = new Point(0, 0);
        Point second = new Point(3, 4);
        double result = first.distance(second);
        assertThat(result, closeTo(5, 0.001));
    }

    @Test
    public void testPoint3() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(3, 4, 5);
        double result = first.distance(second);
        assertThat(result, closeTo(7.071, 0.001));
    }
}