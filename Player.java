import java.util.*;
public class Player{
  private String name;
  private boolean isAI = false;
  private String color;
  Scanner scan1 = new Scanner(System.in);
  public Player(){
    name = "AI";
    isAI = true;
    color = "Red";
  }
  public Player(String n,String c){
    name = n;
    color = c;
  }
  public String getName(){
    return name;
  }
  public String getColor(){
    return color;
  }
  public void takeTurn(GameBoard gb){
    if(isAI){
      for(checker[] x : dgb){
        for(checker y : x){
          if(y.getColor().equals(color)){
            if(y.getKing == true){
              
            }
            else{
              
            }
          }
        }
      }
    }
    else{
      gb.movePiece();
    }
  }
}
