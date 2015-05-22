package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameField;

public class GameFieldTest {
	
	private GameField  gamefield;
	
	@Before
	public void setUp() {
		gamefield = new GameField();
	}
	
	@Test
	public void testgetStoneColor () {
		gamefield.setStone(0, 'B');
		assertEquals(' ', gamefield.getStoneColor(50));
		assertEquals(' ', gamefield.getStoneColor(-5));
		assertEquals('B', gamefield.getStoneColor(0));
		
	}
	
	@Test
	public void testgetStoneColorBlock () {
		assertEquals('R', gamefield.getStoneColorBlock(0, 0));
		
	}
	
	@Test
	public void testgetStoneColorHouse () {
		assertEquals(' ', gamefield.getStoneColorHouse(1, 1));
	}
	
	@Test
	public void testsetStone () {
		assertFalse(gamefield.setStone(-5, 'B'));
		assertTrue(gamefield.setStone(5, 'B'));
	}
	
	@Test
	public void teststoneInBlock () {
		assertTrue(gamefield.stoneInBlock(0));
		gamefield.getStoneBlock(0);
		gamefield.getStoneBlock(0);
		gamefield.getStoneBlock(0);
		gamefield.getStoneBlock(0);
		assertFalse(gamefield.stoneInBlock(0));
	}

	@Test
	public void testmoveOutOfHouse () {
		assertTrue(gamefield.moveOutOfHouse(0));
		gamefield.setStone(30, 'R');
		assertFalse(gamefield.moveOutOfHouse(0));
	}

	@Test
	public void testsetStoneBlock() {
		assertFalse(gamefield.setStoneBlock(0));
		gamefield.getStoneBlock(0);
		assertTrue(gamefield.setStoneBlock(0));
	}
	
	@Test
	public void testsetStoneHouse() {
		assertFalse(gamefield.setStoneHouse(0,4));
		assertFalse(gamefield.setStoneHouse(0, -1));
		assertTrue(gamefield.setStoneHouse(2, 0));
		assertFalse(gamefield.setStoneHouse(2, 0));
	}
	
	@Test
	public void testgetStoneBlock() {
		assertTrue(gamefield.getStoneBlock(0));
		gamefield.getStoneBlock(0);
		gamefield.getStoneBlock(0);
		gamefield.getStoneBlock(0);
		assertFalse(gamefield.getStoneBlock(0));	
	}
}
