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

	public static boolean can_move(char table[][]) {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (table[i][j] != 'X' && table[i][j] != 'O')
	            {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public static boolean valid_move(char table[][], char player, int value) {
		int convert = value + 48;
		char value_equals = (char) convert;

	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	        	if(table[i][j] == value_equals)	{
	        		if(table[i][j] == 'X' || table[i][j] == 'O')
	        		{
	        			System.out.println("\nInvalid position!\n");
	        			return false;
	        		}

	        		else {
	        			table[i][j] = player;
	        			player = changePlayer(player);
	        			return true;
	        		}
	        	}
	        }
	    }
	    return false;
	}


	public static void make_move(char table[][], char player)
	{	
		System.out.println("\n" + player + " Pick a number");
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

	public static char checkIfWinner(int o_number, int x_number, int size)
	{
		char o = 'O';
		char x = 'X';
		char nobody = 'N';

		if (o_number == size) {
	        return o;
		}
	    else if (x_number == size) {
	        return x;
	    }
	       
	    return nobody;
	}

	public static void checkRowWinner(char table[][], int arr_size, int row)
	{
		int o_number = 0;
	    int x_number = 0;

	    for (int j = 0; j < arr_size; j++) {
	        if (table[row][j] == 'O') {
	            o_number++;
	        }
	        else if (table[row][j] == 'X') {
	            x_number++;
	        }
	    }
	    checkIfWinner(o_number, x_number, arr_size);

	}

	public static void checkColWinner(char table[][], int arr_size, int column) {
	    int o_number = 0;
	    int x_number = 0;

	    for (int i = 0; i < arr_size; i++) {
	        if (table[i][column] == 'O') {
	            o_number++;
	        }
	        else if (table[i][column] == 'X') {
	            x_number++;
	        }
	    }
	    checkIfWinner(o_number, x_number, arr_size);
	}

	public static void checkDiagonalsWinner(char table[][], int arr_size)
	{
		int o_number = 0;
	    int x_number = 0;
	    int j = 0;

	    // Byrjum efst í [0][0] og förum svo í [1][1] og svo [2][2]
	    for (int i = 0; i < arr_size; i ++) {
	        if (table[i][j] == 'O')
	            o_number++;
	        else if (table[i][j] == 'X')
	            x_number++;
	        j++;
	    }

	    char winner =  checkIfWinner(o_number, x_number, arr_size);

	    // Byrjum efst í [0][2] og förum svo í [1][1] og svo [2][0]
	    if (winner == 'N') {
	        o_number = 0;
	        x_number = 0;
	        j = 2;
	        for (int i = 0; i < arr_size; i ++) {
	            if (table[i][j] == 'O')
	                o_number++;
	            else if (table[i][j] == 'X')
	                x_number++;
	            j--;
	        }
	        winner = checkIfWinner(o_number, x_number, arr_size);
	    }
	}

/*
	public static boolean isWinner(char table[][])
	{/*
		if((table[0][0] = 'X' && table[0][1] = 'X' && table[0][2] = 'X') || (table[0][0] = 'O' && table[0][1] = 'O' && table[0][2] = 'O'))
		{
			return true;
		}
		if((table[1][0] = 'X' && table[1][1] = 'X' && table[1][2] = 'X') || (table[1][0] = 'O' && table[1][1] = 'O' && table[1][2] = 'O'))
		{
			return true;
		}
		if((table[2][0] = 'X' && table[2][1] = 'X' && table[2][2] = 'X') || (table[2][0] = 'O' && table[2][1] = 'O' && table[2][2] = 'O'))
		{
			return true;
		}
		if((table[0][0] = 'X' && table[1][0] = 'X' && table[2][0] = 'X') || (table[0][0] = 'O' && table[1][0] = 'O' && table[2][0] = 'O'))
		{
			return true;
		}
		if((table[0][1] = 'X' && table[1][1] = 'X' && table[2][1] = 'X') || (table[0][1] = 'O' && table[1][1] = 'O' && table[2][1] = 'O'))
		{
			return true;
		}
		if((table[0][2] = 'X' && table[1][2] = 'X' && table[2][2] = 'X') || (table[0][2] = 'O' && table[1][2] = 'O' && table[2][2] = 'O'))
		{
			return true;
		}
		return false;
	}*/
}
