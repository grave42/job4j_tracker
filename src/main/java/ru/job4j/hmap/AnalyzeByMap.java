package ru.job4j.hmap;

import java.util.*;
import java.util.Collections;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0L;
        double counter = 0L;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                sum += sub.score();
                counter += 1;
            }
        }
        return sum / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumByPupil = 0D;
            for (Subject sub : pupil.subjects()) {
                sumByPupil += sub.score();
            }
            result.add(new Label(pupil.name(), sumByPupil / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> tempRes =  new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                tempRes.merge(sub.name(), sub.score(), Integer::sum);
            }
        }
        for (String key : tempRes.keySet()) {
            int value = tempRes.get(key);
            result.add(new Label(key, (double) value / tempRes.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumByPupil = 0D;
            for (Subject sub : pupil.subjects()) {
                sumByPupil += sub.score();
            }
            result.add(new Label(pupil.name(), sumByPupil));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> tempRes =  new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                tempRes.merge(sub.name(), sub.score(), Integer::sum);
            }
        }
        for (String key : tempRes.keySet()) {
            int value = tempRes.get(key);
            result.add(new Label(key, (double) value));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }
}
