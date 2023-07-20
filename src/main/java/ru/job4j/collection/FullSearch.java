package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> res = new HashSet<>();
        for (Task task : tasks) {
            res.add(task.getNumber());
        }
        return res;
    }
}
