package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Board 
{
	private int orig;
	private int dest;
	private HashMap<Integer,Snake> snakeMap;
	private HashMap<Integer,Ladder> ladderMap;
	
	private Board(int start, int end, ArrayList<Snake> snakes, ArrayList<Ladder> ladders)
	{
		orig=start;
		dest=end;
		initializeMaps(snakes,ladders);
	}
	
	public static Board getBoard(int start, int end, ArrayList<Snake> snakes, ArrayList<Ladder> ladders)
	{
		return new Board(start,end,snakes,ladders);
	}
	private void initializeMaps( ArrayList<Snake> snakes, ArrayList<Ladder> ladders) 
	{
		snakeMap =  new HashMap<Integer, Snake>();
		ladderMap =  new HashMap<Integer, Ladder>();
		for(Snake snake:snakes)
		{
			snakeMap.put(snake.getStart(), snake);
		}
		for(Ladder ladder:ladders)
		{
			ladderMap.put(ladder.getStart(),ladder);
		}
	}

	public int getDest()
	{
		return dest;
	}
	
	public HashMap<Integer,Snake> getSnakeMap()
	{
		return new HashMap<Integer, Snake>(snakeMap);
	}
	
	public HashMap<Integer,Ladder> getLadderMap()
	{
		return new HashMap<Integer,Ladder>(ladderMap);
	}
	
	public int getOrig()
	{
		return orig;
	}
}
