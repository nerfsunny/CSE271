import p.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Tester
{
	public static String GetAthlete(HashMap<String, Athlete> list, String id)
	{
		String athlete = null;

		if(list.containsKey(id) == false)
		{
			return "There is no Athlete that has that Athlete ID";
		}

		for(Athlete x : list.values())
		{
			if(x.getAthleteID().equalsIgnoreCase(id))
			{
				if(x.getAge() < 20)
				{
					System.out.println("Athlete " + x.getAthleteName() + " is underaged." + " Age: " + x.getAge());
					athlete = x.toString();
				}else
				{
					athlete = x.toString();
				}
			}
		}

		return athlete;
	}

	public static double getSalary(HashMap<String, Athlete> list, String team, int age)
	{
		double totalSalary = 0.0;

		for(Athlete x : list.values())
		{
			if((x.getAge() >= age) && (x.getAge() < age + 10) && (x.getTeam().equalsIgnoreCase(team)))
			{
				totalSalary = totalSalary + x.getSalary();
			}
		}

		return totalSalary;
	}

	public static void teamAndState(HashMap<String, Athlete> list, String team, String birth)
	{
		for(Athlete x : list.values())
		{
			if(x.getTeam().equalsIgnoreCase(team) && x.getAthleteBornIn().equalsIgnoreCase(birth))
			{
				if(x.getAge() < 20)
				{
					System.out.println("Athlete " + x.getAthleteName() + " is underaged." + " Age: " + x.getAge());
					System.out.println(x.toString());
				}else
				{
					System.out.println(x.toString());
				}
			}
		}
	}

	public static void main(String args[])
	{
		HashMap<String, Athlete> listOfAthletes = new HashMap<String, Athlete>();
		Athlete person = null;
		RandomAccessFile raf = null;
		int injuredPlayers = 0;
		String specificID = "85da6bad-48bd-4bd8-85bb-61970e1f53eb";

		try
		{
			raf = new RandomAccessFile("Exam_01-E.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				String line = raf.readLine();
				person = new Athlete(line);

				if(person.getCurrentlyInjured() == true)
				{
					injuredPlayers++;
				}
				
				if(listOfAthletes.containsKey(person.getAthleteID()) == true)
				{
					if(person.getAge() < 20)
					{
						System.out.println("Athlete " + person.getAthleteName() + " is underaged." + " Age: " + person.getAge());
						System.out.println("Duplicate Record: " + person.toString());
					}else
					{
						System.out.println("Duplicate Record: " + person.toString());
					}
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

		System.out.println("List of Athletes size: " + listOfAthletes.size() + "\n");
		System.out.println("Number of Injured Players: " + injuredPlayers + "\n");
		System.out.println(GetAthlete(listOfAthletes, specificID) + "\n");
		System.out.printf("%s %7.2f \n \n" ,"The total salary of 30-39 year olds on the Cincinnati Bengals team:", getSalary(listOfAthletes, "Cincinnati Bengals", 30));
		System.out.println("List of players born in Ohio and play for the Arizona Cardinals: ");
		teamAndState(listOfAthletes, "Arizona Cardinals", "Ohio");
	}
}