import java.util.Scanner;

public class GameBoard {
  Scanner kb = new Scanner(System.in);
  Checkers[][] dgb= new Checkers[8][8]; //digital gameboard
  
  public GameBoard(){
    
    
  }

  public void movePiece(String color){
    boolean firstCheck = false;
    boolean secondCheck = false;
    boolean thirdCheck = false;
    boolean fourthCheck = false;
    boolean fifthCheck = false;
    boolean sixthCheck = false; 
    //check that these inputs are valid and doesn't make it go off the board
    System.out.println("Which piece do you want to move? Enter a     letter (A-H) and number (0-7)");
    String from = kb.nextLine();
    char fromX = from.charAt(0);
    int fromY = (int) from.charAt(1);
    System.out.println("Where would you like to move this piece?     Enter a letter (A-H) and number (0-7)");
    String to = kb.nextLine();
    char toX = to.charAt(0);
    int toY = (int) to.charAt(1);
    //check if color of piece matches player
    if(dgb[fromX][fromY].equals(color)){
      firstCheck = true;
    }
    //checks if the space is open
    if(dgb[toX][toY] == null){ 
      secondCheck = true;
    }
    //check that the piece is moving forward
    if(toY>fromY){
      thirdCheck = true;
    }
    //Kings can move backwards
    if(isKing){
      thirdCheck = true;
    }
    //check if where you want to move is a diagonal movement
     if((toX == fromX+1 || toX == fromX-1) && (toY == fromY+1 ||      toY == fromY-1)){ 
      fourthCheck = true;
    }
    //check for jump
    if(fromX+1 = null && toY+1 = null){
      forceJump();
    }else if(fromX-1 = null && toY+1 = null){
       forceJump();
    }else{
      fifthCheck = true; 
    }

    //check if the color of the piece matches the player
    if(dgb[fromX][fromY].equals(color)){
      sixthCheck = true; 
    }

    

    //make sure all checks are true
    if(firstCheck && secondCheck && thirdCheck && fourthCheck){
      
    }
  }

  public void forceJump(){
    
  }
  
}
