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
	public static void main(String args[])
	{
		ArrayList<Student> listOfStudents = new ArrayList<Student>();
		Student stu = new Student("Sunny", "Vaswani");

		System.out.println("Hello World!");
		System.out.println("Also, hello from " + stu.getFirstName() + " " + stu.getLastName());
	}
}