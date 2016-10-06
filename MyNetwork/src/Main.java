/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

import java.io.*;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		MyNetwork MySocialNetwork = new MyNetwork();
		
		MySocialNetwork.readFile();
		System.out.println("Network is ready.");
		MySocialNetwork.mainMenu();
	}
}
