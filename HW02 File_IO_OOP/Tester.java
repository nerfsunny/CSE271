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
	public static double averageMaleScore(ArrayList<Student> scores)
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

	public static double averageFemaleScore(ArrayList<Student> scores)
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

		int maleGradeA = 0, maleGradeB = 0, maleGradeC = 0, maleGradeD = 0, maleGradeF = 0;
		int femaleGradeA = 0, femaleGradeB = 0, femaleGradeC = 0, femaleGradeD = 0, femaleGradeF = 0;
		String grade;
		
		try
		{
			raf = new RandomAccessFile("students2.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				s = new Student();
				String[] parts = raf.readLine().split("\t");
				System.out.println(parts[0]);
				s.setName(parts[0]);
				System.out.println(parts[1]);
				s.setGender(parts[1]);
				System.out.println(parts[2]);
				s.setAverage(Integer.parseInt(parts[2]));

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
			if(s.getGender().equalsIgnoreCase("male"))
			{
				grade = s.getLetterGrade();

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
			if(s.getGender().equalsIgnoreCase("female"))
			{
				grade = s.getLetterGrade();

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

		System.out.println("Grades | Number of Male Students | Number of Female Students");
		System.out.println("A" + " | " + maleGradeA + " | " + femaleGradeA);
		System.out.println("B" + " | " + maleGradeB + " | " + femaleGradeB);
		System.out.println("C" + " | " + maleGradeC + " | " + femaleGradeC);
		System.out.println("D" + " | " + maleGradeD + " | " + femaleGradeD);
		System.out.println("F" + " | " + maleGradeF + " | " + femaleGradeF);
		System.out.println("Averages for both genders." + "Male: " + averageMaleScore(studentNamesAndAverages) + "Female: " + averageFemaleScore(studentNamesAndAverages));
	}
}