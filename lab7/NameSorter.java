package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Sorts a file of names alphabetically, ignoring case
 */
public class NameSorter {
// ADD YOUR INSTANCE VARIABLES EHRE
    /**
     * Constructs a name sorter with the names from the input file
     *
     * @param inputFile name of the input file
     */
    private String inputFile;
    private File myFile;
    private ArrayList <String> myList;
    private static class customCompartor implements Comparator<String> {
        @Override
        public int compare(String s1, String s2){
            String first = s1.split(" ")[1].trim();
            String last = s1.split(" ")[0].trim();

            String first_curr = s2.split(" ")[1].trim();
            String last_curr = s2.split(" ")[0].trim();

            if (last.compareToIgnoreCase(last_curr) == 0){
                System.out.println("im here" + last + " " + last_curr);
                return first.compareToIgnoreCase(first_curr);
            }
            return last.compareToIgnoreCase(last_curr);
        }
    }
    public NameSorter(String inputFile) {
// FILL IN
        this.inputFile = inputFile;
        myFile = new File(inputFile);
        myList= new ArrayList<String>();
        try (Scanner in = new Scanner(myFile)){
            while (in.hasNextLine()){
                String [] x = in.nextLine().split(",");
//                System.out.println(Arrays.toString(x));
                String str = x[0] + x[1];
                System.out.println(str);
                myList.add(str);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File: " + inputFile + " not found");
        }
    }
    /**
     * Sorts the names from the input file alphabetically, ignoring case,
     * then writes the sorted names back to the file, overwriting the
     * previous content
     */
    public void sortNames() {
// FILL IN
        System.out.println(myList);
        myList.sort(new customCompartor());
        try (PrintWriter x = new PrintWriter(myFile)){
            for (int j = 0; j < myList.size(); j++) {
                String[] str = myList.get(j).split(" ");
                x.print(str[0] + ", " + str[1]);
                if (j < myList.size() - 1) {
                    x.println(); // Only print newline if it's not the last element
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File: " + inputFile + " not found");
        }
    }
    public static void main (String[] args){
//        NameSorter ns = new NameSorter("/Users/willtran/IdeaProjects/demo/src/labs/lab7/names1.txt");
//        ns.sortNames();
// names1.txt now looks like this: names1-after.txt Download names1-after.txt
        NameSorter ns2 = new NameSorter("/Users/willtran/IdeaProjects/demo/src/labs/lab7/names2.txt");
        ns2.sortNames();
// names2.txt now looks like this: names2-after.txt Download names2-after.txt


    }
}