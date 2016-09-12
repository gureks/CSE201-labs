/**
 * @author Gurek 2015033
 */

import java.util.*;

public class Board
{
	private static char[][] arr;
	
	Board()
	{
		//Constructor class
		arr = new char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				arr[i][j]='-';
			}
		}
		
	}
	
	public int put(int x, int y, char val)
	{
		//Inserts the character at the coordinates (x,y).
		if(x<3 && x>-1 && y<3 && y>-1)
		{	if(arr[x][y]=='-')
			{
				arr[x][y]=val;
				return 1; //success
			}
			else
			{
				return 0; //error
			}
		}
		else
		{
			return 0; //error
		}
	}
	
	public char[][] get()
	{
		//Returns the state of matrix
		return arr;
	}
	
	public void print()
	{
		//Prints the state of matrix
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.printf("%c",arr[i][j]);
			}
			System.out.println("");
		}
	}
	
	public int checkState()
	{
		//Checks the state of matrix and print a message describing a win or a tie.
		int flag=0;		
		if  (  (arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2] && arr[0][0]=='X') //top column for 'X'
			|| (arr[1][0]==arr[1][1] && arr[1][1]==arr[1][2] && arr[1][0]=='X') //middle column for 'X'
			|| (arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2] && arr[2][0]=='X') //bottom column for 'X'
			|| (arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0] && arr[0][0]=='X') //left row for 'X'
			|| (arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1] && arr[0][1]=='X') //center row for 'X'
			|| (arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2] && arr[0][2]=='X') //right row for 'X'
			|| (arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0]=='X') //l to r diagonal for 'X'
			|| (arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[0][2]=='X') //r to l diagonal for 'X'
			|| (arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2] && arr[0][0]=='O') //top column for 'O'
			|| (arr[1][0]==arr[1][1] && arr[1][1]==arr[1][2] && arr[1][0]=='O') //middle column for 'O'
			|| (arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2] && arr[2][0]=='O') //bottom column for 'O'
			|| (arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0] && arr[0][0]=='O') //left row for 'O'
			|| (arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1] && arr[0][1]=='O') //center row for 'O'
			|| (arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2] && arr[0][2]=='O') //right row for 'O'
			|| (arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0]=='O') //l to r diagonal for 'O'
			|| (arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[0][2]=='O')) //r to l diagonal for 'O'
		{
			return 1; //win
		}
		else
		{
			for (int i=0;i<3;i++)
			{
				for (int j=0;j<3;j++)
				{
					if(arr[i][j]=='-')
					{
						flag++;
					}
				}
			}
			
			if(flag == 0)
			{
				return -1; //tie
			}
			else
			{
				return 0; //nothing
			}
		}
	}
}
