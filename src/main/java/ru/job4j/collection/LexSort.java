package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] parts = left.split("\\. ");
        String[] parts2 = right.split("\\. ");
        int number = Integer.parseInt(parts[0]);
        int number2 = Integer.parseInt(parts2[0]);
        return Integer.compare(number, number2);
    }
}
