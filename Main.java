import java.util.*;

public class Main
{
  
  public static void main(String[] args)throws Exception
    {
      //variables
      Scanner sc = new Scanner(System.in);
      Player p1;
      Player p2;
      GameBoard gameBoard;
      GameBoardGUI gui;
      String p1Color = "";
      String p2Color = "";
      String p1Name = "";
      String p2Name = "";

      System.out.println("(Player 1) What is your name? : ");
      p1Name = sc.nextLine();
      System.out.println("(Player 2) What is your name? (leave blank to play as AI): ");
      p2Name = sc.nextLine();

      gameBoard = new GameBoard();
      gui = new GameBoardGUI(gameBoard);
        p1 = new Player(p1Name, "Red");
      if(p2Name.equals("")){
        p2 = new Player();
      }
      else{
        p2 = new Player(p2Name, "Blue");
      }
      while(gameBoard.checkWin().equals("null")) {
        System.out.println("P1 TURN");
        p1.takeTurn(gameBoard);
        if (!gameBoard.checkWin().equals("null")){
          break;
        }
        System.out.println("P2 TURN");
        p2.takeTurn(gameBoard);
      }
      System.out.println(gameBoard.checkWin() + " Wins!!!");
}}

