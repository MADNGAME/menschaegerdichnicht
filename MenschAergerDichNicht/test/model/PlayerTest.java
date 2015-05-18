package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Player;

public class PlayerTest {

	Player player;
	
	@Before
	public void setUp() {
		player = new Player(1, "Peter", 'B');
	}
	
	@Test
	public void testgetIdx() {
		assertEquals(1, player.getIdx());
	}
	
	@Test
	public void testgetName() {
		assertEquals("Peter", player.getName());
	}
	
	@Test
	public void testgetColor() {
		assertEquals('B', player.getColor());
	}
	
	
}
