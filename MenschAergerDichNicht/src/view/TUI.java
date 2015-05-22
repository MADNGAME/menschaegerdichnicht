package view;

import controller.Controller;

public class TUI {

	private Controller c;
	
	public TUI(Controller c) {
		this.c = c;
	}
	
	private void display() {
		System.out.print(" " + c.getVertexColorBlock(0, 0) + " " + c.getVertexColorBlock(0, 1) + "    |" + c.getVertexColor(38) + "-" + c.getVertexColor(39) + "-" + c.getVertexColor(0)  + "|    " + c.getVertexColorBlock(1, 0) + " " + c.getVertexColorBlock(1, 1) + " ");
		System.out.println("			        |38390|        ");
		System.out.print(" " + c.getVertexColorBlock(0, 2) + " " + c.getVertexColorBlock(0, 3) + "    |" + c.getVertexColor(37) + "|"+ c.getVertexColorHouse(1, 0) +"|" + c.getVertexColor(1) + "|    " + c.getVertexColorBlock(1, 2) + " " + c.getVertexColorBlock(1, 3) + " ");
		System.out.println("			        |37  1|        ");
		System.out.print("        |" + c.getVertexColor(36) + "|"+c.getVertexColorHouse(1, 1)+"|" + c.getVertexColor(2)+ "|        ");
		System.out.println("			        |36  2|        ");
		System.out.print(" _______|" + c.getVertexColor(35) + "|"+c.getVertexColorHouse(1, 2)+"|" + c.getVertexColor(3)+ "|_______ ");
		System.out.println("			 _______|35  3|_______");
		System.out.print("|" + c.getVertexColor(30) + "_" + c.getVertexColor(31) +"_" + c.getVertexColor(32) +"_" + c.getVertexColor(33) +"_" + c.getVertexColor(34) + "|" + c.getVertexColorHouse(1, 3) + "|" + c.getVertexColor(4)+ "_" + c.getVertexColor(5) +"_" + c.getVertexColor(6)+ "_" + c.getVertexColor(7) + "_" + c.getVertexColor(8) + "|");
		System.out.println("			|3031323334  4 5 6 7 8|");
		System.out.print("|" + c.getVertexColor(29) + "_" + c.getVertexColorHouse(0, 0)  +"_" + c.getVertexColorHouse(0, 1) +"_" + c.getVertexColorHouse(0, 2) +"_" + c.getVertexColorHouse(0, 3) + "   " + c.getVertexColorHouse(3, 0) + "_" + c.getVertexColorHouse(3, 1) +"_" + c.getVertexColorHouse(3, 2)+ "_" + c.getVertexColorHouse(3, 3) + "_" + c.getVertexColor(9) + "|");
		System.out.println("			|29                  9|");
		System.out.print("|" + c.getVertexColor(28) + "_" + c.getVertexColor(27) +"_" + c.getVertexColor(26) +"_" + c.getVertexColor(25) +"_" + c.getVertexColor(24) + "|" + c.getVertexColorHouse(2, 3) + "|" + c.getVertexColor(14)+ "_" + c.getVertexColor(13) +"_" + c.getVertexColor(12)+ "_" + c.getVertexColor(11) + "_" + c.getVertexColor(10) + "|");
		System.out.println("			|2827262524 1413121110|");
		System.out.print("        |" + c.getVertexColor(23) + "|"+c.getVertexColorHouse(2, 2) +"|" + c.getVertexColor(15)+ "|        ");
		System.out.println("			        |23 15|        ");
		System.out.print("        |" + c.getVertexColor(22) + "|"+c.getVertexColorHouse(2, 1)+"|" + c.getVertexColor(16)+ "|        ");
		System.out.println("			        |22 16|        ");
		System.out.print(" " + c.getVertexColorBlock(3, 0) + " " + c.getVertexColorBlock(3, 1) + "    |" + c.getVertexColor(21) + "|" + c.getVertexColorHouse(2, 0) + "|" + c.getVertexColor(17)  + "|    " + c.getVertexColorBlock(2,0) + " " + c.getVertexColorBlock(2,1) + " ");
		System.out.println("			        |21 17|        ");
		System.out.print(" " + c.getVertexColorBlock(3,2) + " " + c.getVertexColorBlock(3,3) + "    |" + c.getVertexColor(20) + "-"+ c.getVertexColor(19) +"-" + c.getVertexColor(18) + "|    " + c.getVertexColorBlock(2,2) + " " + c.getVertexColorBlock(2,3) + " ");
		System.out.println("			        |201918           \n");
		System.out.println("______________________________________");
		
	}
	
	
	public void main(String[] args) {
		TUI tui = new TUI(new Controller());
		tui.display();
	}
}