package p;

import java.util.*;
import java.io.*;
import java.security.*;

public class Athlete implements Comparable<Athlete>
{
	//Variables
	private String athleteID, athleteName, athleteBornIn, team;
	private int age, yearsOnTeam;
	private double salary;
	private boolean currentlyInjured;

	//Constructors
	public Athlete()
	{

	}

	public Athlete clone()
	{
		return new Athlete(this);
	}

	public Athlete(Athlete x)
	{	
		this(x.getAthleteID(), x.getAthleteName(), x.getAthleteBornIn(), x.getTeam(), x.getAge(), x.getYearsOnTeam(), x.getSalary(), x.getCurrentlyInjured());
	}

	public Athlete(String athleteID, String athleteName, String athleteBornIn, String team, int age, int yearsOnTeam, double salary, boolean currentlyInjured)
	{
		setAthleteID(athleteID);
		setAthleteName(athleteName);
		setAthelteBornIn(athleteBornIn);
		setTeam(team);
		setAge(age);
		setYearsOnTeam(yearsOnTeam);
		setSalary(salary);
		setCurrentlyInjured(currentlyInjured);
	}

	public Athlete(String[] properties)
	{
		this(properties[0].replaceAll("athleteID:", ""), 
			 properties[1].replaceAll("athleteName:", ""),
			 properties[2].replaceAll("athleteBornIn:", ""), 
			 properties[4].replaceAll("teamName:", ""), 
			 Integer.parseInt(properties[3].replaceAll("age:", "")),
			 Integer.parseInt(properties[5].replaceAll("yearsOnTeam:", "")),
			 Double.parseDouble((properties[6].replaceAll("salary:", "")).replace("$", "")), 
			 Boolean.parseBoolean(properties[7].replaceAll("currentlyInjured:", ""))
			);
	}

	public Athlete(String s)
	{
		this(s.split(","));
	}

	public Athlete(RandomAccessFile raf) throws Exception
	{
		this(raf.readLine());
	}

	public Athlete(Scanner input) throws Exception
	{
		this(input.nextLine());
	}

	//Getter's and Setter's
	public void setAthleteID(String id)
	{
		athleteID = id;
	}

	public void setAthleteName(String name)
	{
		athleteName = name;
	}

	public void setAthelteBornIn(String place)
	{
		athleteBornIn = place;
	}

	public void setTeam(String community)
	{
		team = community;
	}

	public void setAge(int number)
	{
		if(number > 0 && number <= 100)
		{
			age = number;
		}else
		{
			throw new InvalidParameterException(number + " is not possible.");
		}
	}

	public void setYearsOnTeam(int time)
	{
		yearsOnTeam = time;
	}

	public void setSalary(double money)
	{
		salary = money;
	}

	public void setCurrentlyInjured(boolean hospital)
	{
		currentlyInjured = hospital;
	}

	public String getAthleteID()
	{
		return athleteID;
	}

	public String getAthleteName()
	{
		return athleteName;
	}

	public String getAthleteBornIn()
	{
		return athleteBornIn;
	}

	public String getTeam()
	{
		return team;
	}

	public int getAge()
	{
		return age;
	}

	public int getYearsOnTeam()
	{
		return yearsOnTeam;
	}

	public double getSalary()
	{
		return salary;
	}

	public boolean getCurrentlyInjured()
	{
		return currentlyInjured;
	}

	//Methods
	public String getFormalName()
	{
		String firstName = athleteName.split(" ")[0];
		String lastName = athleteName.split(" ")[1];
		return lastName + ", " + firstName;
	}

	public String sortString()
	{
		return team + " " + athleteBornIn + " " + athleteName;
	}

	public void save(RandomAccessFile raf) throws Exception
	{
		raf.writeChars("Athlete ID: " + athleteID);
		raf.writeChars("Athlete Name: " + athleteName);
		raf.writeChars("Athlete Place of Birth: " + athleteBornIn);
		raf.writeChars("Athlete Team: " + team);
		raf.writeInt(age);
		raf.writeInt(yearsOnTeam);
		raf.writeDouble(salary);
		raf.writeBoolean(currentlyInjured);
	}

	public void save(PrintWriter pw) throws Exception
	{
		pw.write("Athlete ID: " + athleteID);
		pw.write("Athlete Name: " + athleteName);
		pw.write("Athlete Place of Birth: " + athleteBornIn);
		pw.write("Athlete Team: " + team);
		pw.write(Integer.toString(age));
		pw.write(Integer.toString(yearsOnTeam));
		pw.write(Double.toString(salary));
		pw.write(Boolean.toString(currentlyInjured));
	}

	//Override Methods
	@Override
	public boolean equals(Object n)
	{
		if(!(n instanceof Athlete))
		{
			return false;
		}

		Athlete x = (Athlete) n;

		return getSalary() == x.getSalary() &&
			   getAge() == x.getAge() &&
			   getYearsOnTeam() == x.getYearsOnTeam() &&
			   getTeam().equalsIgnoreCase(x.getTeam()) &&
			   getAthleteName().equalsIgnoreCase(x.getAthleteName()) &&
			   getAthleteID().equalsIgnoreCase(x.getAthleteID()) &&
			   getAthleteBornIn().equalsIgnoreCase(x.getAthleteBornIn()) &&
			   getCurrentlyInjured() == x.getCurrentlyInjured();

	}

	@Override
	public int compareTo(Athlete x)
	{
		return this.sortString().compareTo(x.sortString());
	}

	@Override
	public String toString()
	{
		return "Athlete ID: " + athleteID + "\n" +
			   "Athlete Name: " + athleteName + "\n" +
			   "Athlete Place of Birth: " + athleteBornIn + "\n" +
			   "Athlete Team: " + team + "\n" +
			   "Athlete Age: " + age + "\n" +
			   "Athlete Tenure: " + yearsOnTeam + "\n" +
			   "Athlete Salary: " + salary + "\n" +
			   "Athlete Injury Status: " + currentlyInjured + "\n";
	}
}