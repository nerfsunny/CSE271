package characterClasses;

import java.security.*;
import java.util.*;

public class ShopKeeper extends NonCombatCharacter
{
	//Variables for the object
	private String characterClass;
	private int level, totalExperience, strength, dexterity, charisma, speed;
	//private int experienceGained;

	private int level0, totalExperience0, strength0, dexterity0, charisma0, speed0;

	//Constructors
	public ShopKeeper(String name)
	{
		super(name);
		quickGenerate();

	}

	//Workhorse
	public ShopKeeper(String name, int level, int totalExperience, int strength, int dexterity, int charisma, int speed)
	{
		super(name);
		setCharacterClass();
		//setExperienceGained();
		setDefaultStats();
		setLevel(level);
		setTotalExperience(totalExperience);
		setStrength(strength);
		setDexterity(dexterity);
		setCharisma(charisma);
		setSpeed(speed);
	}

	public ShopKeeper clone()
	{
		return new ShopKeeper(this);
	}

	public ShopKeeper(ShopKeeper k)
	{
		this(k.getName(), k.getLevel(), k.getTotalExperience(), k.getStrength(), k.getDexterity(), k.getCharisma(), k.getSpeed());
	}

	//Getter's and Setter's
	private void setCharacterClass()
	{
		characterClass = "ShopKeeper";
	}

	/*private void setExperienceGained()
	{
		experienceGained = 0;
	}*/

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

	public void setDefaultStats()
	{
		level0 = level;
		totalExperience0 = totalExperience;
		strength0 = strength;
		dexterity0 = dexterity;
		charisma0 = charisma;
		speed0 = speed;
	}

	//Methods
	public void quickGenerate()
	{
		Random number = new Random();
		setCharacterClass();
		setDefaultStats();
		//setExperienceGained();
		setLevel(number.nextInt(15) + 1);
		setTotalExperience(number.nextInt(100) + 1);
		setStrength(number.nextInt(15) + 1);
		setDexterity(number.nextInt(18) + 1);
		setCharisma(number.nextInt(18) + 1);
		setSpeed(number.nextInt(12) + 1);
	}

	public void defaultStats(String name)
	{
		setName(name);
		setLevel(level0);
		setTotalExperience(totalExperience0);
		setStrength(strength0);
		setDexterity(dexterity0);
		setCharisma(charisma0);
		setSpeed(speed0);
	}

	//Action classes
	public void run() //checks if the character is able to run away from the enemy
	{
		setSpeed(speed0);
		setSpeed(speed0 + 2);
	}

	public void walk()
	{
		setSpeed(speed0);
		setSpeed(speed0 - 2);
	}

	public void stop() //the character cannot move
	{
		setSpeed(speed0);
		speed = 0;
	}

	public boolean talk(RPGCharacter x)
	{
		boolean ret = false;

		if(this.getCharisma() > x.getCharisma())
		{
			ret = true;
		}else
		if(x.getCharisma() > this.getCharisma())
		{
			ret = false;
		}

		return ret;
	}

	public void fight(RPGCharacter x) //allows two character objects to fight each other
	{
		RPGCharacter player1 = null;
		RPGCharacter player2 = null;
		//RPGCharacter buffer = null;

		if(this.getSpeed() > x.getSpeed())
		{
			player1 = new ShopKeeper(this);
			player2 = x;
		}else
		{
			player1 = x;
			player2 = new ShopKeeper(this);
		}

		/*if(player1.getCharacterClass().equalsIgnoreCase("ShopKeeper"))
		{
			buffer = player1;
		}else
		if(player2.getCharacterClass().equalsIgnoreCase("ShopKeeper"))
		{
			buffer = player2;
		}*/

		while(/*buffer.getLifePoints() > 0*/ true)
		{
			player2.setLifePoints(player2.getLifePoints() - player1.getStrength());
			//System.out.println(player2.getCharacterClass() + " " + player2.getLifePoints());

			if(player2.getLifePoints() <= 0)
			{
				break;
			}

			player1.setLifePoints(player1.getLifePoints() - player2.getStrength());
			//System.out.println(player1.getCharacterClass() + " " + player1.getLifePoints());
		
			if(player1.getLifePoints() <= 0)
			{
				break;
			}
		}

		if( (player2.getCharacterClass().equalsIgnoreCase("ShopKeeper") && player2.getLifePoints() <= 0) || (player1.getCharacterClass().equalsIgnoreCase("ShopKeeper") && player1.getLifePoints() <= 0))
		{
			this.setLifePoints(0);
		}else
		{
			x.setLifePoints(0);
			this.setLifePoints(100);
			//increaseStats(x);
		}
	}

	/*public void increaseStats(RPGCharacter x)
	{
		experienceGained = experienceGained + |this.getLevel() - x.getLevel()| + |this.getTotalExperience() - x.getTotalExperience()|

		if(experienceGained >= 50)
		{

		}
	}*/

	//Override Methods
	@Override
	public String toString()
	{
		return " Character's Name: "  + getName()  + "\n" +
			   " Character's Class: " + characterClass + "\n" +
			   " Character's Level: " + level + "\n" + 
			   " Character's Life Points: " + getLifePoints() + "\n" +
			   " Character's Status: " + battleStatus() + "\n" +
			   " Character's Strenght Stat: " + strength + "\n" +
			   " Character's Dexterity Stat: " + dexterity + "\n" +
			   " Character's Charisma: " + charisma + "\n" +
			   " Character's Speed: " + speed + "\n" +
			   " Character's Total Experience: " + totalExperience + "\n" +
			   " Character's Murder Tally: " + getPeopleMurdered();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof ShopKeeper))
		{
			return false;
		}

		ShopKeeper x = (ShopKeeper) obj;

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
}