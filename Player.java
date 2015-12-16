
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    public final String name;
    public final String position;
    public final int overallRating;
    public final int pace;
    public final int shooting;
    public final int dribbling;
    public final int passing;
    public final int defending;
    public final int physical;
    //various instance fields to be initialized in constructor
    public Player(String n, String pos, int r, int pac, int sho, int dri, int pas, int def, int phy)
    {
        name = n;
        position = pos;
        overallRating = r;
        pace = pac;
        shooting = sho;
        dribbling = dri;
        passing = pas;
        defending = def;
        physical = phy;
    }
}
