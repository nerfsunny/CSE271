package characterClasses;

public abstract class NonCombatCharacter extends RPGCharacter
{
	public abstract void run();
	public abstract void walk();
	public abstract void stop();
	public abstract void talk();
	public abstract void fight();
	public abstract void quickGenerate();
}