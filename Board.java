package Backgammon;

public class Board {

	private int MatrixX = 19, MatrixY =  24; //33
	private String[][] set = new String[MatrixY][MatrixX];

	User[] users;

	Board(User[] users) {
		this.users = users;

		// clears the matrix of null
				for(int x = 0; x < MatrixX; x++){
				  for(int y = 0; y < MatrixY; y++){
				    set[y][x] = " ";
				  }
				}


		for(int y = 1; y< MatrixY-1; y++) {
			set[y][0]  = "|";
			set[y][7]  = "|";
			set[y][9]  = "|";
			set[y][16] = "|";
			set[y][18] = "|";
		}

			for(int x = 0; x<MatrixX; x++) {
				set[1][x] = "-";
				set[MatrixY-2][x] = "-";
			}
	}


	public void printBoard(int turn) {

		if(turn == 1) {
			for(int i = 13, x = 1; i<=24; i++, x++) {
				 String s = Integer.toString(i);
				 if(x==7 | x==8 | x==9) {
					 set[0][x] = " ";
					 i--;
				 }
				 else set[0][x] = s;
			}

			for(int i = 12, x = 1; i>0; i--, x++) {
				 String s = Integer.toString(i);
				 if(x==7 | x==8 | x==9) {
					 set[MatrixY-1][x] = " ";
					 i++;
				 }
				 else set[MatrixY-1][x] = s;
			}
		}
		else {
			for(int i = 12, x = 1; i>0; i--, x++) {
				 String s = Integer.toString(i);
				 if(x==7 | x==8 | x==9) {
					 set[0][x] = " ";
					 i++;
				 }
				 else set[0][x] = s;
			}

			for(int i = 13, x = 1; i<=24; i++, x++) {
				 String s = Integer.toString(i);
				 if(x==7 | x==8 | x==9) {
					 set[MatrixY-1][x] = " ";
					 i--;
				 }
				 else set[MatrixY-1][x] = s;
			}
		}

		for(int r=0;r<set.length; r++) {
			 for (int c=0; c< set[r].length; c++) {
				 System.out.format("%3s ",set [r][c] );
			 }
			 System.out.println();
			}

	}

	public String[][] getSet() {
		return set;
	}

	public boolean correctPosition(int choice, int[] positions) {
		boolean found = false;
		for (int i : positions) {
			//System.out.print(i + "This should be positions \n");
			if (choice == i) {
				//System.out.print("Choice is found" + choice);
				found = true;
			}
		}
		// BUGGING System.out.print(found);
		return found;
	}


	/*public void intoBoard(String[][] in) {
		set[][]
	}*/


}
