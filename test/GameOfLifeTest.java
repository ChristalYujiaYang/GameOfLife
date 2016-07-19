
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this

	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}

	/**
	 * Test that toString() method gives the same result as before after
	 * modification
	 * 
	 * @author Yujia Yang
	 */

	// In this test case, we assume the cell is dead, then we use toString()
	// method and toStringOriginal()
	// to get text of the button and see whether they are the same or not.
	// Also, they should both equal to "."
	@Test
	public void toStringTest1() {
		Cell[][] cell = new Cell[1][1];
		cell[0][0] = new Cell();
		cell[0][0].setAlive(false);
		String original = cell[0][0].toStringOriginal();
		String modify = cell[0][0].toString();
		assertEquals(original, modify);
		assertEquals(original, ".");
		assertEquals(".", modify);
	}

	// In this test case, we assume the cell is alive, then we use toString()
	// method and toStringOriginal()
	// to get text of the button and see whether they are the same or not.
	// Also, they should both equal to "X"
	@Test
	public void toStringTest2() {
		Cell[][] cell = new Cell[1][1];
		cell[0][0] = new Cell();
		cell[0][0].setAlive(true);
		String original = cell[0][0].toStringOriginal();
		String modify = cell[0][0].toString();
		assertEquals(original, modify);
		assertEquals(original, "X");
		assertEquals("X", modify);
	}

	// In this test case, we assume the cell has been alive, then we use
	// toString() method and toStringOriginal()
	// to get text of the button and see whether they are the same or not.
	// Also, they should both equal to "."
	@Test
	public void toStringTest3() {
		Cell[][] cell = new Cell[1][1];
		cell[0][0] = new Cell();
		cell[0][0].setAlive(true);
		cell[0][0].setAlive(false);
		String original = cell[0][0].toStringOriginal();
		String modify = cell[0][0].toString();
		assertEquals(original, modify);
		assertEquals(original, ".");
		assertEquals(".", modify);
	}

	/**
	 * Test that getNumNeighbors(int x, int y) method gives the same result as
	 * before after modification
	 * 
	 * @author Yujia Yang
	 */

	// In this test case, we assume all of neighbors of the cell are dead, then
	// the number of neighbors of both method should be 0
	@Test
	public void getNumNeighborsTest1() {
		int size = 15;
		Cell[][] cell = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cell[i][j] = new Cell();
				cell[i][j].setAlive(false);
			}
		}
		MainPanel panel = new MainPanel(size);
		panel.setCells(cell);
		int original = panel.getNumNeighborsOriginal(3, 5);
		int modify = panel.getNumNeighbors(3, 5);
		assertEquals(original, modify);
		assertEquals(original, 0);
		assertEquals(0, modify);
	}

	// In this test case, we assume all of neighbors of the cell are alive, then
	// the number of neighbors of both method should be 8
	@Test
	public void getNumNeighborsTest2() {
		int size = 15;
		Cell[][] cell = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cell[i][j] = new Cell();
				cell[i][j].setAlive(true);
			}
		}
		MainPanel panel = new MainPanel(size);
		panel.setCells(cell);
		int original = panel.getNumNeighborsOriginal(0, 7);
		int modify = panel.getNumNeighbors(0, 7);
		assertEquals(original, modify);
		assertEquals(original, 8);
		assertEquals(8, modify);
	}

	// In this test case, we assume neighbors of the cell are either dead or
	// alive, then
	// the number of neighbors of both method should be equal to each other
	@Test
	public void getNumNeighborsTest3() {
		int size = 15;
		boolean[] alive = { true, false };
		Random random = new Random();
		Cell[][] cell = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cell[i][j] = new Cell();
				cell[i][j].setAlive(alive[random.nextInt(2)]);
			}
		}
		MainPanel panel = new MainPanel(size);
		panel.setCells(cell);
		int original = panel.getNumNeighborsOriginal(7, 14);
		int modify = panel.getNumNeighbors(7, 14);
		assertEquals(original, modify);
	}
}
