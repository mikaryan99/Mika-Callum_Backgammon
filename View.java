// Team Name: group 17
// Student Names: Callum O'Brien, Mika ryan
// GitHub ids: callumob1, Mikaryan99

package Backgammon;

import java.util.Scanner;


public class View {

	Scanner in;

	View () {
		in = new Scanner(System.in);
	}

	public String getName () {
		System.out.println("Enter the player name: ");
		String name = in.nextLine();
		return name;
	}

	public String getCommand (User user) {
		System.out.println(user + " enter command: ");
		String name = in.nextLine();

			return name;
	}



	public int getInt(User user) {
		System.out.println(user + " enter an integer: ");
		String number = in.nextLine();
		int num=0;
		try {
		    num = Integer.parseInt(number);
		} catch (NumberFormatException e) {
		    System.out.println("This is not a valid integer");
		}
		return num;

	}



	public String getABC() {
		System.out.println( "\n enter a letter choice: ");
		String ABC = in.nextLine();
		return ABC;

	}

	public int[] getDice() {

		String[] number = new String[2];

	    number[0] = in.next();
	    number[1] = in.next();
	    in.nextLine();

		int[] num = new int[2];
		for(int i = 0; i<2; i++) {
			try {
			    num[i] = Integer.parseInt(number[i]);
			} catch (NumberFormatException e) {
			    System.out.println("This is not a valid integer");
			}
		}


	     return num;
	}

	public int getLength() {
		System.out.println("Enter Match Length: ");

		String len = in.nextLine();
		int matchlength=0;
		try {
			matchlength = Integer.parseInt(len);
		} catch (NumberFormatException e) {
		    System.out.println("This is not a valid integer");
		}
		System.out.println("The Length of the Match is : " + matchlength);
		return matchlength;
	}


}
   