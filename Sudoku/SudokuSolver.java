import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    final int N = 9; // Size of the Sudoku grid (9x9)

    /* A utility function to print the Sudoku grid */
    void printSolution(int[][] grid) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++)
                System.out.print(" " + grid[row][col] + " "); // Print each cell's value
            System.out.println(); // Move to the next row after printing each row
        }
    }

    /* A utility function to check if a digit can be placed at the given position */
    boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check if the num is not already placed in the current row, current column, and current 3x3 subgrid
        return !usedInRow(grid, row, num) && !usedInCol(grid, col, num) && !usedInBox(grid, row - row % 3, col - col % 3, num);
    }

    /* A utility function to check if the num is used in the current row */
    boolean usedInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < N; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    /* A utility function to check if the num is used in the current column */
    boolean usedInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < N; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    /* A utility function to check if the num is used in the current 3x3 subgrid */
    boolean usedInBox(int[][] grid, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + boxStartRow][col + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /* This function solves the Sudoku problem using Backtracking */
    boolean solveSudoku(int[][] grid) {
        int row = 0, col = 0;
        boolean isEmpty = true;

        // Find the first empty cell in the grid
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If there is no empty cell, the Sudoku is solved
        if (isEmpty) {
            return true;
        }

        // Try digits 1 to 9 for the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                // Place the digit if it's safe
                grid[row][col] = num;

                // Recursively solve the rest of the Sudoku
                if (solveSudoku(grid)) {
                    return true;
                }

                // If placing digit num doesn't lead to a solution, backtrack and try next digit
                grid[row][col] = 0;
            }
        }

        // Trigger backtracking
        return false;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] grid = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudokuSolver.solveSudoku(grid)) {
            System.out.println("Sudoku solved successfully:");
            sudokuSolver.printSolution(grid);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
    }
}

