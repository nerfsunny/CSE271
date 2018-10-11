package p;

import java.util.*;
import java.io.*;
import java.security.*;

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
		this(properties[0].replaceAll("recordId:", ""),
			 properties[1].replace("animal:", ""),
			 properties[2].replace("owner:", ""),
			 properties[3].replace("title:", ""),
			 properties[4].replace("countryAnimalLives:", ""),
			 Double.parseDouble( (properties[5].replace("ownerPaid:", "") ).replace("$", "") )
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

	public Animal(Scanner input) throws Exception
	{
		this(input.nextLine());
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

			this.animal = (b + " " + a).toLowerCase();
		}else
		if(animal.contains(" (unidenfied)"))
		{
			this.animal = (animal.replace("(unidenfied", "")).toLowerCase();
		}else
		{
			this.animal = animal.toLowerCase();
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

	public String sortString()
	{
		return animal + " " + owner + " " + recordID; 
	}

	public void save(RandomAccessFile raf) throws Exception
	{
		raf.writeChars("ID: " + recordID);
		raf.writeChars("Animal: " + animal);
		raf.writeChars("Owner: " + owner);
		raf.writeChars("Title: " + title);
		raf.writeChars("Animal's Country of Residence: " + countryAnimalLives);
		raf.writeDouble(ownerPaid);
	}

	public void save(PrintWriter pw)
	{
		pw.write("ID: " + recordID);
		pw.write("Animal: " + animal);
		pw.write("Owner: " + owner);
		pw.write("Title: " + title);
		pw.write("Animal's Country of Residence: " + countryAnimalLives);
		pw.write(Double.toString(ownerPaid));
	}

	//Override Methods
	@Override
	public int compareTo(Animal a)
	{
		return this.sortString().compareTo(a.sortString());
	}

	@Override
	public String toString()
	{
		return "Record ID: " + recordID + "\n" +
			   "Animal: " + animal + "\n" +
			   "Owner: " + owner + "\n" +
			   "Title: " + title + "\n" +
			   "Animal's Residence: " + countryAnimalLives + "\n" +
			   "Amount Paid: " + ownerPaid + "\n";
	}

	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Animal))
		{
			return false;
		}

		Animal a = (Animal) o;

		return  this.getCountryAnimalLives().equalsIgnoreCase(a.getCountryAnimalLives()) &&
				this.getRecordID().equalsIgnoreCase(a.getRecordID()) &&
				this.getAnimal().equalsIgnoreCase(a.getAnimal()) &&
				this.getTitle().equalsIgnoreCase(a.getTitle()) &&
				this.getOwner().equalsIgnoreCase(a.getOwner()) &&
				this.getOwnerPaid() == a.getOwnerPaid();
	}
}