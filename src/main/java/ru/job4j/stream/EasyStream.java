package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> tmp;

    private EasyStream(List<Integer> source) {
        this.tmp = source;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(new ArrayList<>(source));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer element : tmp) {
            rsl.add(fun.apply(element));
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer element : tmp) {
            if (fun.test(element)) {
                rsl.add(element);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
            return List.copyOf(tmp);
    }
}