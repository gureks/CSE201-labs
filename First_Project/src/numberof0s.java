import java.util.Scanner;

public class numberof0s {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for ( int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		int f=0, l=n, temp;		
		while(l>f)
		{
			temp=l/2;
			if(arr[temp]==0)
			{
				f=temp;
			}
			else 
			{
				l=temp;
			}
		}
		System.out.printf("%d",l);
	}

}


