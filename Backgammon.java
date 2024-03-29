// Team Name: group 17
// Student Names: Callum O'Brien, Mika ryan
// GitHub ids: callumob1, Mikaryan99


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


		int playerA, playerB;

		int matchlength = view.getLength();

		final String FILE_NAME = "Player1.txt";
		Scanner scnr = new Scanner(new FileInputStream(FILE_NAME));


		do {

		Board board = new Board(users);
		Checkers checkers = new Checkers(board);
		Dice dice = new Dice();
		Move move = new Move(users, board, checkers);

		String input1, input2;

		int roll1, roll2;


		roll1 = dice.getRoll();
		roll2 = dice.getRoll();
		//Decide who goes first
		users[0].move(roll1);
		System.out.println(users[0] + " rolled " + roll1 + "\n");
		users[1].move(roll2);
		System.out.println(users[1] + " rolled " + roll2 + "\n");

		playerA = dice.getTurn(roll1, roll2)[0];
		playerB = dice.getTurn(roll1, roll2)[1];
		System.out.println(users[dice.getTurn(roll1, roll2)[0]] + " goes first \n");
		users[playerA].setEndGame();
		users[playerB].setEndGame();



		do {

			checkers.UpdatePos();

			System.out.println("Current Player: " + users[playerA].toString() + "\n"+ "Match Length: " + matchlength);
			board.printBoard(0);
			do {
					//Reading commands from text file or scanning user input
					if(users[playerA].getReadNext()) {
						input1 = "test Player1.txt";
					}
					else {
						input1 = view.getCommand(users[playerA]);
					}

				//Read commands from text file
				if("test Player1.txt".equalsIgnoreCase(input1)) {
					input1=scnr.nextLine();
					if(scnr.hasNext()) {
						users[playerA].readNextLineT();
					}
					else {
						users[playerA].readNextLineF();
					}
				}

			//Pip cout
			if("pip".equalsIgnoreCase(input1)) {
				checkers.getPipCount();
				checkers.duplicates(0);
			}

			//Roll dice
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
				System.out.println(users[playerA] + " rolled " + roll1 + " and " + roll2 + "\n");


				//Find valid moves + move selection
				checkers.duplicates(0);
				int choice = view.getInt(users[playerA]);
				boolean found = board.correctPosition(choice,checkers.positions(0));
				int moveto = move.legalMoves(checkers.duplicates(0),choice , found, roll1, roll2, 0);

				//Bearing off
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

					//Second choice
					checkers.duplicates(0);
					int choice2 = view.getInt(users[playerA]); 
					boolean found2 = board.correctPosition(choice2,checkers.positions(0));

					int moveto2 = move.legalMoves(checkers.duplicates(0),choice2 , found2, 0, roll2, 0);

					if(moveto2 > 0) { 
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}

					else {
						System.out.println("Cant move here\n");
					}
					break;
				}
				//Chosen B
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

					if(moveto2 > 0) {
					move.makemove(0);
					int yco2 = checkers.topchecker(choice2, 0)[0];
					int xco2 = checkers.topchecker(choice2, 0)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					else {
						System.out.println("Cant move here\n");
					}

					break;
				}

				//Chosen C
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

			//Start new game
			if("startnew".equalsIgnoreCase(input1)) {
				users[playerA].EndGame();
			}
			//Quit Game
			if("Q".equalsIgnoreCase(input1)) {
				System.out.println("Program Terminated");
				System.exit(0);
			}
			//Prints command options
			if("hint".equalsIgnoreCase(input1)) {
				System.out.println("To show pip count of both players enter: pip \n");
				System.out.println("To quit the game enter: Q \n");
				System.out.println("To roll dice enter: r \n");
				System.out.println("To start new game enter: startnew \n");
				System.out.println("To set dice roll enter: \n dice \n integer integer \n");
			}
			if(!"r".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1) && !"pip".equalsIgnoreCase(input1) && !"dice".equalsIgnoreCase(input1) && !"hint".equalsIgnoreCase(input1)) {
				System.out.println("Invalid Command, Try again\n");
			}
			}

			while(!"r".equalsIgnoreCase(input1) && !"startnew".equalsIgnoreCase(input1));

			/////////////////////////PLAYER TWO////////////////////////////

			checkers.UpdatePos();
			System.out.println("Current Player: " + users[playerB].toString()+ "\n" + "Match Length: " + matchlength);
			board.printBoard(1);
			do {
				checkers.UpdatePos();

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
				System.out.println(users[playerB] + " rolled " + roll1 + " and " + roll2 +"\n");

				checkers.duplicates(1);
				int choice = view.getInt(users[playerB]);
				boolean found = board.correctPosition(choice,checkers.positions(1));
				int moveto = move.legalMoves(checkers.duplicates(1),choice , found, roll1, roll2, 1);

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

					if(moveto2 != 0) { 
					move.makemove(1);
					int yco2 = checkers.topchecker(choice2, 1)[0];
					int xco2 = checkers.topchecker(choice2, 1)[1];
					board.getSet()[yco2][xco2] = " ";
					checkers.UpdatePos();
					break;
					}
					else {
						System.out.println("Cant move here\n");
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


					if(moveto2 != 0) { 
						move.makemove(1);
						int yco2 = checkers.topchecker(choice2, 1)[0];
						int xco2 = checkers.topchecker(choice2, 1)[1];
						board.getSet()[yco2][xco2] = " ";
						checkers.UpdatePos();
						break;
						}
					else {
						System.out.println("Cant move here\n");
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
				System.out.println("Program Terminated");
				System.exit(0);
			}
			if(!"r".equalsIgnoreCase(input2) && !"Q".equalsIgnoreCase(input2) && !"pip".equalsIgnoreCase(input2) && !"hint".equalsIgnoreCase(input2) && !"dice".equalsIgnoreCase(input2)) {
				System.out.println("Invalid Command, Try again\n");
			}
			if("hint".equalsIgnoreCase(input2)) {
				System.out.println("To show pip count of both players enter: pip \n");
				System.out.println("To quit the game enter: Q \n");
				System.out.println("To roll dice enter: r \n");
				System.out.println("To start new game enter: startnew \n");
				System.out.println("To set dice roll enter: \n dice \n integer integer \n");
			}
			}
			while(!"r".equalsIgnoreCase(input2) && !"startnew".equalsIgnoreCase(input2));

		}
		while(!users[playerA].isGameOver() && !users[playerB].isGameOver() && users[playerA].getBearoff()<15 && users[playerB].getBearoff()<15);

		//Decide winner and allocate scoring
		if(users[playerA].getBearoff()==15) {
			System.out.println( users[playerA].toString () + "wins");
			if(users[playerB].getBearoff()==0) {
				System.out.println("Game ended in a gammon");
				users[playerA].scoreadd(2);
			}
			else if(users[1].getBearoff()>0 && users[playerB].getBearoff()<15) {
				System.out.println("Game ended in a single");
				users[playerA].scoreadd(1);
			}
			else {
				System.out.println("Game ended in a backgammon");
				users[playerA].scoreadd(3);
			}
		}
		else if(users[1].getBearoff()==15){
			System.out.println( users[playerB].toString () + "wins");
			if(users[playerA].getBearoff()==0) {
				System.out.println("Game ended in a gammon");
				users[playerB].scoreadd(2);
			}
			else if(users[playerA].getBearoff()>0 && users[playerA].getBearoff()<15) {
				System.out.println("Game ended in a single");
				users[playerB].scoreadd(1);
			}
			else {
				System.out.println("Game ended in a backgammon");
				users[playerB].scoreadd(3);
			}
		}
		matchlength--;
		users[playerA].resetBear();
		users[playerB].resetBear();
	}while(matchlength>0);

		if(users[playerA].getscore()>users[playerB].getscore()) {
			System.out.println("Match Over!" + users[playerA].toString() +" wins!" );
		}
		else {
			System.out.println("Match Over! \n" + users[playerB].toString() +" wins!" );
		}


	}
}
