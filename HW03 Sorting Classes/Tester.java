/*
 * Homework – 03 
 * Due: Thursday, 09-20-2018 by 11:59 pm
 *
 * @Sundeep Vaswani (vaswansk)
 *
 */

import people.*;
import java.util.*;
import java.io.*;

public class Tester
{
	public static double averageGPAForAllMaleStudents(ArrayList<Student> students)
	{
		int male = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getGender().equalsIgnoreCase("male"))
			{
				gpa = gpa + s.getGPA();
				male++;
			}
		}

		return gpa/male;
	}

	public static double averageGPAForAllFemaleStudents(ArrayList<Student> students)
	{
		int female = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getGender().equalsIgnoreCase("female"))
			{
				gpa = gpa + s.getGPA();
				female++;
			}
		}

		return gpa/female;
	}

	public static double averageGPAForFreshman(ArrayList<Student> students)
	{
		int freshman = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getYearInSchool().equalsIgnoreCase("freshman"));
			{
				gpa = gpa + s.getGPA();
				freshman++;
			}
		}

		return gpa/freshman;
	}

	public static double averageGPAForSophomore(ArrayList<Student> students)
	{
		int sophomore = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getYearInSchool().equalsIgnoreCase("sophomore"));
			{
				gpa = gpa + s.getGPA();
				sophomore++;
			}
		}

		return gpa/sophomore;
	}

	public static double averageGPAForJunior(ArrayList<Student> students)
	{
		int junior = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getYearInSchool().equalsIgnoreCase("junior"));
			{
				gpa = gpa + s.getGPA();
				junior++;
			}
		}

		return gpa/junior;
	}

	public static double averageGPAForSenior(ArrayList<Student> students)
	{
		int senior = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getYearInSchool().equalsIgnoreCase("senior"));
			{
				gpa = gpa + s.getGPA();
				senior++;
			}
		}

		return gpa/senior;
	}

	public static double averageGPAForGraduateStudent(ArrayList<Student> students)
	{
		int graduateStudent = 0;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getYearInSchool().equalsIgnoreCase("graduate student"));
			{
				gpa = gpa + s.getGPA();
				graduateStudent++;
			}
		}

		return gpa/graduateStudent;
	}

	public static void findSpecificStudent(String name, ArrayList<Student> students)
	{
		String firstName = (name.split(" "))[1];
		String lastName = (name.split(" "))[0];
		String studentName = null;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getFirstName().equalsIgnoreCase(firstName) && s.getLastName().equalsIgnoreCase(lastName))
			{
				studentName = s.getLastName() + " " + s.getFirstName();
				gpa = s.getGPA();
			}
		}

		System.out.printf("%s %s \t %.2f \n", studentName + "'s", "GPA: ", gpa);
	}

	public static ArrayList getListOfUniversities(ArrayList<Student> students)
	{
		ArrayList <String> listOfUniversities = new ArrayList<String>();
		int counter = 0;
		int arrayListSize = 0;
		String university;

		for(Student s : students)
		{
			university = s.getUniversity();

			for(int i = 0; i < listOfUniversities.size(); i++)
			{
				if( !( university.equalsIgnoreCase( listOfUniversities.get(i) ) ) )
				{
					counter++;
				}
			}

			if(counter == arrayListSize)
			{
				listOfUniversities.add(university);
			}
		}

		return listOfUniversities;
	}

	public static void main(String args[])
	{
		ArrayList<Student> listOfStudents = new ArrayList<Student>(); //Contains all of the listed students in the text file
		ArrayList<Student> listOfUniversities = null;
		//ArrayList<Double> listOfSpecifiedCalculations = new ArrayList<Double>(); //Contains the average GPA for the requested categories
		Student s = null;
		RandomAccessFile raf = null;
		String specificName = "Harbron Louella";

		try
		{
			raf = new RandomAccessFile("HW-03_Data.txt", "r");
			raf.readLine();

			while(raf.getFilePointer() < raf.length())
			{
				String[] studentDataArray = raf.readLine().split("\t");
				s = new Student(studentDataArray);
				listOfStudents.add(s);
			}
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			try
			{
				raf.close();
			} catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		listOfUniversities = getListOfUniversities(listOfStudents);

		System.out.printf("%s \t %.2f \n", "Average Male GPA: ", averageGPAForAllMaleStudents(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Female GPA: ", averageGPAForAllFemaleStudents(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Freshman GPA: ", averageGPAForFreshman(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Sophomore GPA: ", averageGPAForSophomore(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Junior GPA: ", averageGPAForJunior(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Senior GPA: ", averageGPAForSenior(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Graduate Student GPA: ", averageGPAForGraduateStudent(listOfStudents));
		findSpecificStudent(specificName, listOfStudents);
	}
}