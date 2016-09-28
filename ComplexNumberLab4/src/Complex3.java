/**
 * @author Gurek 2015033
 */

public class Complex3<T extends Number>
{
	private T real;
	private T img;
	
	Complex3(T real, T img)
	{
		this.real=real;
		this.img=img;
	}
	
	public String toString()
	{
		if(img.intValue()<0)
			return "" + real + img+"i";
		else
			return "" + real + "+" + img +"i";
	}
	
	public Complex3 add(Complex3<T> a, Complex3<T> b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			Complex3<T> sum = new Complex3<T>((T)(Double)((Double)a.real+(Double)b.real), (T)(Double)((Double)a.img+(Double)b.img));
			return sum;
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			Complex3<T> sum = new Complex3<T>((T)(Float)((Float)a.real+(Float)b.real), (T)(Float)((Float)a.img+(Float)b.img));
			return sum;
		}
		else
		{
			Complex3<T> sum = new Complex3<T>((T)(Integer)((Integer)a.real+(Integer)b.real), (T)(Integer)((Integer)a.img+(Integer)b.img));
			return sum;
		}
	}
	
	public Complex3 subtract(Complex3 a, Complex3 b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			Complex3<T> diff = new Complex3<T>((T)(Double)((Double)a.real-(Double)b.real), (T)(Double)((Double)a.img-(Double)b.img));
			return diff;
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			Complex3<T> diff = new Complex3<T>((T)(Float)((Float)a.real-(Float)b.real), (T)(Float)((Float)a.img-(Float)b.img));
			return diff;
		}
		else
		{
			Complex3<T> diff = new Complex3<T>((T)(Integer)((Integer)a.real-(Integer)b.real), (T)(Integer)((Integer)a.img-(Integer)b.img));
			return diff;
		}
	}
	
	public Complex3 multiply(Complex3 a, Complex3 b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			Complex3 product = new Complex3((T)(Double)((Double)a.real*(Double)b.real-(Double)a.img*(Double)b.img), (T)(Double)((Double)a.img*(Double)b.real+(Double)a.real*(Double)b.img));
			return product;
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			Complex3 product = new Complex3((T)(Float)((Float)a.real*(Float)b.real-(Float)a.img*(Float)b.img), (T)(Float)((Float)a.img*(Float)b.real+(Float)a.real*(Float)b.img));
			return product;
		}
		else
		{
			Complex3 product = new Complex3((T)(Integer)((Integer)a.real*(Integer)b.real-(Integer)a.img*(Integer)b.img), (T)(Integer)((Integer)a.img*(Integer)b.real+(Integer)a.real*(Integer)b.img));
			return product;
		}
	}
	
	public Complex3<T> conjugate()
	{
		if((real instanceof Double) || (img instanceof Double))
		{
			Complex3<T> conj = new Complex3<T>((T)(Double)real, (T)(Double)(-1*(Double)img));
			return conj;
		}
		else if((real instanceof Float) || (img instanceof Float))
		{
			Complex3<T> conj = new Complex3<T>((T)(Float)real, (T)(Float)(-1*(Float)img));
			return conj;
		}
		else
		{
			Complex3<T> conj = new Complex3<T>((T)(Integer)real, (T)(Integer)(-1*(Integer)img));
			return conj;
		}
	}
	
	public float absolute()
	{
		return (float)Math.hypot(real.doubleValue(), img.doubleValue());
	}
}
