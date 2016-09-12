
/**
 * @author Gurek
 *	2015033
 */

import java.util.*;

public class PlayGame 
{
	public static void main(String[] args) {
		MyPuzzle game = new MyPuzzle();
		Scanner in = new Scanner(System.in);
		char move;
		System.out.println("Initial grid is: ");
		game.displayGrid();
		while(true)
		{
			System.out.println("User input: ");
			move = in.next().charAt(0);
			switch(move)
			{
			case 'L': game.moveLeft();
					break;
			case 'R': game.moveRight();
					break;
			case 'U': game.moveUp();
					break;
			case 'D': game.moveDown();
					break;
			case 'Q': System.out.println("Goodbye!");
					System.exit(0);
					break;
			default: System.out.println("Wrong input.");
					break;
			}
		}
	}

}
