package Backgammon;

public class User {

	private String name;
	private int roll;

	User (String name) {
		this.name = name;
		roll = 1;
	}

	public Boolean isGameOver() {
		return true;
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
