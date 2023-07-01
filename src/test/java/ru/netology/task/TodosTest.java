package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnMatchingTasksForQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Подготовить отчет", "Провести совещание"});
        Meeting meeting = new Meeting(3, "Планирование проекта", "Проект X", "2023-05-20");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { epic, meeting };
        Task[] actual = todos.search("планирование");

        Assertions.assertArrayEquals(expected, actual);
    }
}