package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.StubOutput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemByIdTest {

    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("test", 1);
        tracker.add(item);
        FindItemById findByIdAction = new FindItemById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(item + ln);
    }

}