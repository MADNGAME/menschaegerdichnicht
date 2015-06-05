package controller;

import java.util.Random;

import model.*;

public class Controller implements IController {

	private GameField gamefield;
	@SuppressWarnings("unused")
	private Player player0, player1, player2, player3, currentplayer;
	private int dice;
	
	public Controller() {
		gamefield = new GameField();
		player0 = new Player(0, "Hans", 'R');
		player1 = new Player(1, "Peter", 'B');
		player2 = new Player(2, "Kurt", 'G');
		player3 = new Player(3, "Marco", 'P');
		
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
	
	public boolean getOutOfTheHouse() {
		if(gamefield.stoneInBlock(currentplayer.getIdx()) && gamefield.moveOutOfHouse(currentplayer.getIdx()))
			return true;
			
		return false;
	}	
	
	public char getTokenColor(int idx) {
		return gamefield.getStoneColor(idx);
	}
	
	public char getTokenColorBlock(int player, int idx) {
		return gamefield.getStoneColorBlock(player, idx);
	}
	
	public char getTokenColorHouse(int player, int idx) {
		return gamefield.getStoneColorHouse(player, idx);
	}
}
