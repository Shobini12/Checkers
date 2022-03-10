
//checker objects to be stored on table.
public class Checkers
  {
    private String location;
    private String color;
    
    public Checkers(String l, String c)
    {
      location = l;
      color = c;
    }
    
    public String getLocation()
    {
      return location;
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
class KingChecker extends Checker
  {
    private String location;
    private String color;
    private static boolean isKing = true;
    
    public KingChecker(String l, String c)
    {
      super(l, c);
    }
    
    public String getLocation()
    {
      return location + "K";
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


