package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Serg Mokhin");
        student.setGroup(12);
        student.setDateOfEntry(2021, 2, 28);
        System.out.println("Студент : " + student.getFio() + ", учится в группе : "
                + student.getGroup() + ", зачислен : " + student.getDateOfEntry());
    }
}
