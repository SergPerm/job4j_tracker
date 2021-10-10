package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamArray {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, -8, 9, -14, 0, 36, 48, -19));
        List<Integer> result = numbers.stream().filter(x -> x >= 0).collect(Collectors.toList());
        result.forEach(System.out::println);

    }
}
