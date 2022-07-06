package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        StringJoiner joiner = new StringJoiner(" ");
        for (String task : tasks) {
            joiner.add(task);
        }
        return joiner.toString();
    }
}



