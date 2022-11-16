package Backgammon;

public class Checkers {
	private int MatrixX = 19, MatrixY = 24;
	private Board board;
	
	Checkers(Board board){
		this.board = board;
		
		
		//initial positions
		for (int i = 2;i<=6;i++){
			board.getSet()[i][2] = "x";
		}
		for (int i = 2;i<=4;i++){
			board.getSet()[i][5] = "o";
		}
		for (int i = 2;i<=6;i++){
			board.getSet()[i][10] = "o";
		}
		for (int i = 2;i<=3;i++){
			board.getSet()[i][15] = "x";
		}
		//lower half
		for (int i = 21;i>=17;i--){
			board.getSet()[i][2] = "o";
		}
		for (int i = 21;i>=19;i--){
			board.getSet()[i][5] = "x";
		}
		for (int i = 21;i>=17;i--){
			board.getSet()[i][10] = "x";
		}
		for (int i = 21;i>=20;i--){
			board.getSet()[i][15] = "o";
		}
	}
	
	public void findCheckers() {
		//find X
		for(int y=0; y < MatrixY; y++) {
		    for(int i=0; i < MatrixX; i++) {
				if(board.getSet()[y][i] == "x") {
					//int flag=0;
					System.out.print( i + "\n"); //board.getSet()[y][i]
				}
			}
		}
		//find Y
		
	}

	public void legalMoves() {
		
	}
} 
