package Backgammon;

public class Move{

	private View view = new View();
	User[] users;
	private Board board;
	private Checkers checkers;
	private int moveto = 0;


	Move(User[] users, Board board, Checkers checkers){
		this.users = users;
		this.board = board;
		this.checkers = checkers;
    }


	/* legalMoves takes in the users chosen pip and calculates and returns the legal moves possible from this position
	 * it returns a 0 if no legal moves or found */

	public int legalMoves(int[] duplicates, int choice, boolean found, int roll1, int roll2, int player) {


		int A,B,C;

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
			// TEST
			boolean flag = false;
			for(int i=0; i < checkers.positions(player).length; i++) {
				if(checkers.positions(player)[i] > 6) {
					flag = true;
					break;
				}
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

			}

			if(flag) {
				if(A <= 0) {
					Avalid = false;
				}
				if(B <= 0) {
					Bvalid = false;
				}
				if(C <= 0) {
					Cvalid = false;
				}
			}
			else {
				if(A <= 0) {
					Avalid = true;
					A = 26;
				}
				if(B <= 0) {
					Bvalid = true;
					B = 26;
				}
				if(C <= 0) {
					Cvalid = true;
					C = 26;
				}
			}

			if(Avalid && Bvalid && Cvalid) {
				System.out.println("Legal move options are: \n A =  " + A + "\n B = " + B + "\n C = " + C );
			}
			if(!Avalid && Bvalid && Cvalid) {
				System.out.println("Legal move options are: \n B =  " + B + "\n C = " + C );
			}
			if(Avalid && !Bvalid && Cvalid) {
				System.out.println("Legal move options are: \n A =  " + A + "\n C = " + C );
			}
			if(Avalid && Bvalid && !Cvalid) {
				System.out.println("Legal move options are: \n A =  " + A + "\n B = " + B );
			}
			if(Avalid && !Bvalid && !Cvalid) {
				System.out.println("Legal move options are: \n A =  " + A + "\n");
				skip = true;
				System.out.println("A was selected\n");
				moveto = A;//make move A

			}
			if(!Avalid && Bvalid && !Cvalid) {
				System.out.println("Legal move options are: " + "\n B = " + B + "\n");
				skip = true;
				System.out.println("B was selected\n");
				moveto = B;//make move B

			}
			if(!Avalid && !Bvalid && Cvalid) {
				System.out.println("Legal move options are: " + "\n C = " + C + "\n");
				skip = true;
				System.out.println("C was selected\n");
				moveto = C;//make move C

			}
			////TEST
			if(!Avalid && !Bvalid && !Cvalid) {
				System.out.println("No Moves Available, Next Player \n");
				skip = true;
			}


			if(!skip) {
			String ABC1 = view.getABC();

			if("A".equalsIgnoreCase(ABC1)) {
				System.out.println("A was selected\n");
				moveto = A;//make move A

			}
			if("B".equalsIgnoreCase(ABC1)) {
				System.out.println("B was selected\n");
					moveto = B;//make move B

			}
			if("C".equalsIgnoreCase(ABC1)) {
				System.out.println("C was selected\n");
						moveto = C;//make move C

			}
		  }



		}
		else {
			System.out.println("Incorrect pip Choice ");
            //no move made
		}
		return moveto;
	}

	/* method takes a desired location to move a checker, method recognise's if
	 * this move will be a hit and will move the corresponding checker
	 * to the mid board if so */
	public void makemove(int player) {

		boolean skip = false;
		if(moveto == 26) {
			skip = true;
		}

		if(!skip) {

			int yco = checkers.topchecker(moveto, player)[0];
			int xco = checkers.topchecker(moveto, player)[1];

			if(player == 0) {

				if(moveto>12) {

					if(board.getSet()[yco+1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 1)[0]-1][8] = "o";
					}

					board.getSet()[yco+1][xco] = "x";
				}
				else {

					if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 1)[0]-1][8] = "o";
					}

					board.getSet()[yco-1][xco] = "x";

				}
			}
			else {

				if(moveto>12) {

					if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 0)[0]+1][8] = "x";
					}

					board.getSet()[yco-1][xco] = "o"; //top half
					}
				else {

					if(board.getSet()[yco+1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 0)[0]+1][8] = "x";
					}

					board.getSet()[yco+1][xco] = "o"; //bottom half

				}
		    }
		}
		else {

			users[player].addBearoff();
		}
	}

	public void movetoSet(int x) {
		moveto=x;
	}

}
