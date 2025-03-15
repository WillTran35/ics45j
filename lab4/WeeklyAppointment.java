package labs.lab4;
import java.time.DayOfWeek;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Weekly appointment.
 */
public class WeeklyAppointment extends Appointment {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Initializes appointment for a given day of the week.
     *
     * @param dayOfWeek the day of the wee
     * @param description the text description of the appointment
     */
    private DayOfWeek dayOfWeek;
    public WeeklyAppointment(DayOfWeek dayOfWeek, String description) {
// FILL IN
        super.setDescription(description);
        this.dayOfWeek = dayOfWeek;
    }
    public DayOfWeek getDayOfWeek() {
        return this.dayOfWeek; // FIX ME
    }
    /**
     * Determines if this appointment occurs on the given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @return true if the appointment occurs on the given date.
     */
    public boolean occursOn(int year, int month, int day) {
//        System.out.println("HERE OCC");
//        System.out.println(getDayOfWeek().getValue());
        LocalDate date = LocalDate.of(year,month,day);

        return date.getDayOfWeek().getValue() == getDayOfWeek().getValue(); // FIX ME
    }
    /**
     * Returns true if the given object has the same instance variable
     * value(s) as this WeeklyAppointment
     */
    @Override
    public boolean equals(Object otherObject) {
// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR
//        IMPLEMENTATION
        if (otherObject == null || !(otherObject instanceof WeeklyAppointment)) return false;
        WeeklyAppointment other = (WeeklyAppointment) otherObject;
//        System.out.println("IN EQUALS");
//        System.out.println(other.getDayOfWeek());
//        System.out.println(getDayOfWeek());
//        System.out.println(super.equals(other));
//        System.out.println("END");
        return super.equals(other) && other.getDayOfWeek() == getDayOfWeek(); // FIX ME
    }

    public static void main (String [] args){
        WeeklyAppointment a = new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!");
        System.out.println(a.getDayOfWeek());
//        assertEquals(DayOfWeek.FRIDAY, a.getDayOfWeek());
        System.out.println(a.occursOn(2021, 12, 31));
//        assertTrue(a.occursOn(2021, 12, 31));
        System.out.println(a.equals(new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!")));
        System.out.println(WeeklyAppointment.class.getSuperclass() == Appointment.class);
    }
}
