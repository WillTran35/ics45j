
package labs.lab1;
/**
 * An employee with a name and salary.
 */
public class Employee {
    private String name;
    private double salary;
    /**
     * Constructs an employee.
     *
     * @param employeeName the employee name
     * @param currentSalary the employee salary
     */
    public Employee(String employeeName, double currentSalary) {
        this.name = employeeName;
        this.salary = currentSalary;
// WRITE YOUR CODE HERE
    }
    /**
     * Gets the employee name.
     *
     * @return the name
     */
    public String getName() {
// WRITE YOUR CODE HERE
        return this.name; // FIX ME
    }
    /**
     * Gets the employee salary.
     *
     * @return the salary
     */
    public double getSalary() {
// WRITE YOUR CODE HERE
        return this.salary; // FIX ME
    }
    /**
     * Raises the salary by a given percentage.
     *
     * @param percent the percentage of the raise
     */
    public void raiseSalary(double percent) {
// WRITE YOUR CODE HERE
        this.salary *= (1 + (percent/100));
    }
    public static void main(String[] args){
        Employee emp = new Employee("Robert", 100000);
        emp.raiseSalary(10);
        System.out.println(emp.getSalary());
    }
}