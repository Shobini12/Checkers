import java.awt.*;
import javax.swing.*;
import java.util.*;


public class GameBoardGUI extends JFrame {
	
   private checkerCanvas canvas = new checkerCanvas();
   private GameBoard gameboard;
	
	public GameBoardGUI(GameBoard check){
      gameboard = check;
		setLayout(new BorderLayout());
		setSize(750, 750);
		setTitle("Checkers");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
   
	private class checkerCanvas extends Canvas {
		
	
		
	
		
		
		@Override
		public void update(Graphics g){
			repaint();
		}
		
		@Override
		public void paint(Graphics g){
			
			int square = 65;  //size of each square
			int xBound = 105; //x alignment
			int yBound = 555; //y alignment
			
			Color myColor = new Color(78, 53, 36);
            g.setColor(myColor);
			g.fillRect(0, 0, 750, 750);
		
			//draw board
			int baseCord = 133;
			int baseCordY = 593;
			Color myColor2 = new Color(255, 255, 255);
            g.setColor(myColor2);
			g.drawString("A", baseCord, 645);
			g.drawString("B", (baseCord + square), 645);
			g.drawString("C", (baseCord + square*2), 645);
			g.drawString("D", (baseCord + square*3), 645);
			g.drawString("E", (baseCord + square*4), 645);
			g.drawString("F", (baseCord + square*5), 645);
			g.drawString("G", (baseCord + square*6), 645);
			g.drawString("H", (baseCord + square*7), 645);
			
			g.drawString("0", 80, baseCordY);
			g.drawString("1", 80, (baseCordY - square));
			g.drawString("2", 80, (baseCordY - square*2));
			g.drawString("3", 80, (baseCordY - square*3));
			g.drawString("4", 80, (baseCordY - square*4));
			g.drawString("5", 80, (baseCordY - square*5));
			g.drawString("6", 80, (baseCordY - square*6));
			g.drawString("7", 80, (baseCordY - square*7));
			
			for(int x=0;x<8;x++){
				for(int y=0;y<8;y++){
					g.setColor(Color.black);
					if(((x+y) % 2 == 0)){
						g.fillRect((xBound + x*square), (yBound - y*square), square, square);
					}else{
						g.setColor(Color.white);
						g.fillRect((xBound + x*square), (yBound - y*square), square, square);
					}
				}
			}
			
			//check 2d gb array to determine piece placement
         Checkers[][] checkers = gameboard.getBoard();
         String color;
   		for(int a=0;a<8;a++){
   			for(int b=0;b<8;b++){
   				if(!(checkers[a][b] == null)){
                  color = checkers[a][b].getColor();
   					if(color.equalsIgnoreCase("blue")){
   						g.setColor(Color.blue);
   						if(checkers[a][b].isKing() == false){
   							g.fillOval((xBound + a*square), (yBound - b*square), square, square);	
   						}else{
   							g.setColor(Color.green);	
   							g.fillOval((xBound + a*square), (yBound - b*square), square, square);	
   						}
   					}else{
   						g.setColor(Color.red);
   						if(checkers[a][b].isKing() == false){
   							g.fillOval((xBound + a*square), (yBound - b*square), square, square);	
   						}else{
   							g.setColor(Color.orange);	
   							g.fillOval((xBound + a*square), (yBound - b*square), square, square);		
   						}
   					}
   				}
   		   }
         }
		}
		
	}	
}
