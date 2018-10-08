package characterClasses;

public abstract class NonCombatCharacter extends RPGCharacter
{
	private int peopleMurdered;

	public NonCombatCharacter(String name)
	{
		super(name);
		setPeopleMurdered();
	}

	public void setPeopleMurdered()
	{
		peopleMurdered = 0;
	}

	public int getPeopleMurdered()
	{
		return peopleMurdered;
	}

	public void increaseKillCount()
	{
		peopleMurdered++;
	}

	//public abstract void run();
	//public abstract void walk();
	//public abstract void stop();
	//public abstract void talk();
	//public abstract void fight();
	//public abstract void quickGenerate();
}