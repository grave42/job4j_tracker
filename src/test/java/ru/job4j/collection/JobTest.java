package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void jobAscByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("task1", 1),
                new Job("task2", 0),
                new Job("task33", 3));
        List<Job> exp = Arrays.asList(
                new Job("task2", 0),
                new Job("task1", 1),
                new Job("task33", 3));
        jobs.sort(new JobAscByPriority());
        MatcherAssert.assertThat(jobs, contains(exp.toArray()));
    }

    @Test
    public void jobDescByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("task1", 1),
                new Job("task2", 0),
                new Job("task33", 3));
        List<Job> exp = Arrays.asList(
                new Job("task33", 3),
                new Job("task1", 1),
                new Job("task2", 0));
        jobs.sort(new JobDescByPriority());
        MatcherAssert.assertThat(jobs, contains(exp.toArray()));
    }

    @Test
    public void jobAscByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("zsk1", 1),
                new Job("task2", 0),
                new Job("Ask33", 3));
        List<Job> exp = Arrays.asList(
                new Job("Ask33", 3),
                new Job("task2", 0),
                new Job("zsk1", 1));
        jobs.sort(new JobAscByName());
        MatcherAssert.assertThat(jobs, contains(exp.toArray()));
    }

    @Test
    public void jobDescByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Ask33", 3),
                new Job("zsk1", 1),
                new Job("task2", 0));
        List<Job> exp = Arrays.asList(
                new Job("zsk1", 1),
                new Job("task2", 0),
                new Job("Ask33", 3));
        jobs.sort(new JobDescByName());
        MatcherAssert.assertThat(jobs, contains(exp.toArray()));
    }

}