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

	public void setLifePointsToZero()
	{
		lifePoints = 0;
	}

	public String battleStatus()
	{
		if(lifePoints <= 0)
		{
			return "Dead";
		}

		return "Alive";
	}

	//Abstract Methods to be implemented in the child classes
	public abstract void run();
	public abstract void walk();
	public abstract void stop();
	public abstract boolean talk(RPGCharacter x);
	public abstract void fight(RPGCharacter x);
	public abstract void quickGenerate();
	public abstract int getLevel();
	public abstract int getSpeed();
	public abstract int getDexterity();
	public abstract int getCharisma();
	public abstract int getStrength();
	public abstract String getCharacterClass();
	public abstract void increaseBattleCount();
}