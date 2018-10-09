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

	public void increaseBattleCount()
	{
		peopleMurdered++;
	}

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
}