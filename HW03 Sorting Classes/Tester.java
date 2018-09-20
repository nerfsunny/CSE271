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
	/*public static double averageGPAForAllMaleStudents(ArrayList<Student> students)
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
	}*/

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

		System.out.printf("%s %s \t %.2f \n", studentName + "'s", "GPA: ", gpa);
	}

	public static void writeToFile(ArrayList<Student> students, PrintWriter pw, int c)
	{
		if(c == 1)
		{
			try
			{
				pw = new PrintWriter("originalWay.txt");

				for(Student b : students)
				{
					pw.println(b.toString());
				}
			}catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			}finally
			{
				if(pw != null)
				{
					pw.close();
				}
			}
		}else
		if(c == 2)
		{
			try
			{
				pw = new PrintWriter("originalWay2.txt");

				for(Student b : students)
				{
					pw.println(b.toString());
				}
			}catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			}finally
			{
				if(pw != null)
				{
					pw.close();
				}
			}
		}
	}

	/*public static ArrayList<String> getListOfUniversitiesWithMoreThan1Student(ArrayList<Student> students)
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
	}*/

	public static void main(String args[])
	{
		ArrayList<Student> listOfStudents = new ArrayList<Student>(); //Contains all of the listed students in the text file
		ArrayList<Student> testCase = new ArrayList<Student>();
		ArrayList<String> listOfUniversities = null; //contains a list of universities with more than one student in the given list
		Student s = null;
		RandomAccessFile raf = null;
		PrintWriter pw = null;
		String specificName = "Harbron Louella";

		try
		{
			raf = new RandomAccessFile("HW-03_Data.txt", "r");
			raf.readLine();

			while(raf.getFilePointer() < raf.length())
			{
				s = new Student(raf.readLine());
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

		
		//writeToFile(listOfStudents, pw, 1);
		Collections.sort(listOfStudents);
		//writeToFile(listOfStudents, pw, 2);

		/*System.out.printf("%s \t %.2f \n", "Average Male GPA: ", averageGPAForAllMaleStudents(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Female GPA: ", averageGPAForAllFemaleStudents(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Freshman GPA: ", averageGPAForFreshman(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Sophomore GPA: ", averageGPAForSophomore(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Junior GPA: ", averageGPAForJunior(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Senior GPA: ", averageGPAForSenior(listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Graduate Student GPA: ", averageGPAForGraduateStudent(listOfStudents));*/

		System.out.printf("%s \t %.2f \n", "Average Male GPA: ", averageGPA("male", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Female GPA: ", averageGPA("female", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Freshman GPA: ", averageGPA("freshman", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Sophomore GPA: ", averageGPA("sophomore", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Junior GPA: ", averageGPA("junior", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Senior GPA: ", averageGPA("senior", listOfStudents));
		System.out.printf("%s \t %.2f \n", "Average Graduate Student GPA: ", averageGPA("graduate student", listOfStudents));
		findSpecificStudent(specificName, listOfStudents);
	}
}