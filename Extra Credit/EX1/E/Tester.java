import p.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Tester
{
	public static int numberOfAthletesInjured(HashMap<String, Athlete> list)
	{
		int count = 0;

		for(Athlete x : list.values())
		{
			if(x.getCurrentlyInjured() == true)
			{
				count++;
			}
		}

		return count;
	}

	public static void main(String args[])
	{
		HashMap<String, Athlete> listOfAthletes = new HashMap<String, Athlete>();
		HashMap<String, Athlete> listOfDuplicateAthletes = new HashMap<String, Athlete>();
		Athlete person = null;
		RandomAccessFile raf = null;

		try
		{
			raf = new RandomAccessFile("Exam_01-E.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				String line = raf.readLine();
				person = new Athlete(line);
				
				if(listOfAthletes.containsKey(person.getAthleteID()) == true)
				{
					listOfDuplicateAthletes.put(person.getAthleteID(), person);
				}else
				if(listOfAthletes.containsKey(person.getAthleteID()) == false)
				{
					listOfAthletes.put(person.getAthleteID(), person);
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
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("List of Athletes size: " + listOfAthletes.size());
		System.out.println("List of Athletes with Duplicate IDs: " + listOfDuplicateAthletes.size());
		System.out.println(numberOfAthletesInjured(listOfAthletes));
	}
}