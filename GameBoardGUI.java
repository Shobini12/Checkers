import java.awt.*;
import javax.swing.*;
import java.util.*;


public class GameBoardGUI extends JFrame {
	
	private checkerCanvas canvas = new checkerCanvas();
	
	
	
	
	
	public GameBoardGUI(){
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
		
			
		
		
		public void paint(Graphics g){
			
			int square = 65;  //size of each square
			int xBound = 105; //x alignment
			int yBound = 555; //y alignment
			
			Color myColor = new Color(78, 53, 36);
            g.setColor(myColor);
			g.fillRect(0, 0, 750, 750);
			
	
			
			
			//draw board
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

		}
			
			public void updatePieces(Graphics g, String color, Checkers[][] checkers, boolean king){
				
				
			int square = 65;  //size of each square
			int xBound = 105; //x alignment
			int yBound = 555; //y alignment
				
				//check 2d gb array to determine piece placement
					for(int a=0;a<8;a++){
					for(int b=0;b<8;b++){
						if(!(checkers[a][b] == null)){
							if(color.equalsIgnoreCase("blue")){
								g.setColor(Color.blue);
								if(king == false){
									g.fillOval((xBound + a*square), (yBound - b*square), square, square);	
								}else{
									g.fillOval((xBound + a*square), (yBound - b*square), square, square);
									g.setColor(Color.red);	
									g.fillOval((xBound + a*square), (yBound - b*square), (square - 20), (square - 20));	
								}
								
							}else{
								g.setColor(Color.red);
								if(king == false){
									g.fillOval((xBound + a*square), (yBound - b*square), square, square);	
								}else{
									g.fillOval((xBound + a*square), (yBound - b*square), square, square);
									g.setColor(Color.blue);	
									g.fillOval((xBound + a*square), (yBound - b*square), (square - 20), (square- 20));	
								}
							}
	
						}
	
				}
				
			}	
		}
			
			
				
	}
		
}
	
	

