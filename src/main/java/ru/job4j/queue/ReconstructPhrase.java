package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder res = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                res.append(evenElements.removeFirst());
                size++;
            } else {
                evenElements.removeFirst();
                size--;
            }
        }
        return res.toString();
    }

    private String getDescendingElements() {
        StringBuilder res = new StringBuilder();
        int size =  descendingElements.size();
        for (int i = 0; i < size; i++) {
            res.append(descendingElements.removeLast());
            }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
