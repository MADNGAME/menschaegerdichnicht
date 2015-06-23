package view;

import javax.swing.JFrame;

import controller.Controller;
import model.Player;
import Observer.IObserver;

@SuppressWarnings("serial")
public class GUI extends JFrame implements IObserver{

	private Controller controller;
	private ImagePanel imagePanel;
	
	public GUI(Controller c) {
		this.setTitle("Mensch Aerger Dich Nicht");
		this.setSize(800, 800);
		this.setResizable(false);
		this.setVisible(true);
		this.controller = c;
		this.controller.registerObserver(this);
		
		this.imagePanel = new ImagePanel(controller);
		
		this.add(imagePanel);
	}
	
	public void update(Player currentPlayer, boolean gameEnded) {
		// TODO Auto-generated method stub
		
	}

	public void showDice(Player currentplayer, int dice) {
		// TODO Auto-generated method stub
		
	}

}
