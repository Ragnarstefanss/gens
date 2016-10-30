package is.gens.tictactoe;
import java.util.*;

public class Board {

	public static void initialize_table(char[][] table, int rows_size, int column_size) {
	    int counter = 48;
	    for(int row = 0; row < rows_size; row++)
	    {
	        for(int col = 0; col < column_size; col++)
	         {
	         	counter = counter + 1;
	         	char i = (char)counter;
	           	table[row][col] = i;
	         }
	     }
    }



    public static void displayBoard(char[][] table) {
    	int rows_size = 3;
    	int column_size = 3;

    	if(table[0][0] != ' ')
    	{
		    System.out.println(table[0][0] + " | " + table[0][1] + " | " + table[0][2] );
    		System.out.println("---------");
		    System.out.println(table[1][0] + " | " + table[1][1] + " | " + table[1][2] );
		    System.out.println("---------");
		    System.out.println(table[2][0] + " | " + table[2][1] + " | " + table[2][2] );
    	}
	    else
	    {
	    	System.out.println("Empty board");
	    }
	}	

	public static boolean can_move(char table[][], char player_o, char player_x) {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (table[i][j] != player_x && table[i][j] != player_o)
	            {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public static void valid_move(char table[][], char player, int value) {
		int convert = value + 48;
		char value_equals = (char) convert;

	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	        	if(table[i][j] == value_equals)
	        	{
	        		if(table[i][j] == 'X' || table[i][j] == 'O')
	        		{
	        			System.out.println("\nInvalid position!\n");
	        		}

	        		else {
	        			table[i][j] = player;
	        		}
	        	}
	        }
	    }
	}


	public static void make_move(char table[][], char player)
	{	
		System.out.println("\nPick a number");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int number = Integer.parseInt(input);
		
		if (number < 1 || number > 9){
			System.out.println("\nInvalid position!\n");
		}
		else
		{
			valid_move(table, player, number);
		}
	}


}
