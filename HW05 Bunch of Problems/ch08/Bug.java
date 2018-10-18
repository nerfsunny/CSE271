public class Bug
{
	private int position, increment;

	public Bug(int initialPosition)
	{
		setPosition(initialPosition);
		setIncrement(1);
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public void setIncrement(int increment)
	{
		this.increment = increment;
	}

	public void turn()
	{
		increment = (-1) * increment; 
	}

	public void move()
	{
		position = position + increment;
	}
	
	public int getPosition()
	{
		return position;
	}
}