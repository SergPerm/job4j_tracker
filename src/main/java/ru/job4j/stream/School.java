package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     * distinct() можно убрать в комментарий
     */
    public Map<String, Student> transformListToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        student -> student,
                        (student1, student2) -> student1));
    }
}
