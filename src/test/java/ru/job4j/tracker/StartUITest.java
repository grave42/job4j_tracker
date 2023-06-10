package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
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
        new StartUI(out).init(in, tracker, actions);
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
        new StartUI(out).init(in, tracker, actions);
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator());
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
               "Menu." + System.lineSeparator()
                       + "0. === Find item by name===" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator()
                       + item + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. === Find item by name===" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator());
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by id===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by id===" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator());
    }
}