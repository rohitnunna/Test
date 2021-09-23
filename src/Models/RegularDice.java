package Models;

import java.util.Random;

public class RegularDice implements Mover
{
	int upper;
	int lower;
	
	public RegularDice() 
	{
		lower = 1;
		upper = 6;
	}

	@Override
	public int roll() 
	{
		Random rand = new Random();
		int value = rand.nextInt(upper);
		return value+1;
	}

}
