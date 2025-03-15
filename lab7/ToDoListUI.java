package labs.lab7;
import java.util.Scanner;
/**
 * Class for creating a priority ToDo list.
 */
public class ToDoListUI {
    private ToDoList list;
    /**
     * Constructor
     */
    public ToDoListUI() {
        list = new ToDoList();
    }
    /**
     * Display a menu and accepts commands.
     */
    public void run() {
        String option = "";
        System.out.println("To Do List - Please enter an option");
        System.out.println(" add priority description (add a new task)");
        System.out.println(" next (remove and print most urgent task)");
        System.out.println(" quit (exit this program)");
        System.out.println();
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("> ");
            option = in.nextLine();
            if (option.startsWith("add")) {
                addTask(option);
            } else if (option.equals("next")) {
                nextTask();
            }
        } while (!option.equals("quit"));
    }
    /**
     * Parse the add option line.
     *
     * @param optionStr the option line
     */
    public void addTask(String optionStr) {
        Scanner sin = new Scanner(optionStr);
        sin.next(); // throw away the 'add' part
        if (sin.hasNextInt()) // next part must be priority
        {
            int priority = sin.nextInt();
            if (priority >= 1 && priority <= 9) {
                String description = sin.nextLine().trim();
                list.addTask(priority, description);
            } else {
                System.out.println("Priority must be between 1 and 9, not "
                        + priority);
            }
        } else {
            System.out.println("Use 'add priority description' to add a task.");
            System.out.println("The priority must be an integer between 1 and 9.");
        }
// list.printQueue();
    }
    /**
     * Get the next highest priority task and display the description to the
     user.
     */
    public void nextTask() {
        Task next = list.nextTask();
        if (next == null) {
            System.out.println("There are no tasks in the list.");
        } else {
            System.out.println(next.getDescription());
        }
// list.printQueue();
    }
    public static void main(String[] args) {
        ToDoListUI ui = new ToDoListUI();
        ui.run();
    }
}