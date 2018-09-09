package pack;
import java.security.InvalidParameterException;

public class Student
{
	private String gender; //stores the gender (in this case Male or Female) for each Student object
	private String studentName; //stores the name for each Student object
	private double average; //stores the average score for each student object


	//Getter and Setter's for the Student Class
	public String getLetterGrade()
	{
		if(average > 89)
		{
			return "A";
		}else
		if(average > 79)
		{
			return "B";
		}else
		if(average > 69)
		{
			return "C";
		}else
		if(average > 59)
		{
			return "D";
		}else
		{
			return "F";
		}
	}

	public void setAverage(double a)
	{
		if(a >= 0 && a <= 100)
		{
			average = a;
		}else
		{
			throw new InvalidParameterException("Invalid Test Score: " + a);
		}
	}

	public double getAverage()
	{
		return average;
	}

	public void setName(String n)
	{
		studentName = n;
	}

	public String getName()
	{
		return studentName;
	}

	public void setGender(String g)
	{
		gender = g;
	}

	public String getGender()
	{
		return gender;
	}

	//default constructor (not used)
	/*public Student()
	{

	}*/
}