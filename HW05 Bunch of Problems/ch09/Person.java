public abstract class Person
{
	private String firstName, lastName;
	private int yearOfBirth;

	public Person(String firstName, String lastName, int yearOfBirth)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setYearOfBirth(yearOfBirth);
	}	

	public void setFirstName(String fname)
	{
		firstName = fname;
	}

	public void setLastName(String lname)
	{
		lastName = lname;
	}

	public void setYearOfBirth(int year)
	{
		yearOfBirth = year;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getFullName()
	{
		return firstName + " " + lastName;
	}

	public int getYearOfBirth()
	{
		return yearOfBirth;
	}

	@Override
	public String toString()
	{
		return "Name: " + getFullName() + "\n"
			 + "Year of Birth: " + yearOfBirth + "\n";
	}
}