package p;
import java.io.*;

public class Person 
{
	private String date, time, activity, workoutName, workoutType, competitionName, competitionDistance, shoes, notes;
	private int competitionPlace;
	private double distance;
	private String duration;
	
	//Constructors
	public Person()
	{
		
	}
	
	public Person(String date, String time, String activity, double distance, String duration, String workoutName, String workoutType, String competitionName, String competitionDistance, String competitionPlace, String shoes, String notes)
	{
		setDate(date);
		setTime(time);
		setActivity(activity);
		setDistance(distance);
		setDuration(duration);
		setWorkoutName(workoutName);
		setWorkoutType(workoutType);
		setCompetitionName(competitionName);
		setCompetitionDistance(competitionDistance);
		setCompetitionPlace(competitionPlace);
		setShoes(shoes);
		setNotes(notes);
	}
	
	public Person(String[] s)
	{
		this(s[0].trim(), 
			 s[1].trim(),
			 s[2].trim(),
			 Double.parseDouble(s[3].trim()),
			 s[4].trim(),
			 s[5].trim(),
			 s[6].trim(),
			 s[7].trim(),
			 s[8].trim(),
			 s[9].trim(),
			 s[10].trim(),
			 s[11].trim());
	}
	
	public Person(String s)
	{
		this(s.split("\t"));
	}
	
	public Person(RandomAccessFile raf) throws Exception
	{
		this(raf.readLine());
	}

	//Methods
	public double convertTimeDuration()
	{
		String[] array;
		double total = 0.0;

		if(duration.equals("0"))
		{
			return total;
		}
		
		array = duration.split(":");

		if(array.length == 2)
		{
			double minutes = Double.parseDouble(array[0]) * 60;
			double seconds = Double.parseDouble(array[1]);
			total = minutes + seconds;
		}else
		if(array.length == 3)
		{
			double hours = Double.parseDouble(array[0]) * 3600;
			double minutes = Double.parseDouble(array[1]) * 60;
			double seconds = Double.parseDouble(array[2]);
			total = hours + minutes + seconds;
		}

		return total;
	}
	
	//Getter and Setter's
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getCompetitionDistance() {
		return competitionDistance;
	}

	public void setCompetitionDistance(String competitionDistance) {
		this.competitionDistance = competitionDistance;
	}

	public String getShoes() {
		return shoes;
	}

	public void setShoes(String shoes) 
	{
		this.shoes = shoes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCompetitionPlace() {
		return competitionPlace;
	}

	public void setCompetitionPlace(String competitionPlace) {
		if(competitionPlace.equalsIgnoreCase(""))
		{
			this.competitionPlace = 0;
		}else
		if(Integer.parseInt(competitionPlace) > 0)
		{
			this.competitionPlace = Integer.parseInt(competitionPlace);
		}else
		{
			this.competitionPlace = 0;
		}
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Person [date=" + date + ", time=" + time + ", activity=" + activity + ", workoutName=" + workoutName
				+ ", workoutType=" + workoutType + ", competitionName=" + competitionName + ", competitionDistance="
				+ competitionDistance + ", shoes=" + shoes + ", notes=" + notes + ", competitionPlace="
				+ competitionPlace + ", distance=" + distance + ", duration=" + duration + "]";
	}
}