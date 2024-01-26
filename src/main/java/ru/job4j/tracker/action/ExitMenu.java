package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.action.UserAction;

public class ExitMenu implements UserAction {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}