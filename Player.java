import java.util.*;
public class Player{
  private String name;
  private boolean isAI = false;
  private String color;
  Scanner scan1 = new Scanner(System.in);
  //basic default constructor that makes an AI
  public Player(){
    name = "AI";
    isAI = true;
    color = "Red";
  }
  //Overloaded Constructor that makes a player
  public Player(String n,String c){
    name = n;
    color = c;
  }
  //Get methods for the player's color and name
  public String getName(){
    return name;
  }
  public String getColor(){
    return color;
  }
  //has a player take a turn and runs different methods if they are an AI or player
  public void takeTurn(GameBoard gb){
    if(isAI){
      AImove(gb,false);
    }
    else{
      gb.movePiece(color);
    }
  }

  //AI
  public void AImove(GameBoard gb, boolean hasJumped){
    //Checkers[][] gbd = gb.getBoard();
    boolean hasMoved = false;
    for(int i = gbd.length-1;i>0;i--){
      if(hasMoved){
        break;
      }
      else{
        for(int f = gbd[0].length-1;f>0;f--){
          if((gbd[i][f].getColor()).equals("Red")){
            if(i != 1 && i != 0 && f != 1 && f != 0){
              if(gbd[i-1][f-1] != null && gbd[i-2][f-2] == null){
                gbd[i-1][f-1] = null;
                gbd[i-2][f-2] = gbd[i][f];
                gbd[i][f] = null;
                hasMoved = true;
                break;
              }
            }
            if(i != 0 && f != 8 && i != 1 && f != 7){
              if(gbd[i-1][f+1] != null && gbd[i-2][f+2] == null){
                gbd[i-1][f+1] = null;
                gbd[i-2][f+2] = gbd[i][f];
                gbd[i][f] = null;
                hasMoved = true;
                break;
              }
            }
            //if is king then it can jump backwards too
            if(gbd[i][f].getKing()){
              if(i != 8 && f != 0 && i != 7 && f != 1){
                if(gbd[i+1][f-1] != null && gbd[i+2][f-2] == null){
                  gbd[i+1][f-1] = null;
                  gbd[i+2][f-2] = gbd[i][f];
                  gbd[i][f] = null;
                  hasMoved = true;
                  break;
                }
              }
              if(i != 8 && f != 8 && i != 7 && f != 7){
                if(gbd[i+1][f+1] != null && gbd[i+2][f+2] == null){
                  gbd[i+1][f+1] = null;
                  gbd[i+2][f+2] = gbd[i][f];
                  gbd[i][f] = null;
                  hasMoved = true;
                  break;
                }
              }
            }
          }
        }
      }
    }
    if(hasMoved){
      AImove(gb,true);
    }
    else if(hasJumped == false){
      for(int i = gbd.length-1;i>0;i--){
        if(hasMoved){
          break;
        }
        else{
          for(int f = gbd[0].length-1;f>0;f--){
            if((gbd[i][f].getColor()).equals("Red")){
              if(i != 0 && f != 0){
                if(gbd[i-1][f-1] == null){
                  gbd[i-1][f-1] = gbd[i][f];
                  gbd[i][f] = null;
                  hasMoved = true;
                  break;
                }
              }
              if(i != 0 && f != 8){
                if(gbd[i-1][f+1] == null){
                  gbd[i-1][f+1] = gbd[i][f];
                  gbd[i][f] = null;
                  hasMoved = true;
                  break;
                }
              }
              //if is king then it can jump backwards too
              if(gbd[i][f].getKing()){
                if(i != 8 && f != 0){
                  if(gbd[i+1][f-1] == null){
                    gbd[i+1][f-1] = gbd[i][f];
                    gbd[i][f] = null;
                    hasMoved = true;
                    break;
                  }
                }
                if(i != 8 && f != 8){
                  if(gbd[i+1][f+1] == null){
                    gbd[i+1][f+1] = gbd[i][f];
                    gbd[i][f] = null;
                    hasMoved = true;
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
