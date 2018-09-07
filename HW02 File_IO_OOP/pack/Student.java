package pack;

public class Student
{
	private String gender;
	private double average;

	public String getLetterGrade(double average)
	{
		if(average >= 90 && average <= 100)
		{
			return "A";
		}else
		if(average >= 80 && average < 90)
		{
			return "B";
		}else
		if(average >= 70 && average < 80)
		{
			return "C";
		}else
		if(average >= 60 && average < 70)
		{
			return "D";
		}else
		{
			return "F";
		}
	}

	public String test()
	{
		return "The test works!";
	}

	public Student()
	{

	}
}