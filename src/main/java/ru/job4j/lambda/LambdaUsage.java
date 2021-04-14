package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> attach = Arrays.asList(
                "1. Task",
                "21. Task",
                "111. Task"
        );

        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        System.out.println(attach);
        System.out.println();
        attach.sort(comparator);
        System.out.println(attach);
    }
}
