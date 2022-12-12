package Backgammon;

public class User {

	private String name;
	private int roll;
	private boolean X;
	private int bearoff;

	User (String name) {
		this.name = name;
		roll = 1;
		X = false;
		bearoff = 0;
	}

	public Boolean isGameOver() {
		return X;
	}

	public void EndGame() {
		X = true;
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


}
