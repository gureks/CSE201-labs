/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

public class Movie extends Media
{
	private String director;
	private String producer;
	private String certification;
	
	Movie(String title, String artist, Integer year, String genre, Float size, Integer rating, String duration, String director, String producer, String certification)
	{
		super(title,artist,year,genre,size,rating,duration);
		this.director = director;
		this.producer = producer;
		this.certification = certification;
	}
	
	public String getDirector()
	{
		return director;
	}
	public String getProducer()
	{
		return producer;
	}
	public String getCertification()
	{
		return certification;
	}
	public String toString()
	{
		return	"Movie name: " + getTitle() + 
				"\nArtist: " + getArtist() +
				"\nYear of Release: " + getYear() +
				"\nGenre: " + getGenre() +
				"\nSize: " + getSize() + 
				"\nRating: " + getRating() +
				"\nDuration (hrs): " + getDuration() +
				"\nDirector: " + getDirector() +
				"\nProducer: " + getProducer() +
				"\nCertification: " + getCertification() + "\n\n";
	}
}
