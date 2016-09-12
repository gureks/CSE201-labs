/**
 * @author Gurek 2015033
 */

import java.util.*;

public class LabOne
{
	public static void main(String[] args) 
	{
		Board game = new Board();
		Scanner in = new Scanner(System.in);
		char val = 'X';
		int x,y;
		
		System.out.println("Choose out of the following: ");
		System.out.println("1. Player 1 v/s Player 2");
		System.out.println("2. Player v/s Random");
		System.out.println("3. Random v/s AI");
		System.out.println("4. Player v/s AI");
		System.out.println("Enter option: ");
		
		switch(in.nextInt())
		{
			case 1: 
			{
				while(1==1)
				{
					game.print();
					System.out.println("User " + val + " enter coordinates: ");
					x = in.nextInt();
					y = in.nextInt();
					int putReturn=game.put(x, y, val);
					if (putReturn == 1)
					{
						int result = game.checkState();
						if (result == 1)
						{
							game.print();
							System.out.println("User " + val + " wins.");
							break;
						}
						else if (result == -1)
						{
							game.print();
							System.out.println("It's a tie.");
							break;
						}
						else
						{
							if (val=='X')
							{
								val='O';
							}
							else
							{
								val='X';
							}
						}
					}
					else if(putReturn == 0)
					{
						System.out.println("Invalid coordinates. Please enter again.");
						continue;
					}
				}
				break;
			}
			case 2:
			{
				while(1==1)
				{
					Random rand = new Random();
					
					game.print();
					if (val=='X')
					{	System.out.println("User " + val + " enter coordinates: ");
						x = in.nextInt();
						y = in.nextInt();
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("User " + val + " wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
								val='O';
							}
						}
						else if(putReturn == 0)
						{
							System.out.println("Invalid coordinates. Please enter again.");
							continue;
						}
					}
					
					else
					{
						System.out.println("PC working randomly.");
						x = rand.nextInt(3);
						y = rand.nextInt(3);
						
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("PC wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
									val='X';
							}
						}
						else if(putReturn == 0)
						{
							continue;
						}
					}
				}
				break;
			}
			case 3:
			{
				while(1==1)
				{
					Random rand = new Random();
					
					game.print();
					if (val=='X')
					{	
						System.out.println("PC working randomly.");
						x = rand.nextInt(3);
						y = rand.nextInt(3);
						
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("Random PC wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
									val='O';
							}
						}
						else if(putReturn == 0)
						{
							continue;
						}
					}
					
					else
					{
						System.out.println("AI working.");
						
						char[][] a = game.get();
						//top column
						if(a[0][0]==a[0][1] && a[0][0]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						else if(a[0][0]==a[0][2] && a[0][0]!='-' && a[0][1]=='-')
						{
							x = 0;
							y = 1;
						}
						else if(a[0][1]==a[0][2] && a[0][1]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//middle column
						else if(a[1][0]==a[1][1] && a[1][0]!='-' && a[1][2]=='-')
						{
							x = 1;
							y = 2;
						}
						else if(a[1][0]==a[1][2] && a[1][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[1][2] && a[1][1]!='-' && a[1][0]=='-')
						{
							x = 1;
							y = 0;
						}
						
						//bottom column
						else if(a[2][0]==a[2][1] && a[2][0]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[2][0]==a[2][2] && a[2][0]!='-' && a[2][1]=='-')
						{
							x = 2;
							y = 1;
						}
						else if(a[2][1]==a[2][2] && a[2][1]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						
						//left row
						else if(a[0][0]==a[1][0] && a[0][0]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						else if(a[0][0]==a[2][0] && a[0][0]!='-' && a[1][0]=='-')
						{
							x = 1;
							y = 0;
						}
						else if(a[1][0]==a[2][0] && a[1][0]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//center row
						else if(a[0][1]==a[1][1] && a[0][1]!='-' && a[2][1]=='-')
						{
							x = 2;
							y = 1;
						}
						else if(a[0][1]==a[2][1] && a[0][1]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[2][1] && a[1][1]!='-' && a[0][1]=='-')
						{
							x = 0;
							y = 1;
						}
						
						//right row
						else if(a[0][2]==a[1][2] && a[0][2]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[0][2]==a[2][2] && a[0][2]!='-' && a[1][2]=='-')
						{
							x = 1;
							y = 2;
						}
						else if(a[1][2]==a[2][2] && a[1][2]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						
						//l to r diagonal
						else if(a[0][0]==a[1][1] && a[0][0]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[0][0]==a[2][2] && a[0][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[2][2] && a[1][1]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//r to l diagonal
						else if(a[0][2]==a[1][1] && a[0][2]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						else if(a[1][1]==a[2][0] && a[1][1]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						else if(a[2][0]==a[0][2] && a[2][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						
						else 
						{
							Random num = new Random();
							x = num.nextInt(3);
							y = num.nextInt(3);
						}
						
						
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("AI wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
									val='X';
							}
						}
						else if(putReturn == 0)
						{
							continue;
						}
					}
				}
				break;
			}
			case 4:
			{
				while(1==1)
				{
				
					game.print();
					if (val=='X')
					{	
						System.out.println("User " + val + " enter coordinates: ");
						x = in.nextInt();
						y = in.nextInt();
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("User (" + val + ") wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
								val='O';
							}
						}
						else if(putReturn == 0)
						{
							System.out.println("Invalid coordinates. Please enter again.");
							continue;
						}
					}
					
					else
					{
						System.out.println("AI working.");
						
						char[][] a = game.get();
						//top column
						if(a[0][0]==a[0][1] && a[0][0]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						else if(a[0][0]==a[0][2] && a[0][0]!='-' && a[0][1]=='-')
						{
							x = 0;
							y = 1;
						}
						else if(a[0][1]==a[0][2] && a[0][1]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//middle column
						else if(a[1][0]==a[1][1] && a[1][0]!='-' && a[1][2]=='-')
						{
							x = 1;
							y = 2;
						}
						else if(a[1][0]==a[1][2] && a[1][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[1][2] && a[1][1]!='-' && a[1][0]=='-')
						{
							x = 1;
							y = 0;
						}
						
						//bottom column
						else if(a[2][0]==a[2][1] && a[2][0]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[2][0]==a[2][2] && a[2][0]!='-' && a[2][1]=='-')
						{
							x = 2;
							y = 1;
						}
						else if(a[2][1]==a[2][2] && a[2][1]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						
						//left row
						else if(a[0][0]==a[1][0] && a[0][0]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						else if(a[0][0]==a[2][0] && a[0][0]!='-' && a[1][0]=='-')
						{
							x = 1;
							y = 0;
						}
						else if(a[1][0]==a[2][0] && a[1][0]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//center row
						else if(a[0][1]==a[1][1] && a[0][1]!='-' && a[2][1]=='-')
						{
							x = 2;
							y = 1;
						}
						else if(a[0][1]==a[2][1] && a[0][1]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[2][1] && a[1][1]!='-' && a[0][1]=='-')
						{
							x = 0;
							y = 1;
						}
						
						//right row
						else if(a[0][2]==a[1][2] && a[0][2]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[0][2]==a[2][2] && a[0][2]!='-' && a[1][2]=='-')
						{
							x = 1;
							y = 2;
						}
						else if(a[1][2]==a[2][2] && a[1][2]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						
						//l to r diagonal
						else if(a[0][0]==a[1][1] && a[0][0]!='-' && a[2][2]=='-')
						{
							x = 2;
							y = 2;
						}
						else if(a[0][0]==a[2][2] && a[0][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						else if(a[1][1]==a[2][2] && a[1][1]!='-' && a[0][0]=='-')
						{
							x = 0;
							y = 0;
						}
						
						//r to l diagonal
						else if(a[0][2]==a[1][1] && a[0][2]!='-' && a[2][0]=='-')
						{
							x = 2;
							y = 0;
						}
						else if(a[1][1]==a[2][0] && a[1][1]!='-' && a[0][2]=='-')
						{
							x = 0;
							y = 2;
						}
						else if(a[2][0]==a[0][2] && a[2][0]!='-' && a[1][1]=='-')
						{
							x = 1;
							y = 1;
						}
						
						else 
						{
							Random num = new Random();
							x = num.nextInt(3);
							y = num.nextInt(3);
						}
						
						int putReturn=game.put(x, y, val);
						if (putReturn == 1)
						{
							int result = game.checkState();
							if (result == 1)
							{
								game.print();
								System.out.println("AI wins.");
								break;
							}
							else if (result == -1)
							{
								game.print();
								System.out.println("It's a tie.");
								break;
							}
							else
							{
									val='X';
							}
						}
						else if(putReturn == 0)
						{
							continue;
						}
					}
				}
				break;
			}
		}	
	}
}
