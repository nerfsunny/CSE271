public class Student
{
	private String name;
	private int totalQuizScore = 0;
	private int numberOfQuizzes = 0;

	public Student(String name)
	{
		setName(name);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void addQuiz(int score)
	{
		totalQuizScore = score + totalQuizScore;
		numberOfQuizzes++;
	}

	public int getTotalScore()
	{
		return totalQuizScore;
	}

	public double getNumberOfQuizzes()
	{
		return numberOfQuizzes;
	}

	public double getAverageScore()
	{
		return (double) totalQuizScore/numberOfQuizzes;
	}
}