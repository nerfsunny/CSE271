/*
 * Homework – 04 
 * Due: Monday, 10-08-2018 by 11:59 pm
 *
 * @Sundeep Vaswani (vaswansk)
 *
 */

import characterClasses.*;
import java.util.*;

public class Tester
{
	public static void main(String args[])
	{
		ArrayList<RPGCharacter> listOFCharacters = new ArrayList<RPGCharacter>();
		RPGCharacter test = new Knight("Bob");
		test.quickGenerate();
		System.out.println(test.toString());
	}
}