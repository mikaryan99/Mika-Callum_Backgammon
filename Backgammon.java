package Backgammon;


public class Backgammon {
	public static void main (String[] args) {
		
		Board board = new Board();
		User[] users = new User[2];
		View view = new View();
		users[0] = new User(view.getName());
		users[1] = new User(view.getName());
		
		
		board.printBoard();
		
	}

}
