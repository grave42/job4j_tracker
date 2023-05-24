package ru.job4j.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class Task13Test {

    @Test
    public void whenLocalClassThenFalse() {
        assertFalse(Task13.Nested.class.isLocalClass());
    }

    @Test
    public void whenMemberClassThenTrue() {
        assertTrue(Task13.Nested.class.isMemberClass());
    }

    @Test
    public void whenStaticThenTrue() {
        assertTrue(Modifier.isStatic(Task13.Nested.class.getModifiers()));
    }

    @Test
    public void whenAnonymousClassThenFalse() {
        assertFalse(Task13.Nested.class.isAnonymousClass());
    }

}