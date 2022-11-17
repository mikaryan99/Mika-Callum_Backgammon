package Backgammon;

import java.util.ArrayList;
import java.util.*;

public class Checkers {
	private int MatrixX = 19, MatrixY = 24;
	private Board board;
	private ArrayList<Integer> Xcheckers = new ArrayList<Integer>();
	private ArrayList<Integer> Ocheckers = new ArrayList<Integer>();
	private ArrayList<Integer> douplicates = new ArrayList<Integer>();

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

	public void getPipCount() {
		//find X

		//countT = top of board countB = bottom of board
		int countT = 0;
		int countB = 0;

		// The count method for X could be wrong
		// X and O will swap
		for(int y=0; y < MatrixY/2; y++) {
		    for(int i=0; i < MatrixX; i++) {
				if(board.getSet()[y][i] == "x") {
					if (i<9) {
						countT=countT+(12+i);
						Xcheckers.add(12+i);
					}
					if (i>9) {
						countT=countT+(9+i);
						Xcheckers.add(9+i);
					}
				}
			}
		}

		for(int y=MatrixY/2; y < MatrixY; y++) {
		    for(int i=0, j = 13, k = -16; i < MatrixX; i++, j--, k = k+2) {
				if(board.getSet()[y][i] == "x") {
					if (i<9) {
						countB=countB+(13-i);
						Xcheckers.add(j);
					}
					if (i>9) {
						countB=countB+(16-i);
						Xcheckers.add(i-k);
					}
				}
			}
		}
		int Totalx = countT+countB;

		// Find o
		int countT1 = 0;
		int countB1 = 0;

		for(int y=0; y < MatrixY/2; y++) {
		    for(int i=0; i < MatrixX; i++) {
				if(board.getSet()[y][i] == "o") {
					if (i<9) {
						countT1=countT1+(13-i);
						Ocheckers.add(12+i);
					}
					if (i>9) {
						countT1=countT1+(16-i);
						Ocheckers.add(9+i);
					}
				}
			}
		}

		for(int y=MatrixY/2; y < MatrixY; y++) {
		    for(int i=0; i < MatrixX; i++) {
				if(board.getSet()[y][i] == "o") {
					if (i<9) {
						countB1=countB1+(12+i); // correct
						Ocheckers.add(13-i);
					}
					if (i>9) {
						countB1=countB1+(9+i);
						Ocheckers.add(16-i);
					}
				}
			}
		}
		int Totalo = countT1+countB1;
		System.out.print("x pip count: " + Totalx + "\n"); //******************************
		System.out.print("o pip count: " + Totalo + "\n");
		System.out.println("x checkers pos = " + Xcheckers + "\n");
		System.out.println("o checkers pos = " + Ocheckers + "\n");


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

		//System.out.print(pos + "this");

		//Turns positions into an int array
		Object[] objpos = pos.toArray();
	    int intpos[] = new int[objpos.length];
	    for(int i=0; i<objpos.length; i++){
	         intpos[i] = (int) objpos[i];
	         //System.out.println(intpos[i]);
	      }
	    //System.arraycopy(objpos, 0, intpos, 0, objpos.length);

		return intpos;

	}

	// returns an int array containing pip stacks of THE OPPOSING PLAYER that contain more than one checker
	public int[] duplicates(int turn) {

		ArrayList<Integer> TEST = new ArrayList<Integer>();

		if(turn == 0) {
			 TEST = Ocheckers;
		}
		else {
			TEST = Xcheckers;
		}

		Set<Integer> positions = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();

		for(int i = 0; i < TEST.size(); i++) {
			positions.add(TEST.get(i));
            if(positions.add(TEST.get(i)) == false)
            	duplicates.add(TEST.get(i));
                //System.out.println(TEST.get(i) + "is duplicated");
        }
		//System.out.print(duplicates + "flag");

		//Turns duplicates into an int array
		Object[] objduplicates = duplicates.toArray();
	    int intduplicates[] = new int[objduplicates.length];
	    for(int i=0; i<objduplicates.length; i++){
	         intduplicates[i] = (int) objduplicates[i];
	         //System.out.println(intduplicates[i]);
	      }
	  //  System.arraycopy(objduplicates, 0, intduplicates, 0, objduplicates.length);

		return intduplicates;

	}



	public void legalMoves() {


	}
}
