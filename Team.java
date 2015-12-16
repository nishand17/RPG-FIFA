import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    //instance fields to be initialized in constuctor
    private int points;
    private ArrayList<Player> roster;
    public final String name;
    public final String manager;
    public ArrayList<String> posNeeded;
    private int goalNumber;
    public Team(String n, String m){
        //constructor that initializes instance fields along with adding positions needed to be used in the draft
        name = n;
        manager = m;
        roster = new ArrayList<Player>();
        points = 0;
        goalNumber = 0;
        posNeeded = new ArrayList<String>();
        posNeeded.add("G");
        posNeeded.add("C");
        posNeeded.add("M");
        posNeeded.add("W");
        posNeeded.add("S");
    }
    //various accessor and mutator methods, i will explain unusual methojds
    public int getPoints() {
        return points;
    }
    public void setPoints(int p) {
        points+= p;
    }
    public void addGoal() {
        goalNumber++;
    }
    public int getGoals() {
        return goalNumber;
    }
    public void clearGoals() {
        goalNumber = 0;
    }
    public Player getPlayer(int index) {
        return roster.get(index);
    }
    public void addPlayer(Player p) {
        roster.add(p);
    }
    public void removePlayer(int index) {
        roster.remove(index);
    }
    public String getName() {
        return name;
    }
    public String getManager() {
        return manager;
    }
    public String getPosNeeded(int index) {
        return posNeeded.get(index);
    }
    public void printRoster() {//prints the roster of the team
        System.out.println(name);
        //uses a for loop to iterate through the team's roster, and prints the name, rating, etc of them
        for (int i = 0; i < roster.size(); i++) {
            System.out.println((i+1) + ". Name: " + roster.get(i).name + " Rating: " + roster.get(i).overallRating + " Position " + roster.get(i).position);
        }
    }
    public Player returnCertainPlayer(String position) {//returns a player of the string position in the parameter spot
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).position.equals(position)) {
                return roster.get(i);
            }
        }        
        ///a for loop that searches for a player with the certain position
        return null;
    }
    public Player returnOtherThanKeeper() {//utilizes same logic as the previous method to get a keeper
        Random gen = new Random();
        int random = gen.nextInt(4);
        boolean valid = false;
        while (valid == false) {
            if (getPlayer(random).position.equals("G")) {
                random = gen.nextInt(4);
            }
            else {
                valid = true;
            }
        }
        return getPlayer(random);
    }
}
