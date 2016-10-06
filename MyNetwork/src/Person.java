/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

import java.util.*;

public class Person 
{
	private String username;
	private String password;
	private String display_name;
	private int friends, requests;
	private String status;
	private ArrayList<String> listOffriends, listOfrequests;
	
	public Person(String username, String password, String display_name)
	{
		this.username = username;
		this.password = password;
		this.display_name = display_name; 
		friends = 0;
		requests = 0;
		status = "";
		listOffriends = new ArrayList<String>();
		listOfrequests = new ArrayList<String>();
	}
	
	public void setFriends(int friends)
	{
		this.friends = friends;
	}
	
	public int getFriends()
	{
		return friends;
	}
	
	public void setlistOffriends(String friendUsername)
	{
		listOffriends.add(friendUsername);
	}
	
	public String getlistOffriends()
	{
		String lof = new String();
		lof = "";
		for(String a:listOffriends)
		{
			lof = lof + a + ",";
		}
		return lof;
	}
	
	public void setRequests(int requests)
	{
		this.requests = requests;
	}
	
	public int getRequests()
	{
		return requests;
	}
	
	public void setlistOfrequests(String requestsUsername)
	{
		listOfrequests.add(requestsUsername);
	}
	
	public String getlistOfrequests()
	{
		String lor = new String();
		lor = "";
		for(String a:listOfrequests)
		{
			lor = lor + a + ",";
		}
		return lor;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void updateStatus()
	{
		Scanner in = new Scanner(System.in);
		String status = new String();
		
		System.out.println("Enter new status :");
		status = in.nextLine();
		
		setStatus(status);
		System.out.println("Status updated.");
	}
	
	public void pendingRequests()
	{
		Scanner in = new Scanner(System.in);
		char choice;
		
		if(requests == 0)
		{
			System.out.println("No new requests.");
			return;
		}
		else
		{
			int j = 0;
			for(String a:listOfrequests)
			{
				System.out.println(++j + ".	" + a);	
			}
			System.out.println("b.	Back");
			choice = (char)in.next().charAt(0);
		
			if(choice == 'b')
			{
				return;
			}
			else
			{	
				int c = Character.getNumericValue(choice);
				String temp = new String();
				
				if(c < listOfrequests.size())
				{	
					temp = listOfrequests.get(c-1);
				}
				System.out.println(temp);
				System.out.println("1.	Accept");
				System.out.println("2.	Reject");
				int c2 = in.nextInt();
						
				switch(c2)
				{
					case 1	:	requests--;
								listOfrequests.remove(c-1);
								friends++;
								listOffriends.add(temp);
								break;
										
					case 2	:	requests--;
								listOfrequests.remove(c-1);
								System.out.println("Friend request by " +temp+ " deleted.");
								pendingRequests();
								break;
										
					default	:	System.out.println("Wrong input. Enter again.");
								pendingRequests();
								break;
				}
			}
		}
	}
	
	public int checkIfFriend(String tempUsername)
	{
		int flag=0;
		for(String a:listOffriends)
		{	
			if(a.equals(tempUsername))
			{
				flag=1;
			}
		}
		
		return flag;
	}
	
	public String toString()
	{
		String lof = new String();
		lof = getlistOffriends();
		
		String lor = new String();
		lor = getlistOfrequests();
		
		return username +","+ password +","+ display_name +","+ friends +","+ lof + requests +","+ lor + status;
	}
	
	
}
