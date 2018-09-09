/*
 * Homework - 02
 * Due: 09-09-2018 by 11:59 pm
 * File IO using RandomAccessFile and OOP
 * 
 * @Sundeep Vaswani (vaswansk)
 * 
 */

import pack.*;
import java.util.*;
import java.io.*;

public class Tester
{
	public static double averageMaleScore(ArrayList<Student> scores) //Computes the total average score for all male students
	{
		double average = 0;
		int counter = 0;

		for(Student s : scores)
		{
			if(s.getGender().equalsIgnoreCase("male"))
			{
				counter++;
				average = average + s.getAverage();
			}
		}

		return average/counter;
	}

	public static double averageFemaleScore(ArrayList<Student> scores) //Computes the total average score for all female students
	{
		double average = 0;
		int counter = 0;

		for(Student s : scores)
		{
			if(s.getGender().equalsIgnoreCase("female"))
			{
				counter++;
				average = average + s.getAverage();
			}
		}

		return average/counter;
	}

	public static void main(String args[])
	{
		RandomAccessFile raf = null;
		Student s = null;
		ArrayList <Student> studentNamesAndAverages = new ArrayList <Student>();

		int maleGradeA = 0, maleGradeB = 0, maleGradeC = 0, maleGradeD = 0, maleGradeF = 0; //serves to count all of the male students who have a certain letter grade (in this case A, B, C, D, F)
		int femaleGradeA = 0, femaleGradeB = 0, femaleGradeC = 0, femaleGradeD = 0, femaleGradeF = 0; //serves to count all of the female students who have a certain letter grade (in this case A, B, C, D, F)
		String grade;
		
		try
		{
			raf = new RandomAccessFile("students2.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				s = new Student();
				String[] parts = raf.readLine().split("\t");

				s.setName(parts[0]);
				s.setGender(parts[1]);
				s.setAverage(Double.parseDouble(parts[2]));

				studentNamesAndAverages.add(s);
			}
		}catch (Exception error)
		{
			System.out.println(error.getMessage());
		}finally
		{
			try
			{
				raf.close();
			}catch (Exception error2)
			{
				System.out.println(error2);
			}
		}

		for(Student a : studentNamesAndAverages)
		{
			if(a.getGender().equalsIgnoreCase("male"))
			{
				grade = a.getLetterGrade();

				switch (grade)
					{
						case "A":
							maleGradeA++;
							break;
						case "B":
							maleGradeB++;
							break;
						case "C":
							maleGradeC++;
							break;
						case "D":
							maleGradeD++;
							break;
						case "F":
							maleGradeF++;
							break;
					}
			}else
			if(a.getGender().equalsIgnoreCase("female"))
			{
				grade = a.getLetterGrade();

				switch (grade)
				{
					case "A":
						femaleGradeA++;
						break;
					case "B":
						femaleGradeB++;
						break;
					case "C":
						femaleGradeC++;
						break;
					case "D":
						femaleGradeD++;
						break;
					case "F":
						femaleGradeF++;
						break;
				}
			}
		}

		System.out.printf("%s \t %s \t %s \n", "Grades", "Men", "Women");
		System.out.printf("%s \t %s \t %s \n", "------", "---", "-----");
		System.out.printf("%s \t %d \t %d \n", "A", maleGradeA, femaleGradeA);
		System.out.printf("%s \t %d \t %d \n", "B", maleGradeB, femaleGradeB);
		System.out.printf("%s \t %d \t %d \n", "C", maleGradeC, femaleGradeC);
		System.out.printf("%s \t %d \t %d \n", "D", maleGradeD, femaleGradeD);
		System.out.printf("%s \t %d \t %d \n", "F", maleGradeF, femaleGradeF);
		System.out.printf("%s %.1f %.1f \n", "Average: ", averageMaleScore(studentNamesAndAverages), averageFemaleScore(studentNamesAndAverages));
	}
}