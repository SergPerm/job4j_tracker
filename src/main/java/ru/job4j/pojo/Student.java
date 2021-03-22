package ru.job4j.pojo;

import java.util.Calendar;
import java.util.Date;

public class Student {
    private String fio;
    private int group;
    private Date dateOfEntry;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(int year, int month, int day) {
        this.dateOfEntry = new Date(year - 1900, month - 1, day);
    }
}