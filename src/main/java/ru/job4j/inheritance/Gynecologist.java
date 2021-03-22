package ru.job4j.inheritance;

import java.util.Date;

public class Gynecologist extends Doctor {
    private char sex;

    public Gynecologist(String name, String surname, String education,
                        Date birthday, boolean hasAspirantura, char sex) {
        super(name, surname, education, birthday, hasAspirantura);
        this.sex = sex;
    }

    public void pregnantTesting() {
    }
}
