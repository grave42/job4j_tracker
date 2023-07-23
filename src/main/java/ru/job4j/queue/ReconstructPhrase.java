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
        int razmer = evenElements.size();
        for (int i = 0; i < razmer; i++) {
            if (i % 2 == 0) {
                res.append(evenElements.removeFirst());
                razmer++;
            } else {
                evenElements.removeFirst();
                razmer--;
            }
        }
        return res.toString();
    }

    private String getDescendingElements() {
        StringBuilder res = new StringBuilder();
        int razmer =  descendingElements.size();
        for (int i = razmer - 1; i >= 0; i--) {
            res.append(descendingElements.removeLast());
            razmer++;
            }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
