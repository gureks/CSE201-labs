/**
 * @author Gurek
 *	2015033
 */

import java.util.*;

public class MyPuzzle 
{
	private static int[][] arr;
	
	MyPuzzle()
	{ 
		arr = new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				arr[i][j]=0;
			}
		}
		generateTile();
	}
	public void generateTile()
	{
		Random rand= new Random();
		Random num = new Random();
		int tile = rand.nextInt(16);
//		System.out.println(tile);
//		System.out.println(tile/4);
//		System.out.println(tile%4);
		if( arr[tile/4][tile%4] == 0)
		{
			arr[tile/4][tile%4] = (num.nextInt(1)==0)?2:4;
		}
		else
		{
			generateTile();
		}
//		System.out.println(arr[tile/4][tile%4]);
	}	
	public static void displayGrid()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.printf("%d ",arr[i][j]);
			}
			System.out.println("");
		}
	}

	//YAHAN SE KARNA HAI
	public void moveRight()
	{
		
		generateTile();
		displayGrid();		
		isOver();
		hasWon();
	}
	public void moveLeft()
	{
		
		generateTile();
		displayGrid();
		isOver();
		hasWon();
	}
	public void moveUp()
	{
		
		generateTile();
		displayGrid();
		isOver();
		hasWon();
	}
	public void moveDown()
	{
		
		generateTile();
		displayGrid();
		isOver();
		hasWon();
	}
	public void isOver()
	{
		//checking for 0's
		int flag=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(arr[i][j]==0)
				{
					flag=1;
				}
			}
		}
		if(flag==0)
		{
			//check for same adjacents
			
		}
	}
	//YAHAN TAK
	
	public void hasWon()
	{
		int flag=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(arr[i][j]==2048)
				{
					flag=1;
				}
			}
			if(flag==1)
			{
				break;	
			}
		}
	}

}
