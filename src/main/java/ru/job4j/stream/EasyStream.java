package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private static EasyStream template;
    private static List<Integer> tmp;

    private EasyStream() {
        super();
    }

    public static EasyStream of(List<Integer> source) {
        try {
            template = new EasyStream();
            tmp = new ArrayList<>(source);
            return template;
        } catch (Exception ex) {
            throw new UnsupportedOperationException("не верный тип данных");
        }
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        ListIterator<Integer> listIterator = tmp.listIterator();
        try {
            while (listIterator.hasNext()) {
                Integer element = listIterator.next();
                listIterator.set(fun.apply(element));
            }
            return template;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public EasyStream filter(Predicate<Integer> fun) {
        ListIterator<Integer> listIterator = tmp.listIterator();
        try {
            while (listIterator.hasNext()) {
                Integer element = listIterator.next();
                if (!fun.test(element)) {
                    listIterator.remove();
                }
            }
            return template;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public List<Integer> collect() {
        try {
            return new ArrayList<>(tmp);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}