import java.util.Scanner;

public class GameBoard {
  Scanner kb = new Scanner(System.in);
  Checkers[][] dgb= new Checkers[8][8]; //digital gameboard
  int toX;
  public GameBoard(){
    initBoard();
  }
  public Checkers[][] getBoard(){
   return dgb;
  }
  
  public void movePiece(String color, boolean isKing){
    boolean firstCheck = false;
    boolean secondCheck = false;
    boolean thirdCheck = false;
    boolean fourthCheck = false;
    
    //check that these inputs are valid and doesn't make it go off the board
    boolean isNull = true;
    char fromXChar = 'a';
    int fromX = 0;
    int fromY = 0;
    char toXChar = 'a';
    int toX = 0;
    int toY = 0;
    while(isNull){
       System.out.println("Which piece do you want to move? Enter a     letter (A-H) and number (0-7)");
       String from = kb.nextLine();
       fromXChar = from.charAt(0);
       fromX = toInt(fromXChar);
       fromY = Integer.parseInt(from.substring(1)) - 1;
       System.out.println("Where would you like to move this piece?     Enter a letter (A-H) and number (0-7)");
       String to = kb.nextLine();
       toXChar = to.charAt(0);
       toX = toInt(toXChar);
       toY = Integer.parseInt(to.substring(1)) - 1;
       if(!(dgb[fromX][fromY] == null)){
         isNull = false;
       }
    }
    //check if color of piece matches player
    if((dgb[fromX][fromY].getColor()).equals(color)){
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
    
    //check if where you want to move is a diagonal movement
     if((toX == fromX+1 && toY == fromY+1)||(toX == fromX-1 && toY == fromY+1)){ 
      fourthCheck = true;
    }

    //Kings can move backwards
    if(dgb[fromX][fromY].isKing()&&(toX == fromX+1 && toY == fromY+1)||(toX ==    fromX-1 && toY == fromY+1) ||(toX == fromX+1 && toY == fromY-1)||(toX == fromX-1 && toY == fromY-1)){
      thirdCheck = true;
      fourthCheck = true;
    }

    //make sure all checks are true before moving the piece
    if(firstCheck && secondCheck && thirdCheck && fourthCheck){
      //check for jump
      if(checkJump(fromX, fromY) == 0){
        forceJumpRight(fromX, fromY); 
      }else if(checkJump(fromX, fromY) == 1){
        forceJumpLeft(fromX, fromY); 
      }else{
         dgb[toX][toY] = dgb[fromX][fromY];
         dgb[fromX][fromY] = null;
      }
    }
  }

  public int checkJump(int x, int y){
    //check for jump
    if(dgb[x+2][y+2]==null && dgb[x+1][y+1]!= null && !(dgb[x+1][y+1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){ //check that the space one right and one up is a piece of the opposite color
      return 0; 
    }else if(dgb[x-2][y+2]==null && dgb[x-1][y+1]!= null && !(dgb[x-1][y+1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){
      return 1; 
    }else{
      return 2; 
    }
  }

  //if piece is a king, it can jump in any direction 3/23
  

  public void forceJumpRight(int x, int y){
    dgb[x+2][y+2] = dgb[x][y];
    dgb[x+1][y+1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x+2, y+2)==0){
      doubleJumpRight(x+2, y+2);
    }else if(checkJump(x+2, y+2)==1){
      doubleJumpLeft(x+2, y+2);
    }
  }
  
  public void forceJumpLeft(int x, int y){
    dgb[x-2][y+2] = dgb[x][y];
    dgb[x-1][y+1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x-2, y+2)==0){
      doubleJumpLeft(x-2, y+2);
    }else if(checkJump(x-2, y+2)==1){
      doubleJumpLeft(x-2, y+2);
    }

  }

  public void doubleJumpRight(int x, int y){
    //double jump to the right
    dgb[x+2][y+2] = dgb[x+1][y+1];
    dgb[x+1][y+1] = null;
  }
  
  public void doubleJumpLeft(int x, int y){
    dgb[x-2][y+2] = dgb[x+1][y+1];
    dgb[x][y] = null;
  }
 public void initBoard(){
   dgb[0][0] = new Checkers(0,0,"Red");
   dgb[2][0] = new Checkers(2,0,"Red");
   dgb[4][0] = new Checkers(4,0,"Red");
   dgb[6][0] = new Checkers(6,0,"Red");

   dgb[1][1] = new Checkers(1,1,"Red");
   dgb[3][1] = new Checkers(3,1,"Red");
   dgb[5][1] = new Checkers(5,1,"Red");
   dgb[7][1] = new Checkers(7,1,"Red");
   
   dgb[0][2] = new Checkers(0,2,"Red");
   dgb[2][2] = new Checkers(2,2,"Red");
   dgb[4][2] = new Checkers(4,2,"Red");
   dgb[6][2] = new Checkers(6,2,"Red");

   dgb[1][5] = new Checkers(1,5,"Blue");
   dgb[3][5] = new Checkers(3,5,"Blue");
   dgb[5][5] = new Checkers(5,5,"Blue");
   dgb[7][5] = new Checkers(7,5,"Blue");

   dgb[0][6] = new Checkers(0,6,"Blue");
   dgb[2][6] = new Checkers(2,6,"Blue");
   dgb[4][6] = new Checkers(4,6,"Blue");
   dgb[6][6] = new Checkers(6,6,"Blue");
   
   dgb[1][7] = new Checkers(1,7,"Blue");
   dgb[3][7] = new Checkers(3,7,"Blue");
   dgb[5][7] = new Checkers(5,7,"Blue");
   dgb[7][7] = new Checkers(7,7,"Blue");
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
