package is.gens.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

    @Test
    public void EmptyTable() {
		char[][] table = new char[3][3];

        Board board = new Board();
		board.initialize_table(table, 3, 3);

       	assertEquals(' ', table[1][0]);
	}
}
