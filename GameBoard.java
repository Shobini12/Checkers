import java.util.Locale;
import java.util.Scanner;

public class GameBoard {
    Scanner kb = new Scanner(System.in);
    Checkers[][] dgb = new Checkers[8][8]; //digital gameboard
    int toX;

    public GameBoard() {
        initBoard();
    }

    public Checkers[][] getBoard() {
        return dgb;
    }

    public void movePiece(String color, boolean isKing) {
        boolean firstCheck = false;
        boolean secondCheck = false;
        boolean thirdCheck = false;
        boolean fourthCheck = false;
        //check that these inputs are valid and doesn't make it go off the board
        System.out.println("Which piece do you want to move? Enter a     letter (A-H) and number (0-7)");
        String from = kb.nextLine();
        char fromXChar = from.charAt(0);
        System.out.println(fromXChar);
        int fromX = toInt(fromXChar);
        System.out.println(fromX);
        int fromY = Integer.parseInt(from.substring(1));
        System.out.println(fromY);
        System.out.println("Where would you like to move this piece?     Enter a letter (A-H) and number (0-7)");
        String to = kb.nextLine();
        char toXChar = to.charAt(0);
        int toX = toInt(toXChar);
        int toY = (int) to.charAt(1);
        //check if color of piece matches player
        if (dgb[fromX][fromY].equals(color)) {
            firstCheck = true;
        }
        //checks if the space is open
        if (dgb[toX][toY] == null) {
            secondCheck = true;
        }
        //check that the piece is moving forward
        if (toY > fromY) {
            thirdCheck = true;
        }

        //check if where you want to move is a diagonal movement
        if ((toX == fromX + 1 && toY == fromY + 1) || (toX == fromX - 1 && toY == fromY + 1)) {
            fourthCheck = true;
        }

        //Kings can move backwards
        if (dgb[fromX][toX].isKing() && (toX == fromX + 1 && toY == fromY + 1) || (toX == fromX - 1 && toY == fromY + 1) || (toX == fromX + 1 && toY == fromY - 1) || (toX == fromX - 1 && toY == fromY - 1)) {
            thirdCheck = true;
            fourthCheck = true;
        }

        //make sure all checks are true before moving the piece
        if (firstCheck && secondCheck && thirdCheck && fourthCheck) {
            //check for jump
            if (checkJump(fromX, fromY) == 0) {
                forceJumpRight(fromX, fromY);
            } else if (checkJump(fromX, fromY) == 1) {
                forceJumpLeft(fromX, fromY);
            } else {
                dgb[fromX][fromY] = null;
                dgb[toX][toY] = dgb[fromX][fromY];
            }
        }
    }

    public int checkJump(int x, int y) {
        //check for jump
        if (dgb[x + 2][y + 2] == null && dgb[x + 1][y + 1] != null && !(dgb[x + 1][y + 1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))) { //check that the space one right and one up is a piece of the opposite color
            return 0;
        } else if (dgb[x - 2][y + 2] == null && dgb[x - 1][y + 1] != null && !(dgb[x - 1][y + 1].getColor().equalsIgnoreCase(dgb[x][y].getColor()))) {
            return 1;
        } else {
            return 2;
        }
    }

    //if piece is a king, it can jump in any direction 3/23


    public void forceJumpRight(int x, int y) {
        dgb[x + 2][y + 2] = dgb[x][y];
        dgb[x + 1][y + 1] = null;
        //award point to the color that captured the piece in the jump
        dgb[x][y] = null;
        //check for double jump
        if (checkJump(x + 2, y + 2) == 0) {
            doubleJumpRight(x + 2, y + 2);
        } else if (checkJump(x + 2, y + 2) == 1) {
            doubleJumpLeft(x + 2, y + 2);
        }
    }

