/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 */

import java.util.*;
import java.io.*;

public class MyNetwork 
{
	ArrayList<Person> Network;
	Person LoggedInUser;
	
	public MyNetwork()
	{
		Network = new ArrayList<Person>();
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
				//System.out.println(line);
		        String[] values = line.split(",");
		        
		        int i = 0, j;
		        //Set username, password, display name.
		        Person temp = new Person(values[i],values[i+1],values[i+2]);
		        i+=3;
		        
		        //Set number of friends and list of friends.
		        temp.setFriends(Integer.parseInt(values[i]));
		        for(j = 1; j <= Integer.parseInt(values[i]); j++)
		        {
		        	temp.setlistOffriends(values[i+j]);
		        }
		        i = i + Integer.parseInt(values[i]) + 1;
		        
		        //Set number of requests and list of pending requests.
		        temp.setRequests(Integer.parseInt(values[i]));
		        for(j = 1; j < Integer.parseInt(values[i]); j++)
		        {
		        	temp.setlistOfrequests(values[i+j]);
		        }
		        i = i + Integer.parseInt(values[i]) + 1;
		        
		        //Set status
		        temp.setStatus(values[i]);
		        
		        //Add to ArrayList
		        Network.add(temp);
		        
		        //System.out.println(temp);
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

		int flag = 0;

		try	//If username already exists
		{
			Iterator i = Network.iterator();
			
			while(i.hasNext())
			{  

				Person temp2 = (Person)i.next();
				
				String temp2Username = new String();
				temp2Username = temp2.getUsername();
				
				if(username.equals(temp2Username))
				{
				//	System.out.println(username +","+ password +","+ display_name);
				//	System.out.println(temp2);
					flag = 1;
				}
			}
			
			if (flag == 0)
			{
				Person temp = new Person(username, password, display_name);
				Network.add(temp);
				System.out.println("User " + username + " created.");
			}
			else if (flag == 1)
			{
				throw new UsernameAlreadyExists(username);
			}
		}
		catch(UsernameAlreadyExists exp)
		{      
			System.out.println(exp);
			signup();
		}
		
		mainMenu();
	}
	
	public void login()
	{
		Scanner in = new Scanner(System.in);
		String username, password;
		
		System.out.println("Please enter your username	:	");
		username = in.next();

		System.out.println("Please enter your password	:	");
		password = in.next();

		int flag = 0;
//		Person temp;
		
		try	//If username already exists
		{
			Iterator i = Network.iterator();
			
			while(i.hasNext() && flag == 0)
			{  
				LoggedInUser = (Person)i.next();
				
				String tempUsername = new String();
				tempUsername = LoggedInUser.getUsername();
				
				if(username.equals(tempUsername))
				{
					flag = 1;
				}
			}
			
			if (flag == 1)
			{
				if(password.equals(LoggedInUser.getPassword()))
				{	
					System.out.println(LoggedInUser.getUsername() + " logged in now.");
					System.out.println(LoggedInUser.getStatus());
					afterLoginMenu();
				}
				else
				{
					System.out.println("Wrong password.");
					mainMenu();
				}
			}
			else if (flag == 0)
			{
				throw new UserNotFoundException(username);
			}
		}
		catch(UserNotFoundException exp)
		{      
			System.out.println(exp);
			mainMenu();
		}
	}
	
	public void printNetwork()
	{
		Iterator i = Network.iterator();//getting Iterator from arraylist to traverse elements  
		while(i.hasNext())
		{  
			System.out.println(i.next());  
		}
		mainMenu();
	}
		
	public void logout()
	{
		BufferedWriter	bw = null;
		try 
		{
			bw= new BufferedWriter(new StringWriter());
			
			Iterator i = Network.iterator();
			
			while(i.hasNext())
			{
				Person temp = (Person)i.next();
				bw.write(temp.toString());
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
				if (bw != null)
				{	
					bw.close();
				}
			}		
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}		
	}
	
	public void search()
	{
		Scanner in = new Scanner(System.in);
		String searchUsername;
		searchUsername = in.next();
		
		int flag = 0;
		Person temp;
		
		try	//If username already exists
		{
			Iterator i = Network.iterator();
			
			while(i.hasNext() && flag == 0)
			{  
				temp = (Person)i.next();
				
				String tempUsername = new String();
				tempUsername = temp.getUsername();
				
				if(searchUsername.equals(tempUsername))
				{
					flag = 1;
				}
			}
			
			if (flag == 1)
			{
				LoggedInUser.checkIfFriend(searchUsername);
			}
			else if (flag == 0)
			{
				throw new UserNotFoundException(searchUsername);
			}
		}
		catch(UserNotFoundException exp)
		{      
			System.out.println(exp);
		}
		
		afterLoginMenu();
	}
	public void afterLoginMenu()
	{
		int choice;
		Scanner in = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("1.	List Friends");
		System.out.println("2.	Search");
		System.out.println("3.	Update status");
		System.out.println("4.	Pending requests");
		System.out.println("5.	Logout");
		System.out.println("Enter choice:  ");
		choice = in.nextInt();
		
		switch(choice)
		{
			case 1	: 	System.out.println("Your friends are	:" + LoggedInUser.getlistOffriends());
						afterLoginMenu();
						break;
						
			case 2	:	search();
						break;
						
			case 3	: 	LoggedInUser.updateStatus();
						System.out.println("Status updated.");
						afterLoginMenu();
						break;
						
			case 4	: 	LoggedInUser.pendingRequests();
						afterLoginMenu();
						break;
						
			case 5	: 	logout();
						System.out.println("User " +LoggedInUser.getUsername()+ " logged out successfully.");
						mainMenu();
						break;
						
			case 0	:	System.exit(0);
						break;
						
			case 99	:	printNetwork();
						break;
						
			default	:	System.out.println("Wrong input. Enter again");
						mainMenu();
						break;
		}
	}
	
	public void mainMenu()
	{
		int choice;
		Scanner in = new Scanner(System.in);
		
		System.out.println("1.	Signup");
		System.out.println("2.	Login");
		System.out.println("0.	Exit");
		System.out.println("Enter choice:  ");
		choice = in.nextInt();
		
		switch(choice)
		{
			case 1	: 	signup();
						break;
			case 2	:	login();
						break;
			case 0	:	logout();
						System.exit(0);
						break;
			case 99	:	printNetwork();
						break;
			default	:	System.out.println("Wrong input. Enter again");
						mainMenu();
						break;
		}	
	}
	
}
