package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class ItemByNameTest {

    @Test
    void compareAsc() {
        List<Item> items = Arrays.asList(new Item("Ivan"), new Item("Andrey"), new Item("Filipp"));
        List<Item> expected = Arrays.asList(new Item("Andrey"), new Item("Filipp"), new Item("Ivan"));
        items.sort(new ItemAscByName());
        assertThat(items, contains(expected.toArray()));
    }

    @Test
    void compareDesc() {
        List<Item> items = Arrays.asList(new Item("Filipp"), new Item("Andrey"), new Item("Ivan"));
        List<Item> expected = Arrays.asList(new Item("Ivan"), new Item("Filipp"), new Item("Andrey"));
        items.sort(new ItemDescByName());
        assertThat(items, contains(expected.toArray()));
    }

}