package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial n = " + n + " == " + calc(n));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n less than zero");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}