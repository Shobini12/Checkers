import java.util.*;
public class Player{
  private String name;
  private boolean isAI = false;
  private String color;
  Scanner scan1 = new Scanner(System.in);
  public Player(){
    name = "AI";
    isAI = true;
    color = "Red"
  }
  public Player(String n,String c){
    name = n;
    color = c;
  }
  public String getName(){
    return name;
  }
  public void takeTurn(Checkers[][] gb){
    if(isAI){
      //check which pieces match the color
      //check pieces that can move
      //check pieces that can jump
      //check piece(s) that can make the most jumps
      //move that piece, if tied choose at random
      //make the change to the gameboard
    }
    else{
      //check which pieces match the color
      //check pieces that can move
      //check pieces that can jump
      //print options to move
      //get user input on the move
      //make the change to the gameboard
    }
  }
}
