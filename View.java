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
		// if not A B or C give error ******************************************88
		return ABC;

	}

	public int[] getDice() {

		//int[] numbers = new int[2];
		String[] number = new String[2];
	    //String s = in.next();

	   // numbers[0] = in.nextInt();
	  //  numbers[1] = in.nextInt();

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


}
