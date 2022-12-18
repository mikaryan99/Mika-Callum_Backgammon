// Team Name: group 17
// Student Names: Callum O'Brien, Mika ryan
// GitHub ids: callumob1, Mikaryan99

package Backgammon;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class DiceTest {
	private Dice dice;

	@Test
	void testGetRoll() {
		dice = new Dice();
		assertNotNull(dice.getRoll());
	}

	@Test
	void testGetTurn() {
		int[] turns = new int[2];
		int[] test = new int[2];

		int	roll1 = 6;
		int roll2 = 5;
		

			turns = dice.getTurn(roll1, roll2);
			assertEquals(0,turns[0]);
			assertEquals(1,turns[1]);

			

		
	

	}

}
