package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("not found element with such key");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] names = {"Petr", "Serg", "Stas", "Mary"};
        try {
            System.out.println(indexOf(names, "serg"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
