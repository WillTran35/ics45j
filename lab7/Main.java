package labs.lab7;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1,
     3,
     * ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3
     * ears, because they each have a raised foot. Recursively return the number
     of
     * "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     *
     * @param bunnies number of bunnies
     *
     * @return number of ears total in line
     */
    public static int problem1_countEars(int bunnies) {
        int count = 0 ;
        if (bunnies == 0 ){
            return 0; // base case
        }
        if (bunnies % 2 == 1) {
            return 2 + problem1_countEars(bunnies - 1);
        } else {
            return 3 + problem1_countEars(bunnies - 1);
        }
         // FIX ME
    }
    /**
     * Given an array of ints, computes recursively if the array contains
     somewhere
     * a value followed in the array by that value times 10. If so, returns true.
     *
     * We'll use the convention of considering only the part of the array that
     * begins at the given index. Assume that the initial call will pass in index
     as
     * 0.
     *
     * @param nums input array
     * @param index the index of the array to begin considering
     *
     * @return true if the array contains somewhere a value followed in the array
    by
     * that value times 10, false otherwise
     */
    public static boolean problem2_arrayTimesTen(int[] nums, int index) {
        if (index >= nums.length - 1){
            return false;
        }
        if (nums[index] * 10 == nums[index + 1]){
            return true;
        }
        return problem2_arrayTimesTen(nums, index + 1);

    }
    /**
     * Given an array of ints, compute recursively if the array contains a 6.
     * We'll use the convention of considering only the part of the array that
     * begins at the given index. In this way, a recursive call can pass index+1
     * to move down the array. The initial call will always pass in index as 0.
     *
     * @param nums the array of ints
     * @param index index at which to begin
     *
     * @return whether the array contains a 6
     */

    public static boolean problem3_contains6(int[] nums, int index) {
        if (index >= nums.length){
            return false;
        }
        if (nums[index] == 6){
            return true;
        }
        return problem3_contains6(nums, index + 1);
    }
    /**
     * Reverses the given sentence.
     *
     * @param sentences Sentences to be reversed
     *
     * @return reversed sentences
     */
    public static String problem6_reverse(String sentences) {
//        Mary had a little lamb. Its fleece was white as snow.
        Stack<String> myStack = new Stack<String>();
        String result = "";
        try (Scanner in = new Scanner(sentences)){
            while (in.hasNext()){
                String x = in.next();
                if (x.charAt(x.length() - 1) == '.'){
                    result += x.substring(0,1).toUpperCase() + x.substring(1,x.length() - 1 ).toLowerCase() + " ";
                    while (!myStack.isEmpty()){
                        if (myStack.size() != 1 ){
                            result += myStack.pop()+ " ";
                        }
                        else{
                            result += myStack.pop()+ ". ";
                        }
                    }
                }
                else{
                    myStack.add(x.toLowerCase());
                }
            }
            result = result.trim();
            return result;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (sentences == null || sentences.length() <= 1){
            return sentences;
        }
        return problem6_reverse(sentences.substring(1) + sentences.charAt(0));
    }
    public static void main (String[] args){
        String sentence1 = "MARY HAD A LITTLE LAMB. Its fleece was white as snow.";
        System.out.println(problem6_reverse(sentence1.toUpperCase())); // returns "Lamb little a had mary. Snow as white was fleece its."
        System.out.println(problem3_contains6(new int[] {1, 6, 4}, 0));
    }
}