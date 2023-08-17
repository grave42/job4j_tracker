package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparator2 = (left, right) -> left.getName().compareTo(right.getName());
        attachments.sort(comparator2);
        System.out.println(attachments);
    }
}
