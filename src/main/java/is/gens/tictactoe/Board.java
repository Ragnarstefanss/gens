package is.gens.tictactoe;

public class Board {

	public static void initialize_table(char[][] table, int rows_size, int column_size) {
	    for(int row = 0; row < rows_size; row++)
	    {
	        for(int col = 0; col < column_size; col++)
	         {
	           table[row][col] = ' ';
	         }
	     }
    }

    public static void displayBoard(char[][] table) {
    	int rows_size = 3;
    	int column_size = 3;

    	if(table[0][0] != ' ')
    	{
    		for (int row = 0; row < rows_size; row++)
	    	{
		        for (int col = 0; col < column_size; col++)
		    	{
		    		System.out.println(table[rows_size][column_size]);
		    	}
	    	}
    	}
	    else
	    {
	    	System.out.println("Empty board");
	    }

	}	
}
