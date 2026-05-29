public class Main {
    public static void main(String[] args) {

        SudokuBoard board = new SudokuBoard();

        SudokuGenerator generator = new SudokuGenerator(board);

        generator.generateEasyPuzzle();

        System.out.println("Generated Puzzle:");
        printBoard(board);

        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {

            System.out.println("\nSolved Puzzle:");
            printBoard(board);

        } else {
            System.out.println("No solution found.");
        }
    }

    public static void printBoard(SudokuBoard board) {

        for (int row = 0; row < 9; row++) {
            
            for (int col = 0; col < 9; col++) {

                System.out.print(board.getValue(row, col) + " ");
            }

            System.out.println();
        }
    }
}

/* SudokuBoard board: Creates the 9x9 grid
generator.generateEasyPuzzle(): Creates a sudoku game that can be played
printBoard(board): Displays the grid in terminal
solver.solve: Uses recusion and backtracking AI */
