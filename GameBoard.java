import java.util.Scanner;

public class GameBoard {
  Scanner kb = new Scanner(System.in);
  Checkers[][] dgb= new Checkers[8][8]; //digital gameboard
  int toX;
  
  public GameBoard(){
    
    
  }

  public void movePiece(String color, boolean isKing){
    boolean firstCheck = false;
    boolean secondCheck = false;
    boolean thirdCheck = false;
    boolean fourthCheck = false;
    boolean fifthCheck = false;
    boolean sixthCheck = false; 
    //check that these inputs are valid and doesn't make it go off the board
    System.out.println("Which piece do you want to move? Enter a     letter (A-H) and number (0-7)");
    String from = kb.nextLine();
    char fromXChar = from.charAt(0);
    int fromX = toInt(fromXChar);
    int fromY = (int) from.charAt(1);
    System.out.println("Where would you like to move this piece?     Enter a letter (A-H) and number (0-7)");
    String to = kb.nextLine();
    char toXChar = to.charAt(0);
    int toX = toInt(toXChar);
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
    if(getKing()){
      thirdCheck = true;
    }
    //check if where you want to move is a diagonal movement
     if((toX == fromX+1 && toY == fromY+1)||(toX == fromX-1 &&      toY == fromY+1)){ 
      fourthCheck = true;
    }
    //check for jump
    if(dgb[fromX+1][toY+1]==null){
      forceJumpRight(fromX, toY);
    }else if(dgb[fromX-1][toY+1]==null){
       forceJumpLeft(fromX, toY);
    }else{
      fifthCheck = true; 
    }

    //check if the color of the piece matches the player
    if(dgb[fromX][fromY].equals(color)){
      sixthCheck = true; 
    }
    //make sure all checks are true before moving the piece
    if(firstCheck && secondCheck && thirdCheck && fourthCheck && fifthCheck && sixthCheck){
       //move piece
      dgb[fromX][fromY] = null;
      dgb[toX][toY] = dgb[fromX][fromY]; 
    }
  }

  public void forceJumpRight(int x, int y){
    dgb[x][y] = null;
    dgb[x][y] = [fromX+1][toY+1];
  }

  public void forceJumpLeft(int x, int y){
    dgb[x][y] = null;
    dgb[x][y] = [fromX-1][toY+1];
  }
  
 public void initializeBoard(){
   
   
 }

 public int toInt(char c){
   int toX = 0; 
   switch (c){
      case 'A':
        toX = 0;
        break; 
      case 'B':
        toX = 1;
        break;
      case 'C':
        toX = 2;
        break;
      case 'D':
        toX = 3;
        break;
      case 'E':
        toX = 4;
        break;
      case 'F':
        toX = 5;
        break;
      case 'G':
        toX = 6;
        break;
      case 'H':
        toX = 7;
        break;
      default: 
        System.out.println(c + " is invalid");     
    }
   return toX;
 }
  
}
