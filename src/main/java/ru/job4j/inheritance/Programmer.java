package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education,
                      Date birthday, Boolean hasExperience, String language) {
        super(name, surname, education, birthday, hasExperience);
        this.language = language;
    }

    public boolean isLazy() {
        return false;
    }
}
