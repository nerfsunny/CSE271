import java.lang.Math;

public class SodaCan
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
		this.height = height;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
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