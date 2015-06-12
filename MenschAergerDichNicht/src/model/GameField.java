package model;

public class GameField {

	private token[] gamefield;
	private token[][] block;
	private token[][] house;
	private final char color[] = {'R','B','G','P'}; 
	private final int startposition[] = {30, 0, 10 ,20};
	
	private final int POSITIONS = 40;
	private final int PLAYER = 4;
	private final int HOUSESIZE = 4;
	private final int BLOCKSIZE = 4;
	
	private class token {
		public char color;
	
		public token(char color) {
			this.color = color;
		}
	}
	
	public GameField() {
		gamefield = new token[POSITIONS];
		block = new token[PLAYER][BLOCKSIZE];
		house = new token[PLAYER][HOUSESIZE];
		
		fillGameField();
		fillHouse();
		fillBlock();
	}
	
	private void fillBlock() {
		for(int i = 0; i < PLAYER; i++)
			for(int k = 0; k < BLOCKSIZE; k++) 
				block[i][k] = new token(color[i]);
	}
	
	private void fillHouse() {
		for(int i = 0; i < PLAYER; i++)
			for(int k = 0; k < HOUSESIZE; k++) 
				house[i][k] = new token(' ');
	}
	
	private void fillGameField() {
		for(int i = 0; i < POSITIONS ; i++) {
			gamefield[i] = new token('x');
		}
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
	
/////////////////////////////////////////////////
	
	//true bei Erfolg
	public boolean setStone(int idx, char color) {
		idx = idx % POSITIONS;
		if(0 > idx && gamefield[idx].color != color)
			return false;
		
		gamefield[idx].color = color;
		
		return true;
	}
	
	public int throwPlayer(int idx, char color) {
		idx = idx % POSITIONS;
		if(0 > idx && gamefield[idx].color == color)
			return -1;
		
		for(int i = 0; i < PLAYER; i++)
			if(this.color[i] == gamefield[idx].color)
				return i;
		
		return -1;				
	}
	
	public boolean getStoneBlock(int player) {
		for(int i = 0; i < BLOCKSIZE; i++) {
			if(block[player][i].color == color[player]) {
				block[player][i].color = ' ';
				return true;
			}
		}
		return false;		
	}
	
	public boolean setStoneBlock(int player) {
		for(int i = 3; i >= 0; i--) {
			if(block[player][i].color != color[player]) {
				block[player][i].color = color[player];
				return true;
			}
		}
		return false;
	}
	
	public boolean setStoneHouse(int player, int idx) {
		if(0 > idx || idx > 3 || house[player][idx].color == color[player])
			return false;
		
		house[player][idx].color = color[player];
		return true;		
	}
	
	public boolean moveOutOfHouse(int player) {
		if(color[player] != gamefield[startposition[player]].color) {
			gamefield[startposition[player]].color = color[player];
			return true;
		}
		return false;
	}
	
	//Boolean
	public boolean stoneInBlock(int player) {
		boolean stone = false;
		for(int i = 0; i < BLOCKSIZE;i++)
			stone = stone || block[player][i].color == color[player];
		return stone;
	}
}
