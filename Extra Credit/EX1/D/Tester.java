import p.*;
import java.util.*;
import java.io.*;
import java.security.*;

public class Tester
{
	public static String returnAnimal(HashMap<String, Animal> list, String id)
	{
		String animal = null;

		if(list.containsKey(id) == false)
		{
			return "There is no animal with id " + id + " in the database";
		}

		for(Animal x : list.values())
		{
			if(x.getRecordID().equalsIgnoreCase(id))
			{
				animal = x.toString();
			}
		}

		return animal;
	}

	public static void printSpecificCase(HashMap<String, Animal> list, String id1, String id2)
	{
		for(Animal x : list.values())
		{
			if(x.getTitle().equalsIgnoreCase(id1) && x.getCountryAnimalLives().equalsIgnoreCase(id2))
			{
				System.out.println(x.toString());
			}
		}
	}

	public static double calculateTotal(HashMap<String, Animal> list, String country)
	{
		double total = 0.0;

		for(Animal x : list.values())
		{
			if(x.getCountryAnimalLives().equalsIgnoreCase(country))
			{
				total = total + x.getOwnerPaid();
			}
		}

		return total;
	}

	public static void main(String args[])
	{
		HashMap<String, Animal> database = new HashMap<String, Animal>();
		RandomAccessFile raf = null;
		Animal an = null;
		String specificID = "06fbbe0c-08a2-4f0e-bd61-1a7eefcbd5ef";

		try
		{
			raf = new RandomAccessFile("Exam_01-D.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				an = new Animal(raf);

				if(database.containsKey(an.getRecordID()) == true)
				{
					System.out.println("Duplicate Key: " + an.toString());
				}else
				if(database.containsKey(an.getRecordID()) == false)
				{
					database.put(an.getRecordID(), an);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				raf.close();
			}catch(Exception d)
			{
				d.printStackTrace();
			}
		}

		System.out.println(returnAnimal(database, specificID));
		System.out.println("Animals and Owner (with Dr title) currently residing in France: ");
		printSpecificCase(database, "Dr", "France");
		System.out.printf("%s %7.2f \n", "Total Monetary Value of Animals currently residing in China:", calculateTotal(database, "China"));
	}
}