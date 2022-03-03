//checker objects to be stored on table.
public class Checker
  {
    private int location;
    private String color;
    
    public Checkers(int l, String c)
    {
      location = l;
      color = c;
    }
    
    public int getLocation()
    {
      return location;
    }
    
    public String getColor()
    {
      return color;
    }
  }
public class KingChecker extends Checker
  {
    private static boolean isKing = true;
    
    public KingChecker(int l, String c)
    {
      super(l, c);
    }
    
    public int getLocation()
    {
      return super.location + "K";
    }

    public String getColor()
    {
      return super.color;
    }
  }