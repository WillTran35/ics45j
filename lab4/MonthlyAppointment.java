package labs.lab4;
/**
 * Monthly appointment.
 */
public class MonthlyAppointment extends Appointment {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Initializes appointment to repeat monthly on day of the month.
     *
     * @param day the day of the month
     * @param description the text description of the appointment
     */
    private int day ;

    public MonthlyAppointment(int day, String description) {
// FILL IN
        this.day = day;
        super.setDescription(description);
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
        return getDay() == day; // FIX ME
    }
    /**
     * Returns true if the given object has the same instance variable
     * value(s) as this MonthlyAppointment
     */
    @Override
    public boolean equals(Object otherObject) {
// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR
//        IMPLEMENTATION
        if (otherObject == null || !(otherObject instanceof MonthlyAppointment)) return false;
        MonthlyAppointment other = (MonthlyAppointment) otherObject;
        return super.equals(other) && other.getDay() == getDay(); // FIX ME
    }
}
