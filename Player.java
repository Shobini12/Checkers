public class Player{
  private String name;
  private boolean isAI = false;
  private String color;
  //basic default constructor that makes an AI
  public Player(){
    name = "AI";
    isAI = true;
    color = "Blue";
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
      AImove(gb.getBoard(),false);
    }
    else{
      gb.movePiece(color,false);
    }
  }

  //AI
  public void AImove(Checkers[][] gbd, boolean hasJumped){
    boolean hasMoved = false;
    for(int i = gbd.length-1;i>0;i--){
      if(hasMoved){
        break;
      }
      else{
        for(int f = gbd[0].length-1;f>0;f--){
          if(!(gbd[i][f]== null)){
             if((gbd[i][f].getColor()).equals("Blue")){
               if(i != 1 && i != 0 && f != 1 && f != 0){
                 if(gbd[i-1][f-1] != null && !(gbd[i-1][f-1].getColor().equals("Blue")) && gbd[i-2][f-2] == null){
                   gbd[i-1][f-1] = null;
                   gbd[i-2][f-2] = gbd[i][f];
                   gbd[i][f] = null;
                   System.out.println("Moved to " + (i-2) +" "+(f-2)+" from " + i + " " + f);
                   hasMoved = true;
                   break;
                 }
               }
               if(i != 0 && f != 6 && i != 1 && f != 7){
                 if(gbd[i-1][f+1] != null && !(gbd[i-1][f+1].getColor().equals("Blue")) && gbd[i-2][f+2] == null){
                   gbd[i-1][f+1] = null;
                   gbd[i-2][f+2] = gbd[i][f];
                   gbd[i][f] = null;
                   System.out.println("Moved to " + (i-2) +" "+(f+2)+" from " + i + " " + f);
                   hasMoved = true;
                   break;
                 }
               }
               //if is king then it can jump backwards too
               if(gbd[i][f].isKing()){
                 if(i != 6 && f != 0 && i != 7 && f != 1){
                   if(gbd[i+1][f-1] != null && !(gbd[i+1][f-1].getColor().equals("Blue")) && gbd[i+2][f-2] == null){
                     gbd[i+1][f-1] = null;
                     gbd[i+2][f-2] = gbd[i][f];
                     gbd[i][f] = null;
                     System.out.println("Moved to " + (i+2) +" "+(f-2)+" from " + i + " " + f);
                     hasMoved = true;
                     break;
                   }
                 }
                 if(i != 6 && f != 6 && i != 7 && f != 7){
                   if(gbd[i+1][f+1] != null && !(gbd[i+1][f+1].getColor().equals("Blue")) && gbd[i+2][f+2] == null){
                     gbd[i+1][f+1] = null;
                     gbd[i+2][f+2] = gbd[i][f];
                     gbd[i][f] = null;
                     System.out.println("Moved to " + (i+2) +" "+(f+2)+" from " + i + " " + f);
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
    if(hasMoved){
      AImove(gbd,true);
    }
    else if(hasJumped == false){
      for(int i = gbd.length-1;i>0;i--){
        if(hasMoved){
          break;
        }
        else{
          for(int f = gbd[0].length-1;f>0;f--){
            if(!(gbd[i][f]== null)){
               if((gbd[i][f].getColor()).equals("Blue")){
                 if(i != 0 && f != 0){
                   if(gbd[i-1][f-1] == null){
                     System.out.println((i-1) + " " + (f-1));
                     gbd[i-1][f-1] = gbd[i][f];
                     gbd[i][f] = null;
                     System.out.println("Moved to " + (i-1) +" "+(f-1)+" from " + i + " " + f);
                     hasMoved = true;
                     break;
                   }
                 }
                 if(i != 0 && f != 7){
                   if(gbd[i-1][f+1] == null){
                     gbd[i-1][f+1] = gbd[i][f];
                     gbd[i][f] = null;
                     System.out.println("Moved to " + (i-1) +" "+(f+1)+" from " + i + " " + f);
                     hasMoved = true;
                     break;
                   }
                 }
                 //if is king then it can jump backwards too
                 if(gbd[i][f].isKing()){
                   if(i != 7 && f != 0){
                     if(gbd[i+1][f-1] == null){
                       gbd[i+1][f-1] = gbd[i][f];
                       gbd[i][f] = null;
                       System.out.println("Moved to " + (i+1) +" "+(f-1)+" from " + i + " " + f);
                       hasMoved = true;
                       break;
                     }
                   }
                   if(i != 7 && f != 7){
                     if(gbd[i+1][f+1] == null){
                       gbd[i+1][f+1] = gbd[i][f];
                       gbd[i][f] = null;
                       System.out.println("Moved to " + (i+1) +" "+(f+1)+" from " + i + " " + f);
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
}