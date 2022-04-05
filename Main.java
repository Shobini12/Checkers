import java.util.*;
public class Main
{
  
  public static void main(String[] args)throws Exception
    {
      GameBoard g = new GameBoard();
      GameBoardGUI k = new GameBoardGUI(g);
      Checkers[][] dgb = new Checkers[8][8];
      dgb[0][0] = new Checkers(0,0,"Red");
      dgb[2][0] = new Checkers(2,0,"Red");
      dgb[4][0] = new Checkers(4,0,"Red");
      dgb[6][0] = new Checkers(6,0,"Red");
   
      dgb[1][1] = new Checkers(1,1,"Red");
      dgb[3][1] = new Checkers(3,1,"Red");
      dgb[5][1] = new Checkers(5,1,"Red");
      dgb[7][1] = new Checkers(7,1,"Red");
      
      dgb[0][2] = new Checkers(0,2,"Red");
      dgb[2][2] = new Checkers(2,2,"Red");
      dgb[4][2] = new Checkers(4,2,"Red");
      dgb[6][2] = new Checkers(6,2,"Red");
   
      dgb[1][5] = new Checkers(1,5,"Blue");
      dgb[3][5] = new Checkers(3,5,"Blue");
      dgb[5][5] = new Checkers(5,5,"Blue");
      dgb[7][5] = new Checkers(7,5,"Blue");
   
      dgb[0][6] = new Checkers(0,6,"Blue");
      dgb[2][6] = new Checkers(2,6,"Blue");
      dgb[4][6] = new Checkers(4,6,"Blue");
      dgb[6][6] = new Checkers(6,6,"Blue");
      
      dgb[1][7] = new Checkers(1,7,"Blue");
      dgb[3][7] = new Checkers(3,7,"Blue");
      dgb[5][7] = new Checkers(5,7,"Blue");
      dgb[7][7] = new Checkers(7,7,"Blue");
      Player p1 = new Player();
      p1.AImove(dgb,false);
      
      //declare instance variables and setup
      //ask for user inputs and settings to store in variable.
      //while !gameWon{
      //ask player one to make move
      //checkjump, prompt the user to jump if true.
      //check if the move is valid
      //if the move is valid then do, if not then reask.
      //update GUI
      //ask player two to make a move
      //checkjump, prompt the user to jump if true.
      //check if the move is valid
      //if the move is valid then do, if no reask.
      //update the GUI
      //end of while loop}
      //display winning screen.
    }
}