    public void forceJumpLeft(int x, int y) {
        dgb[x - 2][y + 2] = dgb[x][y];
        dgb[x - 1][y + 1] = null;
        //award point to the color that captured the piece in the jump
        dgb[x][y] = null;
        //check for double jump
        if (checkJump(x - 2, y + 2) == 0) {
            doubleJumpLeft(x - 2, y + 2);
        } else if (checkJump(x - 2, y + 2) == 1) {
            doubleJumpLeft(x - 2, y + 2);
        }

    }

    public void doubleJumpRight(int x, int y) {
        //double jump to the right
        dgb[x + 2][y + 2] = dgb[x + 1][y + 1];
        dgb[x + 1][y + 1] = null;
    }

    public void doubleJumpLeft(int x, int y) {
        dgb[x - 2][y + 2] = dgb[x + 1][y + 1];
        dgb[x][y] = null;
    }

    public void initBoard() {

        for (int a = 0; a < 3; a++) { //a is y level b c and d is x
            if (a == 0) {
                for (int b = 0; b < 7; b += 2) {
                    dgb[b][a] = new Checkers(b, a, "Red");
                }
            } else if (a == 1) {
                for (int c = 1; c < 8; c += 2) {
                    dgb[c][a] = new Checkers(c, a, "Red");
                }
            } else if (a == 2) {
                for (int d = 0; d < 7; d += 2) {
                    dgb[d][a] = new Checkers(d, a, "Red");
                }
            }
        }


        for (int e = 5; e < 9; e++) { //e is y level f g and h is x
            if (e == 5) {
                for (int f = 1; f < 8; f += 2) {
                    dgb[f][e] = new Checkers(f, e, "Blue");
                }
            } else if (e == 6) {
                for (int g = 0; g < 7; g += 2) {
                    dgb[g][e] = new Checkers(g, e, "Blue");
                }
            } else if (e == 7) {
                for (int h = 1; h < 8; h += 2) {
                    dgb[h][e] = new Checkers(h, e, "Blue");
                }
            }
        }
	 
	 
/* 
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
    */
    }

    public int toInt(char c) {
        int toX = 0;
        switch (c) {
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

    //returns winner if there is one, if not then returns null.
    public String checkWin() {
        int numRed = 0;
        int numBlue = 0;
        for (Checkers[] j : dgb) {
            for (Checkers i : j) {
                if (i.getColor().toLowerCase().equals("blue")) {
                    numBlue += 1;
                }
                if (i.getColor().toLowerCase().equals("red")) {
                    numRed += 1;
                }
            }
        }
        if (numRed == 0) {
            return "blue";
        }
        if (numBlue == 0) {
            return "red";
        }
        return null;
    }

    public void checkKing() {
        if (dgb[0][0].getColor().toLowerCase().equals("blue")) {
            dgb[0][0] = null;
            dgb[0][0] = new KingChecker(0, 0, "blue");
        }
        if (dgb[0][2].getColor().toLowerCase().equals("blue")) {
            dgb[0][2] = null;
            dgb[0][2] = new KingChecker(0, 2, "blue");
        }
        if (dgb[0][4].getColor().toLowerCase().equals("blue")) {
            dgb[0][4] = null;
            dgb[0][4] = new KingChecker(0, 0, "blue");
        }
        if (dgb[0][6].getColor().toLowerCase().equals("blue")) {
            dgb[0][6] = null;
            dgb[0][6] = new KingChecker(0, 0, "blue");

        }
        if (dgb[1][7].getColor().toLowerCase().equals("red")) {
            dgb[1][7] = null;
            dgb[1][7] = new KingChecker(0, 0, "red");
        }
        if (dgb[3][7].getColor().toLowerCase().equals("red")) {
            dgb[3][7] = null;
            dgb[3][7] = new KingChecker(0, 0, "red");
        }
        if (dgb[5][7].getColor().toLowerCase().equals("red")) {
            dgb[5][7] = null;
            dgb[5][7] = new KingChecker(0, 0, "red");
        }
        if (dgb[7][7].getColor().toLowerCase().equals("red")) {
            dgb[7][7] = null;
            dgb[7][7] = new KingChecker(0, 0, "red");
        }
    }

}
