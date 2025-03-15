package labs.lab3;
/**
 * A magic square is an n x n matrix which, if filled with numbers, the sum of
 * the elements in each row, each column, and the two diagonal is the same
 * value.
 */
public class Square {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Construct a Square object.
     *
     * @param nums the square array (assume it will always be n x n)
     */
    private int [][] nums;

    public Square(int[][] nums) {
        this.nums = nums;
// FILL IN
    }
    /**
     * Add the numbers in a row of the square.
     *
     * @param i the row index
     * @return the sum of the row
     */
    public int rowSum(int i) {
        int sum = 0 ;
        for (int start = 0; start < nums[i].length ; start ++){
            sum += nums[i][start];
        }

        return sum;
    }
    /**
     * Add the numbers in a column of the square.
     *
     * @param i the column index
     * @return the sum of the column
     */
    public int columnSum(int i) {
        int sum = 0 ;
        for (int in = 0 ; in < nums.length ; in ++){
            sum += nums[in][i];
        }
        return sum;
    }
    /**
     * Find the sum of the diagonal.
     *
     * @param mainDiagonal true if it is the main diagonal (left/top to
    right/bottom),
     * false otherwise (right/top to left/bottom)
     *
     * @return sum the sum of the diagonal
     */
    public int diagonalSum(boolean mainDiagonal) {
        int sum = 0;
        if (mainDiagonal){
            for (int i = 0 ; i < nums.length; i++){
                sum += nums[i][i];
            }
        }
        else{
            for (int i = 0 ; i < nums.length; i++){
                sum += nums[i][nums.length -1 -i];
            }
        }
        return sum;
    }
    /**
     * Determine if the square is a magic square.
     *
     * @return true if square is a magic square, false otherwise
     */
    //square grid where every row, column, and diagonal adds up to the same number
    public boolean isMagic() {
        int diagonalMain = diagonalSum(true) ;
        int diagonalFalse = diagonalSum(false);
        if (diagonalMain != diagonalFalse){
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (rowSum(i) != diagonalMain || columnSum(i) != diagonalMain) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums1 = {
                { 16, 3, 2, 13 },
                { 5, 10, 11, 8 },
                { 9, 6, 7, 12 },
                { 4, 15, 14, 1 }
        };

        Square s1 = new Square(nums1);

        System.out.println("Sum of row 0: " + s1.rowSum(0)); // Expected: 34
        System.out.println("Sum of row 3: " + s1.rowSum(3)); // Expected: 34
        System.out.println("Sum of column 1: " + s1.columnSum(1)); // Expected: 34
        System.out.println("Sum of column 2: " + s1.columnSum(2)); // Expected: 34
        System.out.println("Sum of main diagonal: " + s1.diagonalSum(true)); // Expected: 34
        System.out.println("Is the square magic? " + s1.isMagic()); // Expected: true

        int[][] nums2 = {
                { 6, 3, 20 },
                { 15, 0, 1 },
                { 7, 2, 17 }
        };

        Square s2 = new Square(nums2);

        System.out.println("Sum of row 1: " + s2.rowSum(1)); // Expected: 16
        System.out.println("Sum of row 2: " + s2.rowSum(2)); // Expected: 26
        System.out.println("Sum of column 0: " + s2.columnSum(0)); // Expected: 28
        System.out.println("Sum of column 1: " + s2.columnSum(1)); // Expected: 5
        System.out.println("Sum of secondary diagonal: " + s2.diagonalSum(false)); // Expected: 27
        System.out.println("Is the square magic? " + s2.isMagic()); // Expected: false

    }

}
