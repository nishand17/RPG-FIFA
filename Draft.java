import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Draft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Draft
{
    //this class consists of 2 methods, userPick and CpuPick 
    public Draft()
    {
    }
    public void userPick(ArrayList<Player> p, Team t) {
        Scanner sc = new Scanner(System.in);//declares and initializes new Scanner object referenced by sc
        boolean correctPick = false;//declares and initializes a boolean primitive value refrerenced by correctPick to choose a player        
        System.out.println("Choose a number from the list of Players to choose someone for your team!");
        int playerNum = sc.nextInt();
        boolean validPlayer = false;//boolean primitive for checking if the user's value entered is valid
        while (validPlayer == false) {
            if (playerNum>0 && playerNum<p.size()+1) {//if statement that checks is the playerNum integer value is between the range of the player arrayList
                validPlayer = true;
                break;
            }
            else {
                System.out.println("That is not a valid player, enter a valid number");
                playerNum = sc.nextInt();
            }
        }
        while (correctPick == false) {
            for (int i = 0; i < t.posNeeded.size(); i++) {
                if (p.get(playerNum-1).position.equals(t.getPosNeeded(i))) { //checks if the player is one of the positions needed by the team
                    correctPick = true;
                    t.posNeeded.remove(i);
                    break;
                }
            }
            if (correctPick == false) {//if not, the user will have to re-enter a player value
                System.out.println("You already have a player of that position! Choose another!");
                playerNum = sc.nextInt();
            }
        }
        System.out.println("You chose " + p.get(playerNum-1).name);
        t.addPlayer(p.get(playerNum-1));//adds the player to the team's roster arrayList and removes the player object from the player arrayList
        p.remove(playerNum-1);
        System.out.println("Your team now has: ");
        t.printRoster();
        System.out.println("Enter anything to continue!");
        String input = sc.next();
    }
    public void cpuPick(ArrayList<Player> p, Team t) {//the same logic as the userpick but with no inputs 
        boolean correctPick = false;
        int playerNum = 1;
        while (correctPick == false) {
            for (int i = 0; i < t.posNeeded.size(); i++) {
                if (p.get(playerNum-1).position.equals(t.getPosNeeded(i))) { 
                    correctPick = true;
                    t.posNeeded.remove(i);
                    break;
                }
            }
            if (correctPick == false) {
                playerNum = playerNum+1;
            }
        }
        t.addPlayer(p.get(playerNum-1));
        p.remove(playerNum-1);
    }
}
