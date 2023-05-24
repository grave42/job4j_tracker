package ru.job4j.tasks;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task14Test {

    Class<?> taskClass;

    @Before
    public void init() {
        Class<?>[] members = Task14.class.getNestMembers();
        for (Class<?> m : members) {
            if ("Nested".equals(m.getSimpleName())) {
                taskClass = m;
            }
        }
    }

    @Test
    public void whenLocalClassThenTrue() {
        assertTrue(taskClass.isLocalClass());
    }

    @Test
    public void whenMemberClassThenFalse() {
        assertFalse(taskClass.isMemberClass());
    }

    @Test
    public void whenStaticThenFalse() {
        assertFalse(Modifier.isStatic(taskClass.getModifiers()));
    }

    @Test
    public void whenAnonymousThenFalse() {
        assertFalse(taskClass.isAnonymousClass());
    }

}