package labs.lab4;
/**
 * A class to keep track of an appointment.
 */
import java.time.DayOfWeek;
public abstract class Appointment {
    private String description;
    /**
     * Constructs an appointment without a description.
     */
    public Appointment() {
        description = "";
    }
    /**
     * Sets the description of this appointment.
     *
     * @param description the text description of the appointment
     */
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    /**
     * Determines if this appointment occurs on the given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @return true if the appointment occurs on the given date.
     */
    public abstract boolean occursOn(int year, int month, int day);
    /**
     * Converts appointment to string description.
     */
    @Override
    public String toString() {
        return description;
    }
    /**
     * Returns true if the given object has the same instance variable
     * value(s) as this Appointment
     */
    @Override
    public boolean equals(Object otherAppointment) {

//        if (otherAppointment == null || otherAppointment != otherAppointment.getClass()) return false;
        Appointment other  = (Appointment) otherAppointment;
        return other.getDescription().equals(getDescription()); // FIX ME
    }
    public static void main(String [] args){
        Appointment[] appointments = new Appointment[] {
                new DailyAppointment("Brush teeth"),
                new MonthlyAppointment(1, "Visit Grandma"), new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
                new OnetimeAppointment(2023, 10, 31, "Schedule yearly checkup"),
                new YearlyAppointment(10, 31, "Trick or Treat"), new DailyAppointment("Write some code"),
                new MonthlyAppointment(31, "Change mascara"), new YearlyAppointment(3, 28, "Robert's birthday"),
                new OnetimeAppointment(2022, 11, 1, "Doctor appointment"),
                new WeeklyAppointment(DayOfWeek.SUNDAY, "Plan my week"),
                new WeeklyAppointment(DayOfWeek.FRIDAY, "Lunch with Mom"),
                new WeeklyAppointment(DayOfWeek.WEDNESDAY, "Lunch with Dad"),
                new WeeklyAppointment(DayOfWeek.MONDAY, "Fight a case of \"The Mondays\""),
                new OnetimeAppointment(2023, 11, 1, "Dentist appointment"),
                new OnetimeAppointment(2024, 11, 1, "Dentist appointment"),
                new YearlyAppointment(7, 15, "Lunch with Mom") };

        int year = 2023;
        int month = 10;
        int day = 31;
        System.out.println("Your appointments on " + month + "/" + day + "/" + year + ":");
        for (Appointment a : appointments) {
            if (a.occursOn(year, month, day)) {
                System.out.println(a);
            }
        }
//        System.out.println("YOOOOOO");
//        int count = 0 ;
//        for (Appointment a : appointments){
//            System.out.print(count + " ");
//            System.out.println(a);
//            count ++;
//        }
        System.out.println(appointments[2].equals(appointments[13]));
        System.out.println(appointments[2].equals(appointments[14]));

// The above code prints:
//        Your appointments on 10/31/2023:
//        Brush teeth
//        Schedule yearly checkup
//        Trick or Treat
//        Write some code
//        Change mascara
//        false
//        false
    }
}
