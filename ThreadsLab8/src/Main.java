
/**
 * 
 * @author Gurek Singh 2015033
 * @author Saurabh Kapur 2015087
 *
 */

public class Main
{
	public static void main(String[] args)
	{
		temperature temp = new temperature();
		float[] minT = new float[5];
		float[] maxT = new float[5];
		float[] avgT = new float[5];
		minT = temp.getMin();
		maxT = temp.getMax();
		avgT = temp.getAvg();
		for(int i = 0; i<5; i++)
		{
			System.out.println(minT[i]);
			System.out.println(maxT[i]);
			System.out.println(avgT[i]);
			System.out.println("\n\n");
		}
		
		humidity hum = new humidity();
		float[] minH = new float[5];
		float[] maxH = new float[5];
		float[] avgH = new float[5];
		minH = hum.getMin();
		maxH = hum.getMax();
		avgH = hum.getAvg();
		for(int i = 0; i<5; i++)
		{
			System.out.println(minH[i]);
			System.out.println(maxH[i]);
			System.out.println(avgH[i]);
			System.out.println("\n\n");
		}
		
		rainfall rain = new rainfall();
		float[] minR = new float[5];
		float[] maxR = new float[5];
		float[] avgR = new float[5];
		minR = rain.getMin();
		maxR = rain.getMax();
		avgR = rain.getAvg();
		for(int i = 0; i<5; i++)
		{
			System.out.println(minR[i]);
			System.out.println(maxR[i]);
			System.out.println(avgR[i]);
			System.out.println("\n\n");
		}
	}

}
