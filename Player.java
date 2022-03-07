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
      AImove(gb)
    }
    else{
      gb.movePiece(color);
    }
  }
  public void AImove(GameBoard gb){
    Checkers[][] gbd = gb.getBoard();
    for(int i = 0;i<gbd.length;i++){
      for(int f = 0;f<gbd[0].length;f++){
        Checkers y = gbd[i][f];
        boolean moveUR = false;
        boolean moveUL = false;
        boolean moveDR = false;
        boolean moveDL = false;
        boolean canJump = false;
        if(y.getColor().equals(color)){
          if(y.getKing == true){
            if(i != 0 && f != 0){
              if(gbd[i-1][f-1] == null){
                moveUR = true;
              }
            }
            if(i != 0 && f != 8){
              if(gbd[i-1][f+1] == null){
                moveUR = true;
              }
            }
            if(i != 8 && f != 0){
              if(gbd[i+1][f-1] == null){
                moveUR = true;
              }
            }
            if(i != 8 && f != 8){
              if(gbd[i+1][f+1] == null){
                moveUR = true;
              }
            }
          }
          else{
              
          }
        }
      }
    }
  }
}
