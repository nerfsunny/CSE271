import java.util.*;

public class Tester 
{
	public static void main(String args[])
	{	
		//======================> 8.5
		System.out.println("#8.5" + "\n");
		
		Random n = new Random();
		double radius = n.nextInt(10) + 1;
		double height = n.nextInt(10) + 1;
		System.out.println("Radius: " + radius); 
		System.out.println("Height: " + height);
		
		SodaCan can = new SodaCan(radius, height);
		System.out.println("Soda Can Surface Area: " + can.getSurfaceArea());
		System.out.println("Soda Can Volume: " + can.getVolume());
		System.out.println("");
		
		//======================> 8.7
		System.out.println("#8.7" + "\n");
		Student stu1 = new Student("Sunny");
		
		for(int i = 0; i < 10; i++)
		{	
			Random number = new Random();
			stu1.addQuiz(number.nextInt(100) + 1);
		}
		
		System.out.println(stu1.getName() + "'s Total Number of Quizzes: " + stu1.getNumberOfQuizzes());
		System.out.println(stu1.getName() + "'s Total Quiz Score: " + stu1.getTotalScore());
		System.out.println(stu1.getName() + "'s Avergae Quiz Score: " + stu1.getAverageScore());
		System.out.println("");
		
		//======================> 8.10
		System.out.println("#8.10" + "\n");
		VotingMachine machine = new VotingMachine();
		
		for(int j = 0; j < 100; j++)
		{
			Random number = new Random();
			int num = number.nextInt(2) + 1;
			
			switch(num)
			{
				case 1:
					machine.increaseDemocratVote();
					break;
				case 2:
					machine.increaseRepublicanVote();
				default:
					break;
			}
		}
		
		System.out.println("Voting completed.");
		System.out.println("Total Democrat Votes: " + machine.getTotalDemocratVotes());
		System.out.println("Total Republican Votes: " + machine.getTotalRepublicanVotes());
		System.out.println("");
		
		//======================> 8.11
		System.out.println("#8.11" + "\n");
		
		Letter paper = new Letter("Sunny", "Billy");
		paper.addLine("It's been a while since the last letter I sent you.");
		paper.addLine("How are you doing?");
		paper.addLine("I recently beat Pokemon LeafGreen.");
		paper.addLine("It was a lot of fun.");
		paper.addLine("You should play it sometime.");
		paper.addLine(paper.signLetter());
		
		System.out.println(paper.getText());
		System.out.println("");
		
		//======================> 8.12
		System.out.println("#8.12" + "\n");
		Random value = new Random();
		Bug insect = new Bug(10);
		System.out.println("Initial Position of Bug: " + insect.getPosition());
		
		for(int k = 0; k < 15; k++)
		{
			int possibility = value.nextInt(2) + 1;
			
			switch(possibility)
			{
				case 1:
					insect.move();
					break;
				case 2:
					insect.turn();
					break;
				default:
					insect.move();
					insect.turn();
					break;
			}
			System.out.println("New Position of Bug: " + insect.getPosition());
		}
		
		System.out.println("");
		System.out.println("Final Position of Bug: " + insect.getPosition());
		System.out.println("");
		
		//======================> 9.8
		System.out.println("#9.08" + "\n");
		
		Person p1 = new Student("Sunny", "Vaswani", 1998, "Engineering");
		Person p2 = new Instructor("Zane", "Oliver", 1975, 55123.31);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("");
		
		//======================> 9.9
		System.out.println("#9.09" + "\n");
		
		Employee emp1 = new Manager("Bob", "Jones", 45000.0, "Sales");
		Employee emp2 = new Executive("Sue", "Roberts", 48945.12, "Education");
		
		System.out.println(emp1.toString());
		System.out.println(emp2.toString());
		System.out.println("");
		
		//======================> 9.10
		System.out.println("#9.10" + "\n");
		
		Random num = new Random();
		int x = num.nextInt(5);
		int y = num.nextInt(5);
		int width = num.nextInt(10) + 1;
		int height = num.nextInt(10) + 1;
		BetterRectangle shape = new BetterRectangle(x, y, width, height);
		
		System.out.println("Width: " + shape.getWidth());
		System.out.println("Height: " + shape.getHeight());
		System.out.println("Perimeter: " + shape.getPerimeter());
		System.out.println("Area: " + shape.getArea());
		System.out.println("");

		//======================> 9.14
		System.out.println("#9.14" + "\n");
		
		Random measurement = new Random();
		SodaCan can = null;
		ArrayList<SodaCan> listOfCans = new ArrayList<SodaCan>();
		double totalSurfaceArea = 0;
		double averageSurfaceArea;
		
		for(int i = 0; i < 20; i++)
		{
			double canRadius = measurement.nextInt(10) + 1;
			double canHeight = measurement.nextInt(10) + 1;
			
			can = new SodaCan(canRadius, canHeight);
			listOfCans.add(can);
		}
		
		for(SodaCan c : listOfCans)
		{
			totalSurfaceArea = totalSurfaceArea + c.getSurfaceArea();
		}
		
		averageSurfaceArea = (double) totalSurfaceArea/listOfCans.size();
		
		System.out.println("Average surface area for " + listOfCans.size() + " can(s) with various radius and height: " + averageSurfaceArea);
}