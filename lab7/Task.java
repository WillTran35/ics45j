package labs.lab7;
/**
 * Class for creating a priority To Do list.
 */
public class Task implements Comparable {
// ADD INSTANCE VARIABLES HERE
    /**
     * Constructor
     *
     * @param description The description of the task.
     * @param priority The priority of the task.
     */
    private int priority;
    private String description;
    public Task(int priority, String description) {
// FILL IN
        this.priority = priority;
        this.description = description;
    }
    /**
     * @return the priority
     */
    public int getPriority() {
        return this.priority;
    }
    /**
     * @return the task description
     */
    public String getDescription() {
        return this.description; // FIX ME
    }
    @Override
    public int compareTo(Object otherObject) {
        if (!(otherObject instanceof Task)){
            return -1;
        }
        Task otherTask = (Task) otherObject;
        if (this.priority < otherTask.priority) {
            return -1;
        } else if (this.priority > otherTask.priority) {
            return 1;
        }
        return 0;
    }
}