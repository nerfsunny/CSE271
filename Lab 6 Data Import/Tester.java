/*
 * 
 * Date: 11/01/2018
 * Name: Sundeep Vaswani (vaswansk)
 * 
 * 
 * 
 */

import p.*;
import java.util.*;
import java.io.*;

public class Tester 
{
	public static String getStringMonth(Person p)
	{
		String temp = p.getDate().split("/")[0];
		String month;

		switch(temp)
		{
			case "01":
				month = "January";
				break;
			case "02":
				month = "February";
				break;
			case "03":
				month = "March";
				break;
			case "04":
				month = "April";
				break;
			case "05":
				month = "May";
				break;
			case "06":
				month = "June";
				break;
			case "07":
				month = "July";
				break;
			case "08":
				month = "August";
				break;
			case "09":
				month = "September";
				break;
			case "10":
				month = "October";
				break;
			case "11":
				month = "November";
				break;
			case "12":
				month = "December";
				break;
			default:
				month = "None";
				break;
		}

		return month;
	}

	public static String getStringYear(Person p)
	{
		return p.getDate().split("/")[2];
	}

	public static void getFastetTime(HashMap<String, ArrayList<Person>> temp)
	{
		ArrayList<Person> runners = temp.get("Running");
		Person fastest = null;

		System.out.println("");

		for(int i = runners.size() - 1; i >= 0; i--)
		{
			Person p = runners.get(i);

			if(p.convertTimeDuration() <= 0)
			{
				runners.remove(i);
			}
		}

		fastest = runners.get(0);

		for(Person x : runners)
		{
			if(x.getDistance() >= 10.0 && x.convertTimeDuration() > 0 && x.convertTimeDuration() < fastest.convertTimeDuration())
			{
				fastest = x;
			}
		}

		System.out.println("The fastest 10 mile was " + fastest.getDuration() + " on " + fastest.getDate());
	}
	
	public static void totalMilesByShoe(HashMap<String, ArrayList<Person>> temp)
	{
		HashMap<String, Double> shoes = new HashMap<String, Double>();
		
		for(ArrayList<Person> list : temp.values())
		{
			for(Person p : list)
			{
				if(shoes.containsKey(p.getShoes()))
				{
					double newValue = shoes.get(p.getShoes());
					newValue = newValue + p.getDistance();
					shoes.replace(p.getShoes(), newValue);
				}else
				{
					shoes.put(p.getShoes(), p.getDistance());
				}
			}
		}

		double temporary = shoes.get("");
		shoes.remove("", shoes.get(""));
		shoes.put("Other Brands", temporary);

		for(String shoeName : shoes.keySet())
		{
			System.out.printf("%s %-32s \t %s %.2f \n", "Shoes:", shoeName, "Total Distance:", shoes.get(shoeName));
		}
	}
	
	public static void calculateMilesByMonthYear(HashMap<String, ArrayList<Person>> temp)
	{
		HashMap<String, HashMap<String, Double> > lists = new HashMap<String, HashMap<String, Double> >();

		for(ArrayList<Person> list : temp.values())
		{
			for(Person p : list)
			{
				if(lists.containsKey( getStringYear( p ) ) )
				{
					if(lists.get( getStringYear( p ) ).containsKey( getStringMonth( p ) ) )
					{
						HashMap<String, Double> buffer = lists.get( getStringYear( p ) );
						double newValue = buffer.get( getStringMonth( p ) );

						newValue = newValue + p.getDistance();

						buffer.replace(getStringMonth( p ), newValue );
						lists.replace(getStringYear(p), buffer);
					}else
					{
						lists.get( getStringYear(p) ).put(getStringMonth(p), p.getDistance() );
					}
				}else
				{
					lists.put( getStringYear( p ), new HashMap<String, Double>() );
				}
			}
		}

		for(String year : lists.keySet())
		{
			HashMap<String, Double> months = lists.get(year);

			System.out.println("");
			System.out.println("Year: " + year);

			for(String month : months.keySet())
			{
				System.out.printf("\t %s %.2f \n", month + ":", months.get(month));
			}
		}
	}
	
	public static void main(String[] args)
	{
		HashMap<String, ArrayList<Person>> athletes = new HashMap<String, ArrayList<Person>>();
		RandomAccessFile raf = null;
		Person p = null;
		
		try
		{
			raf = new RandomAccessFile("Lab-06_DataImport.txt", "r");
			raf.readLine();
			
			while(raf.getFilePointer() < raf.length())
			{
				p = new Person(raf);
				
				if(athletes.containsKey(p.getActivity()))
				{
					athletes.get(p.getActivity()).add(p);
				}else
				{
					athletes.put(p.getActivity(), new ArrayList<Person>());
					athletes.get(p.getActivity()).add(p);
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

		totalMilesByShoe(athletes);
		calculateMilesByMonthYear(athletes);
		getFastetTime(athletes);
	}
}