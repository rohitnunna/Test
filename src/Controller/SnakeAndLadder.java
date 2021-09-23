package Controller;

import Models.Board;
import Models.EvenRollerDice;
import Models.Mover;
import Models.Pawn;



public class SnakeAndLadder 
{
	Board board;
	Mover dice;
	Pawn pawn;
	public SnakeAndLadder(Board board, Mover dice, Pawn pawn)
	{
		this.board = board;
		this.dice = dice;
		this.pawn = pawn;
	}
	public boolean startGame()
	{
		System.out.println("Game has Started");
		while(pawn.getLocation() != board.getDest())
		{
			int next = dice.roll();
			System.out.println("Dice Rolled and value is:"+next);
			if(board.getSnakeMap().containsKey(pawn.getLocation()+next))
			{
				int snakeLocation = board.getSnakeMap().get(pawn.getLocation()+next).getStart();
				System.out.printf("Snake found at location:%d",snakeLocation);
				System.out.println();
				pawn.moveto(board.getSnakeMap().get(pawn.getLocation()+next).getEnd());
				System.out.printf("After Snake encounter, pawn moved to location:%d",pawn.getLocation());
				System.out.println();
			}
			else if(board.getLadderMap().containsKey(pawn.getLocation()+next))
			{
				int ladderLocation = board.getLadderMap().get(pawn.getLocation()+next).getStart();
				System.out.printf("Ladder found at location:%d",ladderLocation);
				System.out.println();
				pawn.moveto(board.getLadderMap().get(pawn.getLocation()+next).getEnd());
				System.out.printf("After Ladder found, pawn moved to location:%d",pawn.getLocation());
				System.out.println();
			}
			else if(pawn.getLocation()+next <= board.getDest())
			{
				pawn.moveto(pawn.getLocation()+next);
				System.out.printf("After Ladder found, pawn moved to location:%d",pawn.getLocation());
				System.out.println();
				if(pawn.getLocation() == board.getDest())
				{
					System.out.println("Game completed Successfully!!");
					return true;
				}
			}
			else
			{
				if(dice.getClass()==EvenRollerDice.class && (board.getDest()%2==0) && (pawn.getLocation()%2!=0))
				{
					int curr = pawn.getLocation();
					boolean isShouldContinue=false;
					while(curr<100)
					{
						if(board.getLadderMap().containsKey(curr))
						{
							isShouldContinue=true;
							break;
						}
						curr++;
					}
					if(!isShouldContinue)
					{
						System.out.println("With Even Dice and No more ladders/snakes left cannot move to end, Suspending game");
						return false;
					}
				}
				System.out.printf("Cannot move beyond dest:%d",board.getDest());
				System.out.println();
				System.out.println("Rolling Dice again!");
				
			}
		}
		return false;
	}
}
