package Backgammon;

import java.util.ArrayList;
import java.util.*;

public class Checkers {
	private int MatrixX = 19, MatrixY = 24;
	private Board board;
	//position of checkers in terms of display to viewer
	private ArrayList<Integer> Xcheckers = new ArrayList<Integer>();
	private ArrayList<Integer> Ocheckers = new ArrayList<Integer>();

	//position of checkers in terms of a respective player
	private ArrayList<Integer> XintermsO = new ArrayList<Integer>();
	private ArrayList<Integer> OintermsX = new ArrayList<Integer>();

	//position of checkers in terms of the matrix
	private ArrayList<Integer> Xmatrixpos = new ArrayList<Integer>();
	private ArrayList<Integer> Omatrixpos = new ArrayList<Integer>();

	private int[] displayX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
	private int[] displayO = {24, 23,22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 25};
	private int[] matrix =  {15, 14, 13, 12, 11, 10, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 8};

	Checkers(Board board){
		this.board = board;


		//initial positions
		for (int i = 2;i<=6;i++){
			board.getSet()[i][1] = "x";
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
			board.getSet()[i][1] = "o";
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


	public void UpdatePos() {

		Xcheckers.clear();
		Ocheckers.clear();
		OintermsX.clear();
		XintermsO.clear();
		Xmatrixpos.clear();
		Omatrixpos.clear();

		//TOP HALF
		for(int y=0; y < MatrixY/2; y++) {
		    for(int i=matrix.length/2; i < matrix.length; i++) {
		    	int x = matrix[i];
		    	int Xdisplayi = displayX[i];
		    	int Odisplayi = displayO[i];
				if(board.getSet()[y][x] == "x") {
						Xcheckers.add(Xdisplayi);
						XintermsO.add(Odisplayi);
						Xmatrixpos.add(x);
				}
				if(board.getSet()[y][x] == "o") {
					Ocheckers.add(Odisplayi);
					OintermsX.add(Xdisplayi);
					Omatrixpos.add(x);
			    }
			}
		}
		//BOTTOM HALF
		for(int y=MatrixY/2; y < MatrixY; y++) {
		    for(int i=0; i < matrix.length/2; i++) {
		    	int x = matrix[i];
		    	int Xdisplayi = displayX[i];
		    	int Odisplayi = displayO[i];
		    	if(board.getSet()[y][8] == "o") {
					Ocheckers.add(25);
					OintermsX.add(25);
					Omatrixpos.add(8);
					}
		    	if(board.getSet()[y][x] == "x") {
					Xcheckers.add(Xdisplayi);
					XintermsO.add(Odisplayi);
					Xmatrixpos.add(x);
					}
		    	if(board.getSet()[y][x] == "o") {
		    		Ocheckers.add(Odisplayi);
		    		OintermsX.add(Xdisplayi);
		    		Omatrixpos.add(x);
		    		}
			}
		}
		//System.out.println("O = " + OintermsX + "\n");
		//System.out.println("X = " + XintermsO + "\n");
	}


	public void getPipCount() {

		int TotalO=0, TotalX=0;
		for(int i = 0; i<Xcheckers.size();i++) {
			TotalX = TotalX + Xcheckers.get(i);
		}
		for(int i = 0; i<Ocheckers.size();i++) {
			TotalO = TotalO + Ocheckers.get(i);
		}

		System.out.println("x pip count: " + TotalX + "\n"); //******************************
		System.out.println("o pip count: " + TotalO + "\n");
	}


	// returns an int array containing pips where THE CURRENT PLAYER's checkers are present
	public int[] positions(int turn) {

		ArrayList<Integer> TEST = new ArrayList<Integer>();

		if(turn == 0) {
			 TEST = Xcheckers;
		}
		else {
			TEST = Ocheckers;
		}

		Set<Integer> pos = new HashSet<Integer>();

		for(int i = 0; i < TEST.size(); i++) {
			pos.add(TEST.get(i));
		}

		//Turns positions into an int array
		Object[] objpos = pos.toArray();
	    int intpos[] = new int[objpos.length];
	    for(int i=0; i<objpos.length; i++){
	         intpos[i] = (int) objpos[i];
	      }


		return intpos;

	}

	// returns an int array containing pip stacks of THE OPPOSING PLAYER that contain more than one checker
	public int[] duplicates(int turn) {

		ArrayList<Integer> TEST = new ArrayList<Integer>();

		if(turn == 0) {
			 TEST = OintermsX;
		}
		else {
			TEST = XintermsO;
		}

		Set<Integer> positions = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();

		for(int i = 0; i < TEST.size(); i++) {
			//positions.add(TEST.get(i));
            if(positions.add(TEST.get(i)) == false)
            	duplicates.add(TEST.get(i));
                //System.out.println(TEST.get(i) + "is duplicated");
        }

		//Turns duplicates into an int array
		Object[] objduplicates = duplicates.toArray();
	    int intduplicates[] = new int[objduplicates.length];
	    for(int i=0; i<objduplicates.length; i++){
	         intduplicates[i] = (int) objduplicates[i];
	       // System.out.println(intduplicates[i]);
	      }

		return intduplicates;

	}

	public int[] topchecker(int choice, int player){

		//board.printBoard(player);

		int xco,yco = 0;
		xco = matrix[choice-1];
		//System.out.println("xco = " + xco + "\n");

		if(player == 0) {
			if(choice>12) {
				for(int i =2; i<MatrixY/2; i++) {

					if(!"x".equals(board.getSet()[i][xco])) {
						yco = i-1;
						break;
					}
				  }
			}
			else {
				for(int i = MatrixY-3; i>MatrixY/2; i--) {

					if(!"x".equals(board.getSet()[i][xco])) {
						yco = i+1;
						break;
					}
				  }
			}
		}
		else {
			if(choice<13) {
				for(int i =2; i<MatrixY/2; i++) {

					if(!"o".equals(board.getSet()[i][xco])) {
						yco = i-1;
						break;
					}
				  }
			}
			else {
				for(int i = MatrixY-3; i>MatrixY/2; i--) {

					if(!"o".equals(board.getSet()[i][xco])) {
						yco = i+1;
						break;
					}
				  }

			}
		}

		int[] coordinates = {yco,xco};
		//System.out.println("yco = " + yco + "\n");

		return coordinates;
	}


}
