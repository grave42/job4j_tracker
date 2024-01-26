package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.action.UserAction;

import java.util.List;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> result = tracker.findByName(name);
        if (result.size() > 0) {
            for (Item item : result) {
                out.println(item);
            }
        } else {
           out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
