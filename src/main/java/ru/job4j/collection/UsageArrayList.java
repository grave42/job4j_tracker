package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Objects;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object name : names) {
            System.out.println(name);
        }
    }
}
