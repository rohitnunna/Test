package Models;

public final class Snake implements SpecialItem 
{

	private final int start;
	private final int end;
	
	
	
	private Snake(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
	public static Snake makeSnake(int start, int end)
	{
		return new Snake(start,end);
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
