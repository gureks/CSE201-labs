import java.io.*;
import java.text.DecimalFormat;

/**
 *
 * @author Gurek Singh 2015033
 * @author Saurabh Kapur 2015087
 *
 */

public class rainfall 
{
	private float[][] rainfall;
	private float[] min, max, avg;
	
	public rainfall()
	{
		rainfall = new float[5][100];
		BufferedReader br = null;
		DecimalFormat df = new DecimalFormat("###.#");

		try 
		{
			//System.out.println("reading file");
			
			br = new BufferedReader(new FileReader("rainfall"));
			String next = null;

			for(int i=0;i<5;i++)
			{
				for(int j=0;j<100;j++)
				{	
					next = br.readLine();
					float temp = Float.valueOf(next);
					rainfall[i][j] = Float.valueOf(df.format(temp));
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
				output = output + rainfall[i][j];
			output = output +"\n";
		}
		return output;
	}
	
	private void setMin()
	{
		min = new float [5];
		for(int i = 0; i<5; i++)
		{
			min[i] = rainfall[i][0];
			for (float j : rainfall[i])
				min[i] = Math.min(min[i], j);
		}
	}
	
	private void setMax()
	{
		max = new float [5];
		for(int i = 0; i<5; i++)
		{
			max[i] = rainfall[i][0];
			for (float j : rainfall[i])
				max[i] = Math.max(max[i], j);
		}
	}
	
	private void setAvg()
	{
		avg = new float [5];
		for(int i = 0; i<5; i++)
		{
			avg[i] = rainfall[i][0];
			for (float j : rainfall[i])
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
