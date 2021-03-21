package ru.job4j.oop;

public class Fix {
    private String desk;

    public Fix(String desk) {
        this.desk = desk;
    }

    public static void main(String[] args) {
        String bug = "fix me";
        Fix fix = new Fix(bug);
    }
}
