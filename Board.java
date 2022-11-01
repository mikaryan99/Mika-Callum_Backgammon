package Backgammon;

public class Board {
	
	private int MatrixX = 15, MatrixY =  20; //33
	private String[][] set = new String[MatrixY][MatrixX];
	
	Board() {
		
		// clears the matrix of null  
				for(int x = 0; x < MatrixX; x++){
				  for(int y = 0; y < MatrixY; y++){
				    set[y][x] = " ";
				  }
				}
		
		for(int x = 0;x<=MatrixX; x +=7) {			
			for(int y = 0; y<MatrixY; y++) {
				set[y][x] = "|";
			}
		}
		for(int y = 0;y<=MatrixY; y +=MatrixY-1) {			
			for(int x = 0; x<MatrixX; x++) {
				set[y][x] = "-";
			}
		}
	}
	
	public void printBoard() {
		
		for(int r=0;r<set.length; r++) {
			 for (int c=0; c< set[r].length; c++) {
				 System.out.format("%1s ",set [r][c] );
			 }
			 System.out.println();
			}
		
	}
	

}  