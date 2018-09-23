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
	public static double averageGPA(String specificString, ArrayList<Student> students)
	{
		int counter = 0;
		double gpa = 0.0;

		if(specificString.equalsIgnoreCase("male") || specificString.equalsIgnoreCase("female"))
		{
			for(Student x : students)
			{
				if(x.getGender().equalsIgnoreCase(specificString))
				{
					counter++;
					gpa = gpa + x.getGPA();
				}
			}
		}else
		if(specificString.equalsIgnoreCase("freshman") || specificString.equalsIgnoreCase("sophomore") || specificString.equalsIgnoreCase("junior") || specificString.equalsIgnoreCase("senior") || specificString.equalsIgnoreCase("graduate student"))
		{
			for(Student x : students)
			{
				if(x.getYearInSchool().equalsIgnoreCase(specificString))
				{
					counter++;
					gpa = gpa + x.getGPA();
				}
			}
		}

		return gpa/counter;
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

		System.out.printf("%s %-12s %.2f \n \n", studentName + "'s", "GPA:", gpa);
	}

	public static double averageGenderUniversityGPA(ArrayList<Student> students, String university, String gender)
	{
		int counter = 0;
		double gpa = 0.0;

		for(Student y : students)
		{
			if(y.getGender().equalsIgnoreCase(gender) && y.getUniversity().equalsIgnoreCase(university))
			{
				counter++;
				gpa = gpa + y.getGPA();
			}
		}

		if(counter == 0)
		{
			return 0;
		}else
		{
			return gpa/counter;
		}
	}

	public static ArrayList<String> getListOfUniversitiesWithMoreThan1Student(ArrayList<Student> students)
	{
		ArrayList <String> listOfUniversities = new ArrayList<String>(); //contains list of universities with more than one student
		int counter = 0; //counts how many instances a certain university shows up in a list of students
		String university;
		boolean check = false;

		for(Student s : students)
		{
			university = s.getUniversity();

			for(Student x : students)
			{
				if(x.getUniversity().equalsIgnoreCase(university))
				{
					counter++;
				}
			}

			if(counter > 1)
			{
				for(int i = 0; i < listOfUniversities.size(); i++)
				{
					if(university.equalsIgnoreCase(listOfUniversities.get(i)))
					{
						check = true;
						break;
					}
				}

				if(check == false)
				{
					listOfUniversities.add(university);
				}

				check = false;
			}

			counter = 0;
		}

		return listOfUniversities;
	}

	public static void main(String args[])
	{
		ArrayList<Student> listOfStudents = new ArrayList<Student>(); //Contains all of the listed students in the text file
		ArrayList<String> listOfUniversities = null; //contains a list of universities with more than one student in the given list
		ArrayList<Double> scores = new ArrayList<Double>();
		Student s = null;
		RandomAccessFile raf = null;
		String specificName = "Harbron Louella";
		int counter = 0;

		try
		{
			raf = new RandomAccessFile("HW-03_Data.txt", "r");
			raf.readLine();

			while(raf.getFilePointer() < raf.length())
			{
				s = new Student(raf);
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

		Collections.sort(listOfStudents);
		listOfUniversities = getListOfUniversitiesWithMoreThan1Student(listOfStudents);

		for(String university : listOfUniversities)
		{
			scores.add(averageGenderUniversityGPA(listOfStudents, university, "male"));
			scores.add(averageGenderUniversityGPA(listOfStudents, university, "female"));
		}

		System.out.println("City | State Code | Zip Code | University | Last Name");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(listOfStudents.get(i).sortByCity());
		}

		System.out.println("");

		System.out.printf("%-30s %.2f \n", "Average Male GPA:", averageGPA("male", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Female GPA:", averageGPA("female", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Freshman GPA:", averageGPA("freshman", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Sophomore GPA:", averageGPA("sophomore", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Junior GPA:", averageGPA("junior", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Senior GPA:", averageGPA("senior", listOfStudents));
		System.out.printf("%-30s %.2f \n", "Average Graduate Student GPA:", averageGPA("graduate student", listOfStudents));
		findSpecificStudent(specificName, listOfStudents);

		for(String university : listOfUniversities)
		{
			System.out.println(university);
			System.out.printf("%s %.2f %s %.2f \n \n", "Average Male GPA:", scores.get(counter), "Average Female GPA:", scores.get(counter+1));
			counter = counter + 2;
		}
		
	}
}