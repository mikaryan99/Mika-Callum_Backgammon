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
		//checkers.findCheckers();
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
			System.out.print("Current Player: " + users[playerA].toString() + "\n");
			board.printBoard(playerA);
			input1 = view.getCommand(users[playerA]);
			if("pip".equalsIgnoreCase(input1)) {
				checkers.getPipCount();
			}
			if("r".equalsIgnoreCase(input1)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				System.out.print(users[playerA] + " rolled " + roll1 + " and " + roll2 + "\n");
			}
			
			
			System.out.print("Current Player: " + users[playerB].toString() + "\n");
			board.printBoard(playerB);
			input2 = view.getCommand(users[playerB]);
			if("pip".equalsIgnoreCase(input2)) {
				checkers.getPipCount();
			}
			if("r".equalsIgnoreCase(input2)) {
				roll1 = dice.getRoll();
				roll2 = dice.getRoll();
				System.out.println(users[playerB] + " rolled " + roll1 + " and " + roll2 + "\n");
			}

		}
		while(!"Q".equalsIgnoreCase(input1) && !"Q".equalsIgnoreCase(input2));

		System.out.println("Game Over!");
	}


}
