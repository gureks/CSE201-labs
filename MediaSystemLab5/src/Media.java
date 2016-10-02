import java.io.Serializable;

/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

public class Media implements Comparable<Media>, Serializable
{
	private String title;
	private String artist;
	private Integer year;
	private String genre;
	private String size; 
	private Integer rating;
	private String duration; 
	
	Media(String title, String artist, Integer year, String genre, String size, Integer rating, String duration)
	{
		this.title = title;
		this.artist = artist;
		this.year = year; 
		this.genre = genre;
		this.size = size; 
		this.rating = rating;
		this.duration = duration;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public String getDuration()
	{
		return duration;
	}
	
	public Integer getRating()
	{
		return rating;
	}
	
	public Integer getYear()
	{
		return year;
	}
	
	public int compareTo(Media arg)
	{
		return 0;
	}
}
