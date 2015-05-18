package controller;

import java.util.Random;

import model.*;

public class Controller implements IController {

	private GameField gamefield;
	private Player player0, player1, player2, player3, currentplayer;
	private int dice;
	
	public Controller() {
		gamefield = new GameField();
		player0 = new Player(0, "Hans", 'R');
		player1 = new Player(1, "Peter", 'B');
		player2 = new Player(2, "Meier", 'G');
		player3 = new Player(3, "HansWurst", 'P');
		
		currentplayer = player0;
	}
	
	
	
	public void dice() {
		Random r = new Random();
		dice = r.nextInt(6) + 1;
	}

	
	
	public boolean move(int idx) {
		if(gamefield.setStone(idx, 'x') && gamefield.setStone(idx + dice, currentplayer.getColor())) {
			return true;
		}
		return false;
		
	}
	
	public char getVertexColor(int idx) {
		return gamefield.getStoneColor(idx);
	}
	
	public char getVertexColorBlock(int player, int idx) {
		return gamefield.getStoneColorBlock(player, idx);
	}
	
	public char getVertexColorHouse(int player, int idx) {
		return gamefield.getStoneColorHouse(player, idx);
	}
	
	public boolean getOutOfTheHouse() {
		if(gamefield.StoneInBlock(currentplayer.getIdx()) && gamefield.inFrontOfHouseEmpty(currentplayer.getIdx()))
			return true;
			
		return false;
	}
	
}
