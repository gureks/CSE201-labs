/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

public class Song extends Media
{
	private String movie;
	
	Song(String title, String movie, String artist, Integer year, String genre, Float size, Integer rating, String duration)
	{
		super(title,artist,year,genre,size,rating,duration);
		this.movie= movie;
	}
	
	public String getMovie()
	{
		return movie;
	}
	
	public String toString()
	{
		return	"Song Title: " + getTitle() + 
				"\nMovie: " + getMovie() + 
				"\nArtist: " + getArtist() +
				"\nYear of Release: " + getYear() +
				"\nGenre: " + getGenre() +
				"\nSize: " + getSize() + 
				"\nRating: " + getRating() +
				"\nDuration (hrs): " + getDuration() + "\n\n";
	}

}
