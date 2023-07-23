package firstproject;
import java.util.Scanner;
import java.util.Random;

public class FirstProject 
{
	public static void main(String[] args) 
	{	
		//Intro
		System.out.println("Attack = Attack the enemy.");
		System.out.println("Defend = Attack damage will be halved. Does not stack.");
		System.out.println("Crit Chance = 10% chance for the player, 5% chance for the computer to get double damage.");
		System.out.println("Get Ready To Play!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("What is your player's name?");
		
		//Variables
		Scanner input = new Scanner(System.in);
		String name = "";
		String choice = "";
		int turn = 1;
		name = input.nextLine();
		Player player = new Player(name, 10, 100, 10);
		Player computer = new Player("Morgeth, The Destroyer", 13, 110, 20);
		int one = 1;
		System.out.println(computer.getName() + " confronts you, would you like to attack or defend");
		
		//Gameplay
		while (one == 1)
		{
			//Player Turn
			System.out.println("(type 'attack' or 'defend')");
			choice = input.nextLine();
			System.out.println();
			//Player Attack
			if (choice.toLowerCase().equals("attack"))
			{
				if (computer.getHealth() > 0)
				{
					if (player.critHit())
					{
						player.doDamage(computer);
						player.doDamage(computer);
						System.out.println(player.getName() + " has attacked " + computer.getName() + " with a critical hit for " + player.getDamage()*2 + " damage.");
						System.out.println(computer.getName() + " has " + computer.getHealth() + " health remaining.");
					}
					else 
					{	
						computer.doDamage(player);
						System.out.println(player.getName() + " has attacked " + computer.getName() + " for " + player.getDamage() + " damage.");
						System.out.println(computer.getName() + " has " + computer.getHealth() + " health remaining.");
					}
					if (computer.getHealth() <= 0)
					{
						System.out.println(computer.getName() + " has been defeated.");
						one = 2;
					}
				}
				player.setDamage(10);
				//	^better to be there?^	else if (computer.getHealth() <= 0)
					
			//Player Defend	
			}
			else if (choice.toLowerCase().equals("defend"))
			{
				computer.setDamageDefend(2);
				System.out.println(player.getName() + " has defended and reduced " + computer.getName() + "'s next attack.");
			}
			//Player Stupidity
			else System.out.println("You're an idiot. You have lost your turn. Type 'attack' or 'defend' next time :)");
			
			System.out.println();
			System.out.println(computer.getName() + "'s Turn.");
			System.out.println();
			
			//Computers Turn
			turn = (int) Math.floor(Math.random()*(2) + 1);
			if (turn == 1)
			{
				//Computer attack
				if (player.getHealth() > 0)
				{
					if (computer.critHit())
					{
						computer.doDamage(player);
						computer.doDamage(player);
						System.out.println(computer.getName() + " has attacked " + player.getName() + " with a critical hit for " + computer.getDamage()*2 + " damage.");
						System.out.println(player.getName() + " has " + player.getHealth() + " health remaining.");
					}	
					else
					{	
						player.doDamage(computer);
						System.out.println(computer.getName() + " has attacked " + player.getName() + " for " + computer.getDamage() + " damage.");
						System.out.println(player.getName() + " has " + player.getHealth() + " health remaining.");
					}
					if (player.getHealth() <= 0)
					{
						System.out.println(player.getName() + " has been defeated.");
						one = 2;
					}
				}
				computer.setDamage(10);
				
				//Computer Defend
				if (turn != 1)
				{
					player.setDamageDefend(2);
					System.out.println(computer.getName() + " has defended and reduced " + player.getName() + "'s next attack.");
				}
				
			}
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println(player.getName() + "'s turn");
		}
	}
}
		
		/*
		Scanner input = new Scanner(System.in);		
		System.out.println("Attack = Attack the enemy.");
		System.out.println("Defend = Attack damage will be halved. Does not stack.");
		
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
			
			System.out.println();
		}
		
	}
}
*/