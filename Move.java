package Backgammon;

//import java.util.ArrayList;


public class Move{


	Move(){

    }

	// duplicates = spaces not free, positions = your checker locations, roll values
	// MIGHT NEED convert pip place to matrix pos function in checkers or board
	public void legalMoves(int[] duplicates, int position, boolean found, int roll1, int roll2) {  // int player)

		//possible moves
		int A,B,C;


		if(found) {
			A = position + roll1;
			B = position + roll2;
			C = position + roll1 + roll2;
			System.out.print("Legal move options are: \n A =  " + A + "\n B = " + B + "\n C = " + C + "\n");

		}
		else {
			System.out.println("Incorrect pip Choice ");
		}
	}


}
