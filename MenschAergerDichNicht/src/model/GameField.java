package model;

public class GameField {

	private vertex[] gamefield;
	private vertex[][] block;
	private vertex[][] house;
	private final char color[] = {'R','B','G','P'}; 
	private final int startposition[] = {30, 0, 10 ,20};
	
	private final int POSITIONS = 40;
	private final int PLAYER = 4;
	private final int HOUSESIZE = 4;
	private final int BLOCKSIZE = 4;
	
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
	
/////////////////////////////////////////////////
	
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
		if(0 > idx)
			return false;
		
		gamefield[idx].color = color;
		
		return true;
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
		for(int i = 3; i >= 0 ;i--) {
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
