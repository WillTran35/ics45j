package labs.lab2;
/**
 * This class models a paycheck.
 */
public class Paycheck {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructs a PayCheck for a given week.
     *
     * @param wage the employee's hourly wage
     * @param hours the amount of hours worked
     * @param taxRate percentage this employee is taxed
     */
    private double wage;
    private double hours;
    private double taxRate;
    public Paycheck(double wage, double hours, double taxRate) {
// FILL IN
        this.wage = wage;
        this.hours = hours;
        this.taxRate = taxRate;
    }
    /**
     * Gets the pay for this week
     *
     * @return the pay, including overtime if earned, and taxes taken out on
     * the full amount earned
     */
    public double getPay() {
        if (hours <= 40){
            return hours * wage - (hours*wage *(taxRate/100));
        }; // FIX Me

        double total = 40 * wage + (hours-40) * (wage *2);
        return total - (total * (taxRate/100));


    }
    public static void main (String [] args){
        Paycheck p1 = new Paycheck(10.5, 42, 0);
        System.out.println(p1.getPay()); // Expected: 462.0

        Paycheck p2 = new Paycheck(10.5, 42, 10);
        System.out.println(p2.getPay()); // Expected: 415.8

        Paycheck p3 = new Paycheck(10.5, 40, 10);
        System.out.println(p3.getPay()); // Expected: 378.0

        Paycheck p4 = new Paycheck(10.5, 33.2, 25);
        System.out.println(p4.getPay()); // Expected: 261.45

        Paycheck p5 = new Paycheck(100.33, 65.5, 20);
        System.out.println(p5.getPay()); // Expected: 7304.024

    }
}
