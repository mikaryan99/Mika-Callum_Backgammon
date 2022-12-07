package Backgammon;
import java.util.Scanner;


public class Backgammon {
	public static void main (String[] args) {

		View view = new View();
		User[] users = new User[2];
		users[0] = new User(view.getName());
		users[1] = new User(view.getName());
		Board board = new Board(users);
		Checkers checkers = new Checkers(board);
		Dice dice = new Dice();

		//Test Area
		Move move = new Move(board);

		//*************

		int playerA, playerB;

		String input1, input2;
		//board.printBoard();
		int roll1, roll2;

		roll1 = dice.getRoll();
		roll2 = dice.getRoll();

		users[0].move(roll1);
		System.out.print(users[0] + " rolled " + roll1 + "\n");
		users[1].move(roll2);
		System.out.print(users[1] + " rolled " + roll2 + "\n");

		playerA = dice.getTurn(roll1, roll2)[0];
		playerB = dice.getTurn(roll1, roll2)[1];
		System.out.print(users[dice.getTurn(roll1, roll2)[0]] + " goes first \n");

		//
		//

		do {

			///////////////////////////////////////////////////
			checkers.UpdatePos();

			System.out.print("Current Player: " + users[playerA].toString() + "\n");
			board.printBoard(0);
			do {
			input1 = view.getCommand(users[playerA]);

			if("pip".equalsIgnoreCase(input1)) {
				checkers.getPipCount();
				checkers.duplicates(0);
			}
			
			//TEST SPACE ************************************8
			//if("hint".equalsIgnoreCase(input1)) {
				//int choice = view.getInt(users[playerA]);
				//boolean found = board.correctPosition(choice,checkers.positions(0));
				//move.legalMoves(checkers.duplicates(0),choice , found, roll1, roll2);
			//}
            //*************************************************8
			if("r".equalsIgnoreCase(input1) || "dice".equalsIgnoreCase(input1)) {
				if("r".equalsIgnoreCase(input1)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				}
				else {
					int[] numbers = view.getDice();
					roll1 = numbers[0];
					roll2 = numbers[1];
				}
				System.out.print(users[playerA] + " rolled " + roll1 + " and " + roll2 + "\n");


				//////////////////////////*************************///////////////////////////////////

				//checkers.getPipCount();
				checkers.duplicates(0);
				int choice = view.getInt(users[playerA]);
				boolean found = board.correctPosition(choice,checkers.positions(0));
				int moveto = move.legalMoves(checkers.duplicates(0),choice , found, roll1, roll2);
				move.movetoSet(moveto);

				//CHosen A
				if(moveto == choice-roll1  && moveto != 0) {
					//roll1 = 0;
					move.makemove(0);
					int yco = checkers.topchecker(choice, 0)[0];
					int xco = checkers.topchecker(choice, 0)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(0);

					checkers.duplicates(0);
					int choice2 = view.getInt(users[playerA]);
					boolean found2 = board.correctPosition(choice2,checkers.positions(0));
					//error? below

					int moveto2 = move.legalMoves(checkers.duplicates(0),choice2 , found2, 0, roll2);
					move.movetoSet(moveto2);

					if(moveto2 != 0) { // this is new
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					//else {
					//	Sytem.out.print
					//}
					break;
				}
				if(moveto == choice-roll2 && moveto != 0) {
					move.makemove(0);
					int yco = checkers.topchecker(choice, 0)[0];
					int xco = checkers.topchecker(choice, 0)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(0);

					checkers.duplicates(0);
					int choice2 = view.getInt(users[playerA]);
					boolean found2 = board.correctPosition(choice2,checkers.positions(0));
					
					int moveto2 = move.legalMoves(checkers.duplicates(0),choice2 , found2, roll1, 0);
					move.movetoSet(moveto2);
					
					if(moveto2 != 0) { // this is new
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					
					break;
				}
				if(moveto == choice-roll1-roll2 && moveto != 0) {
					move.makemove(0);
					int yco = checkers.topchecker(choice, 0)[0];
					int xco = checkers.topchecker(choice, 0)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					break;

				}
				break;
				}


				//////////////////////////*************************///////////////////////////////////
			System.out.print("\n");


			if("Q".equalsIgnoreCase(input1)) {
				users[playerA].EndGame();
			}
			if("hint".equalsIgnoreCase(input1)) {
				System.out.print("To show pip count of both players enter: pip \n");
				System.out.print("To quit the game enter: Q \n");
				System.out.print("To roll dice enter: r \n");
			}
			if(!"r".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1) && !"pip".equalsIgnoreCase(input1) && !"dice".equalsIgnoreCase(input1) && !"hint".equalsIgnoreCase(input1)) {
				System.out.print("Invalid Command, Try again\n");
			}
			}

			while(!"r".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1));

			/////////////////////////////////////////////////////


			System.out.print("Current Player: " + users[playerB].toString() + "\n");
			board.printBoard(1);
			do {
				checkers.UpdatePos();

			input2 = view.getCommand(users[playerB]);
			if("pip".equalsIgnoreCase(input2)) {
				checkers.getPipCount();
				//checkers.duplicates(1);
			}
			if("r".equalsIgnoreCase(input2) || "dice".equalsIgnoreCase(input2)) {
				if("r".equalsIgnoreCase(input2)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				}
				else {
					int[] numbers = view.getDice();
					roll1 = numbers[0];
					roll2 = numbers[1];
				}
				System.out.println(users[playerB] + " rolled " + roll1 + " and " + roll2 + "\n");

				checkers.duplicates(1);
				int choice = view.getInt(users[playerB]);
				boolean found = board.correctPosition(choice,checkers.positions(1));
				int moveto = move.legalMoves(checkers.duplicates(1),choice , found, roll1, roll2);
				move.movetoSet(moveto);

				if(moveto == choice-roll1 && moveto != 0) {
					move.makemove(1);
					int yco = checkers.topchecker(choice, 1)[0];
					int xco = checkers.topchecker(choice, 1)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(1);

					checkers.duplicates(1);
					int choice2 = view.getInt(users[playerB]);
					boolean found2 = board.correctPosition(choice2,checkers.positions(1));
					int moveto2 = move.legalMoves(checkers.duplicates(1),choice2 , found2, 0, roll2);
					move.movetoSet(moveto2);
					
					if(moveto2 != 0) { // this is new
					move.makemove(1);
					int yco2 = checkers.topchecker(choice2, 1)[0];
					int xco2 = checkers.topchecker(choice2, 1)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					break;
				}
				if(moveto == choice-roll2 && moveto != 0) {
					move.makemove(1);
					int yco = checkers.topchecker(choice, 1)[0];
					int xco = checkers.topchecker(choice, 1)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(1);

					checkers.duplicates(1);
					int choice2 = view.getInt(users[playerB]);
					boolean found2 = board.correctPosition(choice2,checkers.positions(1));
					int moveto2 = move.legalMoves(checkers.duplicates(1),choice2 , found2, roll1, 0);
					move.movetoSet(moveto2);
					
					if(moveto2 != 0) { // this is new
						move.makemove(1);
						int yco2 = checkers.topchecker(choice2, 1)[0];
						int xco2 = checkers.topchecker(choice2, 1)[1];
						board.getSet()[yco2][xco2] = " ";
						checkers.UpdatePos();
						break;
						}
					break;
				}
				if(moveto == choice-roll1-roll2 && moveto != 0) {
					move.makemove(1);
					int yco = checkers.topchecker(choice, 1)[0];
					int xco = checkers.topchecker(choice, 1)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					break;

				}
				break;
			}
			if("Q".equalsIgnoreCase(input2)) {
				users[playerB].EndGame();
			}
			if(!"r".equalsIgnoreCase(input2) && !"Q".equalsIgnoreCase(input2) && !"pip".equalsIgnoreCase(input2) && !"hint".equalsIgnoreCase(input2) && !"dice".equalsIgnoreCase(input2)) {
				System.out.print("Invalid Command, Try again\n");
			}
			if("hint".equalsIgnoreCase(input2)) {
				System.out.print("To show pip count of both players enter: pip \n");
				System.out.print("To quit the game enter: Q \n");
				System.out.print("To roll dice enter: r \n");
			}
			}
			while(!"r".equalsIgnoreCase(input2) && !"Q".equalsIgnoreCase(input2));
			///////////////////////////////////////////////////////////////

		}
		while(!users[playerA].isGameOver() && !users[playerB].isGameOver());

		System.out.println("Game Over!");
	}


}
