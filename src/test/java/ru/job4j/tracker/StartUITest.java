package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitMenu()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItem(out),
                new ExitMenu()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitMenu()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitMenu()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(out.toString()).isEqualTo(
                "Menu." + LN
                        + "0. Exit" + LN
        );
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"});
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitMenu()};
        Tracker tracker = new Tracker();
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(out.toString()).isEqualTo(
                "Menu." + LN
                        + "0. === Show all items ===" + LN
                        + "1. Exit" + LN
                        + "Хранилище еще не содержит заявок" + LN
                        + "Menu." + LN
                        + "0. === Show all items ===" + LN
                        + "1. Exit" + LN);
    }

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1"));
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"});
        UserAction[] actions = {
                new FindItemByName(out),
                new ExitMenu()};
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(out.toString()).isEqualTo(
               "Menu." + LN
                       + "0. === Find item by name===" + LN
                       + "1. Exit" + LN
                       + item + LN
                       + "Menu." + LN
                       + "0. === Find item by name===" + LN
                       + "1. Exit" + LN);
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindItemById(out),
                new ExitMenu()};
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(out.toString()).isEqualTo(
                "Menu." + LN
                        + "0. === Find item by id===" + LN
                        + "1. Exit" + LN
                        + item + LN
                        + "Menu." + LN
                        + "0. === Find item by id===" + LN
                        + "1. Exit" + LN);
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitMenu()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
        );
    }
}