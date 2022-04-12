
//checker objects to be stored on table.
public class Checkers
  {
    private int locationy;
    private int locationx;
    private String color;
    //Constructor, called from main.
    public Checkers(int x, int y, String c)
    {
      locationy = y;
      locationx = x;
      color = c;
    }
    //get location method to get location of checker.
    public int getLocation()
    {
      return locationx + locationy;
    }
    //getColor method returns color of checker.
    public String getColor()
    {
      return color;
    }
    //getKing method returns if the object in the specified array location is a king.
    public boolean isKing()
    {
      return false;
    }
  }
  //KingChecker objects, same methods as the checkers.
class KingChecker extends Checkers
  {
    private int locationx;
    private int locationy;
    private String color;
    
    public KingChecker(int x, int y, String c)
    {
      super(x,y,c);
    }
    
    public int getLocation()
    {
      return locationx + locationy;
    }

    public String getColor()
    {
      return color;
    }

    public boolean isKing()
    {
      return true;
    }
  }


