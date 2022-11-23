package Backgammon;


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
		Move move = new Move();

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




		do {

			///////////////////////////////////////////////////
			System.out.print("Current Player: " + users[playerA].toString() + "\n");
			board.printBoard(playerA);
			do {
			input1 = view.getCommand(users[playerA]);

			if("pip".equalsIgnoreCase(input1)) {
				checkers.UpdatePos();
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
			if("r".equalsIgnoreCase(input1)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				System.out.print(users[playerA] + " rolled " + roll1 + " and " + roll2 + "\n");
			}
			if("Q".equalsIgnoreCase(input1)) {
				users[playerA].EndGame();
			}
			if("hint".equalsIgnoreCase(input1)) {
				System.out.print("To show pip count of both players enter: pip \n");
				System.out.print("To quit the game enter: Q \n");
				System.out.print("To roll dice enter: r \n");
			}
			if(!"r".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1) && !"pip".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1) && !"hint".equalsIgnoreCase(input1)) {
				System.out.print("Invalid Command, Try again\n");
			}
			}

			while(!"r".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input1));

			/////////////////////////////////////////////////////


			System.out.print("Current Player: " + users[playerB].toString() + "\n");
			board.printBoard(playerB);
			do {
			input2 = view.getCommand(users[playerB]);
			if("pip".equalsIgnoreCase(input2)) {
				checkers.UpdatePos();
				checkers.getPipCount();
				//checkers.duplicates(1);
			}
			if("r".equalsIgnoreCase(input2)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				System.out.println(users[playerB] + " rolled " + roll1 + " and " + roll2 + "\n");
			}
			if("Q".equalsIgnoreCase(input2)) {
				users[playerB].EndGame();
			}
			if(!"r".equalsIgnoreCase(input2) && !"Q".equalsIgnoreCase(input2) && !"pip".equalsIgnoreCase(input2) && !"Q".equalsIgnoreCase(input2) && !"hint".equalsIgnoreCase(input2)) {
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
