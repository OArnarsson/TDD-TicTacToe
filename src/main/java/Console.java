package ttt;

import java.util.Random;
import java.util.Scanner;

public class Console 
{
	private Board b;
	private int IsOver;
	private int SIZE = 3;

    public Console()  
    {
    	b = new Board();
    	IsOver = b.isOver();
		b.mark = SelectFirstPlayer();
    }
    
	public void MockPrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char cell = b.cells[i][y];
				//System.out.println(pos);
				if (cell == '*')
				{
					System.out.print(pos + " ");
				}
				else
				{
					System.out.print(cell + " ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");

	}
	
	public void PrintLines(int size)
	{
		char line = '-';
		for (int i = 0; i <= size*4; i++)
		{
			System.out.print(line);
		}
		System.out.println();
	}
	
	public void VisualPrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			PrintLines(SIZE);
			for (int y = 0; y < SIZE; y++)
			{
				int pos = (SIZE * i+y) + 1;
				char cell = b.cells[i][y];				
				System.out.print("| ");
				
				if (cell == '*')
				{
					
					System.out.print(pos + " ");
				}
				else
				{
					System.out.print(cell + " ");
				}
			}
			System.out.print("| ");
			System.out.print("\n");
		}
		PrintLines(SIZE);
	}
	
	public void Play()
	{
		int isOver = b.isOver();
		while (isOver == 0)
		{
			System.out.println("Current player is: " + b.mark);
			readInput();
			VisualPrintBoard();
			isOver = b.isOver();
		}

		Winner(isOver);
	}
	
	public void Winner(int mark)
	{
		printGameOver();

		char win;
		if (mark == 1)
		{
			win = 'X';
		}
		else if (mark == 2)
		{
			win = 'O';
		}
		else
		{
			return;
		}
		
		System.out.println("Congratulations Player " + win + " YOU'RE WINNER!");
	}
	
	public void MockPlay()
	{
		MOCKreadInput(2);
		MOCKreadInput(4);
		MOCKreadInput(8);
		for (int i = 1; i < 10; i++)
		{
			MOCKreadInput(i);
		}
		MockPrintBoard();
	}
	
	public void MOCKreadInput(int pos)
	{
		b.updateCell(pos-1);
	}
	
	public String MockReadBoard()
	{
		return b.stringifyBoard();
	}
	
	public void readInput()
	{
		System.out.print("Choose cell: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		b.updateCell(input-1);
	}
	
	public char SelectFirstPlayer()
    {
    	Random rand = new Random();
    	int select = rand.nextInt(2);    	
    	if (select == 0)
    	{
    		return 'X';
    	}
    	return 'O';
    }
	
	//TEST CASE
    public int GetIsOver()
    {
    	return IsOver;
    }
    
    public static void main(String[] args) 
    {
		printWelcome();

		Console c = new Console();

		c.VisualPrintBoard();
		c.Play();
		
	}
    
	//Awesome ascii art checking in.
	private static void printWelcome() {
		System.out.println("  _____                                    _______ _______ _______ ");
		System.out.println(" / ____|                                  |__   __|__   __|__   __|");
		System.out.println("| (___  _   _ _ __   ___ _ __ __ _ _   _     | |     | |     | |   ");
		System.out.println(" \\___ \\| | | | '_ \\ / _ \\ '__/ _` | | | |    | |     | |     | |   ");
		System.out.println(" ____) | |_| | | | |  __/ | | (_| | |_| |    | |     | |     | |   ");
		System.out.println("|_____/ \\__, |_| |_|\\___|_|  \\__, |\\__, |    |_|ic   |_|ac   |_|oe ");
		System.out.println("	 __/ |                __/ | __/ |                          ");
		System.out.println("	|___/                |___/ |___/                           ");
		System.out.println("___________________________________________________________________\n");
	}

	private static void printGameOver() {
		System.out.println("  _____                       ____                 ");
		System.out.println(" / ____|                     / __ \\                ");
		System.out.println("| |  __  __ _ _ __ ___   ___| |  | |_   _____ _ __ ");
		System.out.println("| | |_ |/ _` | '_ ` _ \\ / _ \\ |  | \\ \\ / / _ \\ '__|");
		System.out.println("| |__| | (_| | | | | | |  __/ |__| |\\ V /  __/ |   ");
		System.out.println(" \\_____|\\__,_|_| |_| |_|\\___|\\____/  \\_/ \\___|_|   ");
		System.out.println("												 ");
	}
}
