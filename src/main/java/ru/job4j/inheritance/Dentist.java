package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {

    private String address;

    public Dentist(String name, String surname, String education,
                   Date birthday, boolean hasAspirantura, String address) {
        super(name, surname, education, birthday, hasAspirantura);
        this.address = address;
    }

    public void deleteTooth() {

    }
}
