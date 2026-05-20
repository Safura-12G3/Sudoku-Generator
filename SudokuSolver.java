public class SudokuSolver {

    private SudokuBoard board;

    public SudokuSolver(SudokuBoard board) {
        this.board = board;
    }

    public boolean solve() {
        return solveRecursive();
    }

    private boolean solveRecursive() {

        int[] emptyCell = findEmptyCell();

        if (emptyCell == null) {
            return true; // Puzzle solved!

        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {

            if (board.isValidMove(row, col, num)) {

                board.setValue(row, col, num);

                if (solveRecursive()) {
                    return true; // Continue with this placement
                }

                // backtrack
                board.setValue(row, col, 0);
            }
        }

        return false; // Triggers backtracking

    }

    private int[] findEmptyCell() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board.getValue(row, col) == 0) {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }
    
}

/* Notes:
findEmptyCell() Scans the board and returns the first cell with value 0 (empty).
solveRecursive() Attempts to solve by trying valid numbers in empty cells.
backtracking If a number leads to a dead end, the algorithm resets the cell to 0 and tries the next number.
 */