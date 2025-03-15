package labs.lab2;
import java.util.Scanner;
//import java.util.Math;
public class Main {
    /**
     * Returns a string representing the number of hours and minutes between two
     * military times (from time1 to time2).
     *
     * Assume inputs will always be valid military times.
     *
     * @param time1 first time in military format
     * @param time2 second time in military format
     *
     * @return a string representing the hours and minutes from time1 to time 2
     */
    public static String problem1_militaryTimeDifference(int time1, int time2) {
        //if time1 > time2 find time it takes time1 to get to midnight
        // if time 2> time1 find time it gets time 1 to get to time2

//        problem1_militaryTimeDifference(900, 1730); // returns "8 hours 30 minutes"
//        problem1_militaryTimeDifference(1730, 900); // returns "15 hours 30 minutes"

        int total_hrs = 0 ;
        int total_min = 0 ;
        String result = "";
        int hr1 = (int) time1 / 100 ;
        int min1 = (int) time1 % 100;

        int hr2 = (int) time2 / 100 ;
        int min2 = (int) time2 % 100;

        int time1time = hr1 * 60 + min1;
        int time2time = hr2 * 60 + min2;
//        System.out.print(hr1 + " " + min1 + " " + hr2+ " " + min2 );
        if (time1time > time2time){
            time2time += 24*60;  // need to go to next day
        }
        total_hrs = Math.abs(time2time - time1time) / 60;
        total_min = Math.abs(time2time-time1time) %60;
        result = total_hrs + " hours " + total_min +  " minutes";
        return result; // FIX ME
    }
    /**
     * Reads a number between 1,000 and 999,999 from the user and prints it with
     * no commas
     *
     * @param in the Scanner to be used for user input
     *
     * To run this method using the keyboard for user input, call it
    like
     * this: problem2_removeCommas(new Scanner(System.in));
     */
    public static void problem2_removeCommas(Scanner in) {
// FILL IN

        int x ;
        System.out.print("Please enter an integer between 1,000 and 999,999, using a comma after the thousands: ");
        x = in.nextInt();
        System.out.print(x);
    }
    /**
     * Accepts an int as a parameter and returns a String that contains the
     * sequence of individual digits, each separated by one space. You may assume
     * that the input always has exactly five digits and is not negative.
     *
     * @param number the input number
     *
     * @return a String that contains the sequence of individual digits, each
     * separated by one space
     */
    public static String problem3_printDigits(int number) {
        //always has 5 digits
        //ex 12345
        int first = number / 10000;
        int second = (number/1000)%10;
        int third = (number/100) %10;
        int fourth = (number / 10) %10;
        int fifth = (number)% 10;
        return first + " " + second + " " + third + " " + fourth + " " + fifth; // FIX ME
    }
    /**
     * Given three integers a, b, and c, one of them is small, one is medium, and
     * one is large. Return true if the three values are evenly spaced, so the
     * difference between small and medium is the same as the difference between
     * medium and large.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     *
     * @return true if the three values are evenly space, false otherwise
     */
    public static boolean problem6_evenlySpaced(int a, int b, int c) {
        int temp;
        if (a > b){
            temp = a;
            a = b;
            b = temp;
        }
        if (b > c ){
            temp = b;
            b = c;
            c= temp;

        }
        if (a > b ){
            temp = a;
            a = b;
            b = temp;
        }

        return (b-a) == (c-b); // FIX ME
    }
    /**
     * Given three ints, a b c, return their sum. However, if one of the values
     is
     * the same as one or more of the other values, those matching values do not
     * count towards the sum.
     *
     * @param a first number
     * @param b second number
     * @param c third number
     * @return the sum of the 3 numbers; however, if one of the values is the
    same
     * as one or more of the other values, those matching values do not
     * count towards the sum
     */
    public static int problem7_specialSum(int a, int b, int c) {
        int sum = 0 ;
        if (a != b && a != c){
            sum += a;
        }
        if (b!=c && b!= a){
            sum += b;
        }
        if (c!= b && c!= a){
            sum += c;
        }
        return sum; // FIX ME
    }
    /**
     * Translates a letter grade into a numeric grade
     *
     * @param letterGrade the letter grade to translate
     * @return the numeric grade
     */
    public static double problem8_getNumericGrade(String letterGrade) {
        if (letterGrade.equalsIgnoreCase("a") || letterGrade.equalsIgnoreCase("a+")){
            return 4.0;
        }
        else if (letterGrade.equalsIgnoreCase("a-")){
            return 3.7;
        }
        else if (letterGrade.equalsIgnoreCase("b")){
            return 3.0;
        }
        else if (letterGrade.equalsIgnoreCase("b+")){
            return 3.3;
        }
        else if (letterGrade.equalsIgnoreCase("b-")){
            return 2.7;
        }
        else if (letterGrade.equalsIgnoreCase("c")){
            return 2.0;
        }
        else if (letterGrade.equalsIgnoreCase("c+")){
            return 2.3;
        }
        else if (letterGrade.equalsIgnoreCase("c-")){
            return 1.7;
        }
        else if (letterGrade.equalsIgnoreCase("d")){
            return 1.0;
        }
        else if (letterGrade.equalsIgnoreCase("d+")){
            return 1.3;
        }
        else if (letterGrade.equalsIgnoreCase("d-")){
            return 0.7;
        }
        else if (letterGrade.equalsIgnoreCase("f") ){
            return 0;
        }

        return -1; // FIX ME
    }
    /**
     * Translates a numeric grade into a letter grade
     *
     * @param numericGrade the numeric grade to translate
     *
     * @return the letter grade
     */
    public static String problem8_getLetterGrade(double numericGrade) {
        if (numericGrade >= 0 && numericGrade < 0.5){
            return "F";
        }
        else if (numericGrade >= 0.5 && numericGrade < 0.85){
            return "D-";
        }
        else if (numericGrade >= 0.85 && numericGrade < 1.15){
            return "D";
        }
        else if (numericGrade >= 1.15 && numericGrade < 1.5){
            return "D+";
        }
        else if (numericGrade >= 1.5 && numericGrade < 1.85){
            return "C-";
        }
        else if (numericGrade >= 1.85 && numericGrade < 2.15){
            return "C";
        }
        else if (numericGrade >= 2.15 && numericGrade < 2.5){
            return "C+";
        }
        else if (numericGrade >= 2.5 && numericGrade < 2.85){
            return "B-";
        }
        else if (numericGrade >= 2.85 && numericGrade < 3.15){
            return "B";
        }
        else if (numericGrade >= 3.15 && numericGrade < 3.5){
            return "B+";
        }
        else if (numericGrade >= 3.5 && numericGrade < 3.85){
            return "A-";
        }
        else if (numericGrade >= 3.85 && numericGrade < 4.0){
            return "A";
        }
        else if (numericGrade == 4.0){
            return "A+";
        }
        return "Error"; // FIX ME
    }

    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println(problem1_militaryTimeDifference(900, 1730)); // returns "8 hours 30 minutes"
        System.out.println(problem1_militaryTimeDifference(1730, 900));
        System.out.println(problem1_militaryTimeDifference(1630, 1630)); // returns "0 hours 0 minutes"
        System.out.println(problem1_militaryTimeDifference(630, 731)); // returns "1 hours 1 minutes"
//        problem2_removeCommas(in);
        System.out.println(problem3_printDigits(22250));
        System.out.println(problem6_evenlySpaced(4,6,2));
        System.out.println("problem6_evenlySpaced(2, 4, -6): " + problem6_evenlySpaced(2, 4, -6));  // Expected: false
        System.out.println("problem6_evenlySpaced(4, 6, 2): " + problem6_evenlySpaced(4, 6, 2));    // Expected: true
        System.out.println("problem6_evenlySpaced(3, 6, 4): " + problem6_evenlySpaced(3, 6, 4));    // Expected: false
        System.out.println("problem6_evenlySpaced(4, 4, 4): " + problem6_evenlySpaced(4, 4, 4));    // Expected: true
        System.out.println(problem7_specialSum(1, 2, 3)); // Expected output: 6
        System.out.println(problem7_specialSum(3, 2, 3)); // Expected output: 2
        System.out.println(problem7_specialSum(3, 3, 3));

        System.out.println(problem8_getNumericGrade("G")); // Expected: -1.0
        System.out.println(problem8_getNumericGrade("a-")); // Expected: 3.7
        System.out.println(problem8_getNumericGrade("C+")); // Expected: 2.3
        System.out.println(problem8_getNumericGrade("B")); // Expected: 3.0

        System.out.println(problem8_getLetterGrade(2.85)); // Expected: "B"
        System.out.println(problem8_getLetterGrade(0.51)); // Expected: "D-"
        System.out.println(problem8_getLetterGrade(4.0)); // Expected: "A+"
        System.out.println(problem8_getLetterGrade(8.3)); // Expected: "Error"

    }
}