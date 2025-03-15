package labs.lab3;
/**
 * Represents a table of values.
 */
public class Table {
    private int[][] values;
    /**
     * Constructs a table with given rows and columns.
     *
     * @param rows the rows in the table (assume always > 0)
     * @param columns the columns in the table (assume always > 0)
     */
    public Table(int rows, int columns) {
        values = new int[rows][columns];
    }
    /**
     * Sets a value in the table.
     *
     * @param i the row of the item to modify (assume always within the bounds of
    the table)
     * @param j the column of the item to modify (assume always within the bounds
    of the table)
     * @param n the number to use for the new value.
     */
    public void set(int i, int j, int n) {
        values[i][j] = n;
    }
    /**
     * Computes and returns the average of the adjacent neighbors of the given
     * table element in all eight surrounding directions.
     *
     * If the element is located at the boundary of the table, include only
     * the neighbors that are in the table. For example if row and column are
     * both 0, there are only three neighbors.
     *
     * If the given element has no neighbors, return 0.
     *
     * If no element with the given row & column exists in this table, return 0.
     *
     * @param row the row of the element
     * @param column the column of the element
     * @return the average of the adjacent elements
     */
    public double neighborAverage(int row, int column) {
        int sum = 0;
        int count = 0;

        if (row >= values.length || row < 0 || column >= values[row].length ||column < 0){
            return 0;
        }
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r == row && c == column) continue; // Exclude the center element
                if (r < 0 || r >= values.length || c < 0 || c >= values[r].length) continue;
                sum += values[r][c];
                count += 1;
            }
        }

        if (count == 0) return 0;
//        System.out.print(sum);
//        System.out.println(count);
        return (double) sum / count;
    }

    /**
     * Returns the sum of a row or column in elements in the table
     *
     * @param i the row or column to sum. Assume it will always
     * be within the bounds of the table
     * @param horizontal if true, then i represents a row, else a column.
     * @return the sum of the given row or column.
     */
    public double sum(int i, boolean horizontal) {
        double sum = 0.0;
        if (!horizontal){
            for (int in = 0 ; in < values.length; in ++){
                sum += values[in][i];
            }
        }
        else{
            for (int in = 0 ; in < values[i].length; in ++){
                sum += values[i][in];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
//        Table table = new Table(4, 5); // 4 x 5 table
//
//        // Fill the table with the given sequence of values
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 5; j++) {
//                table.set(i, j, (3 + i) * (2 + j));
//            }
//        }
//
//        // Neighbor averages
//        System.out.println("Neighbor Average at (1, 1): " + table.neighborAverage(1, 1)); // 12.0
//        System.out.println("Neighbor Average at (2, 3): " + table.neighborAverage(2, 3)); // 25.0
//        System.out.println("Neighbor Average at (0, 0): " + table.neighborAverage(0, 0)); // 9.666667
//        System.out.println("Neighbor Average at (3, 4): " + table.neighborAverage(3, 4)); // 28.333333
//        System.out.println("Neighbor Average at (1, 4): " + table.neighborAverage(1, 4)); // 21.6
//        System.out.println("Neighbor Average at (1, 0): " + table.neighborAverage(1, 0)); // 10.4
//        System.out.println("Neighbor Average at (3, 2): " + table.neighborAverage(3, 2)); // 21.6
//        System.out.println("Neighbor Average at (0, 2): " + table.neighborAverage(0, 2)); // 14.4
//
//        // Row and column sums
//        System.out.println("Sum of row 0 (row-wise): " + table.sum(0, true)); // 60.0
//        System.out.println("Sum of column 0 (column-wise): " + table.sum(0, false)); // 36.0
//        System.out.println("Sum of row 1 (row-wise): " + table.sum(1, true)); // 80.0
//        System.out.println("Sum of column 1 (column-wise): " + table.sum(1, false)); // 54.0
//        System.out.println("Sum of row 2 (row-wise): " + table.sum(2, true)); // 100.0
//        System.out.println("Sum of column 2 (column-wise): " + table.sum(2, false)); // 72.0
//        System.out.println("Sum of row 3 (row-wise): " + table.sum(3, true)); // 120.0
//        System.out.println("Sum of column 3 (column-wise): " + table.sum(3, false)); // 90.0
//        System.out.println("Sum of column 4 (column-wise): " + table.sum(4, false)); // 108.0

        Table table = new Table(4, 5); // 4 x 5 table
// Fill it with a sequence of values:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                table.set(i, j, (3 + i) * (2 + j));
            }
        }

// Test cases with print statements
        System.out.println("Neighbor Average (1, 1): " + table.neighborAverage(1, 1)); // Expected: 12.0
        System.out.println("Neighbor Average (2, 3): " + table.neighborAverage(2, 3)); // Expected: 25.0
// Upper-left corner
        System.out.println("Neighbor Average (0, 0): " + table.neighborAverage(0, 0)); // Expected: 9.66667
// Lower-right corner
        System.out.println("Neighbor Average (3, 4): " + table.neighborAverage(3, 4)); // Expected: 28.333333
// Right-hand side
        System.out.println("Neighbor Average (1, 4): " + table.neighborAverage(1, 4)); // Expected: 21.6
// Left-hand side
        System.out.println("Neighbor Average (1, 0): " + table.neighborAverage(1, 0)); // Expected: 10.4
// Bottom row
        System.out.println("Neighbor Average (3, 2): " + table.neighborAverage(3, 2)); // Expected: 21.6
// Top row
        System.out.println("Neighbor Average (0, 2): " + table.neighborAverage(0, 2)); // Expected: 14.4

// Sum of rows/columns
        System.out.println("Sum of Row 0: " + table.sum(0, true)); // Expected: 60.0
        System.out.println("Sum of Column 0: " + table.sum(0, false)); // Expected: 36.0
        System.out.println("Sum of Row 1: " + table.sum(1, true)); // Expected: 80.0
        System.out.println("Sum of Column 1: " + table.sum(1, false)); // Expected: 54.0
        System.out.println("Sum of Row 2: " + table.sum(2, true)); // Expected: 100.0
        System.out.println("Sum of Column 2: " + table.sum(2, false)); // Expected: 72.0
        System.out.println("Sum of Row 3: " + table.sum(3, true)); // Expected: 120.0
        System.out.println("Sum of Column 3: " + table.sum(3, false)); // Expected: 90.0
        System.out.println("Sum of Column 4: " + table.sum(4, false)); // Expected: 108.0

// Single-element table tests
        table = new Table(1, 1);
        table.set(0, 0, -3);

// Neighbor average tests for out-of-bound cases
        System.out.println("Neighbor Average (1, 1): " + table.neighborAverage(1, 1)); // Expected: 0.0
        System.out.println("Neighbor Average (8, 8): " + table.neighborAverage(8, 8)); // Expected: 0.0

// Sum of rows/columns for single-element table
        System.out.println("Sum of Row 0: " + table.sum(0, true)); // Expected: -3.0
        System.out.println("Sum of Column 0: " + table.sum(0, false)); // Expected: -3.0
    }

}
