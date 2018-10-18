import java.util.*;

public class Tester 
{
	public static void main(String args[])
	{	
		//======================> 8.5
		SodaCan can = new SodaCan(3, 4);
		System.out.println("Soda Can Surface Area: " + can.getSurfaceArea());
		System.out.println("Soda Can Volume: " + can.getVolume());
		System.out.println("");
		
		//======================> 8.7
		Student stu1 = new Student("Sunny");
		
		for(int i = 0; i < 10; i++)
		{	
			Random number = new Random();
			stu1.addQuiz(number.nextInt(100) + 1);
		}
		
		System.out.println(stu1.getName() + "'s Total Number of Quizzes: " + stu1.getNumberOfQuizzes());
		System.out.println(stu1.getName() + "'s Total Quiz Score: " + stu1.getTotalScore());
		System.out.println(stu1.getName() + "'s Avergae Quiz Score: " + stu1.getAverageScore());
	}
	
}

