package ru.netology.javacore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TodosTests {
    Todos todos;

    @BeforeEach
    void initial() {
        todos = new Todos();
    }

    @AfterEach
    void reset() {
        todos = null;
    }

    @Test
    void testAddTask() {
        String task1 = "Заняться акробатикой";
        String task2 = "Выйти на пробежку";
        String expected = "Выйти на пробежку Заняться акробатикой";

        todos.addTask(task1);
        todos.addTask(task2);
        String result = todos.getAllTasks();
        assertThat(result, equalTo(expected));
    }

    @Test
    void testRemoveTask() {
        String task1 = "Заняться акробатикой";
        String task2 = "Выйти на пробежку";
        String expected = "Выйти на пробежку";

        todos.addTask(task1);
        todos.addTask(task2);
        todos.removeTask("Заняться акробатикой");
        String result = todos.getAllTasks();
        assertThat(result, equalTo(expected));

    }

    @Test
    void testGetAllTasks() {
        String expected = "Акробатика Пробежка Учеба";

        todos.addTask("Учеба");
        todos.addTask("Акробатика");
        todos.addTask("Пробежка");

        String result = todos.getAllTasks();

        Assertions.assertEquals(expected, result);
    }
}
