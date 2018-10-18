public class Instructor extends Person
{
	private double salary;

	public Instructor(String firstName, String lastName, int yearOfBirth, double salary)
	{
		super(firstName, lastName, yearOfBirth);
		setSalary(salary);
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public double getSalary()
	{
		return salary;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Salary: " + salary + "\n";
	}
}