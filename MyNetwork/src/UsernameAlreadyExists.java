/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */


public class UsernameAlreadyExists extends Exception
{
	private String username;
	
	public UsernameAlreadyExists(String username)
	{
		this.username = username;
	}
	
	public String toString()
	{
		return username + " already exists. Please enter again. ";
	}
}