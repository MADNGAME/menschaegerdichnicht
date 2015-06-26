package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Observer.IObservable;
import Observer.IObserver;
import model.*;

public class Controller implements IController, IObservable {

	private GameField gamefield;
	private Player player0, player1, player2, player3, currentplayer;
	private Random r;
	private int dice;
	
	private final List<IObserver> observers = new ArrayList<IObserver>();
	
	public Controller() {
		gamefield = new GameField();
		r = new Random();
		player0 = new Player(0, "Rudolf", 'R');
		player1 = new Player(1, "Bastian", 'B');
		player2 = new Player(2, "Gert", 'G');
		player3 = new Player(3, "Sascha", 'S');
		
		currentplayer = player0;
		dice();
	}
	
	public boolean moveStart() {
		// Raus kommen
		if(gamefield.isStartFree(currentplayer.getIdx()) && gamefield.isStoneInBlock(currentplayer.getIdx()) && dice == 6) {
			int player = gamefield.throwPlayerStart(currentplayer.getIdx(), currentplayer.getColor());
			
			if(player != currentplayer.getIdx() && player >= 0)
				gamefield.setStoneBackInBlock(player);
						
			gamefield.getStoneOutOfBlock(currentplayer.getIdx());
			updateObservers();
			return true;
		}
		
		// Man kann nicht fahren
		if(gamefield.stoneOnGamefield(currentplayer.getIdx()) == 0) {
			updateObservers();
			return true;
		}
		
		return false;
	}
	
	public boolean move(int idx) {		
		// Falscher Stein
		if(!gamefield.color(currentplayer.getIdx(), idx)) {
			return false;
		}
		
		// Steine ins Haus bringen
		if(gamefield.isRounded(currentplayer.getIdx(), idx, dice)) {
			if(gamefield.setStoneInHouse(currentplayer.getIdx(), idx + dice))
				return false;
			gamefield.setStone(idx, 'x');
			updateObservers();
			return true;
		}
		
		// Steine schlagen
		int player = gamefield.throwPlayer(idx + dice, currentplayer.getColor());
		
		if(player == currentplayer.getIdx())
			return false;
		
		if(player >= 0)
			gamefield.setStoneBackInBlock(player);
			
		// normales Fahren
		gamefield.setStone(idx, 'x');
		gamefield.setStone(idx + dice, currentplayer.getColor());
		updateObservers();
		
		return true;
	}
	
	public boolean getOutOfBlock() {
		return gamefield.getStoneOutOfBlock(currentplayer.getIdx());
	}
	
	private void dice() {
		dice = r.nextInt(6) + 1;
	}
	
	public boolean isGameEnded() {
		return gamefield.isGameEnded();
	}
	
	public void setNextPlayer() {
		if(currentplayer == player0)
			currentplayer = player1;
		else if(currentplayer == player1)
			currentplayer = player2;
		else if(currentplayer == player2)
			currentplayer = player3;
		else if(currentplayer == player3)
			currentplayer = player0;			
	}
	
	/*class Fan {
private FanState currentState;
public Fan() {
currentState = new Off();
}
public void setState( FanState s ) {
currentState = s;
}
public void pull() {
currentState.pull( this );
} }
interface FanState {
void pull( Fan fan );
}
class Off/Low/Medium/High implements FanState { //likewise for Low, Medium, High
public void pull( Fan fan ) {
fan.setState( new Low() );
System.out.println( " low speed" );
} }*/
	
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}
	
	public void unregisterObserver(IObserver observer) {
		observers.remove(observer);
	}
	
	public void updateObservers() {
		
		for (IObserver observer : observers) {
			observer.update(currentplayer, this.isGameEnded());
		}
		
		if(dice != 6)
			setNextPlayer();
		dice();
		
		for (IObserver observer : observers) {
			observer.showDice(currentplayer, this.dice);
		}
		
		if(isGameEnded())
			System.exit(0);	
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
