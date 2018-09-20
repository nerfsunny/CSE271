package people;
import java.security.InvalidParameterException;
import java.io.*;

public class Student implements Comparable<Student>
{
	//Initiallizing necessary variables for Students
	private String firstName, lastName, gender, username, password, university, email, yearInSchool, city, state, phoneNumber;
	private double currentGPA;
	private int zip;

	//Getters and Setters
	public void setFirstName(String f)
	{
		firstName = f;
	}

	public void setLastName(String l)
	{
		lastName = l;
	}

	public void setGender(String g)
	{
		gender = g;
	}

	public void setUsername(String u)
	{
		username = u;
	}

	public void setPassword(String p)
	{
		password = p;
	}

	public void setUniversity(String u)
	{
		university = u;
	}

	public void setEmail(String e)
	{
		email = e;
	}

	public void setYearInSchool(String yis)
	{
		if(yis.equalsIgnoreCase("freshman") || yis.equalsIgnoreCase("sophomore") || yis.equalsIgnoreCase("junior") || yis.equalsIgnoreCase("senior") || yis.equalsIgnoreCase("graduate student"))
		{
			yearInSchool = yis;
		}else
		{
			throw new InvalidParameterException("Student can not be a " + yis);
		}
	}

	public void setCity(String c)
	{
		city = c;
	}

	public void setState(String s)
	{
		state = s;
	}

	public void setGPA(double g)
	{
		if(g >= 0.0 && g <= 4.0)
		{
			currentGPA = g;
		}else
		{
			throw new InvalidParameterException("GPA of " + g + " is not possible");
		}
	}

	public void setPhoneNumber(String p)
	{
		phoneNumber = p;
	}

	public void setZip(int z)
	{
		zip = z;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public String getUniversity()
	{
		return university;
	}

	public String getEmail()
	{
		return email;
	}

	public String getYearInSchool()
	{
		return yearInSchool;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public Double getGPA()
	{
		return currentGPA;
	}

	public Integer getZip()
	{
		return zip;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	//returns basic information about the Student object
	@Override
	public String toString()
	{
		return city + " " 
			 + state + " "
			 + zip + " "
			 + university + " "
			 + lastName; 
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student)) 
		{
			return false;
		}

		Student s = (Student) obj;

		return	firstName.equalsIgnoreCase(s.getFirstName()) &&
				lastName.equalsIgnoreCase(s.getLastName()) &&
				gender.equalsIgnoreCase(s.getGender()) &&
				username.equalsIgnoreCase(s.getUsername()) &&
				password.equalsIgnoreCase(s.getPassword()) &&
				university.equalsIgnoreCase(s.getUniversity()) &&
				email.equalsIgnoreCase(s.getEmail()) &&
				yearInSchool.equalsIgnoreCase(s.getYearInSchool()) &&
				city.equalsIgnoreCase(s.getCity()) &&
				state.equalsIgnoreCase(s.getState()) && 
				phoneNumber.equalsIgnoreCase(s.getPhoneNumber()) &&
				currentGPA == s.getGPA() &&
				zip == s.getZip();
	}

	@Override
	public int compareTo(Student s)
	{
		return this.toString().compareTo(s.toString());
	}

	/*public String allData()
	{
		return "Student: " + firstName + " " + lastName + " Gender: " + gender + " University: " + university + " Year: " + yearInSchool + " Student's GPA: " + currentGPA + 
		" City: " + city + " State: " + state + " Zip Code: " + zip + " Phone Number: " + phoneNumber + " Email: " + email + " Username: " + username + " Password: " + password;
	}*/

	//default constructor (left empty)
	public Student()
	{

	}

	//workhorse constructor
	public Student(String firstName, String lastName, String gender, String username, String pass, String university, String email, String year, String city, String state, Double gpa, Integer zip, String phoneNumber)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setUsername(username);
		setPassword(password);
		setUniversity(university);
		setEmail(email);
		setYearInSchool(year);
		setCity(city);
		setState(state);
		setGPA(gpa);
		setZip(zip);
		setPhoneNumber(phoneNumber);
	}

	protected Student clone()
	{
		return new Student(this);
	}

	//copy constrcutor
	public Student(Student s)
	{
		this(s.getFirstName(), s.getLastName(), s.getGender(), s.getUsername(), s.getPassword(), s.getUniversity(), s.getEmail(), s.getYearInSchool(), s.getCity(), s.getState(), s.getGPA(), s.getZip(), s.getPhoneNumber());
	}

	//Constructor that accepts an array of Strings necessary for the Student object
	public Student(String[] x)
	{
		this(x[1], x[0], x[2], x[3], x[4], x[7], x[5], x[8], x[9], x[10], Double.parseDouble(x[6]), Integer.parseInt(x[11]), x[12]);
	}

	public Student(String output)
	{
		this(output.split("\t"));
	}

	/*public Student(RandomAccessFile r)
	{
		this(r.readLine());
	}*/
}