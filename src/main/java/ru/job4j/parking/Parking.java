package ru.job4j.parking;

/**
 * инициализируем парковку через конструктор
 * проверяем возможность разместить автомобиль
 * добавляем автомобиль на парковку при возможности
 * получаем список всех автомобилей на парковке
 * ищем автомобиль по номеру
 * удаляем автомобиль с парковки
 */
public interface Parking {

    boolean parkAutomobile(Automobile automobile);

    Automobile findByNumber(String number);

    boolean delete(String number);
}

