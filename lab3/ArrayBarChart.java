package labs.lab3;
/**
 * Generates a bar chart representing the contents of an int array using the
 * index value of each element and asterisks
 */
public class ArrayBarChart {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructor
     *
     * @param arr array represented by this chart
     */
    private int [] arr ;
//    private int max;
    public ArrayBarChart(int[] arr) {
// FILL IN
        this.arr = arr;
//        this.max = findMax();
    }
    /**
     * Prints the bar chart to the console
     */
    public void printBarChart() {
// FILL IN
        int count = 0 ;
        for (int x : arr){
            System.out.print(count + ": ");
            int count2 = getNumAsterisks(count);
            for (int i =0 ; i < count2; i++){
                System.out.print("*");
            }
//            System.out.println("*".repeat(getNumAsterisks(count)));
            if (count != arr.length - 1){
                System.out.print("\n");
            }

            count ++;
        }
    }
    public int findMax(){
        int max = arr[0];

        for (int x : arr){
            if (x > max){
                max = x;
            }

        }
        return max;
    }
    /**
     * Returns the number of asterisks to print for the given index
     *
     * @param index index
     *
     * @return the number of asterisks to print for the index
     */
    public int getNumAsterisks(int index) {
        int max = findMax();
        if (arr[index] == max){
            return 10;
        }
        else{
//            Syst?em.out.println("YOOO");
//            Sysem.out.println((int)Math.ceil((double)arr[index] / max * 10));
            return (int) Math.round((double) arr[index] / max * 10);
        }
    }
    public static void main (String[] args){
        ArrayBarChart chart1 = new ArrayBarChart(new int[] {88, 14, 20, 25, 43, 100});
        chart1.printBarChart();
        System.out.println("Number of asterisks at index 0: " + chart1.getNumAsterisks(0)); // Expected: 9
        System.out.println("Number of asterisks at index 2: " + chart1.getNumAsterisks(2)); // Expected: 2
        System.out.println("Number of asterisks at index 5: " + chart1.getNumAsterisks(5)); // Expected: 10
        ArrayBarChart chart2 = new ArrayBarChart(new int[] {8, 8, 3, 3, 1, 0, 2, 4, 12});
        chart2.printBarChart();
        System.out.println("Number of asterisks at index 0: " + chart2.getNumAsterisks(0)); // Expected: 7
        System.out.println("Number of asterisks at index 2: " + chart2.getNumAsterisks(2)); // Expected: 3
        System.out.println("Number of asterisks at index 5: " + chart2.getNumAsterisks(5)); // Expected: 0
    }
}

