package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void convertArray() {
        Integer[][] matr = {{2, 7, 9}, {3, 6, 1}, {7, 4, 2}};
        Matrix matrix = new Matrix();
        List<Integer> result = matrix.convertArray(matr);
        List<Integer> expected = List.of(2, 7, 9, 3, 6, 1, 7, 4, 2);
        assertThat(result, is(expected));

    }
}