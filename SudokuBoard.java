ublic class SudokuBoard {

    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setValue(int row, int col, int value) {
        board[row][col] = value;
    }

    public int getValue(int row, int col) {
        return board[row][col];
    }

    // Core Rule Check
    // This method checks if a number can be placed in a specific cell.
    public boolean isValidMove(int row, int col, int number) {

        return !usedInRow(row, number)
                && !usedInCol(col, number)
                && !usedInBox(row, col, number);
    }


    // Row Check
    // This method checks if a number is already present in the specified row.
    private boolean usedInRow(int row, int number) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }


    // Column Check
    // This method checks if a number is already present in the specified column.
    private boolean usedInCol(int col, int number) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;

    }

    // 3x3 Box Check
    // This method checks if a number is already present within the specified 3x3 grid.
    private boolean usedInBox(int row, int col, int number) {

        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[boxRowStart + r] [boxColStart + c] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}