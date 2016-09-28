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
		Complex1 sum = new Complex1(a.real+b.real, a.img+b.img);
		return sum;
	}
	
	public Complex1 subtract(Complex1 a, Complex1 b)
	{
		Complex1 diff = new Complex1(a.real-b.real, a.img-b.img);
		return diff;
	}
	
	public Complex1 multiply(Complex1 a, Complex1 b)
	{
		Complex1 product = new Complex1(a.real*b.real-a.img*b.img, a.img*b.real+a.real*b.img);
		return product;
	}
	
	public Complex1 conjugate()
	{
		Complex1 conj = new Complex1(real, -1*img);
		return conj;
	}
	
	public float absolute()
	{
		float val = (float)Math.sqrt(real*real + img*img);
		return val;
	}
}