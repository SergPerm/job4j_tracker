package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FuncInterf {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
    List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }

    public static void main(String[] args) {
        FuncInterf function = new FuncInterf();
        function.diapason(5, 8, x -> x * x + 1).forEach(System.out::println);
    }
}