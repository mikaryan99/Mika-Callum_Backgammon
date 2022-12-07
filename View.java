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

	/*public String getABC(User user) {
		System.out.print(user + " enter A B or C: ");
		//in.nextLine();
		String ABC = in.nextLine();
		// if not int give error
		return ABC;

	}*/




	public String getABC() {
		System.out.println( "\n enter a choice: A B or C ");
		String ABC = in.nextLine();
		// if not A B or C give error ******************************************88
		return ABC;

	}

	public int[] getDice() {

		int[] numbers = new int[2];
	    //String s = in.next();

	    numbers[0] = in.nextInt();
	    numbers[1] = in.nextInt();

	     return numbers;
	}


}
