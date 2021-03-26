package ru.job4j.oop;

public class OldStudent {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        OldStudent petya = new OldStudent();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();

    }
}
