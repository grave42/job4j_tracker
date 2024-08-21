package ru.job4j.lombok;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class Permission {
    private int id;
    private String name;

    @Singular("rules")
    private List<String> rules;
}