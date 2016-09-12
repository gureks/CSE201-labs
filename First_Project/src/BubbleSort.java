import java.util.Scanner;

public class BubbleSort
{

	public static void bubble(int[] arr, int n)
	{
		int temp;
		
		for ( int i = 0; i<n; i++)
		{
			for (int j = 0; j<n-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for ( int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		
		bubble(arr,n);
		
		for (int i=0;i<n;i++)
		{
			System.out.printf("%d ",arr[i]);
		}
	}
}
