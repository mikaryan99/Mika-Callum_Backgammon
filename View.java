package Backgammon;

import java.util.Scanner;


public class View {

	Scanner in;

	View () {
		in = new Scanner(System.in);
	}

	public String getName () {
		System.out.print("Enter the player name: ");
		String name = in.nextLine();
		return name;
	}

	public String getCommand (User user) {
		System.out.print(user + " enter command: ");
		String name = in.nextLine();
		return name;
	}

	public int getInt(User user) {
		System.out.print(user + " enter an integer: ");
		int number = in.nextInt();
		// if not int give error *************************************************8
		return number;

	}


	public String getABC() {
		System.out.println( "\n enter a choice: A B or C ");
		String ABC = in.nextLine();
		// if not A B or C give error ******************************************88
		return ABC;

	}

}
