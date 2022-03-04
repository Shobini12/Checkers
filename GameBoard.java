import java.util.Scanner;
package Checkers;

public class GameBoard {
  Scanner kb = new Scanner(System.in);
  Checkers[][] dgb= new Checkers[8][8]; //digital gameboard
  public GameBoard(){
    
    
  }

  public void movePiece(){
    boolean firstCheck = false;
    boolean secondCheck = false;
    boolean thirdCheck = false;
    //check that these inputs are valid and doesn't make it go off the board
    System.out.println("Which piece do you want to move? Enter a     letter (A-H) and number (0-7)");
    String from = kb.nextLine();
    char fromX = from.charAt(0);
    int fromY = (int) from.charAt(1);
    System.out.println("Where would you like to move this piece?     Enter a letter (A-H) and number (0-7)");
    String to = kb.nextLine();
    char toX = to.charAt(0);
    int toY = (int) to.charAt(1);
    //checks if the space is open
    if(dgb[toX][toY] == null){ 
      firstCheck = true;
    }
    //check that the piece is moving forward
    if(toY>fromY){
      secondCheck = true;
    }
    //check if where you want to move is a diagonal movement
     if((toX == fromX+1 || toX == fromX-1) && (toY == fromY+1 ||      toY == fromY-1)){ 
      thirdCheck = true;
    }
    
  

  
  }

  public void checkPos(){ //check for all invalid moves - already occupied, not moving diagonally
    
  }

  
}
