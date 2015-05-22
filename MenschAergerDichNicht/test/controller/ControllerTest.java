package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;


public class ControllerTest {
	
	private Controller controller;
	
	@Before
	public void setUp() {
		controller = new Controller();
	}
	
	@Test
	public void testdice() {
		controller.dice();
	}
	
	@Test
	public void testmove() {
		controller.dice();
		assertTrue(controller.move(0));
	}
	
	@Test
	public void testgetVertexColor() {
		assertEquals('x', controller.getVertexColor(0));
	}
	
	@Test
	public void testgetVertexColorBlock() {
		assertEquals('R', controller.getVertexColorBlock(0, 0));
	}
	
	@Test
	public void testgetVertexColorHouse() {
		assertEquals(' ', controller.getVertexColorHouse(0, 0));
	}
	
	@Test
	public void testgetOutOfHouse() {
		assertTrue(controller.getOutOfTheHouse());
		assertFalse(controller.getOutOfTheHouse());
	}

}
