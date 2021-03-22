package ru.job4j.inheritance;

import java.util.Date;

public class Doctor extends Profession {
    private boolean hasAspirantura;

    public Doctor(String name, String surname, String education,
                  Date birthday, boolean hasAspirantura) {
        super(name, surname, education, birthday);
        this.hasAspirantura = hasAspirantura;
    }
}
