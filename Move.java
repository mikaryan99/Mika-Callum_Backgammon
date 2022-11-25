package Backgammon;

//import java.util.ArrayList;


public class Move{

	private View view = new View();
	User[] users;
	private Board board = new Board(users);
	private Checkers checkers = new Checkers(board);
	private int moveto = 0;

	Move(Board board){
		this.board = board;
    }

	// duplicates = spaces not free, positions = your checker locations, roll values
	// MIGHT NEED convert pip place to matrix pos function in checkers or board (choice was position
	public int legalMoves(int[] duplicates, int choice, boolean found, int roll1, int roll2) {  // int player)

		//possible moves
		int A,B,C;
		//int moveto = 0; //return value  ************************ go bCK TO THIS ^^^^ BAD CODE
		boolean Avalid = true, Bvalid = true, Cvalid = true;
		boolean skip = false;




		if(found) {
			A = choice - roll1;
			B = choice - roll2;
			C = choice - roll1 - roll2;

			if(roll1 == 0) {
				return moveto=B;
			}
			if(roll2 == 0) {
				return moveto=A;
			}

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
				// if A B or C <= 0
				// valid = false;
			}
			if(A <= 0) {
				Avalid = false;
			}
			if(B <= 0) {
				Bvalid = false;
			}
			if(C <= 0) {
				Cvalid = false;
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
			////TEST
			if(!Avalid && !Bvalid && !Cvalid) {
				System.out.print("No Moves Available, Next Player");
				skip = true;
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

	public void makemove(int player) {              //int moveto, int player) {

		int yco = checkers.topchecker(moveto, player)[0];
		int xco = checkers.topchecker(moveto, player)[1];


		if(player == 0) {
			if(moveto>12) {
				board.getSet()[yco+1][xco] = "x";
				//System.out.println("ITS WORKING SORTA");
			}
			else {
				board.getSet()[yco-1][xco] = "x";
			}
		}
		else {
			if(moveto>12) {
				board.getSet()[yco-1][xco] = "o"; //top half
				}
			else {
				board.getSet()[yco+1][xco] = "o"; //bottom half
				}
	    }
	}

	public void movetoSet(int x) {
		moveto=x;
	}

}
