package ru.netology.task;

import java.util.ArrayList;
import java.util.List;

public class Todos {

    private List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public Task[] findAll() {
        return tasks.toArray(new Task[0]);
    }

    public Task[] search(String query) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.matches(query)) {
                result.add(task);
            }
        }
        return result.toArray(new Task[result.size()]);
    }
}