package ru.netology.javacore;

public class TaskRequest {

    private final String type;
    private final String task;

    public TaskRequest(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}

