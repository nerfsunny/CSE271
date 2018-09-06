/*
 * Homework - 01
 * Due: 09-02-2018 by 11:59 pm
 * File IO using Scanner and PrintWriter
 * 
 * 
 *	@Sundeep Vaswani (vaswansk)
 * 
 */

import java.util.*;
import java.io.*;

public class Tester
{
	public static void writeToFile(PrintWriter pw, ArrayList score, ArrayList name)
	{
		try
		{
			pw = new PrintWriter("studentNamesAndScores.txt");

			for(int i = 0; i < name.size(); i++)
			{
				pw.println(name.get(i));

				for(int j = 0; j < 4; j++)
				{
					pw.println(score.get(j));
				}

				for(int k = 0; k < 4; k++)
				{
					score.remove(0);
				}
			}

		}catch (Exception x)
		{
			System.out.println("Error: " + x.getMessage());
		} finally
		{
			if(pw != null)
			{
				pw.close();
			}
		}
	}

	public static void readFromFile(Scanner in)
	{
		ArrayList<Double> oldAverageScore = new ArrayList<Double>();
		ArrayList<Double> newAverageScore = new ArrayList<Double>();
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		ArrayList<String> listOfNames = new ArrayList<String>();
		double difference = 0;
		String letter = null;
		int index = 0;

		try
		{
			in = new Scanner(new File("studentNamesAndScores.txt"));

			while(in.hasNextLine())
			{
				listOfNames.add(in.nextLine());

				for(int i = 0; i < 4; i++)
				{
					buffer.add(Integer.parseInt(in.nextLine()));
				}

				oldAverageScore.add(averageScore(buffer));
				index = findLowestScore(buffer);
				buffer.remove(index);
				newAverageScore.add(averageScore(buffer));

				buffer.clear();
			} 
		} catch (Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			} finally
			{
				if(in != null)
				{
					in.close();
				}
			}

		System.out.println("Name | Average (Old) | Average (New) | Difference | Letter Grade");

		for(int e = 0; e < listOfNames.size(); e++)
		{
			difference = newAverageScore.get(e) - oldAverageScore.get(e);
			letter = letterGrade(newAverageScore.get(e));
			System.out.println(listOfNames.get(e) + " | " + oldAverageScore.get(e) + " | " + newAverageScore.get(e) + " | " + difference + " | " + letter);
		}

	}

	public static Double averageScore(ArrayList<Integer> a)
	{
		double score = 0;

		for(int i = 0; i < a.size(); i++)
		{
			score = score + a.get(i);
		}

		return score/(a.size());
	}

	public static Integer getInt(Scanner in)
	{
		while(true)
		{
			try
			{
				int score = Integer.parseInt(in.nextLine());

				if(score < 0 || score > 100)
				{
					return 1/0;	
				}else
				{
					return score;
				}
			}catch(Exception x)
			{
				System.out.println("Invalid score. Please try again.");
			}
		}
	}

	public static Integer findLowestScore(ArrayList<Integer> a) //finds the index for the lowest score for the student and returns it so that it can be removed
	{
		int x, z = 0;

		for(int i = 0; i < a.size(); i++)
		{
			x = a.get(i);
			z = i;
			a.remove(i);

			if(x <= a.get(0) && x <= a.get(1) && x <= a.get(2))
			{
				a.add(z, x);
				break;
			}

			a.add(z, x);
		}

		return z;
	}

	public static String letterGrade(double a)
	{
		if(a >= 90 && a <= 100)
		{
			return "A";
		}else
		if(a >= 80 && a < 90)
		{
			return "B";
		}else
		if(a >= 70 && a < 80)
		{
			return "C";
		}else
		if(a >= 60 && a < 70)
		{
			return "D";
		}else
		{
			return "F";
		}
	}

	public static void main(String args[])
	{
		//Initializing
		Scanner scan = new Scanner(System.in);
		PrintWriter prw = null;
		ArrayList<Integer> buffer = new ArrayList<Integer>(); //temporary list to hold and manipulate values
		ArrayList<String> listOfNames = new ArrayList<String>(); //contains list of student names
		String name, response = null;
		boolean status = false;
		int check = 0;

		while(status == false)
		{
			System.out.println("Enter the name of a student: ");
			name = scan.nextLine();
			listOfNames.add(name);

			for(int i = 0; i < 4; i++)
			{
				System.out.print("Please enter score " + (i + 1) + ": ");
				buffer.add(getInt(scan));
			}

			while(check == 0)
			{
				System.out.println("Are you done entering your student's scores? (Enter \"done\" if you are; otherwise enter \"no\" to enter another student's name and scores.");
				response = scan.nextLine();

				if(response.equalsIgnoreCase("done"))
				{
					System.out.println("Alright.");
					status = true;
					check = 1;
				}else
				if(response.equalsIgnoreCase("no"))
				{
					System.out.println("Alright. Please prepare the data of another student.");
					check = 2;
				}else
				{
					System.out.println("I'm sorry, I didn't quite get that. Could you type that again?");
				}
			}

			check = 0;
		}

		writeToFile(prw, buffer, listOfNames);
		readFromFile(scan);
	}
}