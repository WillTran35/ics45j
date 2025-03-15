package labs.lab7;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Class for creating a priority ToDo list.
 */
public class ToDoList {
    private PriorityQueue<Task> tasks;
    /**
     * Constructor
     */
    public ToDoList() {
// FILL IN
        this.tasks = new PriorityQueue<Task>();
    }
    /**
     * Adds a new task with the given priority and description
     *
     * @param priority priority of the new task
     * @param description description of the new task
     */
    public void addTask(int priority, String description) {
// FILL IN
        tasks.add(new Task(priority, description));
    }
    /**
     * Returns the next highest priority task; if two tasks have the
     * same priority, returns either one
     */
    public Task nextTask() {
        return tasks.poll();

    }
}
