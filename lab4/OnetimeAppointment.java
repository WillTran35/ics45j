package labs.lab4;
/**
 * A onetime appointment.
 */
public class OnetimeAppointment extends Appointment {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Initializes appointment for a given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @param description the text description of the appointment
     */
    private int year;
    private int month;
    private int day;
//    private String description;
    public OnetimeAppointment(int year, int month, int day, String description) {
// FILL IN
//        super();
        super.setDescription(description);
        this.year = year;
        this.month = month;
        this.day = day;
//        this.year = year;

    }
    public int getYear() {
        return this.year;
//        return -1; // FIX ME
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
        return year == getYear() && getMonth() == month && getDay() == day; // FIX ME
    }
    /**
     * Returns true if the given object has the same instance variable
     * value(s) as this OnetimeAppointment
     */
    @Override
    public boolean equals(Object otherObject) {
// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR
//        IMPLEMENTATION
        if (otherObject == null || !(otherObject instanceof OnetimeAppointment)) return false;
        OnetimeAppointment other = (OnetimeAppointment) otherObject;
        return super.equals(other) && other.getDay() == getDay() && other.getMonth() == getMonth() && other.getYear() == getYear(); // FIX ME

    }
}
