package firstproject;
public class Computer 
{
	private int health;
	private int damage;
	private int crit;
	private String name;
	
	public Computer(String name, int damage, int health, int crit)
	{
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.crit = crit;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int HP)
	{
		health = HP;
	}
	
	public int getDamage()
	{
		if (critHit())
			return damage * 2;
		return damage;
	}
	
	public int critChance(int Chance)
	{
		return Chance = (int) Math.floor(Math.random()*(20) + 1);
	}
	
	public boolean critHit()
	{
		if (critChance(crit) == (7))
			return true;
		else return false;
	}
}
