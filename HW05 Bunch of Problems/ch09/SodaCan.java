import java.lang.Math;
import java.security.InvalidParameterException;

public class SodaCan implements Measurable
{
	private double height, radius;

	public SodaCan()
	{
		setHeight(1);
		setRadius(1);
	}

	public SodaCan(double radius, double height)
	{
		setRadius(radius);
		setHeight(height);
	}

	public void setHeight(double height)
	{
		if(height > 0)
		{
			this.height = height;
		}else
		{
			throw new InvalidParameterException("Value " + height + " is not possible");
		}
	}

	public void setRadius(double radius)
	{
		if(radius > 0)
		{
			this.radius = radius;
		}else
		{
			throw new InvalidParameterException("Value " + radius + " is not possible.");
		}
	}

	public double getHeight()
	{
		return height;
	}

	public double getRadius()
	{
		return radius;
	}

	public double getSurfaceArea()
	{
		return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));
	}

	public double getVolume()
	{
		return Math.PI * Math.pow(radius, 2) * height;
	}
}