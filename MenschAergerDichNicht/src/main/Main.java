package main;

import java.util.Scanner;

import view.GUI;
import view.TUI;
import controller.Controller;


public class Main {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		Controller c = new Controller();
		
		TUI tui = new TUI(c);
		new GUI(c);
			
		do {
			while(tui.noInput());
			tui.handleInput(sc.nextInt());
		} while(true);
	}
	
}
