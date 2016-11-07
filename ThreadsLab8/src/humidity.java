import java.io.*;
import java.text.DecimalFormat;

/**
 *
 * @author Gurek Singh 2015033
 * @author Saurabh Kapur 2015087
 *
 */

public class humidity 
{
	private float[][] humidity;
	private float[] min, max, avg;
	
	public humidity()
	{
		humidity = new float[5][100];
		BufferedReader br = null;
		DecimalFormat df = new DecimalFormat("###.#");

		try 
		{
			//System.out.println("reading file");
			
			br = new BufferedReader(new FileReader("humidity"));
			String next = null;

			for(int i=0;i<5;i++)
			{
				for(int j=0;j<100;j++)
				{	
					next = br.readLine();
					float temp = Float.valueOf(next);
					humidity[i][j] = Float.valueOf(df.format(temp));
				}
				String temp = br.readLine();
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
		
		setMin();
		setMax();
		setAvg();
	}
	
	public String toString()
	{
		String output = new String();
		for(int i=0;i<5;i++)
		{	
			for(int j=0;j<100;j++)
				output = output + humidity[i][j];
			output = output +"\n";
		}
		return output;
	}
	
	private void setMin()
	{
		min = new float [5];
		for(int i = 0; i<5; i++)
		{
			min[i] = humidity[i][0];
			for (float j : humidity[i])
				min[i] = Math.min(min[i], j);
		}
	}
	
	private void setMax()
	{
		max = new float [5];
		for(int i = 0; i<5; i++)
		{
			max[i] = humidity[i][0];
			for (float j : humidity[i])
				max[i] = Math.max(max[i], j);
		}
	}
	
	private void setAvg()
	{
		avg = new float [5];
		for(int i = 0; i<5; i++)
		{
			avg[i] = humidity[i][0];
			for (float j : humidity[i])
				avg[i] += j;
			avg[i] /= 100.0;
		}
	}
	
	public float[] getMin()
	{
		return min;
	}
	
	public float[] getMax()
	{
		return max;
	}
	
	public float[] getAvg()
	{
		return avg;
	}
}
