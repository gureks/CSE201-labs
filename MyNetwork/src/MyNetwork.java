/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 */

import java.util.*;
import java.io.*;

public class MyNetwork 
{
	Person[] Network;
	int noOfPersons;
	
	public MyNetwork()
	{
		noOfPersons = 0;
	}
	
	public void readFile()
	{
		BufferedReader br = null;
		
		System.out.println("Reading Database...");
		try 
		{
			br = new BufferedReader(new FileReader("input.txt"));
			String line = null;

			while ((line = br.readLine()) != null) 
			{
				System.out.println(line);
		        String[] values = line.split(",");
				System.out.println(Arrays.toString(values));

		        int i = 0, j;
		        //Set username, password, display name.
		        Network[noOfPersons] = new Person(values[i],values[i+1],values[i+2]);
		        i+=3;
		        
		        //Set number of friends and list of friends.
		        Network[noOfPersons].setFriends(Integer.parseInt(values[i]));
		        for(j = 1; j <= Integer.parseInt(values[i]); j++)
		        {
		        	Network[noOfPersons].setlistOffriends(values[i+j], j-1);
		        }
		        i = i + Integer.parseInt(values[i]) + 1;

		        System.out.println(values[i]);
		        //Set number of requests and list of pending requests.
		        Network[noOfPersons].setRequests(Integer.parseInt(values[i]));
		        
		        for(j = 1; j < Integer.parseInt(values[i]); j++)
		        {
		        	Network[noOfPersons].setlistOffriends(values[i+j], j-1);
		        }
			}
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if (br != null)
				{	
					br.close();
				}
			}
				
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	
		
	}
	
	public void signup()
	{
		String username, password, display_name;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Username: ");
		username = in.next();

		System.out.println("Enter Display name: ");
		display_name = in.next();
		
		System.out.println("Enter Password: ");
		password = in.next();
		
		Person newUser = new Person(username, password, display_name);
		
		
		
		
		in.close();
	}
	
	public void login()
	{
		//doSomething();
	}
	
	public void mainMenu()
	{
		int choice;
		Scanner in = new Scanner(System.in);
		
		System.out.println("1.	Signup");
		System.out.println("2.	Login");
		System.out.println("Enter choice:  ");
		choice = in.nextInt();
		
		switch(choice)
		{
			case 1	: 	signup();
						break;
			case 2	:	login();
						break;
			case 0	:	System.exit(0);
						break;
			default	:	System.out.println("Wrong input. Enter again");
						mainMenu();
						break;
		}
		
	}
	
	public static void main(String[] args) 
	{
		MyNetwork MySocialNetwork = new MyNetwork();
		MySocialNetwork.readFile();
		System.out.println("Network is ready.");
		
		MySocialNetwork.mainMenu();
	}
}
