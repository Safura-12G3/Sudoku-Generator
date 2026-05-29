// Sudoku Generator
// Generates the puzzles

import java.util.Random;

public class SudokuGenerator {

    private SudokuBoard board;
    private Random random;

    public SudokuGenerator(SudokuBoard board) {
        this.board = board;
        this.random = new Random();
    }

    public void generateFullBoard() {
        fillBoard(0, 0);
    }

    private boolean fillBoard(int row, int col) {

        if (row == 9) {
            return true; // Board filled successfully
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        int[] numbers = {1,2,3,4,5,6,7,8,9};

        for (int number : numbers) {

            if (board.isValidMove(row, col, number)) {

                board.setValue(row, col, number);

                if (fillBoard(nextRow, nextCol)) {
                    return true;
                }

                // Backtrack if wrong
                board.setValue(row, col, 0);
            }

        }

        return false;
    }


    public void removeCells(int cellsToRemove) {

        while (cellsToRemove > 0) {

            int row = random.nextInt(9);
            int col = random.nextInt(9);


            if (board.getValue(row, col) != 0) {
                board.setValue(row, col, 0);
                cellsToRemove--;
            }
        }
    }

    public void generateEasyPuzzle() {
        generateFullBoard();
        removeCells(25);
    }

    public void generateMediumPuzzle() {
        generateFullBoard();
        removeCells(40);
    }

    public void generateHardPuzzle() {
        generateFullBoard();
        removeCells(55);
    }
}