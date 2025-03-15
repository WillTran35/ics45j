package labs.lab4;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.time.DayOfWeek;

import org.junit.Test;

import labs.lab4.*;

public class Lab4TestGrader {
    private final double EPSILON = 1e-13;

    // 2 points Existing Test case

    @Test
    public void problem1_1() {
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

    // 2 points
    @Test // No Discount
    public void problem1_2() {

        Customer c1 = new Customer();
        c1.makePurchase(30);
        assertEquals(0, c1.getNumDiscountsToUse());
        assertEquals(30.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(40);
        assertEquals(0, c1.getNumDiscountsToUse());
        assertEquals(70.0, c1.getTotalAmountSpent(), EPSILON);

        Customer c2 = new Customer();
        c2.makePurchase(0);
        assertEquals(0, c2.getNumDiscountsToUse());
        assertEquals(0.0, c2.getTotalAmountSpent(), EPSILON);
    }

    // 2 points Single Discount earned and applied
    @Test
    public void problem1_3() {

        Customer c1 = new Customer();
        c1.makePurchase(100); // Earns 1 discount
        assertEquals(1, c1.getNumDiscountsToUse());
        assertEquals(100.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(50); // Uses 1 discount
        assertEquals(0, c1.getNumDiscountsToUse());
        assertEquals(145.0, c1.getTotalAmountSpent(), EPSILON);

        Customer c2 = new Customer();
        c2.makePurchase(100); // Earns 1 discount
        assertEquals(1, c2.getNumDiscountsToUse());
        assertEquals(100.0, c2.getTotalAmountSpent(), EPSILON);

        c2.makePurchase(10); // Uses 1 discount
        assertEquals(0, c2.getNumDiscountsToUse());
        assertEquals(109.0, c2.getTotalAmountSpent(), EPSILON);
    }

    // 2 points Multiple discounts earned and applied
    @Test
    public void problem1_4() {

        Customer c1 = new Customer();
        c1.makePurchase(80); // No discount applied
        assertEquals(0, c1.getNumDiscountsToUse());
        assertEquals(80.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(60);
        assertEquals(1, c1.getNumDiscountsToUse());
        assertEquals(140.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(30); // Uses 1 discount
        assertEquals(0, c1.getNumDiscountsToUse());
        assertEquals(167.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(150); // No discount applied (since discountsToUse = 0)
        assertEquals(2, c1.getNumDiscountsToUse());
        assertEquals(317.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(20); // Uses 1 discount
        assertEquals(1, c1.getNumDiscountsToUse());
        assertEquals(335.0, c1.getTotalAmountSpent(), EPSILON);

        Customer c2 = new Customer();
        c2.makePurchase(120); // Earns 1 discount
        assertEquals(1, c2.getNumDiscountsToUse());
        assertEquals(120.0, c2.getTotalAmountSpent(), EPSILON);

        c2.makePurchase(50); // Uses 1 discount
        assertEquals(0, c2.getNumDiscountsToUse());
        assertEquals(165.0, c2.getTotalAmountSpent(), EPSILON);

        c2.makePurchase(200); // Earns 2 discounts
        assertEquals(2, c2.getNumDiscountsToUse());
        assertEquals(365.0, c2.getTotalAmountSpent(), EPSILON);
    }

    // 2 points large purchase and multiple discounts
    @Test
    public void problem1_5() {
        // Customer 1: Very large purchase
        Customer c1 = new Customer();
        c1.makePurchase(20000);
        assertEquals(200, c1.getNumDiscountsToUse());
        assertEquals(20000.0, c1.getTotalAmountSpent(), EPSILON);

        c1.makePurchase(3000);
        assertEquals(226, c1.getNumDiscountsToUse());
        assertEquals(22700.0, c1.getTotalAmountSpent(), EPSILON);

        // Customer 2: Multiple large purchases
        Customer c2 = new Customer();
        c2.makePurchase(15000);
        assertEquals(150, c2.getNumDiscountsToUse());
        assertEquals(15000.0, c2.getTotalAmountSpent(), EPSILON);

        c2.makePurchase(5000);
        assertEquals(194, c2.getNumDiscountsToUse());
        assertEquals(19500.0, c2.getTotalAmountSpent(), EPSILON);


        Customer c3 = new Customer();
        c3.makePurchase(8000);
        assertEquals(80, c3.getNumDiscountsToUse());
        assertEquals(8000.0, c3.getTotalAmountSpent(), EPSILON);

        c3.makePurchase(7000);
        assertEquals(142, c3.getNumDiscountsToUse());
        assertEquals(14300.0, c3.getTotalAmountSpent(), EPSILON);
    }

    // 2 points Existing Test case

    @Test
    public void problem3_1() {
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

    // 2 points SuccessfulLogin
    @Test
    public void problem3_2() {
        LoginForm login = new LoginForm("user", "pass123");
        assertFalse(login.isLoggedIn());

        login.input("user");
        login.input("pass123");
        login.click("Submit");

        assertTrue(login.isLoggedIn());

        LoginForm login2 = new LoginForm("user@email.com", "password123");
        assertFalse(login2.isLoggedIn());
        login2.input("user@email.com");
        login2.input("password123");
        login2.click("Submit");
        assertTrue(login2.isLoggedIn());

        LoginForm login3 = new LoginForm("john.doe", "p@ssw0rd");
        assertFalse(login3.isLoggedIn());
        login3.input("john.doe");
        login3.input("p@ssw0rd");
        login3.click("Submit");
        assertTrue(login3.isLoggedIn());

        LoginForm login4 = new LoginForm("administrator", "securePassword123!");
        assertFalse(login4.isLoggedIn());
        login4.input("administrator");
        login4.input("securePassword123!");
        login4.click("Submit");
        assertTrue(login4.isLoggedIn());
    }

    // 2 points Failed Login
    @Test
    public void problem3_3() {

        LoginForm login1 = new LoginForm("admin", "admin123");
        login1.input("wrong");
        login1.input("wrong123");
        login1.click("Submit");
        assertFalse(login1.isLoggedIn());


        LoginForm login2 = new LoginForm("user", "pass");
        login2.input("user");
        login2.input("wrong");
        login2.click("Submit");
        assertFalse(login2.isLoggedIn());


        LoginForm login3 = new LoginForm("test", "test123");
        login3.input("wrong");
        login3.input("test123");
        login3.click("Submit");
        assertFalse(login3.isLoggedIn());

        LoginForm login4 = new LoginForm("user", "pass123");

        login4.input("");
        login4.input("");
        login4.click("Submit");

        assertFalse(login4.isLoggedIn());
    }

    // 2 points Form Reset
    @Test
    public void problem3_4() {
        LoginForm login = new LoginForm("User", "pass123");

        login.input("user");
        login.input("partial");
        login.click("Reset");
        login.input("User");
        login.input("pass123");
        login.click("Submit");
        assertTrue(login.isLoggedIn());

        LoginForm login1 = new LoginForm("admin", "admin123");
        login1.input("admin");
        login1.input("admin123");
        login1.click("Reset");
        assertFalse(login1.isLoggedIn());

        LoginForm login2 = new LoginForm("test", "test123");
        login2.input("test");
        login2.input("test123");
        login2.click("Submit");
        login2.click("Reset");
        assertTrue(login2.isLoggedIn());


    }
    // 2 points Ignoring Input after Login
    @Test
    public void problem3_5() {
        LoginForm login1 = new LoginForm("admin", "admin123");
        login1.input("admin");
        login1.input("admin123");
        login1.click("Submit");
        login1.input("hacker");
        login1.input("hacker123");
        login1.click("Submit");
        assertTrue(login1.isLoggedIn());

        LoginForm login2 = new LoginForm("user", "pass");
        login2.input("user");
        login2.input("pass");
        login2.click("Submit");
        login2.click("Reset");
        assertTrue(login2.isLoggedIn());

        LoginForm login3 = new LoginForm("test", "test123");
        login3.input("test");
        login3.input("test123");
        login3.click("Submit");
        login3.input("newuser");
        login3.input("newpass");
        login3.click("Submit");
        assertTrue(login3.isLoggedIn());

        LoginForm login4 = new LoginForm("john.doe", "password@123");

        login4.input("john.doe");
        login4.input("password@123");
        login4.input("extra");
        login4.input("input");
        login4.click("Submit");

        assertTrue(login4.isLoggedIn());
    }

    // 2 points Existing Test case
    @Test
    public void problem5_1() {
        // Test case 1
        Toy lamby = new Toy("Lamby", "white fluffy stuffed lamb that I got for Christmas", false);
        Toy sharky = new Toy("Sharky", "blue shark with its mouth chewed off",
                true);
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

    // 2 points Add and Remove toys
    @Test
    public void problem5_2() {
        Toy toy1 = new Toy("Squeaky Duck", "yellow rubber duck", false);
        Toy toy2 = new Toy("Chewy Bone", "brown bone", true);
        Toy toy3 = new Toy("Tug Rope", "blue and white rope", false);
        ToyInventory inventory = new ToyInventory();

        inventory.addToy(toy1);
        inventory.addToy(toy2);
        inventory.addToy(toy3);
        inventory.removeToy("Chewy Bone");
        assertEquals("Squeaky Duck\nyellow rubber duck\nNOT DESTROYED\n"
                + "Tug Rope\nblue and white rope\nNOT DESTROYED", inventory.getInventoryReport());

        inventory.removeToy("Squeaky Duck");
        inventory.removeToy("Tug Rope");
        assertEquals("", inventory.getInventoryReport());

    }

    //2 points Test for Duplicate Toy names

    @Test
    public void problem5_3() {
        Toy toy1 = new Toy("Squeaky Ball", "red ball", false);
        Toy toy2 = new Toy("Squeaky Ball", "blue ball", true);
        Toy toy3 = new Toy("Plush Bear", "soft teddy bear", false);
        ToyInventory inventory = new ToyInventory();

        inventory.addToy(toy1);
        inventory.addToy(toy2);
        assertEquals("Squeaky Ball\nred ball\nNOT DESTROYED", inventory.getInventoryReport());


        inventory.addToy(toy3);
        Toy duplicateBear = new Toy("Plush Bear", "another teddy bear", true);
        inventory.addToy(duplicateBear);
        assertEquals("Squeaky Ball\nred ball\nNOT DESTROYED\n"
                + "Plush Bear\nsoft teddy bear\nNOT DESTROYED", inventory.getInventoryReport());


        inventory.removeToy("Squeaky Ball");
        Toy newSqueakyBall = new Toy("Squeaky Ball", "green ball", false);
        inventory.addToy(newSqueakyBall);
        assertEquals("Plush Bear\nsoft teddy bear\nNOT DESTROYED\n"
                + "Squeaky Ball\ngreen ball\nNOT DESTROYED", inventory.getInventoryReport());
    }

    //2 points Testing with Empty toy name , null description
    @Test
    public void problem5_4() {
        Toy toy1 = new Toy("", "mystery toy", false); // Empty name
        Toy toy2 = new Toy("Frisbee", null, true); // Null description
        String longDescription = "This is a very long description that goes on and on and on...";
        Toy toy3 = new Toy("Rubber Chicken", longDescription, false); // Very long description
        ToyInventory inventory = new ToyInventory();

        // Example 1: Add a toy with an empty name
        inventory.addToy(toy1);
        assertEquals("\nmystery toy\nNOT DESTROYED", inventory.getInventoryReport());

        // Example 2: Add a toy with a null description
        inventory.addToy(toy2);
        assertEquals("\nmystery toy\nNOT DESTROYED\n"
                + "Frisbee\nnull\nDESTROYED", inventory.getInventoryReport());

        // Example 3: Add a toy with a very long description
        inventory.addToy(toy3);
        assertEquals("\nmystery toy\nNOT DESTROYED\n"
                + "Frisbee\nnull\nDESTROYED\n"
                + "Rubber Chicken\n" + longDescription + "\nNOT DESTROYED", inventory.getInventoryReport());
    }

    // 2 points Verify Inventory report
    @Test
    public void problem5_5() {
        Toy toy1 = new Toy("Kong", "chewable rubber toy", false);
        Toy toy2 = new Toy("Nylabone", "durable chew bone", true);
        Toy toy3 = new Toy("Tennis Ball", "standard green ball", false);
        ToyInventory inventory = new ToyInventory();

        // Example 1: Generate a report for an empty inventory
        assertEquals("", inventory.getInventoryReport());

        // Example 2: Generate a report for an inventory with one toy
        inventory.addToy(toy1);
        assertEquals("Kong\nchewable rubber toy\nNOT DESTROYED", inventory.getInventoryReport());

        // Example 3: Generate a report for an inventory with multiple toys
        inventory.addToy(toy2);
        inventory.addToy(toy3);
        assertEquals("Kong\nchewable rubber toy\nNOT DESTROYED\n"
                + "Nylabone\ndurable chew bone\nDESTROYED\n"
                + "Tennis Ball\nstandard green ball\nNOT DESTROYED", inventory.getInventoryReport());
    }
    //  2 points Existing Test case
    @Test
    public void problem6_1() {
        BetterRectangle r1 = new BetterRectangle(2, 3, 15, 17);
        assertEquals(2.0, r1.getX(), EPSILON);
        assertEquals(3.0, r1.getY(), EPSILON);
        assertEquals(15.0, r1.getWidth(), EPSILON);
        assertEquals(17.0, r1.getHeight(), EPSILON);
        assertEquals(64.0, r1.getPerimeter(), EPSILON);
        assertEquals(255.0, r1.getArea(), EPSILON);
        assertTrue(BetterRectangle.class.getSuperclass() == Rectangle.class);
    }

    //2 points Test the inherited methods

    @Test
    public void problem6_2() {
        BetterRectangle r6 = new BetterRectangle(10, 20, 30, 40);

        assertTrue(r6.contains(15, 25)); // Inherited method from Rectangle
        assertFalse(r6.contains(5, 15));

        Rectangle other = new Rectangle(15, 25, 10, 10);
        assertTrue(r6.intersects(other)); // Inherited method from Rectangle
    }

    // 2 points Test large numbers
    @Test
    public void problem6_3() {
        BetterRectangle r5 = new BetterRectangle(1000000, 1000000, 1000000, 2000000);
        assertEquals(1000000.0, r5.getX(), EPSILON);
        assertEquals(1000000.0, r5.getY(), EPSILON);
        assertEquals(1000000.0, r5.getWidth(), EPSILON);
        assertEquals(2000000.0, r5.getHeight(), EPSILON);
        assertEquals(6000000.0, r5.getPerimeter(), EPSILON);
        assertEquals(2000000000000.0, r5.getArea(), EPSILON);
    }

    // 2 points Test negative coordinates
    @Test
    public void problem6_4() {
        BetterRectangle r3 = new BetterRectangle(-10, -20, 5, 8);
        assertEquals(-10.0, r3.getX(), EPSILON);
        assertEquals(-20.0, r3.getY(), EPSILON);
        assertEquals(5.0, r3.getWidth(), EPSILON);
        assertEquals(8.0, r3.getHeight(), EPSILON);
        assertEquals(26.0, r3.getPerimeter(), EPSILON);
        assertEquals(40.0, r3.getArea(), EPSILON);
    }

    // 2 points Test zero dimensions
    @Test
    public void problem6_5() {
        BetterRectangle r2 = new BetterRectangle(0, 0, 0, 0);
        assertEquals(0.0, r2.getX(), EPSILON);
        assertEquals(0.0, r2.getY(), EPSILON);
        assertEquals(0.0, r2.getWidth(), EPSILON);
        assertEquals(0.0, r2.getHeight(), EPSILON);
        assertEquals(0.0, r2.getPerimeter(), EPSILON);
        assertEquals(0.0, r2.getArea(), EPSILON);
    }

    // 10 points existing test case
    @Test
    public void problems7_1() {
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
    // 5 points test DailyAppointment
    @Test
    public void problems7_2() {
        DailyAppointment daily = new DailyAppointment("Brush teeth");
        assertTrue(daily.occursOn(2023, 1, 1));
        assertTrue(daily.occursOn(2023, 6, 15));
        assertTrue(daily.occursOn(2025, 12, 31));

        assertTrue(daily.equals(new DailyAppointment("Brush teeth")));
        assertFalse(daily.equals(new DailyAppointment("Floss teeth")));
        assertFalse(daily.equals(null));


        assertEquals("Brush teeth", daily.getDescription());
        daily.setDescription("New routine");
        assertEquals("New routine", daily.getDescription());
    }
    // 5 point test MonthlyAppointment
    @Test
    public void problems7_3() {
        MonthlyAppointment monthly = new MonthlyAppointment(15, "Pay rent");
        assertTrue(monthly.occursOn(2023, 1, 15));
        assertTrue(monthly.occursOn(2023, 12, 15));
        assertTrue(monthly.occursOn(2024, 2, 15));
        assertFalse(monthly.occursOn(2023, 1, 16));
        assertFalse(monthly.occursOn(2023, 2, 14));

        assertEquals(15, monthly.getDay());

        assertTrue(monthly.equals(new MonthlyAppointment(15, "Pay rent")));
        assertFalse(monthly.equals(new MonthlyAppointment(16, "Pay rent")));
        assertFalse(monthly.equals(new MonthlyAppointment(15, "Different task")));
        assertFalse(monthly.equals(null));

        MonthlyAppointment endOfMonth = new MonthlyAppointment(31, "Monthly Financial Review");
        assertTrue(endOfMonth.occursOn(2023, 1, 31));
        assertTrue(endOfMonth.occursOn(2023, 3, 31));
        assertFalse(endOfMonth.occursOn(2023, 4, 30));
        assertFalse(endOfMonth.occursOn(2023, 2, 28));
    }
    // 5 point test oneTimeAppointment
    @Test
    public void problems7_4() {
        OnetimeAppointment onetime1 = new OnetimeAppointment(2023, 3, 1, "Dentist appointment");
        assertTrue(onetime1.occursOn(2023, 3, 1));
        assertFalse(onetime1.occursOn(2023, 3, 2));
        assertFalse(onetime1.occursOn(2024, 3, 1));

        assertEquals(2023, onetime1.getYear());
        assertEquals(3, onetime1.getMonth());
        assertEquals(1, onetime1.getDay());

        assertTrue(onetime1.equals(new OnetimeAppointment(2023, 3, 1, "Dentist appointment")));
        assertFalse(onetime1.equals(new OnetimeAppointment(2023, 3, 2, "Dentist appointment")));
        assertFalse(onetime1.equals(new OnetimeAppointment(2023, 3, 1, "Different appointment")));
        assertFalse(onetime1.equals(null));

    }
    // 5 point test Weekly Appointment
    @Test
    public void problems7_5() {
        WeeklyAppointment weekly = new WeeklyAppointment(DayOfWeek.MONDAY, "Team meeting");
        assertTrue(weekly.occursOn(2023, 1, 2));  // A Monday
        assertTrue(weekly.occursOn(2023, 1, 9));  // Next Monday
        assertTrue(weekly.occursOn(2023, 12, 25)); // A Monday
        assertFalse(weekly.occursOn(2023, 1, 3)); // A Tuesday
        assertFalse(weekly.occursOn(2023, 1, 8)); // A Sunday

        assertEquals(DayOfWeek.MONDAY, weekly.getDayOfWeek());

        assertTrue(weekly.equals(new WeeklyAppointment(DayOfWeek.MONDAY, "Team meeting")));
        assertFalse(weekly.equals(new WeeklyAppointment(DayOfWeek.TUESDAY, "Project status update")));
        assertFalse(weekly.equals(new WeeklyAppointment(DayOfWeek.MONDAY, "Team building exercise")));
        assertFalse(weekly.equals(null));
        WeeklyAppointment weekly2 = new WeeklyAppointment(DayOfWeek.WEDNESDAY, "Midweek review");
        assertTrue(weekly2.occursOn(2023, 1, 4));  // Wednesday
        assertFalse(weekly2.occursOn(2023, 1, 5)); // Thursday
    }
    // 5 point test yearly appointment
    @Test
    public void problems7_6() {
        YearlyAppointment yearly = new YearlyAppointment(12, 25, "Christmas");
        assertTrue(yearly.occursOn(2023, 12, 25));
        assertTrue(yearly.occursOn(2024, 12, 25));
        assertTrue(yearly.occursOn(2025, 12, 25));
        assertFalse(yearly.occursOn(2023, 12, 26));
        assertFalse(yearly.occursOn(2023, 11, 25));

        assertEquals(12, yearly.getMonth());
        assertEquals(25, yearly.getDay());

        assertTrue(yearly.equals(new YearlyAppointment(12, 25, "Christmas")));
        assertFalse(yearly.equals(new YearlyAppointment(12, 26, "Christmas")));
        assertFalse(yearly.equals(new YearlyAppointment(12, 25, "Different holiday")));

        YearlyAppointment leapDay = new YearlyAppointment(2, 29, "Happy Leap day");
        assertTrue(leapDay.occursOn(2024, 2, 29));  // 2024 is a leap year
        assertFalse(leapDay.occursOn(2023, 2, 28)); // 2023 is not a leap year
        assertFalse(leapDay.occursOn(2023, 3, 1));  // Day after Feb 28 in non-leap year
    }
    // 3 point test inheritance
    @Test
    public void problems7_7() {
        assertTrue(DailyAppointment.class.getSuperclass() == Appointment.class);
        assertTrue(MonthlyAppointment.class.getSuperclass() == Appointment.class);
        assertTrue(OnetimeAppointment.class.getSuperclass() == Appointment.class);
        assertTrue(WeeklyAppointment.class.getSuperclass() == Appointment.class);
        assertTrue(YearlyAppointment.class.getSuperclass() == Appointment.class);
    }
    // 2 point test Description of appointment class
    @Test
    public void problems7_8() {
        Appointment appointment = new DailyAppointment("Morning Meditation");
        assertEquals("Morning Meditation", appointment.getDescription());
        appointment.setDescription("Daily exercise routine");
        assertEquals("Daily exercise routine", appointment.getDescription());
        Appointment appointment1 = new DailyAppointment("Journaling time");
        assertEquals("Journaling time", appointment1.toString());
    }

}