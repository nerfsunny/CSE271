package characterClasses;

public abstract class CombatCharacter extends RPGCharacter
{
	private int battlesWon;

	//Constructors
	public CombatCharacter(String name)
	{
		super(name);
		setBattlesWon();
	}

	//Getter's and Setter's
	public void setBattlesWon()
	{
		battlesWon = 0;
	}

	public int getBattlesWon()
	{
		return battlesWon;
	}

	//Methods
	public void increaseBattleCount()
	{
		battlesWon++;
	}

	//Abstract Methods to be implemented in the child classes
	public abstract void run();
	public abstract void walk();
	public abstract void stop();
	public abstract boolean talk(RPGCharacter x);
	public abstract void fight(RPGCharacter x);
	public abstract void quickGenerate();
	//public abstract void increaseStats();
	public abstract int getLevel();
	public abstract int getSpeed();
	public abstract int getDexterity();
	public abstract int getCharisma();
	public abstract int getStrength();
	public abstract String getCharacterClass();
}