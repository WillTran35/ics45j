package labs.lab3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    /**
     * Takes in a string and returns a string containing all substrings, sorted
     by
     * length (ascending), with a comma and a space separating each one
     *
     * @param str the string from which to make substrings
     * @return string containing all substrings
     */
    public static String problem1_getAllSubstrings(String str) {
//        problem1_getAllSubstrings("rum"); // returns "r, u, m, ru, um, rum"
//problem1_getAllSubstrings("***"); // returns "*, *, *, **, **, ***"
//problem1_getAllSubstrings("r"); // returns "r"
        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0 ; i < str.length(); i ++){
            for (int j = i; j <= str.length() ; j ++){
                if (str.substring(i,j) != ""){
                    substrings.add(str.substring(i,j));
                }
            }
        }
        substrings.sort((a, b) -> Integer.compare(a.length(), b.length()));
        return String.join(", ", substrings); // FIX ME
    }
    /**
     * Accepts a String as a parameter and looks for a mirror image (backwards)
     * string at both the beginning and end of the given string. In other words,
     * zero or more characters at the very beginning of the given string, and at
     the
     * very end of the string in reverse order (possibly overlapping). For
     example,
     * the string "abXYZba" has the mirror end "ab".
     *
     * @param str the string to check for mirror ends
     * @return the mirror end, or the empty string if no mirror end exists
     */

    public static boolean isPalindrome(String str){
        int start = str.length() -1 ;
        int count = 0;
        while (start >= 0){
            if (str.charAt(start) != str.charAt(count)){
                return false;
            }
            start --;
            count ++;
        }
        return true;
    }

    public static String problem2_mirrorEnds(String str) {
        int start = 0 ;
        int end = str.length() - 1;
        String result  = "" ;
        while (start <= end){
            if (str.charAt(start) == str.charAt(end)){
                result += str.charAt(start);
                start ++;
                end --;
            }
            else{
                break;
            }
        }
        if (isPalindrome(str)){
            return str;
        }
        return result; // FIX ME
    }
    /**
     * Accepts a string as a parameter and returns the sum of the numbers
     appearing
     * in the string, ignoring all other characters. A "number" in this case is a
     * series of 1 or more digit characters in a row.
     *
     * @param str the input String
     *
     * @return the sum of all the number appearing in the string
     */
    public static int problem3_sumNumbers(String str) {
//        problem3_sumNumbers("abc123xyz") // returns 123
//problem3_sumNumbers("aa11b33") // returns 44
//problem3_sumNumbers("7 11") // returns 18
//problem3_sumNumbers("Robert") // returns 0
        int sum = 0 ;
        int i = 0 ;
        while (i < str.length()){
            char c = str.charAt(i);
            String temp = "" ;
            if (Character.isDigit(c)){
                temp += c;
                i ++;
                while (i < str.length()){
                    char ch = str.charAt(i);
                    if (Character.isDigit(ch)){
                        temp += ch;
                        i ++ ;
                    }
                    else{
                        break;
                    }
                }
                sum += Integer.parseInt(temp);
            }
            else{
                i++;
            }
        }
        return sum;
    }

    /**
     * Given a non-empty array, return true if there is a place to split the
     array
     * so that the sum of the numbers on one side is equal to the sum of the
     numbers
     * on the other side.
     *
     * @param nums the array to split
     * @return true if there is a place to split the array so that the sum of the
     * numbers on one side is equal to the sum of the numbers on the
    other
     * side
     */
    public static boolean problem6_sumSplitBalance(int[] nums) {
//        problem6_sumSplitBalance(new int[] {1, 1, 1, 2, 1}); // returns true
//        problem6_sumSplitBalance(new int[] {2, 1, 1, 2, 1}); // returns false
//        problem6_sumSplitBalance(new int[] {10, 10}); // returns true
//        problem6_sumSplitBalance(new int[] {1}); // returns false
        int sum = 0 ;
        for (int x : nums){
            sum += x;
        }

        int leftSum = 0 ;
        int rightSum = 0 ;
        int target = 0;

        if (nums.length < 2){
            return false;
        }
        for (int i = 0 ; i < nums.length; i ++){
            leftSum += nums[i];
            int j = nums.length - 1;
            target = sum - leftSum;
//            System.out.print("sum");
//            System.out.print(sum);
//            System.out.println(nums[i]);
            while (j > i){
                rightSum += nums[j];
//                System.out.print("RIGHTSUM");
//                System.out.println(rightSum);
                j -- ;
            }
            if (rightSum == leftSum){
//                System.out.print(rightSum);
                return true;
            }
            rightSum = 0;
        }

        return false; // FIX ME
    }
    /**
     * Takes an array of ints and returns an array that contains the exact same
     numbers
     * as the given array, but rearranged so that all the even numbers come
     before all
     * the odd numbers
     *
     * @param nums the input array
     *
     * @return the rearranged array with all even numbers coming before all odd
    numbers
     */
    public static int[] problem7_evenOdd(int[] nums) {
        ArrayList <Integer> evens = new ArrayList<>(nums.length);
        ArrayList <Integer> odds = new ArrayList<>(nums.length);
//        int [] evens = {0} ;
//        int [] odds = {0};
        for (int x : nums){
            if (x % 2 == 0){
                evens.add(x);
//                evens[evens.length -1 ] = x ;
            }
            else{
                odds.add(x);
//                odds[evens.length -1 ] = x ;
            }
        }
        for (int j : odds){
            evens.add(j);
        }
        int [] result = new int[nums.length];
        int count = 0 ;
        for (int x : evens){
            result[count] = x;
            count ++;
        }
        return result; // FIX ME
    }

    public static void main (String[] args){
        System.out.println(problem1_getAllSubstrings("rum")); // returns "r, u, m, ru, um, rum"
        System.out.println(problem1_getAllSubstrings("***"));
        System.out.println(problem1_getAllSubstrings("*"));
        System.out.println(problem2_mirrorEnds("abXYZba")); // Expected output: "ab"
        System.out.println(problem2_mirrorEnds("abca"));    // Expected output: "a"
        System.out.println(problem2_mirrorEnds("aba"));     // Expected output: "aba"
        System.out.println(problem2_mirrorEnds("abc"));     // Expected output: ""
        System.out.println(problem3_sumNumbers("abc123xyz")); // Expected output: 123
        System.out.println(problem3_sumNumbers("aa11b33"));   // Expected output: 44
        System.out.println(problem3_sumNumbers("7 11"));      // Expected output: 18
        System.out.println(problem3_sumNumbers("Robert"));

        System.out.println("problem6_sumSplitBalance(new int[] {1, 1, 1, 2, 1}): " +
                problem6_sumSplitBalance(new int[] {1, 1, 1, 2, 1})); // true

        System.out.println("problem6_sumSplitBalance(new int[] {2, 1, 1, 2, 1}): " +
                problem6_sumSplitBalance(new int[] {2, 1, 1, 2, 1})); // false

        System.out.println("problem6_sumSplitBalance(new int[] {10, 10}): " +
                problem6_sumSplitBalance(new int[] {10, 10})); // true

        System.out.println("problem6_sumSplitBalance(new int[] {1}): " +
                problem6_sumSplitBalance(new int[] { 0, 0 })); // true

        System.out.println("Example 1: " + Arrays.toString(problem7_evenOdd(new int[]{1, 0, 1, 0, 0, 1, 1})));

        // Example 2
        System.out.println("Example 2: " + Arrays.toString(problem7_evenOdd(new int[]{3, 3, 2})));

        // Example 3
        System.out.println("Example 3: " + Arrays.toString(problem7_evenOdd(new int[]{2, 2, 2})));


        System.out.println("Test 1: " + problem6_sumSplitBalance(new int[] {1, 1, 1, 2, 1})); // Expected: true
        System.out.println("Test 2: " + problem6_sumSplitBalance(new int[] {2, 1, 1, 2, 1})); // Expected: false
        System.out.println("Test 3: " + problem6_sumSplitBalance(new int[] {10, 10})); // Expected: true
        System.out.println("Test 4: " + problem6_sumSplitBalance(new int[] {1})); // Expected: false
        System.out.println("Test 5: " + problem6_sumSplitBalance(new int[] {10, 0, 1, -1, 10})); // Expected: true
        System.out.println("Test 6: " + problem6_sumSplitBalance(new int[] {1, 1})); // Expected: true
        System.out.println("Test 7: " + problem6_sumSplitBalance(new int[] {1, 2})); // Expected: false
        System.out.println("Test 8: " + problem6_sumSplitBalance(new int[] {1, 1, 1, 1, 4})); // Expected: true
        System.out.println("Test 9: " + problem6_sumSplitBalance(new int[] {2, 1, 1, 1, 4})); // Expected: false
        System.out.println("Test 10: " + problem6_sumSplitBalance(new int[] {2, 3, 4, 1, 2})); // Expected: false
        System.out.println("Test 11: " + problem6_sumSplitBalance(new int[] {1, 2, 3, 1, 0, 2, 3})); // Expected: true
        System.out.println("Test 12: " + problem6_sumSplitBalance(new int[] {1, 2, 3, 1, 0, 1, 3})); // Expected: false
        System.out.println("Test 13: " + problem6_sumSplitBalance(new int[] {0, 0, 0, 0, 0})); // Expected: true
        System.out.println("Test 14: " + problem6_sumSplitBalance(new int[] {11, 1, 3, 3, 4})); // Expected: true
        System.out.println("Test 15: " + problem6_sumSplitBalance(new int[] {0})); // Expected: false
        System.out.println("Test 16: " + problem6_sumSplitBalance(new int[] {0, 0})); // Expected: true
        System.out.println("Test 17: " + problem6_sumSplitBalance(new int[] {-1, -11, -3, -18, 3})); // Expected: true
        System.out.println("Test 18: " + problem6_sumSplitBalance(new int[] {-1, -11, -3, -18, -3})); // Expected: false
        System.out.println("Test 19: " + problem6_sumSplitBalance(new int[] {-1, -11, -3, -8, -13, -10})); // Expected: true
    }

}
