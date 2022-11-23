package Backgammon;

//import java.util.ArrayList;


public class Move{

	private View view = new View();

	Move(){

    }

	// duplicates = spaces not free, positions = your checker locations, roll values
	// MIGHT NEED convert pip place to matrix pos function in checkers or board (choice was position
	public int legalMoves(int[] duplicates, int choice, boolean found, int roll1, int roll2) {  // int player)

		//possible moves
		int A,B,C;
		int moveto = 0; //return value
		boolean Avalid = true, Bvalid = true, Cvalid = true;
		boolean skip = false;



		if(found) {
			A = choice - roll1;
			B = choice - roll2;
			C = choice - roll1 - roll2;

			for(int i = 0; i<duplicates.length; i++) {
				if(A == duplicates[i]) {
					Avalid = false;
				}
				if(B == duplicates[i]) {
					Bvalid = false;
				}
				if(C == duplicates[i]) {
					Cvalid = false;
				}
			}

			if(Avalid && Bvalid && Cvalid) {
				System.out.print("Legal move options are: \n A =  " + A + "\n B = " + B + "\n C = " + C );
			}
			if(!Avalid && Bvalid && Cvalid) {
				System.out.print("Legal move options are: \n B =  " + B + "\n C = " + C );
			}
			if(Avalid && !Bvalid && Cvalid) {
				System.out.print("Legal move options are: \n A =  " + A + "\n C = " + C );
			}
			if(Avalid && Bvalid && !Cvalid) {
				System.out.print("Legal move options are: \n A =  " + A + "\n B = " + B );
			}
			if(Avalid && !Bvalid && !Cvalid) {
				System.out.print("Legal move options are: \n A =  " + A + "\n");
				skip = true;
				System.out.print("A was selected\n");
				moveto = A;//make move A
				//update checkers
				//get another integer
				//make move (only one option using second dice)
				//update checkers
			}
			if(!Avalid && Bvalid && !Cvalid) {
				System.out.print("Legal move options are: " + "\n B = " + B + "\n");
				skip = true;
				System.out.print("B was selected\n");
				moveto = B;//make move B
				//update checkers
				//get another integer
				//make move (only one option using first dice)
				//update checkers
			}
			if(!Avalid && !Bvalid && Cvalid) {
				System.out.print("Legal move options are: " + "\n C = " + C + "\n");
				skip = true;
				System.out.print("C was selected\n");
				moveto = C;//make move C
				//update checkers
				//break
			}

			if(!skip) {
			String ABC1 = view.getABC();

			if("A".equalsIgnoreCase(ABC1)) {
				System.out.print("A was selected\n");
				moveto = A;//make move A
				//update checkers
				//get another integer
				//make move (only one option using second dice)
				//update checkers
			}
			if("B".equalsIgnoreCase(ABC1)) {
				System.out.print("B was selected\n");
					moveto = B;//make move B
					//update checkers
					//get another integer
					//make move (only one option using first dice)
					//update checkers
			}
			if("C".equalsIgnoreCase(ABC1)) {
				System.out.print("C was selected\n");
						moveto = C;//make move C
						//update checkers
						//break
			}
		  }



		}
		else {
			System.out.println("Incorrect pip Choice ");
            //no move made
		}
		return moveto;
	}


}


//take in A/B/C choice from user and return it
//if A return roll1
//nahhhht in Backgammon instead
