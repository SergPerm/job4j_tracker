package ru.job4j.pojo;

public class Book {
    private String name;
    private int amountOfPage;

    public Book(String name, int amountOfPage) {
        this.name = name;
        this.amountOfPage = amountOfPage;
    }

    public Book() {
        this.name = null;
        this.amountOfPage = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfPage() {
        return amountOfPage;
    }

    public void setAmountOfPage(int amountOfPage) {
        this.amountOfPage = amountOfPage;
    }
}
