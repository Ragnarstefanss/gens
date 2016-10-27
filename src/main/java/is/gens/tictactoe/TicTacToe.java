package is.gens.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
    	int numRows = 3;
    	int numColumn = 3;
		char[][] table = new char[numRows][numColumn];
		
		Board board = new Board();
		board.initialize_table(table, numRows, numColumn);

		board.displayBoard(table);
    }
}
