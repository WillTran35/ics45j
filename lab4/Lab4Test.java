package labs.lab4;
import static org.junit.Assert.*;
import java.awt.Rectangle;
import java.time.DayOfWeek;
import org.junit.Test;
import labs.lab4.*;
public class Lab4Test {
    private final double EPSILON = 1e-13;
    @Test
    public void problem1() {
        Customer c = new Customer();
        c.makePurchase(75);
        assertEquals(0, c.getNumDiscountsToUse());
        assertEquals(75.0, c.getTotalAmountSpent(), EPSILON);
        c.makePurchase(50.25);
        assertEquals(1, c.getNumDiscountsToUse());
        assertEquals(125.25, c.getTotalAmountSpent(), EPSILON);
        c.makePurchase(9.99);
        assertEquals(0, c.getNumDiscountsToUse());
        assertEquals(134.241, c.getTotalAmountSpent(), EPSILON);
        c.makePurchase(234.30);
        assertEquals(2, c.getNumDiscountsToUse());
        assertEquals(368.541, c.getTotalAmountSpent(), EPSILON);
        c.makePurchase(10);
        assertEquals(1, c.getNumDiscountsToUse());
        assertEquals(377.541, c.getTotalAmountSpent(), EPSILON);
    }
    @Test
    public void problem3() {
        LoginForm login1 = new LoginForm("user", "password");
        assertFalse(login1.isLoggedIn());
        login1.input("user");
        login1.input("password");
        login1.click("Submit");
        assertTrue(login1.isLoggedIn());
        LoginForm login2 = new LoginForm("admin", "admin123");
        login2.input("test");
        login2.input("test123");
        login2.click("Submit");
        assertFalse(login2.isLoggedIn());
        login2.input("admin");
        login2.input("admin123");
        login2.click("Reset");
        assertFalse(login2.isLoggedIn());
        login2.click("Submit");
        assertFalse(login2.isLoggedIn());
        login2.input("admin");
        login2.input("admin123");
        login2.input("test");
        login2.input("test123");
        login2.click("Submit");
        assertTrue(login2.isLoggedIn());
        login2.input("test");
        login2.input("test123");
        login2.click("Submit");
        assertTrue(login2.isLoggedIn());
    }
    @Test
    public void problem5() {
// Test case 1
        Toy lamby = new Toy("Lamby", "white fluffy stuffed lamb that I got for Christmas", false);
        Toy sharky = new Toy("Sharky", "blue shark with its mouth chewed off", true);
        Toy socky = new Toy("Socky", "my brother's old sock that I like to carry around in my mouth like a treasure", true);
        Toy tennisBall = new Toy("Tennis Ball", "standard green tennis ball that I play with outside", false);
        ToyInventory inventory = new ToyInventory();
        inventory.addToy(lamby);
        inventory.addToy(sharky);
        inventory.addToy(socky);
        inventory.addToy(tennisBall);
        inventory.removeToy("Sharky");
        assertEquals("Lamby\n"
                        + "white fluffy stuffed lamb that I got for Christmas\n"
                        + "NOT DESTROYED\n"
                        + "Socky\n"
                        + "my brother's old sock that I like to carry around in my mouth like a treasure\n"
                        + "DESTROYED\n"
                        + "Tennis Ball\n"
                        + "standard green tennis ball that I play with outside\n"
                        + "NOT DESTROYED", inventory.getInventoryReport());
    }
    @Test
    public void problem6() {
        BetterRectangle r1 = new BetterRectangle(2, 3, 15, 17);
        assertEquals(2.0, r1.getX(), EPSILON);
        assertEquals(3.0, r1.getY(), EPSILON);
        assertEquals(15.0, r1.getWidth(), EPSILON);
        assertEquals(17.0, r1.getHeight(), EPSILON);
        assertEquals(64.0, r1.getPerimeter(), EPSILON);
        assertEquals(255.0, r1.getArea(), EPSILON);
        assertTrue(BetterRectangle.class.getSuperclass() == Rectangle.class);
    }
    @Test
    public void problems7Thru10TestAppointment() {
        Appointment[] appointments = new Appointment[] {
                new DailyAppointment("Brush teeth"),
                new MonthlyAppointment(1, "Visit Grandma"),
                new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
                new OnetimeAppointment(2021, 10, 31, "Schedule yearly checkup"),
                new YearlyAppointment(10, 31, "Trick or Treat"),
                new DailyAppointment("Write some code"),
                new MonthlyAppointment(31, "Change mascara"),
                new YearlyAppointment(3, 28, "Robert's birthday"),
                new OnetimeAppointment(2020, 11, 1, "Doctor appointment"),
                new WeeklyAppointment(DayOfWeek.SUNDAY, "Plan my week"),
                new WeeklyAppointment(DayOfWeek.FRIDAY, "Lunch with Mom"),
                new WeeklyAppointment(DayOfWeek.WEDNESDAY, "Lunch with Dad"),
                new WeeklyAppointment(DayOfWeek.MONDAY, "Fight a case of \"The Mondays\""),
                new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
                new OnetimeAppointment(2022, 11, 1, "Dentist appointment"),
                new YearlyAppointment(7, 15, "Lunch with Mom") };
        int year = 2021, month = 10, day = 31;
        assertTrue(appointments[0].occursOn(year, month, day));
        assertFalse(appointments[1].occursOn(year, month, day));
        assertFalse(appointments[2].occursOn(year, month, day));
        assertTrue(appointments[3].occursOn(year, month, day));
        assertTrue(appointments[4].occursOn(year, month, day));
        assertTrue(appointments[5].occursOn(year, month, day));
        assertTrue(appointments[6].occursOn(year, month, day));
        assertFalse(appointments[7].occursOn(year, month, day));
        assertFalse(appointments[8].occursOn(year, month, day));
        assertTrue(appointments[9].occursOn(year, month, day));
        assertFalse(appointments[10].occursOn(year, month, day));
        assertFalse(appointments[11].occursOn(year, month, day));
        assertFalse(appointments[12].occursOn(year, month, day));
        assertFalse(appointments[13].occursOn(year, month, day));
        assertFalse(appointments[14].occursOn(year, month, day));
        assertFalse(appointments[15].occursOn(year, month, day));
        assertTrue(appointments[2].equals(appointments[13]));
        assertFalse(appointments[2].equals(appointments[14]));
        assertFalse(appointments[1].equals(appointments[6]));
        assertFalse(appointments[10].equals(appointments[15]));
    }
    @Test
    public void problems7Thru10TestOnetimeAppointment() {
        OnetimeAppointment a = new OnetimeAppointment(2023, 11, 2, "Lab 4 Due");
                assertEquals(2023, a.getYear());
        assertEquals(11, a.getMonth());
        assertTrue(a.occursOn(2023, 11, 2));
        assertTrue(a.equals(new OnetimeAppointment(2023, 11, 2, "Lab 4 Due")));
        assertTrue(OnetimeAppointment.class.getSuperclass() ==
                Appointment.class);
    }
    @Test
    public void problems7Thru10TestDailyAppointment() {
        DailyAppointment a = new DailyAppointment("Remember to stay healthy!");
        assertTrue(a.occursOn(2023, 11, 2));
        assertTrue(a.equals(new DailyAppointment("Remember to stay healthy!")));
        assertTrue(DailyAppointment.class.getSuperclass() == Appointment.class);
    }
    @Test
    public void problems7Thru10TestMonthlyAppointment() {
        MonthlyAppointment a = new MonthlyAppointment(1, "First day of the month!");
        assertEquals(1, a.getDay());
        assertTrue(a.occursOn(2023, 12, 1));
        assertTrue(a.equals(new MonthlyAppointment(1, "First day of the month!")));
        assertTrue(MonthlyAppointment.class.getSuperclass() ==
                Appointment.class);
    }
    @Test
    public void problems7Thru10TestYearlyAppointment() {
        YearlyAppointment a = new YearlyAppointment(1, 1, "Happy New Year!");
        assertEquals(1, a.getMonth());
        assertEquals(1, a.getDay());
        assertTrue(a.occursOn(2024, 1, 1));
        assertTrue(a.equals(new YearlyAppointment(1, 1, "Happy New Year!")));
        assertTrue(YearlyAppointment.class.getSuperclass() ==
                Appointment.class);
    }
    @Test
    public void problems7Thru10TestWeeklyAppointment() {
        WeeklyAppointment a = new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!");
        assertEquals(DayOfWeek.FRIDAY, a.getDayOfWeek());
        assertTrue(a.occursOn(2021, 12, 31));
        assertTrue(a.equals(new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!")));
        assertTrue(WeeklyAppointment.class.getSuperclass() == Appointment.class);
    }
}
