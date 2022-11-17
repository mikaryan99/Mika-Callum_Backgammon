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
		// if not int give error
		return number;

	}


}
