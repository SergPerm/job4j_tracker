package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private short amountBuilding;

    public Builder(String name, String surname, String education,
                   Date birthday, Boolean hasExperience, short amountBuilding) {
        super(name, surname, education, birthday, hasExperience);
        this.amountBuilding = amountBuilding;
    }
}
