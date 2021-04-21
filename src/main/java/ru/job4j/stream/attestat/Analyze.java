package ru.job4j.stream.attestat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    /**
     * Метод averageScore вычисляет общий средний балл.
     * @param stream
     * @return общий средний балл.
     *         - flatMap() для преобразования в поток объектов Subject;
     *         - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
     *         - average() для расчета среднего бала по предмету;
     *         - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     * @param stream
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     * поскольку нам надо выполнить преобразование в поток объектов класса Tuple,
     * последовательность будет следующей:
     *  - метод map() для преобразования в поток объектов класса Tuple, внутри метода
     *      мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     *  - при этом в конструктор первым параметром будет передаваться имя текущего
     *      объекта Pupil - используем соответствующий геттер;
     *  - вторым параметром рассчитанный средний балл - расчет можно произвести по той
     *      же последовательности, что описана для метода averageScore;
     *  - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     * требуется выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     *    - flatMap() для преобразования в поток объектов Subject;
     *    - метод collect() в который мы передаем метод groupingBy() (минимум с двумя параметрами)
     *    класса Collectors. При этом карта собирается следующим образом: ключ - это имя предмета,
     *    значение - средний балл по этому предмету для каждого ученика. Для расчета среднего
     *    балла используйте метод averagingDouble() класса Collectors;
     *    - после этого собранную карту мы разбираем с помощью entrySet()
     *    и открываем поток с помощью stream();
     *    - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     *    внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     *    - в конструктор мы будем передавать параметры с помощью методов getKey() и
     *    getValue() интерфейса Entry;
     *    - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream
     * @return возвращает лучшего ученика.
     * можно использовать метод averageScoreBySubject за исключением следующих особенностей:
     *         - в данном методе мы рассчитываем суммарный балл, нужно использовать метод sum();
     *         - терминальной операцией будет метод max(), в который будем передавать компаратор.
     *     При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
     *         - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return  stream
                .map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Tuple::compare)
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream
     * @return Возвращает объект Tuple (имя предмета,
     *                                  сумма баллов каждого ученика по этому предмету).
     *   - для реализации данного метода можно использовать метод averageScoreByPupil
     *       за исключением следующих особенностей:
     *   - в данном методе мы рассчитываем суммарный балл, нужно использовать метод summingDouble();
     *   - терминальной операцией будет метод max(), в который будем передавать компаратор.
     *    При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
     *   - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Tuple::compare)
                .orElse(null);
    }
}
