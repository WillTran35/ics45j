package labs.lab4;
/**
 * A yearly appointment.
 */
public class YearlyAppointment extends Appointment {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Initializes appointment that happens every year on a given date.
     *
     * @param month the month
     * @param day the day
     * @param description the text description of the appointment
     */
    private int month;
    private int day ;

    public YearlyAppointment(int month, int day, String description) {
// FILL IN
        setDescription(description);
        this.month = month;
        this.day = day;

    }
    public int getMonth() {
        return this.month; // FIX ME
    }
    public int getDay() {
        return this.day; // FIX ME
    }
    /**
     * Determines if this appointment occurs on the given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     *
     * @return true if the appointment occurs on the given date.
     */
    public boolean occursOn(int year, int month, int day) {
        return month == getMonth() && day == getDay(); // FIX ME
    }
    /**
     * Returns true if the given object has the same instance variable
     * value(s) as this YearlyAppointment
     */
    @Override
    public boolean equals(Object otherObject) {
// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR
//        IMPLEMENTATION
        if (otherObject == null || !(otherObject instanceof YearlyAppointment)) return false;
        YearlyAppointment other = (YearlyAppointment) otherObject;
        return super.equals(other) && other.getDay() == getDay() && other.getMonth() == getMonth(); // FIX ME
    }
}