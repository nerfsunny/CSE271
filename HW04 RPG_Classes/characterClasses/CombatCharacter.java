package characterClasses;

public abstract class CombatCharacter extends RPGCharacter
{
	private int battlesWon;

	//Constructors
	public CombatCharacter(String name)
	{
		super(name);
		setBattlesWon(0);
	}

	//Getter's and Setter's
	public void setBattlesWon(int b)
	{
		battlesWon = b;
	}

	public int getBattlesWon()
	{
		return battlesWon;
	}

	//Methods
	public void increaseBattlesWon()
	{
		battlesWon++;
	}

	//Abstract Methods to be implemented in the child classes
	/*public abstract void run();
	public abstract void walk();
	public abstract void stop();
	public abstract void talk();
	public abstract void fight();
	public abstract void quickGenerate();*/
}