package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dod1k@po4ta.ru", "Dodikov Valeriy Dodikovich");
        map.put("dod1k@po4ta.ru", "Viktorov Viktor Viktorovich");
        map.put("bob1k@ko4ka.ru", "Bobikov Vasiliy Sergeevich");
        map.put("ya@lol.ru", "Ivanov Ivan Ivanovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
