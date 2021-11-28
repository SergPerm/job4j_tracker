package ru.job4j.cache;

import java.util.Scanner;

/**
 * Класс Key Emulator для работы с пользователем. Предоставить пользователю возможности:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */

public class Emulator {
    private final Scanner sc = new Scanner(System.in);
    private AbstractCache<String, String> cache;

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.createCache();
        emulator.extractedFromCache();
        emulator.downloadContentFileToCache();
    }

    /**
     * упрощенный метод загрузки данных файла в кэш
     * запрашиваем имя файла и его содержимое и загружаем в кэш
     */
    private void downloadContentFileToCache() {
        System.out.println("введите имя файла для загрузки содержимого файла в кэш : ");
        String filename = sc.nextLine();
        System.out.println("введите содержимого файла для загрузки в кэш : ");
        String fileContent = sc.nextLine();
        this.cache.put(filename, fileContent);
    }

    /**
     * запрашиваем у пользователя путь к файлу и распечатываем содержимое файла находящееся в кэше
     */

    private void extractedFromCache() {
        System.out.println("введите имя файла для получения содержимого файла из кэш : ");
        System.out.println(this.cache.get(sc.nextLine()));
    }

    /**
     * создаём кэш
     * запрашиваем путь к директории для кэширования и создаем кэш
     */
    private void createCache() {
        System.out.println("введите путь к директории с текстовыми файлами для их кеширования  : ");
        String cacheDir = sc.nextLine();
        cache = new DirFileCache(cacheDir);
    }
}
