package Backgammon;

public class Dice {
	private final static double SIDES_ON_DICE = 6.0;

	public final static int getRoll () {
		double roll = Math.random()*SIDES_ON_DICE+1.0;
		return (int) roll;
	}

	public int[] getTurn(int roll1, int roll2) {
		int[] turns = new int[2];

		if(roll1 > roll2) {
			turns[0] = 0;
			turns[1] = 1;
			return turns;

		}
		else {
			turns[0] = 1;
			turns[1] = 0;
			return turns;

		}
	}

}
