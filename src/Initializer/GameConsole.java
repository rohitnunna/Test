package Initializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.SnakeAndLadder;
import Models.Board;
import Models.EvenRollerDice;
import Models.Ladder;
import Models.Mover;
import Models.Pawn;
import Models.RegularDice;
import Models.Snake;

public class GameConsole 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the start location of the Board");
		int startb = sc.nextInt();
		System.out.println("Enter the end location of the Board");
		int endb = sc.nextInt();
		System.out.println("Enter the number of Snakes in the Board");
		int noOfSnakes = sc.nextInt();
		ArrayList<Snake> snakes = new ArrayList<Snake>(noOfSnakes);
		HashMap<Integer,Boolean> snakemapforValid = new HashMap<Integer,Boolean>();
		while(noOfSnakes>0)
		{
			System.out.printf("Enter start location for snake(Integer value greater than %d and lesser than %d):",startb,endb);
			System.out.println();
			int start = sc.nextInt();
			System.out.printf("Enter end location for snake(Integer value lesser than %d )",start);
			System.out.println();
			int end = sc.nextInt();
			while(start<end || start<startb || start>startb || end<endb || end>endb)
			{
				System.out.printf("Enter start location for snake(Integer value greater than %d and lesser than %d):",startb,endb);
				System.out.println();
				start = sc.nextInt();
				System.out.printf("Enter end location for snake(Integer value lesser than %d )",start);
				System.out.println();
				end = sc.nextInt();
			}
			snakemapforValid.put(start, true);
			Snake snake = (Snake) Snake.makeSnake(start, end);
			snakes.add(snake);
			noOfSnakes--;
		}
		System.out.println("Enter the number of Ladders int the Board");
		int noOfLadders = sc.nextInt();
		ArrayList<Ladder> ladders = new ArrayList<Ladder>(noOfLadders);
		while(noOfLadders>0)
		{
			System.out.printf("Enter start location for Ladder(Integer value greater than %d):",startb);
			System.out.println();
			int start = sc.nextInt();
			System.out.printf("Enter end location for Ladder(Integer value greater than %d and lesser than %d)",start,endb);
			System.out.println();
			int end = sc.nextInt();
			while(start>end || start<startb || start>startb || end<endb || end>endb || snakemapforValid.containsKey(start))
			{
				System.out.printf("Enter start location for snake(Integer value greater than %d and lesser than %d):",startb,endb);
				System.out.println();
				start = sc.nextInt();
				System.out.printf("Enter end location for snake(Integer value lesser than %d )",start);
				System.out.println();
				end = sc.nextInt();
			}
			Ladder ladder = (Ladder) Ladder.getLadder(start, end);
			ladders.add(ladder);
			noOfLadders--;
		}
		Board board = Board.getBoard(startb, endb, snakes,ladders);
		System.out.println("Choose 1 for Regular Dice, 2 for Special Dice");
		int dicetype = sc.nextInt();
		while(dicetype>2 || dicetype <1)
		{
			System.out.println("choose only 1 or 2 for regular and special dice respectively");
			dicetype = sc.nextInt();
		}
		Mover dice = null;
		if(dicetype==1)
		{
			dice = new RegularDice();
		}
		if(dicetype==2)
		{
			dice = new EvenRollerDice();
		}
		Pawn pawn = new Pawn(board.getOrig());
		//for now default value ten
		/*System.out.println("Enter number of times the game has to be played:");*/
		int noOfTimes = 10;
		SnakeAndLadder game = new SnakeAndLadder(board, dice, pawn);
		while(noOfTimes>0)
		{
			game.startGame();
			pawn.moveto(board.getOrig());
			noOfTimes--;
		}
	}
}
