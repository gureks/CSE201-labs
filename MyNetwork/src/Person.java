/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

public class Person 
{
	private String username;
	private String password;
	private String display_name;
	private int friends, requests;
	private String status;
	private String[] listOffriends, listOfrequests;
	
	public Person(String username, String password, String display_name)
	{
		this.username = username;
		this.password = password;
		this.display_name = display_name; 
		friends = 0;
		requests = 0;
		status = "";
	}
	
	public void setFriends(int friends)
	{
		this.friends = friends;
	}
	
	public int getFriends()
	{
		return friends;
	}
	
	public void setlistOffriends(String friendUsername, int i)
	{
		listOffriends[i] = new String();
		listOffriends[i] = friendUsername;
	}
	
	public void setRequests(int requests)
	{
		this.requests = requests;
	}
	
	public int getRequests()
	{
		return requests;
	}
	
	public void setlistOfrequests(String requestsUsername, int i)
	{
		listOfrequests[i] = new String();
		listOfrequests[i] = requestsUsername;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public String toString()
	{
		return username +","+ password +","+ display_name +","+ friends +","+ listOffriends +","+ requests +","+ listOfrequests +","+ status;
	}
	
	
}
