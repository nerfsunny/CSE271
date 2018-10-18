public class Executive extends Manager
{
	public Executive(String firstName, String lastName, double salary, String department)
	{
		super(firstName, lastName, salary, department);
	}

	@Override
	public String toString() //Probably don't need this as there is no new information that this class adds but only included it for the assignment problem
	{
		return super.toString();
	}
}