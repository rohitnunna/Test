package Models;

import java.util.Random;

public class EvenRollerDice implements Mover
{
	int upper;
	int lower;
	
	public EvenRollerDice() 
	{

		upper=6;
		lower=1;
	}
	
	@Override
	public int roll() 
	{
		Random rand = new Random();
		int value = rand.nextInt(upper/2)+1;
		return (value*2);	
	}

}
