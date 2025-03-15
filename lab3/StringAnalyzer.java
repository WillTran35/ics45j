package labs.lab3;

import java.util.ArrayList;

public class StringAnalyzer {
    // ADD INSTANCE VARIABLES EHRE
    private String mystring ;
    public StringAnalyzer(String str) {
        this.mystring = str;
// FILL IN
    }
    /**
     *
     * @return a string consisting of only the uppercase letters
     * in the string
     */
    public String getAllUppercase() {
        String result = "" ;
        int i = 0 ;
        while (i < this.mystring.length()){
            char ch = mystring.charAt(i);
            if (Character.isUpperCase(ch)){
                result += ch;
            }
            i++;
        }
        return result; // FIX ME
    }
    /**
     *
     * @return a string consisting of every other char
     * in the string, starting with the first char
     */
    public String getEveryOtherChar() {
        String result = "" ;
        int i = 0 ;
        while (i < this.mystring.length()){
            char ch = mystring.charAt(i);
            result += ch;
            i += 2;

        }
        return result; // FIX ME
    }

    public boolean isVowel(char c ){
        String VOWELS = "aeiouAEIOU";

        return VOWELS.indexOf(c) != -1;
    }
    /**
     *
     * @return a string in which all the vowels in the
     * string are replaced with an asterisk
     */
    public String replaceVowelsWithAsterisk() {
        String result = "" ;
        int i = 0 ;
        while (i < this.mystring.length()){
            char ch = mystring.charAt(i);
            if (isVowel(ch)){
                result += '*';
            }
            else{
                result += ch;
            }
            i++;
        }
        return result; // FIX ME

    }
    /**
     *
     * @return the number of vowels in the string
     */
    public int getNumVowels() {
        int result = 0 ;
        int i = 0 ;
        while (i < this.mystring.length()){
            char ch = mystring.charAt(i);
            if (isVowel(ch)){
                result ++;
            }
            i++;
        }
        return result ;
    }
    /**
     *
     * @return a string containing the indices of all vowels
     * in the string, each one separated by a single space
     */
    public String getVowelPositions() {
        ArrayList<Integer> nums = new ArrayList<>();
        String result = "";
        int in = 0 ;
        while (in < this.mystring.length()){
            char ch = mystring.charAt(in);
            if (isVowel(ch)){
                nums.add(in);
            }
            in ++;
        }
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            if (i != nums.size() - 1) { // If it's not the last element
                result += x + " "; // Append with space
            } else {
                result += x; // Append without space for the last element
            }
        }
        return result;
    }

    public static void main (String []args){
        StringAnalyzer sa = new StringAnalyzer("Robert Sean Navarro");

        System.out.println("All Uppercase: " + sa.getAllUppercase());
        System.out.println("Every Other Char: " + sa.getEveryOtherChar());
        System.out.println("Vowels Replaced with Asterisk: " + sa.replaceVowelsWithAsterisk());
        System.out.println("Number of Vowels: " + sa.getNumVowels());
        System.out.println("Vowel Positions: " + sa.getVowelPositions());

    }
}