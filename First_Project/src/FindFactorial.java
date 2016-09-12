import java.util.Scanner;


public class FindFactorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a=1,b=1,temp;
		System.out.printf("%d %d ",a,b);
		while(a+b<n)
		{
			System.out.printf("%d ",a+b);
			temp=a+b;
			a=b;
			b=temp;
		}
	}

}
