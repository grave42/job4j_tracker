package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] num : list) {
            for (int num2 : num) {
                rsl.add(num2);
            }
        }
        return rsl;
    }
}