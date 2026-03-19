package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * Provides functionality to add, find, and filter tasks.
 * @author KasopeOdugbesan
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager and initializes the task collection.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws an exception if a task with the same ID already exists.
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate task ID is detected
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException();
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * @param taskId the ID of the task
     * @return the Task if found, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of tasks that match the given status.
     * @param status the status to filter by
     * @return a list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }

        return result;
    }
}