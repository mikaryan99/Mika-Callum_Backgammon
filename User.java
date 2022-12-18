// Team Name: group 17
// Student Names: Callum O'Brien, Mika ryan
// GitHub ids: callumob1, Mikaryan99

package Backgammon;

public class User {

	private String name;
	private int roll;
	private boolean X;
	private int bearoff;
	private boolean readnext;
	private int score;

	User (String name) {
		this.name = name;
		roll = 1;
		X = false;
		bearoff = 0;
		readnext=false;
		score=0;
	}


	public Boolean isGameOver() {
		return X;
	}

	public void EndGame() {
		X = true;
	}
	
	public void nEndGame() {
		X = false;
	}

	public void setEndGame() {
		X = false;
	}

	public void move(int roll) {
		this.roll = roll;
	}

	public int getroll() {
		return roll;
	}

	public String toString () {
		return name;
	}

	public void addBearoff() {
		bearoff = bearoff+1;
	}

	public int getBearoff() {
		return bearoff;
	}

	public void resetBear() {
		bearoff = 0;
	}

	public void readNextLineT() {
		readnext=true;
	}
	public void readNextLineF() {
		readnext=false;
	}
	public boolean getReadNext() {
		return readnext;
	}
	public int getscore() {
		return score;
	}
	public void scoreadd(int x) {
		score=score+x;
	}


}
