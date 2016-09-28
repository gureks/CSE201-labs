/**
 * @author Gurek 2015033
 */

import java.util.*;

public class ComplexDemo
{
	public static void Complex1Demo()
	{
		int real, img;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Demonstrating Complex(1) class	:	");
		
		System.out.println("Enter integer first Complex number");
		System.out.println("real part	:	");
		real = in.nextInt();
		System.out.println("imaginary part	:	");
		img = in.nextInt();
		Complex1 first = new Complex1(real,img);
		
		System.out.println("Enter integer second Complex number");
		System.out.println("real part	:	");
		real = in.nextInt();
		System.out.println("imaginary part	:	");
		img = in.nextInt();
		Complex1 second = new Complex1(real,img);
		
		System.out.println("Entered numbers are " + first + " and " + second);
		System.out.println("Conjugate value of numbers are " + first.conjugate() + " and " + second.conjugate() + " respectively.");
		System.out.println("Absolute value of numbers are " + first.absolute() + " and " + second.absolute() + " respectively.");
		System.out.println("Sum of numbers is " + first.add(first,second));
		System.out.println("Difference of numbers is " + first.subtract(first,second));
		System.out.println("Product of numbers is " + first.multiply(first,second));
	}

	public static void Complex2Demo()
	{
		Number real, img;
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("");

		System.out.println("Demonstrating Complex(2) class(using Double)	:	");
		
		System.out.println("Enter first Complex number");
		System.out.println("real part	:	");
		real = in.nextDouble();
		System.out.println("imaginary part	:	");
		img = in.nextDouble();
		Complex2 first = new Complex2(real,img);
		
		System.out.println("Enter second Complex number");
		System.out.println("real part	:	");
		real = in.nextDouble();
		System.out.println("imaginary part	:	");
		img = in.nextDouble();
		Complex2 second = new Complex2(real,img);
		
		System.out.println("Entered numbers are " + first + " and " + second);
		System.out.println("Conjugate value of numbers are " + first.conjugate() + " and " + second.conjugate() + " respectively.");
		System.out.println("Absolute value of numbers are " + first.absolute() + " and " + second.absolute() + " respectively.");
		System.out.println("Sum of numbers is " + first.add(first,second));
		System.out.println("Difference of numbers is " + first.subtract(first,second));
		System.out.println("Product of numbers is " + first.multiply(first,second));
	}
	
	public static void Complex3Demo()
	{
		Float real, img;
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println("Demonstrating Complex(3) class(using Float)	:	");
		
		System.out.println("Enter first Complex number");
		System.out.println("real part	:	");
		real = in.nextFloat();
		System.out.println("imaginary part	:	");
		img = in.nextFloat();
		Complex3<Float> first = new Complex3<Float>(real,img);
		
		System.out.println("Enter second Complex number");
		System.out.println("real part	:	");
		real = in.nextFloat();
		System.out.println("imaginary part	:	");
		img = in.nextFloat();
		Complex3<Float> second = new Complex3<Float>(real,img);
		
		System.out.println("Entered numbers are " + first + " and " + second);
		System.out.println("Conjugate value of numbers are " + first.conjugate() + " and " + second.conjugate() + " respectively.");
		System.out.println("Absolute value of numbers are " + first.absolute() + " and " + second.absolute() + " respectively.");
		System.out.println("Sum of numbers is " + first.add(first,second));
		System.out.println("Difference of numbers is " + first.subtract(first,second));
		System.out.println("Product of numbers is " + first.multiply(first,second));
	}
}
