package p;

import java.util.*;
import java.io.*;

public class Animal implements Comparable<Animal>
{
	//Variables
	private String recordID, animal, owner, title, countryAnimalLives;
	private double ownerPaid;

	//Constructors
	public Animal()
	{

	}

	public Animal clone()
	{
		return new Animal(this);
	}

	public Animal(Animal a)
	{
		this(a.getRecordID(), a.getAnimal(), a.getOwner(), a.getTitle(), a.getCountryAnimalLives(), a.getOwnerPaid());
	}

	public Animal(String recordID, String animal, String owner, String title, String countryAnimalLives, Double ownerPaid)
	{
		setRecordID(recordID);
		setAnimal(animal);
		setOwner(owner);
		setTitle(title);
		setCountryAnimalLives(countryAnimalLives);
		setOwnerPaid(ownerPaid);
	}

	public Animal(String[] properties)
	{
		this(properties[0],
			 properties[1],
			 properties[2],
			 properties[3],
			 properties[4],
			 properties[5],
			 Double.parseDouble( (properties[6].replace("ownerPaid:", "") ).replace("$", "") )
			);
	}

	public Animal(String s)
	{
		this(s.split("~"));
	}

	public Animal(RandomAccessFile raf) throws Exception
	{
		this(raf.readLine());
	}

	//Getter's and Setter's
	public void setRecordID(String id)
	{
		recordID = id;
	}

	public void setAnimal(String animal)
	{
		if(animal.contains(","))
		{
			String a = animal.split(", ")[0];
			String b = animal.split(", ")[1];

			this.animal = b + " " + a;
		}else
		if(animal.contains(" (unidenfied)"))
		{
			this.animal = animal.replace("(unidenfied", "");
		}else
		{
			this.animal = animal;
		}
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setCountryAnimalLives(String country)
	{
		countryAnimalLives = country;
	}

	public void setOwnerPaid(double money)
	{
		ownerPaid = money;
	}

	public String getRecordID()
	{
		return recordID;
	}

	public String getAnimal()
	{
		return animal;
	}

	public String getOwner()
	{
		return owner;
	}

	public String getTitle()
	{
		return title;
	}

	public String getCountryAnimalLives()
	{
		return countryAnimalLives;
	}

	public double getOwnerPaid()
	{
		return ownerPaid;
	}

	//Methods
	public String getFormalName()
	{
		return title + " " + owner.split(" ")[1];
	}

	//Override Methods
}