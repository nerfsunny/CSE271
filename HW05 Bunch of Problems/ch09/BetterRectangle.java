import java.awt.Rectangle;

public class BetterRectangle extends Rectangle
{
	public BetterRectangle(int xposition, int yposition, int width, int height)
	{
		super(); 
		setSize(width, height);
		setLocation(xposition, yposition);
	}

	public double getArea()
	{
		return super.getWidth() * super.getHeight();
	}

	public double getPerimeter()
	{
		return (2 * super.getWidth()) + (2 * super.getHeight());
	}
}