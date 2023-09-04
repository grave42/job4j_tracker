package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(1.0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map((Pupil name) -> new Tuple(name.name(), name.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(1.0D)))
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(sub -> new Tuple(sub.getKey(), sub.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map((Pupil name) -> new Tuple(name.name(), name.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(sub -> new Tuple(sub.getKey(), sub.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}
