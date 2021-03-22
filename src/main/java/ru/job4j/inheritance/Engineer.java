package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {

    private boolean hasExperience;

    public Engineer(String name, String surname, String education,
                    Date birthday, Boolean hasExperience) {
        super(name, surname, education, birthday);
        this.hasExperience = hasExperience;
    }

    public void createProject() {
    }
}
