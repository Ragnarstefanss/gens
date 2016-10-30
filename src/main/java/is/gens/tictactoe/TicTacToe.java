package is.gens.tictactoe;

public class TicTacToe {

	
    public static void main(String[] args) {
    	int numRows = 3;
    	int numColumn = 3;
		char[][] table = new char[numRows][numColumn];

		//Player player = Player.O;
		char player = 'X';

		Board board = new Board();
		board.initialize_table(table, numRows, numColumn);

		board.displayBoard(table);


		do {
			board.make_move(table, 'X');
			board.displayBoard(table);
			//winner = getWinner(table);
			if(board.can_move(table)) {
				board.make_move(table, 'O');
				board.displayBoard(table);
			}
		} while(board.can_move(table));
    }
}
