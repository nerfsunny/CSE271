public class Manager extends Employee
{
	private String department;

	public Manager(String firstName, String lastName, double salary, String department)
	{
		super(firstName, lastName, salary);
		setDepartment(department);
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getDepartment()
	{
		return department;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Department: " + department + "\n";
	}
}