package Backgammon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new User("Tom");
	}

	@Test
	@DisplayName("Checks that an object has been created.")
	void testUser() {
		assertNotNull(user);
	}

	@Test
	void testIsGameOver() {
		assertEquals(false,user.isGameOver());
	}

	@Test
	void testEndGame() {
		user.EndGame();
		assertEquals(true,user.isGameOver());
	}

	@Test
	void testMove() {
		Random rand = new Random();
		int X = rand.nextInt(12 - 1 + 1) + 1;
		user.move(X);
		assertEquals(X,user.getroll());
	}

	@Test
	void testGetroll() {
		assertNotNull(user.getroll());
	}

	@Test
	void testToString() {
		assertEquals("Tom",user.toString());
	}

	@Test
	void testAddBearoff() {
		int X = user.getBearoff();
		user.addBearoff();
		assertEquals(X+1,user.getBearoff());
	}

	@Test
	void testGetBearoff() {
		assertNotNull(user.getBearoff());
	}

	@Test
	void testReadNextLineT() {
		user.readNextLineT();
		assertEquals(true,user.getReadNext());
	}

	@Test
	void testReadNextLineF() {
		user.readNextLineF();
		assertEquals(false,user.getReadNext());
	}

	@Test
	void testGetReadNext() {
		assertNotNull(user.getReadNext());
	}

	@Test
	void testGetscore() {
		assertNotNull(user.getscore());
	}

	@Test
	void testScoreadd() {
		Random rand = new Random();
		int X = rand.nextInt(3 - 1 + 1) + 1;
		user.scoreadd(X);
		assertEquals(X,user.getscore());
	}

}
