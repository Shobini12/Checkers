import java.util.Scanner;

public class GameBoard {
  Scanner kb = new Scanner(System.in);
  Checkers[][] dgb= new Checkers[8][8]; //digital gameboard
  int toX;
  
  public GameBoard(){
    initBoard();
  }
  
  public void movePiece(String color, boolean isKing){
    boolean firstCheck = false;
    boolean secondCheck = false;
    boolean thirdCheck = false;
    boolean fourthCheck = false;
    boolean fifthCheck = false; 
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
    
    //check if where you want to move is a diagonal movement
     if((toX == fromX+1 && toY == fromY+1)||(toX == fromX-1 &&      toY == fromY+1)){ 
      fourthCheck = true;
    }

    //Kings can move backwards
    if(checkKing(fromX,fromY)&&(toX == fromX+1 && toY == fromY+1)||(toX == fromX-1 && toY == fromY+1) ||(toX == fromX+1 && toY == fromY-1)||(toX == fromX-1 && toY == fromY-1)){
      thirdCheck = true;
      fourthCheck = true;
    }
    //make sure piece doesn't go off the board
    if((toX>=0 && toX<=7)&&(toY>=0 && toY<=7)){
      fifthCheck = true; 
    }

    //make sure all checks are true before moving the piece
    if(firstCheck && secondCheck && thirdCheck && fourthCheck && fifthCheck){
      //check for jump
      if(checkKing(fromX, fromY)){
        kingJump(fromX, fromY);
      }else if(checkJump(fromX, fromY) == 0){
        forceJumpUR(fromX, fromY); 
      }else if(checkJump(fromX, fromY) == 1){
        forceJumpUL(fromX, fromY); 
      }else{
        dgb[fromX][fromY] = null;
        dgb[toX][toY] = dgb[fromX][fromY];
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

  public boolean checkKing(int x, int y){
    if(dgb[x][y].isKing()){
      return true;
    }else{
      return false;
    }
  }

  public void kingJump(int x, int y){
    if(dgb[x+2][y+2]==null && dgb[x+1][y+1]!= null && !(dgb[x+1][y+1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){ 
      //jump up right
      forceJumpUR(x,y);
    }else if(dgb[x-2][y+2]==null && dgb[x-1][y+1]!= null && !(dgb[x-1][y+1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){
      //jump up left
      forceJumpUL(x,y);
    }else if(dgb[x+2][y-2]==null && dgb[x+1][y-1]!= null && !(dgb[x+1][y-1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){
     forceJumpDR(x,y);
    }else if(dgb[x-2][y-2]==null && dgb[x-1][y-1]!= null && !(dgb[x-1][y-1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))){
      forceJumpDL(x,y);
    }
   
  }

  public void forceJumpUR(int x, int y){
    dgb[x+2][y+2] = dgb[x][y];
    dgb[x+1][y+1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x+2, y+2)==0){
      doubleUR(x+2, y+2);
    }else if(checkJump(x+2, y+2)==1){
      doubleUL(x+2, y+2);
    }
  }
  
  public void forceJumpUL(int x, int y){
    dgb[x-2][y+2] = dgb[x][y];
    dgb[x-1][y+1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x-2, y+2)==0){
      doubleUR(x-2, y+2);
    }else if(checkJump(x-2, y+2)==1){
      doubleUL(x-2, y+2);
    }

  }

  //for kings only 
  public void forceJumpDR(int x, int y){
    dgb[x+2][y-2] = dgb[x][y];
    dgb[x+1][y-1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x+2, y-2)==0){
      doubleDR(x+2, y-2);
    }else if(checkJump(x+2, y-2)==1){
      doubleDL(x+2, y-2);
    }

  }

  //for kings only 
  public void forceJumpDL(int x, int y){
    dgb[x-2][y-2] = dgb[x][y];
    dgb[x-1][y-1] = null;
    //award point to the color that captured the piece in the jump
    dgb[x][y] = null;
    //check for double jump
    if(checkJump(x-2, y-2)==0){
      doubleDR(x-2, y-2);
    }else if(checkJump(x-2, y-2)==1){
      doubleDL(x-2, y-2);
    }
  }
  
  public void doubleUR(int x, int y){
    //double jump to the right
    dgb[x+2][y+2] = dgb[x][y];
    dgb[x+1][y+1] = null;
  }
  
  public void doubleUL(int x, int y){
    dgb[x-2][y+2] = dgb[x][y];
    dgb[x-1][y+1] = null;
  }

   public void doubleDR(int x, int y){
    //double jump to the right
    dgb[x+2][y-2] = dgb[x][y];
    dgb[x+1][y-1] = null;
  }

  public void doubleDL(int x, int y){
    //double jump to the right
    dgb[x-2][y-2] = dgb[x][y];
    dgb[x-1][y-1] = null;
  }
  
 public void initBoard(){
   dgb[0][0] = new Checkers(0,0,"Red");
   dgb[0][2] = new Checkers(0,2,"Red");
   dgb[0][4] = new Checkers(0,4,"Red");
   dgb[0][6] = new Checkers(0,6,"Red");

   dgb[1][1] = new Checkers(1,1,"Red");
   dgb[1][3] = new Checkers(1,3,"Red");
   dgb[1][5] = new Checkers(1,5,"Red");
   dgb[1][7] = new Checkers(1,7,"Red");
   
   dgb[2][0] = new Checkers(2,0,"Red");
   dgb[2][2] = new Checkers(2,2,"Red");
   dgb[2][4] = new Checkers(2,4,"Red");
   dgb[2][6] = new Checkers(2,6,"Red");

   dgb[5][1] = new Checkers(5,1,"Blue");
   dgb[5][3] = new Checkers(5,3,"Blue");
   dgb[5][5] = new Checkers(5,5,"Blue");
   dgb[5][7] = new Checkers(5,7,"Blue");

   dgb[6][0] = new Checkers(6,0,"Blue");
   dgb[6][2] = new Checkers(6,2,"Blue");
   dgb[6][4] = new Checkers(6,4,"Blue");
   dgb[6][6] = new Checkers(6,6,"Blue");
   
   dgb[7][1] = new Checkers(7,1,"Blue");
   dgb[7][3] = new Checkers(7,5,"Blue");
   dgb[7][5] = new Checkers(7,5,"Blue");
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
