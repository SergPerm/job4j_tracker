package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> pName = person -> person.getName().contains(key);
        Predicate<Person> pSurname = person -> person.getSurname().contains(key);
        Predicate<Person> pPhone = person -> person.getPhone().contains(key);
        Predicate<Person> pAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = pName.or(pSurname).or(pPhone).or(pAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person person : persons) {
//            if (person.getName().contains(key)
//                || person.getSurname().contains(key)
//                || person.getPhone().contains(key)
//                || person.getAddress().contains(key)) {
//                result.add(person);
//            }
//        }
        return result;
    }
}