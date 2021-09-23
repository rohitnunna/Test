package Models;

public final class Ladder implements SpecialItem 
{
	int start;
	int end;
	
	private Ladder(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
	
	public static Ladder getLadder(int start, int end)
	{
		return new Ladder(start,end);
	}
	@Override
	public void movePawn(Pawn p) 
	{
		p.location = this.end;
	}

	public int getStart()
	{
		return start;
	}
	
	public int getEnd()
	{
		return end;
	}
}
