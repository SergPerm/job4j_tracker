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
        ListIterator<Integer> listIterator = tmp.listIterator();
            while (listIterator.hasNext()) {
                Integer element = listIterator.next();
                listIterator.set(fun.apply(element));
            }
            return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        tmp.removeIf(element -> !fun.test(element));
        return this;
    }

    public List<Integer> collect() {
            return new ArrayList<>(tmp);
    }
}