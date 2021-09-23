package Models;

public class Pawn 
{
	int location;
	public Pawn(int start)
	{
		this.location = start;
	}
	
	public boolean checkIfAtDestiantion(Board b)
	{
		if(this.location == b.getDest())
			return true;
		return false;
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public void moveto(int loc)
	{
		location = loc;
	}
}
