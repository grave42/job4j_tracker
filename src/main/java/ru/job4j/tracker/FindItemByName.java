package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
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
