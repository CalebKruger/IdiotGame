package firstproject;
import java.util.Scanner;
import java.util.Random;

public class FirstProject 
{
	public static void main(String[] args) 
	{
		System.out.println("Attack = Attack the enemy.");
		System.out.println("Defend = Attack damage will be halved. Does not stack.");
		Scanner input = new Scanner(System.in);
		int health = 100;
		int damage = 10;
		int AIhealth = 100;
		int AIdamage = 10;
		String choice = "";
		System.out.println();
		
		for (int i = 0; i < 50; i++)
		{
			System.out.println("There is an enemy, would you like to attack or defend");
			System.out.println("(type 'attack' or 'defend')");
			choice = input.nextLine();
			if (choice.toLowerCase().equals("attack"))
			{
				if (AIhealth > 0)
				{
					AIhealth -= damage;
					System.out.println("You attacked with " + damage + " damage.");
					System.out.println("The enemy has " + AIhealth + " health remaining.");
				}
				if (AIhealth <= 0)
				{
					System.out.println("The enemy has been killed");
					break;
				}
				damage = 10;
			}
			else if(choice.toLowerCase().equals("defend"))
			{
				AIdamage = 5;
				System.out.println("You have raised your guard. The damage of the enemy's next attack has been halved.");
			}
			else System.out.println("You're an idiot. You have lost your turn.");
			System.out.println();
			System.out.println("Enemy's turn");
			int turn = (int) Math.floor(Math.random()*(2) + 1);
			if (turn == 1)
			{
				if (health > 0)
				{
					health -= AIdamage;
					System.out.println("You have been attacked for " + AIdamage + " damage.");
					System.out.println("You have " + health + " health remaining.");
				}
				if (health <= 0)
				{
					System.out.println("You have been killed. Idiot.");
					break;
				}
				AIdamage = 10;
			}
			if (turn == 2)
			{
				damage = 5;
				System.out.println("The enemy raised their guard. The damage of your next attack has been halved.");
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
		}
		
	}
}
