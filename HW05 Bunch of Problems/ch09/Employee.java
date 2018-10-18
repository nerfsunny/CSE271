public class Employee
{
	private String firstName, lastName;
	private double salary;

	public Employee(String firstName, String lastName, double salary)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setSalary(salary);
	}

	public void setFirstName(String fname)
	{
		firstName = fname;
	}

	public void setLastName(String lname)
	{
		lastName = lname;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
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

	public double getSalary()
	{
		return salary;
	}

	@Override
	public String toString()
	{
		return "Name: " + getFullName() + "\n"
			 + "Salary: " + salary + "\n";
	}
}