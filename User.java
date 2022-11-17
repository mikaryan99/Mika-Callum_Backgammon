package Backgammon;

public class User {

	private String name;
	private int roll;
	private boolean X;

	User (String name) {
		this.name = name;
		roll = 1;
		X = false;
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


}
