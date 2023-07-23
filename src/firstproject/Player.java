package firstproject;
public class Player 
{
	private int health;
	private int damage;
	private int crit;
	private String name;
	
	public Player(String name, int damage, int health, int crit)
	{
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.crit = crit;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	/*
	public void setHealth(int HP)
	{
		health = HP;
	}
	*/
	
	public void setDamage(int DMG)
	{
		damage = DMG;
	}
	
	public void doDamage(Player other)
	{
		this.health -= other.getDamage();
	}
	
	public int getDamage()
	{
		//if (critHit())
		//	return damage * 2;
		return damage;
	}
	
	public void setDamageDefend(int DMG)
	{
		damage /= DMG;
	}
	
	public int critChance()
	{
		return (int)Math.floor(Math.random()*(crit) + 1);
	}
	
	public boolean critHit()
	{
		if (critChance() == (7))
			return true;
		else return false;
	}	
}
