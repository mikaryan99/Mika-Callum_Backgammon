package Backgammon;

public class Dice {
	private final static double SIDES_ON_DICE = 6.0;    // changing to 1.0 is good for testing
	
	

	public final static int getRoll () {
		double roll = Math.random()*SIDES_ON_DICE+1.0;
		return (int) roll;
	}

	public int[] getTurn(int roll1, int roll2) {
		int[] turns = new int[2];

		if(roll1 > roll2) {
			//System.out.print(users[0] + " goes first \n");
			turns[0] = 0;
			turns[1] = 1;
			return turns;
			//playerA = 0;
			//playerB = 1;
		}
		else {
			turns[0] = 1;
			turns[1] = 0;
			return turns;
			/*System.out.print(users[1] + " goes first \n");
			playerB = 0;
			playerA = 1;*/
		}
	}

}
