/**
 * Category C · Coding Assignment
 * Problem 10 / Week 10 Problem 5: Busiest Bus Row
 *
 * Task:
 * A college bus records how many students sit in each seat as a 2D grid, where each row is one row of
 * seats. The transport office wants to know which row carries the most students.
 * Implement a function busiestRow(grid) that returns the index of the row with the largest total and that
 * total. If two rows tie, return the one with the smaller index.
 *
 * Constraints:
 * - 1 <= rows, columns <= 10
 * - 0 <= grid[i][j] <= 3
 *
 * Complexity:
 * - Time Complexity: O(r * c) where r is rows and c is columns, since every cell in the grid is visited once.
 * - Space Complexity: O(1) auxiliary space beyond the input grid.
 *
 * Hint:
 * Use an outer loop for the rows and an inner loop to add up the seats in each row; update the best row
 * only when a total is strictly larger. This naturally preserves the smaller index in case of a tie.
 */
public class Problem5_BusiestBusRow {

    /**
     * Determines the row index with the highest seat total and returns [bestRowIndex, maxTotal].
     * Ties are broken by choosing the smaller row index.
     *
     * @param grid 2D array of seat counts
     * @return int array containing [row_index, total_students]
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }

            // Update only if rowTotal is strictly greater than maxTotal
            // This ensures earlier row index is preserved on ties
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRowIndex = r;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }

    /**
     * Helper to format output as: "Row <index>, Total <total>"
     */
    public static String formatBusiestRow(int[] result) {
        return "Row " + result[0] + ", Total " + result[1];
    }

    public static void main(String[] args) {
        // Example:
        // grid = [[2, 0, 1], [3, 3, 1], [1, 1, 1]] -> Expected Output: Row 1, Total 7
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println(formatBusiestRow(result));
    }
}
