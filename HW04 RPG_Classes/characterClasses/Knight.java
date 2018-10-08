package characterClasses;

import java.security.*;
import java.util.*;

public class Knight extends CombatCharacter implements Comparable<RPGCharacter>
{
	//Variables for the object
	private String characterClass;
	private int level, totalExperience, strength, dexterity, charisma, speed;

	//Constructors
	public Knight(String name)
	{
		super(name);
	}

	//Workhorse
	public Knight(String name, int level, int totalExperience, int strength, int dexterity, int charisma, int speed)
	{
		super(name);
		setCharacterClass();
		setLevel(level);
		setTotalExperience(totalExperience);
		setStrength(strength);
		setDexterity(dexterity);
		setCharisma(charisma);
		setSpeed(speed);
	}

	public Knight clone()
	{
		return new Knight(this);
	}

	public Knight(Knight k)
	{
		this(k.getName(), k.getLevel(), k.getTotalExperience(), k.getStrength(), k.getDexterity(), k.getCharisma(), k.getSpeed());
	}

	//Getter's and Setter's
	private void setCharacterClass()
	{
		characterClass = "Knight";
	}

	public void setLevel(int l)
	{
		if(l > 0 && l <= 25)
		{
			level = l;
		}else
		{
			throw new InvalidParameterException("Level " + l + " is not possible.");
		}
	}

	public void setTotalExperience(int e)
	{
		totalExperience = e;
	}

	public void setStrength(int s)
	{
		strength = s;
	}

	public void setDexterity(int d)
	{
		dexterity = d;
	}

	public void setCharisma(int c)
	{
		charisma = c;
	}

	public void setSpeed(int s)
	{
		speed = s;
	}

	public String getCharacterClass()
	{
		return characterClass;
	}

	public int getLevel()
	{
		return level;
	}

	public int getTotalExperience()
	{
		return totalExperience;
	}

	public int getStrength()
	{
		return strength;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public int getCharisma()
	{
		return charisma;
	}

	public int getSpeed()
	{
		return speed;
	}

	//Methods
	public void quickGenerate()
	{
		Random number = new Random();
		setCharacterClass();
		setLevel(number.nextInt(20) + 1);
		setTotalExperience(number.nextInt(100) + 1);
		setStrength(number.nextInt(20) + 1);
		setDexterity(number.nextInt(20) + 1);
		setCharisma(number.nextInt(20) + 1);
		setSpeed(number.nextInt(15) + 1);
	}

	public void defaultStats(String name)
	{
		setName(name);
		setLevel(1);
		setTotalExperience(0);
		setStrength(1);
		setDexterity(1);
		setCharisma(1);
		setSpeed(1);
	}

	//Action classes
	public void run()
	{
		Random number = new Random();

		if(number.nextInt(2) == 1)
		{

		}
	}

	public void fight(RPGCharacter x)
	{
		if(!(x instanceof CombatCharacter))
		{

		}
	}

	//Override Methods
	@Override
	public String toString()
	{
		return  "Character's Name: "  + getName()  +
			   " Character's Class: " + characterClass + 
			   " Character's Level: " + level + 
			   " Character's Life Points: " + getLifePoints() +
			   " Character's Strenght Stat: " + strength +
			   " Character's Dexterity Stat: " + dexterity +
			   " Character's Charisma: " + charisma + 
			   " Character's Speed: " + speed +
			   " Character's Total Experience: " + totalExperience;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Knight))
		{
			return false;
		}

		Knight x = (Knight) obj;

		return characterClass.equalsIgnoreCase(x.getCharacterClass())       &&
			   getName().equalsIgnoreCase(x.getName())        				&&
			   level == x.getLevel() 									    &&
			   getLifePoints() == x.getLifePoints()							&&
			   strength == x.getStrength()								    &&
			   dexterity == x.getDexterity()							    &&
			   charisma == x.getCharisma()								    &&
			   speed == x.getCharisma()					 				    &&
			   totalExperience == x.getTotalExperience();
	}

	@Override
	public String sortCharacters()
	{
		return characterClass  + " " + 
			   getName() 	   + " " +
			   level 		   + " " +
			   totalExperience;
	}

	@Override
	public int compareTo(RPGCharacter x)
	{
		return this.sort().compareTo(x.sort());
	}
}