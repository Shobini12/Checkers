public class Player{
  private String name;
  private boolean isAI = false;
  private String color;
  public Player(){
    name = "AI";
    isAI = true;
    color = "Red"
  }
  public Player(String n,String c){
    name = n;
  }
  public String getName(){
    return name;
  }
  public takeTurn(){
    if(isAI){
      
    }
    else{
      //check pieces
    }
  }
}
