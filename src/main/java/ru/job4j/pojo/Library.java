package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("book1", 584);
        Book book2 = new Book("book2", 189);
        Book book3 = new Book("book3", 347);
        Book book4 = new Book("Clean code", 673);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println(pr.getName() + " " + pr.getAmountOfPage());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println(pr.getName() + " " + pr.getAmountOfPage());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            if (pr.getName().equals("Clean code")) {
                System.out.println(pr.getName() + " " + pr.getAmountOfPage());
            }
        }
    }
}
