package Backgammon;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Backgammon {
	public static void main (String[] args) throws IOException
	{

		View view = new View();
		User[] users = new User[2];
		users[0] = new User(view.getName());
		users[1] = new User(view.getName());
		Board board = new Board(users);
		Checkers checkers = new Checkers(board);
		Dice dice = new Dice();

		//Test Area
		Move move = new Move(users, board, checkers);

		//*************

		int playerA, playerB;

		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("Enter Match Length: ");
		Scanner sc=new Scanner(System.in);  
		int len = sc.nextInt();
		int matchlength=len;
		System.out.println("The Length of the Match is : " + len);
		final String FILE_NAME = "Player1.txt";
		Scanner scnr = new Scanner(new FileInputStream(FILE_NAME));
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
		
		do {
		
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
		users[playerA].nEndGame();
		users[playerB].nEndGame();
		//
		//

		do {

			///////////////////////////////////////////////////
			checkers.UpdatePos();

			System.out.println("Current Player: " + users[playerA].toString() + "Match Length: " + matchlength);
			board.printBoard(0);
			do {
					
					if(users[playerA].getReadNext()) {
						input1 = "test Player1.txt";
					}
					else {
						input1 = view.getCommand(users[playerA]);
					}
					
				if("test Player1.txt".equalsIgnoreCase(input1)) {
					input1=scnr.nextLine();
					if(scnr.hasNext()) {
						users[playerA].readNextLineT();
					}
					else {
						users[playerA].readNextLineF();
					}
				}
				
				
			if("pip".equalsIgnoreCase(input1)) {
				checkers.getPipCount();
				checkers.duplicates(0);
			}

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
				int moveto = move.legalMoves(checkers.duplicates(0),choice , found, roll1, roll2, 0);
/*  */			move.movetoSet(moveto);

                if(moveto == 26) {
    				move.makemove(0);
					int yco = checkers.topchecker(choice, 0)[0];
					int xco = checkers.topchecker(choice, 0)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(0);
                }

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

					int moveto2 = move.legalMoves(checkers.duplicates(0),choice2 , found2, 0, roll2, 0);
					move.movetoSet(moveto2);

					if(moveto2 > 0) { // this is new
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}

					else {
						System.out.print("Cant move here\n");
					}
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

					int moveto2 = move.legalMoves(checkers.duplicates(0),choice2 , found2, roll1, 0, 0);
					move.movetoSet(moveto2);

					if(moveto2 > 0) { // this is new
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					else {
						System.out.print("Cant move here\n");
					}

					break;
				}
			checkers.UpdatePos();
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
			if("startnew".equalsIgnoreCase(input1)) {
				users[playerA].EndGame();
			}

			if("Q".equalsIgnoreCase(input1)) {
				//users[playerA].EndGame();
				System.out.println("Program Terminated");
				System.exit(0);
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

			while(!"r".equalsIgnoreCase(input1) && !"startnew".equalsIgnoreCase(input1));

			/////////////////////////PLAYER TWO////////////////////////////

			checkers.UpdatePos();
			System.out.println("Current Player: " + users[playerB].toString() + "Match Length: " + matchlength);
			board.printBoard(1);
			do {
				checkers.UpdatePos();

			//input2 = view.getCommand(users[playerB]);
				
				if(users[playerB].getReadNext()) {
					input2 = "test Player1.txt";
				}
				else {
					input2 = view.getCommand(users[playerB]);
				}
				
			if("test Player1.txt".equalsIgnoreCase(input2)) {
				input2=scnr.nextLine();
				if(scnr.hasNext()) {
					users[playerB].readNextLineT();
				}
				else {
					users[playerB].readNextLineF();
				}
			}
				
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
				int moveto = move.legalMoves(checkers.duplicates(1),choice , found, roll1, roll2, 1);
				move.movetoSet(moveto);


                if(moveto == 26) {
    				move.makemove(1);
					int yco = checkers.topchecker(choice, 1)[0];
					int xco = checkers.topchecker(choice, 1)[1];
					board.getSet()[yco][xco] = " ";
					checkers.UpdatePos();
					board.printBoard(1);
                }


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
					int moveto2 = move.legalMoves(checkers.duplicates(1),choice2 , found2, 0, roll2, 1);
					move.movetoSet(moveto2);

					if(moveto2 != 0) { // this is new
					move.makemove(1);
					int yco2 = checkers.topchecker(choice2, 1)[0];
					int xco2 = checkers.topchecker(choice2, 1)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					else {
						System.out.print("Cant move here\n");
					}
					break;
				}
				checkers.UpdatePos();
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
					int moveto2 = move.legalMoves(checkers.duplicates(1),choice2 , found2, roll1, 0, 1);
/* ****** */		move.movetoSet(moveto2);  // this function could be wrong and bypassing error checks from legal ??


					if(moveto2 != 0) { // this is new
						move.makemove(1);
						int yco2 = checkers.topchecker(choice2, 1)[0];
						int xco2 = checkers.topchecker(choice2, 1)[1];
						board.getSet()[yco2][xco2] = " ";
						checkers.UpdatePos();
						break;
						}
					else {
						System.out.print("Cant move here\n");
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
			checkers.UpdatePos();
			
			if("startnew".equalsIgnoreCase(input2)) {
				users[playerB].EndGame();
			}
			if("Q".equalsIgnoreCase(input2)) {
				//users[playerB].EndGame();
				System.out.println("Program Terminated");
				System.exit(0);
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
			while(!"r".equalsIgnoreCase(input2) && !"startnew".equalsIgnoreCase(input2));
			///////////////////////////////////////////////////////////////

		}
		while(!users[playerA].isGameOver() && !users[playerB].isGameOver() && users[playerA].getBearoff()<15 && users[playerB].getBearoff()<15);

		
		//!!!!!!!!!!!!!!!!!!!!!!!!1
		if(users[playerA].getBearoff()==15) {
			System.out.println( users[playerA].toString () + "wins");
			if(users[playerB].getBearoff()==0) {
				System.out.println("Game ended in a gammon");
				
			}
			else if(users[playerB].getBearoff()>0 && users[playerB].getBearoff()<15) {
				System.out.println("Game ended in a single");
			}
			else {
				System.out.println("Game ended in a backgammon");
			}
		}
		else if(users[playerB].getBearoff()==15){
			System.out.println( users[playerB].toString () + "wins");
			if(users[playerA].getBearoff()==0) {
				System.out.println("Game ended in a gammon");
			}
			else if(users[playerA].getBearoff()>0 && users[playerA].getBearoff()<15) {
				System.out.println("Game ended in a single");
			}
			else {
				System.out.println("Game ended in a backgammon");
			}
		}
		len--;
	}while(len>0);
		//!!!!!!!!!!!!!!!!!!!!!!!!!

		
		System.out.println("Game Over!");
	}//marks end of a match
}
