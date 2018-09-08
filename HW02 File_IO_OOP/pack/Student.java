package pack;
import java.security.InvalidParameterException;

public class Student
{
	private String gender;
	private String studentName;
	private double average;

	public String getLetterGrade()
	{
		if(this.getAverage() > 89)
		{
			return "A";
		}else
		if(this.getAverage() > 79)
		{
			return "B";
		}else
		if(this.getAverage() > 69)
		{
			return "C";
		}else
		if(this.getAverage() > 59)
		{
			return "D";
		}else
		{
			return "F";
		}
	}

	public void setAverage(int a)
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

	public Student()
	{

	}
}