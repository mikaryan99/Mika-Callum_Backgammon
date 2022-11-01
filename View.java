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
}
