package ru.job4j.gc;

public class GCUser {
    private String firstName;
    private String name;

    public GCUser(String firstName, String name) {
        this.firstName = firstName;
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s %s%n", firstName, name);
    }
}
