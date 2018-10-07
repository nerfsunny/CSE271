package characterClasses;

public abstract class RPGCharacter
{
	private String name;
	private int lifePoints;

	public RPGCharacter(String name)
	{
		setName(name);
		setLifePoints(100);
	}

	//Getter's and Setter's
	public void setName(String n)
	{
		name = n;
	}

	public void setLifePoints(int l)
	{
		lifePoints = l;
	}

	public String getName()
	{
		return name;
	}

	public int getLifePoints()
	{
		return lifePoints;
	}

	//Abstract Methods to be implemented in the child classes
	/*public abstract void run();
	public abstract void walk();
	public abstract void stop();
	public abstract void talk();
	public abstract void quickGenerate();*/
}