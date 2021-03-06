/**
 * @author Gurek 2015033
 */

public class Complex2
{
	private Number real;
	private Number img;
	
	Complex2(Number real, Number img)
	{
		this.real=real;
		this.img=img;
	}
	
	public String toString()
	{
		if((real instanceof Double) || (img instanceof Double))
		{
			if ((double)img >= 0)
				return "" + real.doubleValue() + "+" + img.doubleValue() + "i";
			else 
				return "" + real.doubleValue() + img.doubleValue() + "i";
		}
		else if((real instanceof Float) || (img instanceof Float))
		{
			if ((float)img >= 0)
				return "" + real.floatValue() + "+" + img.floatValue() + "i";
			else 
				return "" + real.floatValue() + img.floatValue() + "i";
		}
		else
		{
			if (img.intValue() >= 0)
				return "" + real.intValue() + "+" + img.intValue() + "i";
			else 
				return "" + real.intValue() + img.intValue() + "i";
		}
	}
	
	public Complex2 add(Complex2 a, Complex2 b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			return new Complex2((Double)a.real+(Double)b.real, (Double)a.img+(Double)b.img);
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			return new Complex2((Float)a.real+(Float)b.real, (Float)a.img+(Float)b.img);
		}
		else
		{
			return new Complex2((int)a.real+(int)b.real, (int)a.img+(int)b.img);
		}
	}
	
	public Complex2 subtract(Complex2 a, Complex2 b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			Complex2 diff = new Complex2((double)a.real-(double)b.real, (double)a.img-(double)b.img);
			return diff;
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			Complex2 diff = new Complex2((float)a.real-(float)b.real, (float)a.img-(float)b.img);
			return diff;
		}
		else
		{
			Complex2 diff = new Complex2((int)a.real-(int)b.real, (int)a.img-(int)b.img);
			return diff;
		}
	}
	
	public Complex2 multiply(Complex2 a, Complex2 b)
	{
		if((a.real instanceof Double) || (b.real instanceof Double) 
				|| (a.img instanceof Double) || (b.img instanceof Double))
		{
			return new Complex2((double)a.real*(double)b.real-(double)a.img*(double)b.img, (double)a.img*(double)b.real+(double)a.real*(double)b.img);
		}
		else if((a.real instanceof Float) || (b.real instanceof Float) 
				|| (a.img instanceof Float) || (b.img instanceof Float))
		{
			return new Complex2((float)a.real*(float)b.real-(float)a.img*(float)b.img, (float)a.img*(float)b.real+(float)a.real*(float)b.img);
		}
		else
		{
			return new Complex2((int)a.real*(int)b.real-(int)a.img*(int)b.img, (int)a.img*(int)b.real+(int)a.real*(int)b.img);
		}
	}
	
	public Complex2 conjugate()
	{
		if((real instanceof Double) || (img instanceof Double))
		{
			return new Complex2((double)real, -1*(double)img);
		}
		else if((real instanceof Float) || (img instanceof Float))
		{
			return new Complex2((float)real, -1*(float)img);
		}
		else
		{
			return new Complex2((int)real, -1*(int)img);
		}
	}
	
	public float absolute()
	{
		return (float)Math.hypot(real.doubleValue(),img.doubleValue());
	}
}
