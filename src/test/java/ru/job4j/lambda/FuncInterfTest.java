package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncInterfTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FuncInterf function = new FuncInterf();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        FuncInterf function = new FuncInterf();
        List<Double> result = function.diapason(2, 5, x -> x * x + 1);
        List<Double> expected = Arrays.asList(5D, 10D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenOtherFunctionThenLinearResults() {
        FuncInterf function = new FuncInterf();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2D, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}