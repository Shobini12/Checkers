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
      ArrayList<Checker> canMove = new ArrayList<Checker>();
      int farJump = 0;
      for(int i = 0;i<gbd.length;i++){
        for(int f = 0;f<gbd[0].length;f++){
          Checker y = gbd[i][f];
          boolean moveUR = false;
          boolean moveUL = false;
          boolean moveDR = false;
          boolean moveDL = false;
          boolean canJump = false;
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
