package labs.lab7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
    private TreeSet<String> uniqueWords;
    private File myFile ;
    private ArrayList <String> mylist;
    private String fileName;
// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE
    /**
     * Constructor
     *
     * @param filename file from which to read words
     */
    public WordCounter(String filename) {
// FILL IN
        uniqueWords = new TreeSet<String>();
        myFile = new File(filename);
        mylist = new ArrayList<String>();
        fileName = filename;
        try (Scanner in = new Scanner(myFile)){
            while (in.hasNext()){
                String x = in.next();
                String res = "";
                for (int j = 0; j < x.length(); j++){
                    if (Character.isLetterOrDigit(x.charAt(j))){
                        res += Character.toLowerCase(x.charAt(j));
                    }
                }
                mylist.add(res);
                uniqueWords.add(res);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File: " + filename + " not found");
        }
    }
    /**
     * Returns the number of unique words in the file
     *
     * @return number of unique words
     */
    public int getNumUniqueWords() {
        return uniqueWords.size(); // FIX ME
    }
    /**
     * Returns the number of words in the file
     *
     * @return number of words
     */
    public int getNumWords() {
        return mylist.size(); // FIX ME
    }
    /**
     * returns a list of the unique words with all non-letter and non-digit
     * characters removed, all in lower case, as a List in alphabetical order
     *
     * @return list of unique words
     */
    public List<String> getUniqueWords() {
        ArrayList <String> result = new ArrayList<String>();
        for (String x : uniqueWords){
            String res = "";
            for (int i = 0; i < x.length(); i++){
                if (Character.isLetterOrDigit(x.charAt(i))){
                    res += Character.toLowerCase(x.charAt(i));
                }
            }
            result.add(res);
        }
        return result; // FIX ME
    }
}
