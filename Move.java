package Backgammon;

//import java.util.ArrayList;


public class Move{

	private View view = new View();
	User[] users; // = new User[2];
	private Board board;// = new Board(users);
	private Checkers checkers;// = new Checkers(board);
	private int moveto = 0;
	//private int centreO =0, centreX =0;

	Move(User[] users, Board board, Checkers checkers){
		this.users = users;
		this.board = board;
		this.checkers = checkers;
    }

	// duplicates = spaces not free, positions = your checker locations, roll values
	// MIGHT NEED convert pip place to matrix pos function in checkers or board (choice was position
	public int legalMoves(int[] duplicates, int choice, boolean found, int roll1, int roll2, int player) {  // int player)

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
			// TEST
			boolean flag = false;
			for(int i=0; i < checkers.positions(player).length; i++) {
				if(checkers.positions(player)[i] > 6) {
					flag = true;
					break;
				}
			}
			//*****

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
				System.out.print("No Moves Available, Next Player \n");
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
					/*if(board.getSet()[yco+1][xco] != " ") {
						board.getSet()[21-centreO][8] = "o";
						//centreO++;
					}*/
					board.getSet()[yco+1][xco] = "x";
					//System.out.println("ITS WORKING SORTA");
				}
				else {

					if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 1)[0]+1][8] = "o";
					}
					/*if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[21-centreO][8] = "o";
						centreO++;
					}*/
					board.getSet()[yco-1][xco] = "x";

				}
			}
			else {

				if(moveto>12) {

					if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 1)[0]+1][8] = "x";
					}
					/*if(board.getSet()[yco-1][xco] != " ") {
						board.getSet()[2+centreX][8] = "x";
						centreX++;
					}*/
					board.getSet()[yco-1][xco] = "o"; //top half
					}
				else {

					if(board.getSet()[yco+1][xco] != " ") {
						board.getSet()[checkers.topchecker(25, 1)[0]-1][8] = "x";
					}
					/*if(board.getSet()[yco+1][xco] != " ") {
						board.getSet()[2+centreX][8] = "x";
						centreX++;
					}*/
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
