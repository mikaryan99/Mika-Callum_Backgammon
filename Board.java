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

		/*for(int x = 0;x<=MatrixX; x +=7) {
			for(int y = 0; y<MatrixY; y++) {
				set[y][x] = "|";
			}
		}*/

			//initial positions
				for (int i = 2;i<=6;i++){
					set[i][2] = "x";
				}
				for (int i = 2;i<=4;i++){
					set[i][5] = "o";
				}
				for (int i = 2;i<=6;i++){
					set[i][10] = "o";
				}
				for (int i = 2;i<=3;i++){
					set[i][15] = "x";
				}
				//lower half
				for (int i = 21;i>=17;i--){
					set[i][2] = "o";
				}
				for (int i = 21;i>=19;i--){
					set[i][5] = "x";
				}
				for (int i = 21;i>=17;i--){
					set[i][10] = "x";
				}
				for (int i = 21;i>=20;i--){
					set[i][15] = "o";
				}
				
				

		for(int y = 1; y< MatrixY-1; y++) {
			set[y][0]  = "|";
			set[y][7]  = "|";
			set[y][9]  = "|";
			set[y][16] = "|";
			set[y][18] = "|";
		}

		//for(int y = 0;y<=MatrixY; y +=MatrixY-1) {
			for(int x = 0; x<MatrixX; x++) {
				set[1][x] = "-";
				set[MatrixY-2][x] = "-";
			}
		//}
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

	/*public void intoBoard(String[][] in) {
		set[][]
	}*/


}   
