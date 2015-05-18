package model;

public class GameField {

	private vertex[] gamefield;
	private vertex[][] block;
	private vertex[][] house;
	
	private final int POSITIONS = 40;
	private final int PLAYER = 4;
	private final int HOUSESIZE = 4;
	private final int BLOCKSIZE = 4;
	private final char color[] = {'R','B','G','P'}; 
	
	private class vertex {
		public char color;
	
		public vertex(char color) {
			this.color = color;
		}
	}
	
	public GameField() {
		gamefield = new vertex[POSITIONS];
		block = new vertex[PLAYER][BLOCKSIZE];
		house = new vertex[PLAYER][HOUSESIZE];
		
		fillGameField();
		fillHouse();
		fillBlock();
	}
	
	private void fillBlock() {
		for(int i = 0; i < PLAYER; i++)
			for(int k = 0; k < BLOCKSIZE; k++) 
				block[i][k] = new vertex(color[i]);
	}
	
	
	private void fillHouse() {
		for(int i = 0; i < PLAYER; i++)
			for(int k = 0; k < HOUSESIZE; k++) 
				house[i][k] = new vertex(' ');
	}


	private void fillGameField() {
		for(int i = 0; i < POSITIONS ; i++) {
			gamefield[i] = new vertex('x');
		}
	}
	
	public boolean setStone(int idx, char color) {
		if(0 >= idx || idx >= POSITIONS)
			return false;
		
		gamefield[idx].color = color;
		
		return true;
	}
	
	public char getStoneColor(int idx) {
		if(0 > idx || idx >= POSITIONS)
			return ' ';
		
		return gamefield[idx].color;
	}
	
	public char getStoneColorBlock(int player, int idx) {
		return block[player][idx].color;
	}
	
	public char getStoneColorHouse(int player, int idx) {
		return house[player][idx].color;
	}
	
}
