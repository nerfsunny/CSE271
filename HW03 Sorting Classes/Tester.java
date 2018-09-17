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

	public static void findWimmerRoth(ArrayList<Student> students)
	{
		String name = null;
		double gpa = 0.0;

		for(Student s : students)
		{
			if(s.getFirstName().equalsIgnoreCase("wimmer") && s.getLastName().equalsIgnoreCase("roth"))
			{
				name = s.getFirstName() + " " + s.getLastName();
				gpa = s.getGPA();
			}
		}

		System.out.printf("%s \t %.2f", name, gpa);
	}

	public static void main(String args[])
	{
		ArrayList<Student> listOfStudents = new ArrayList<Student>(); //Contains all of the listed students in the text file
		ArrayList<Double> listOfSpecifiedCalculations = new ArrayList<Double>(); //Contains the average GPA for the requested categories
		Student s = null;
		RandomAccessFile raf = null;

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

		for(Student z : listOfStudents)
		{
			System.out.println(z.allData());
		}
	}
}