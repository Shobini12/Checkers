
//checker objects to be stored on table.
public class Checkers
  {
    private int locationy;
    private int locationx;
    private String color;
    
    public Checkers(int x, int y, String c)
    {
      locationy = y;
      locationx = x;
      color = c;
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
      return false;
    }
  }
class KingChecker extends Checkers
  {
    private int locationx;
    private int locationy;
    private String color;
    private static boolean isKing = true;
    
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
//awd


