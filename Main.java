import java.util.*;
public class Main
{
  
  public static void main(String[] args)throws Exception
    {
      GameBoard g = new GameBoard();
      GameBoardGUI k = new GameBoardGUI(g);
      Player p1 = new Player();
      p1.takeTurn(g);
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

