import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

public class MediaSystem 
{
	static ArrayList<Movie> listMovie = new ArrayList<Movie>(); 
	static int numberOfmovie = 0;
	static ArrayList<Song> listSong = new ArrayList<Song>(); 
	static int numberOfsong = 0;
	
	public static void Serialize()
	{
		BufferedReader br1 = null;

		try {
			 br1 = new BufferedReader(new FileReader("movie.txt"));
			 String line = null;
			 
	         FileOutputStream fileOut = new FileOutputStream("movie.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         while ((line = br1.readLine()) != null) 
	         {
	        	 //System.out.println(line);
	        	 String[] values = line.split(",");
	        	 
	        	 Movie temp = new Movie(values[0],values[1],Integer.valueOf(values[2]),values[3],Float.valueOf(values[4]),Integer.valueOf(values[5]),values[6],values[7],values[8],values[9]);
	         
	        	 out.writeObject(temp);
	        	 //System.out.println(temp);
	         }
	         
	         out.close();
	         fileOut.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if (br1 != null)
				{	
					br1.close();
				}
			}
				
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	         
	    System.out.println("Serialized data from Movie.txt is saved in movie.dat\n");
	
	    
		BufferedReader br2 = null;

		try {
			 br2 = new BufferedReader(new FileReader("song.txt"));
			 String line = null;
			 
	         FileOutputStream fileOut = new FileOutputStream("song.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         while ((line = br2.readLine()) != null) 
	         {
	        	 //System.out.println(line);
	        	 String[] values = line.split(",");
	        	 
	        	 Song temp = new Song(values[0],values[1],values[2],Integer.valueOf(values[3]),values[4],Float.valueOf(values[5]),Integer.valueOf(values[6]),values[7]);
	         
	        	 out.writeObject(temp);
	        	 //System.out.println(temp);
	         }
	         
	         out.close();
	         fileOut.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if (br2 != null)
				{	
					br2.close();
				}
			}
				
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	         
	    System.out.println("Serialized data from Song.txt is saved in song.dat\n");
	}

	public static void Deserialize()
	{
		try {
			 
			System.out.println("Reading data from movie.dat\n");
			Movie temp = null;
			
			FileInputStream fileIn = new FileInputStream("movie.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
	         
	         while ((temp = (Movie)in.readObject()) != null) 
	         {
	        	 //System.out.println(temp);
	        	 listMovie.add(temp);
	        	 numberOfmovie++;
	         }

	         in.close();
	         fileIn.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		catch (EOFException ex)
		{
			System.out.println("");
		}
		
		catch (ClassNotFoundException ex)
		{
			System.out.println("Class not found");
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}
		
		/*finally
		{
	         System.out.println("Number of Movies: " + numberOfmovie + "\n");
		}*/
		
		try {
			 
			System.out.println("Reading data from song.dat\n");
			Song temp = null;
			
			FileInputStream fileIn = new FileInputStream("song.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
	         
	         while ((temp = (Song)in.readObject()) != null) 
	         {
	        	 //System.out.println(temp);
	        	 listSong.add(temp);
	        	 numberOfsong++;
	         }
	         
	         in.close();
	         fileIn.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		catch (EOFException ex)
		{
			System.out.println("");
		}
		
		catch (ClassNotFoundException ex)
		{
			System.out.println("Class not found");
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}
		
		/*finally
		{
	         System.out.println("\nNumber of Songs: " + numberOfsong);
		}*/

	
	}
	
	public static void viewSong()
	{
		Iterator<Song> itr = listSong.iterator();
		
		while(itr.hasNext())
		{  
			System.out.println(itr.next());
		} 
	}
	
	public static void viewMovie()
	{
		Iterator<Movie> itr = listMovie.iterator();
		
		while(itr.hasNext())
		{  
			System.out.println(itr.next());
		} 
	}
	
	public static void topK()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 'k' for top songs according to rating	:	");
		int k = in.nextInt();
		
		Collections.sort(listSong);
		Collections.reverse(listSong);
		
		for(int i=0;i<k;i++)
		{
			Song temp = listSong.get(i);
			System.out.println("Song Name: " + temp.getTitle());
			System.out.println("Rating: " + temp.getRating());
			System.out.println();
		}
		
		Collections.reverse(listSong);
		
		
		System.out.println("Enter 'k' for top movies according to rating	:	");
		k = in.nextInt();
		
		Collections.sort(listMovie);
		Collections.reverse(listMovie);
		
		for(int i=0;i<k;i++)
		{
			Movie temp = listMovie.get(i);
			System.out.println("Movie Name: " + temp.getTitle());
			System.out.println("Rating: " + temp.getRating());
			System.out.println();
		}
		
		Collections.reverse(listMovie);
	}
	
	public static void searchGenre()
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Genre of Song you wish to search	:	");
		String genre = in.next();
		
		Iterator<Song> itr = listSong.iterator();
		
		while(itr.hasNext())
		{  
			Song temp = itr.next();
			if(genre.equals(temp.getGenre()))
			{
				System.out.println(temp);
			}
		} 	
		
		in.close();
	}
	
	public static void searchDirector()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Director's name whose Movie you wish to search	:	");
		String director = in.next();
		
		Iterator<Movie> itr = listMovie.iterator();
		
		while(itr.hasNext())
		{  
			Movie temp = itr.next();
			if(director.equals(temp.getDirector()))
			{
				System.out.println(temp);
			}
		} 	
		
		in.close();
	}
	
	public static void displayCount()
	{
		System.out.println("\nNumber of songs in the library	:	" + numberOfsong);
		System.out.println("Number of movies in the library	:	" + numberOfmovie);
	}
	
	public static void searchSongOfMovie()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter movie name whose song you wish to list  :  ");
		String movie = in.next();
		
		Iterator<Song> itr = listSong.iterator();
		
		while(itr.hasNext())
		{
			Song temp = (Song)itr.next();
			if(movie.equals(temp.getMovie()))
			{
				System.out.println(temp.getTitle());
			}
		}
		
		in.close();
	}
	
	public static void editRating()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nEnter song title whose rating you wish to change  :  ");
		String title = in.next();
		
		Iterator<Song> itr = listSong.iterator();
		
		while(itr.hasNext())
		{
			Song temp = (Song)itr.next();
			if(title.equals(temp.getTitle()))
			{
				System.out.println("Enter new rating 	:");
				int rating = in.nextInt();
				System.out.println("Rating of " + temp.getTitle() + " updated from " + temp.getRating() + " to " + rating);
				temp.setRating(rating);
			}
		}
		
		System.out.println("\nEnter song title whose rating you wish to change  :  ");
		title = in.next();
		
		Iterator<Movie> itr2 = listMovie.iterator();
		
		while(itr2.hasNext())
		{
			Movie temp = (Movie)itr2.next();
			if(title.equals(temp.getTitle()))
			{
				System.out.println("Enter new rating 	:");
				int rating = in.nextInt();
				System.out.println("Rating of " + temp.getTitle() + " updated from " + temp.getRating() + " to " + rating);
				temp.setRating(rating);
			}
		}
		
		in.close();
	}
	
	public static void writeChanges()
	{

		try {			 
	         FileOutputStream fileOut = new FileOutputStream("movie.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         Iterator<Movie> itr = listMovie.iterator();
	         
	         while(itr.hasNext()) 
	         {
	        	 Movie temp = itr.next();
	        	 out.writeObject(temp);
	        	 //System.out.println(temp);
	         }
	         
	         out.close();
	         fileOut.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}	
		
		try {			 
	         FileOutputStream fileOut = new FileOutputStream("song.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         Iterator<Song> itr = listSong.iterator();
	         
	         while(itr.hasNext()) 
	         {
	        	 Song temp = itr.next();
	        	 out.writeObject(temp);
	        	 //System.out.println(temp);
	         }
	         
	         out.close();
	         fileOut.close();
		}     
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
			ex.printStackTrace();
		}
		
		catch (IOException ex)
		{
			System.out.println("IO Exception");
			ex.printStackTrace();
		}	

		
	}

	
	public static void main(String[] args) 
	{
		MediaSystem.Serialize();
		MediaSystem.Deserialize();
		
		MediaSystem.viewSong();
		MediaSystem.viewMovie();
	
		MediaSystem.topK();
		
		MediaSystem.searchGenre();
		
		MediaSystem.searchDirector();
		
		MediaSystem.editRating();
		MediaSystem.writeChanges();
		
		MediaSystem.displayCount();
		
		MediaSystem.searchSongOfMovie();
	}
	
}
