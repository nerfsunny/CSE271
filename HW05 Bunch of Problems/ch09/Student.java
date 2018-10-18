public class Student extends Person
{
	private String major;

	public Student(String firstName, String lastName, int yearOfBirth, String major)
	{
		super(firstName, lastName, yearOfBirth);
		setMajor(major);
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getMajor()
	{
		return major;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Major: " + major + "\n";
	}
}