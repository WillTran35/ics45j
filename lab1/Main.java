package labs.lab1;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;
public class Main {
    /**
     * Given a string, if a length 2 substring appears at both its beginning and
     end
     * (case-sensitive comparison), return a string without the substring at the
     * beginning, so "HelloHe" yields "lloHe". The substring may overlap with
     * itself, so "Hi" yields "." Otherwise, return the original string
     unchanged.
     * The string can be any length, including 0.
     *
     * @param str the input string
     * @return if a length 2 substring appears at both its beginning and
    end,
     * a string without the substring at the beginning
     */
    public static String problem1_remove2(String str) {
        if (str.length() < 2){
            return str;
        }
        String sub1 = str.substring(0,2);
        String sub2 = str.substring(str.length()-2);
        if (sub1.equals(sub2)){
            if (str.length() == 2){
                return "";
            }
            return str.substring(2);
        }
        else{
            return str;
        }
    }
    /**
     * Given a string and a second "word" string, we'll say that the word matches
     the
     * string if it appears at the front of the string, except its first char
     does not
     * need to match exactly. On a match, return the front of the string, or
     otherwise
     * return the empty string. So, with the string "hippo" the word "hi" returns
     * "hi", "xip" returns "hip", and "dog" returns "". The word will be at least
     * length 1.
     *
     * @param str the input string
     * @param word the word to match
     * @return the front of the string if it matches, otherwise the empty
    string
     */
    public static String problem2_frontMatch(String str, String word) {
        int length = word.length();
        int strlength = str.length();
        if (strlength < length){
            return "";
        }
        for (int i = 1 ; i < length; i++){
            if (word.charAt(i)!=str.charAt(i)){
                return "";
            }
        }

        return str.substring(0, length);
    }
    /**
     * In the Java library, a color is specified by its red, green, and blue
     components
     * between 0 and 255. Write a method that:
     *
     * 1. Takes in a red, a green, and a blue value, constructs a Color object
     based on
     * those values.
     * 2. Applies the brighter method of the Color class to the color.
     * 3. Returns the resulting Color object
     *
     * (Note: you will not actually see the color. Graphical user interfaces will
     be
     * covered in week 9.)
     *
     * Assume all color value inputs will be integers between 0 and 255.
     *
     * @param red the red value
     * @param green the green value
     * @param blue the blue value
     *
     * @return the brightened version of the input Color
     */
    public static Color problem3_brighten(int red, int green, int blue) {
        Color myColor = new Color(red, green, blue);
        return myColor.brighter(); // FIX ME
    }
    /**
     * This method will pick a combination of numbers in a lottery. In this
     lottery,
     * players can choose 6 numbers (possibly repeated) between 1 and 99 (both
     inclusive).
     * Construct an object of the Random class (see the Java API docs) and invoke
     an
     * appropriate method to generate each number. Your method should return a
     String that
     * contains this sentence: "The winning numbers are ", followed by the 6
     numbers with
     * one space in between each number.
     *
     * @return "The winning numbers are ", followed by 6 randomly-generated
    numbers
     * with one space in between each number.
     */
    public static String problem4_drawNumbers() {
        int [] myarr = new int[6];
        int lower = 1;
        int high  = 99;
        String result ;
        Random rand = new Random();
        for (int i = 0 ; i < 6 ; i++){
            myarr[i] = rand.nextInt(high - lower + 1) + lower;
        }
        result = "The winning numbers are " + myarr[0] + " " + myarr[1] + " " + myarr[2] + " " + myarr[3] + " " + myarr[4] + " "
                + myarr[5];
        return result;
    }
    /**
     * Write a method that creates two Rectangle objects and returns a Rectangle
     object
     * that is the intersection of the two rectangles.
     *
     * Assume all inputs for height and width will always be >= 0.
     *
     * @param x1 x position of the first rectangle
     * @param y1 y position of the first rectangle
     * @param width1 width of the first rectangle
     * @param height1 height of the first rectangle
     * @param x2 x position of the second rectangle
     * @param y2 y position of the second rectangle
     * @param width2 width of the second rectangle
     * @param height2 height of the second rectangle
     *
     * @return a Rectangle object that is the intersection of the two rectangles
     */
    public static Rectangle problem5_rectIntersect(int x1, int y1, int width1,
                                                   int height1,
                                                   int x2, int y2, int width2, int height2) {
        Rectangle rect1 = new Rectangle(x1, y1, width1, height1);
        Rectangle rect2 = new Rectangle(x2, y2, width2, height2);

        return rect1.intersection(rect2);
    }
    public static void main(String[] args){
//        System.out.println(problem1_remove2("HelloHe"));
//        System.out.println(problem1_remove2("HelloHi"));
//        System.out.println(problem1_remove2("Hi"));
//        System.out.println(problem1_remove2("H"));
//        System.out.println(problem2_frontMatch("hippo", "h"));
//        System.out.println(problem2_frontMatch("hippo", "xip"));
//
//        System.out.println(problem4_drawNumbers());
        System.out.println(Main.problem2_frontMatch("hippo", "hi")); // Expected: "hi"
        System.out.println(Main.problem2_frontMatch("hippo", "xip")); // Expected: "hip"
        System.out.println(Main.problem2_frontMatch("hippo", "dog")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("hippo", "i")); // Expected: "h"
        System.out.println(Main.problem2_frontMatch("hippo", "ix")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("h", "ix")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("", "i")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("hip", "zi")); // Expected: "hi"
        System.out.println(Main.problem2_frontMatch("hip", "zip")); // Expected: "hip"
        System.out.println(Main.problem2_frontMatch("hip", "zig")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("h", "z")); // Expected: "h"
        System.out.println(Main.problem2_frontMatch("hippo", "xippo")); // Expected: "hippo"
        System.out.println(Main.problem2_frontMatch("hippo", "xyz")); // Expected: ""
        System.out.println(Main.problem2_frontMatch("hippo", "hip")); // Expected: "hip"
        System.out.println(Main.problem2_frontMatch("kitten", "cit")); // Expected: "kit"
        System.out.println(Main.problem2_frontMatch("kit", "cit")); // Expected: "kit"


    }
}

