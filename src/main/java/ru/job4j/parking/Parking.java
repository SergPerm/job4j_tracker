package ru.job4j.parking;

import java.util.List;

/**
 * инициализируем парковку
 * проверяем возможность разместить автомобиль
 * добавляем автомобиль на парковку при возможности
 * получаем список всех автомобилей на парковке
 * ищем автомобиль по номеру
 * удаляем автомобиль с парковки
 */
public interface Parking {
    void init();

    boolean canParking(Automobile automobile);

    Automobile add(Automobile automobile);

    List<Automobile> findAll();

    Automobile findByNumber(String number);

    boolean delete(Automobile automobile);
}

