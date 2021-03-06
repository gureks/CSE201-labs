/**
 * @author Gurek 2015033
 */

public class Complex1
{
	private int real;
	private int img;
	
	Complex1(int real, int img)
	{
		this.real=real;
		this.img=img;
	}
	
	public String toString()
	{
		if (img >= 0)
			return "" + real + "+" + img + "i";
		else 
			return "" + real + img + "i";
	}
	
	public Complex1 add(Complex1 a, Complex1 b)
	{
		return new Complex1(a.real+b.real, a.img+b.img);
	}
	
	public Complex1 subtract(Complex1 a, Complex1 b)
	{
		return new Complex1(a.real-b.real, a.img-b.img);
	}
	
	public Complex1 multiply(Complex1 a, Complex1 b)
	{
		return new Complex1(a.real*b.real-a.img*b.img, a.img*b.real+a.real*b.img);
	}
	
	public Complex1 conjugate()
	{
		return new Complex1(real, -1*img);
	}
	
	public double absolute()
	{
		return Math.hypot(real,img);
	}
}
