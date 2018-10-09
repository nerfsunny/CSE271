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
		Random number = new Random();
		Scanner input = new Scanner(System.in);
		ArrayList<RPGCharacter> listOfEnemies = new ArrayList<RPGCharacter>();
		ArrayList<RPGCharacter> deadEnemies = new ArrayList<RPGCharacter>();
		RPGCharacter player = null;
		String name = null;
		int deadCombatCharacters = 0, deadNonCombatCharacters = 0;

		System.out.println("Please enter a name for your randomly generated character.");
		name = input.next();
		int createCharacter = number.nextInt(7) + 1;

		switch(createCharacter)
		{
			case 1:
				player = new Knight(name);
				break;
			case 2:
				player = new Wizard(name);
				break;
			case 3:
				player = new Assassin(name);
				break;
			case 4:
				player = new ShopKeeper(name);
				break;
			case 5:
				player = new Commoner(name);
				break;
			case 6:
				player = new Brawler(name);
				break;
			case 7:
				player = new BlackSmith(name);
			default:
				player = new Knight("Sunny");
		}

		System.out.println("This is your randomly generated character.");
		System.out.println(player.toString());

		for(int i = 1; i < 21; i++)
		{
			RPGCharacter enemy = null;
			int createEnemy = number.nextInt(7) + 1;

			switch(createEnemy)
			{
				case 1:
					enemy = new Knight("Enemy " + i);
					break;
				case 2:
					enemy = new Wizard("Enemy " + i);
					break;
				case 3:
					enemy = new Assassin("Enemy " + i);
					break;
				case 4:
					enemy = new ShopKeeper("Enemy " + i);
					break;
				case 5:
					enemy = new Commoner("Enemy " + i);
					break;
				case 6:
					enemy = new Brawler("Enemy " + i);
					break;
				case 7:
					enemy = new BlackSmith("Enemy " + i);
				default:
					enemy = new Knight("Sunny");
			}

			listOfEnemies.add(enemy);
		}

		System.out.println("Let's see how well you do against these 20 randomly generated enemies.");
		System.out.println();

		for(int i = 0; i < listOfEnemies.size(); i++)
		{
			player.fight(listOfEnemies.get(i));

			if(player.battleStatus().equalsIgnoreCase("Alive"))
			{
				player.increaseBattleCount();
				deadEnemies.add(listOfEnemies.get(i));
				listOfEnemies.remove(i);
				i = 0;
			}else
			if(player.battleStatus().equalsIgnoreCase("Dead"))
			{
				break;
			}
		}

		for(RPGCharacter x : deadEnemies)
		{
			if(x instanceof CombatCharacter)
			{
				deadCombatCharacters++;
			}else
			if(x instanceof NonCombatCharacter)
			{
				deadNonCombatCharacters++;
			}
		}

		System.out.println(player.toString());
		System.out.println(" Dead Combat Characters: " + deadCombatCharacters);
		System.out.println(" Dead NonCombat Characters: " + deadNonCombatCharacters);
	}
}