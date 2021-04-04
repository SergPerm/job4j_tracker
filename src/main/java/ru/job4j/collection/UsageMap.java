package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("mohin@list.ru", "Sergey Mokhin");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }

}
