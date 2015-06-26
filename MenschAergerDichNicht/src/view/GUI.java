package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Image;

import controller.Controller;
import model.Player;
import Observer.IObserver;

@SuppressWarnings("serial")
public class GUI extends JFrame implements IObserver, ActionListener{

	private Controller controller;
	private JPanel OberPanel;
	private JPanel LinkesPanel;
	private JPanel RechtesPanel;
	private JPanel Wuerfel;
	
	private ImageIcon brett;
	
	private JLabel labelicon;
	private JLabel ausgabe;
	
	private JButton wuerfel;
	
	
		
	
	
	public GUI(Controller c) {
		this.setTitle("Mensch Aerger Dich Nicht");
		//this.setPreferredSize(new Dimension(100, 800));
		this.controller = c;
		this.controller.registerObserver(this);
		
		//this.imagePanel = new ImagePanel(controller);
		
		//this.add(imagePanel);
		
		
		//OberLabel
		OberPanel = new JPanel();
		OberPanel.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(800,800));
		OberPanel.setBackground(Color.RED);
	
		
		//Linkes Panel
		LinkesPanel = new JPanel();
		LinkesPanel.setBackground(Color.ORANGE);
		LinkesPanel.setPreferredSize(new Dimension(600,800));
		brett = new ImageIcon(getClass().getResource("brett.jpg"));
		labelicon = new JLabel(brett);
		LinkesPanel.add(labelicon);
		
		OberPanel.add(LinkesPanel);
		//LinkesPanel<<//
		
		//Rechtes Panel
		RechtesPanel = new JPanel();
		RechtesPanel.setBackground(Color.CYAN);
		RechtesPanel.setPreferredSize(new Dimension(150,800));
		
			//Aufgabe - Currentplayer is an der Reihe
			ausgabe = new JLabel();
			ausgabe.setText(c.isGameEnded() + " ist an der Reihe");
			RechtesPanel.add(ausgabe);
		
			//Wuerfel
			Wuerfel = new JPanel();
			
				//wuerfel Button
				wuerfel = new JButton("Würfel");
				wuerfel.addActionListener(this);
				
				Wuerfel.add(wuerfel);
				//
				
				
			RechtesPanel.add(Wuerfel);
		//RechtesPanel<<//		
				
		OberPanel.add(RechtesPanel);
		//OberPanel<<//
		
		
		this.add(OberPanel);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
		
	}
	

	public void update(Player currentPlayer, boolean gameEnded) {
		// TODO Auto-generated method stub
		
	}

	public void showDice(Player currentplayer, int dice) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int w = (int) (Math.random()*6 + 1); 
		this.wuerfel.setText("Würfelzahl: " + w); 
		
	}

}
