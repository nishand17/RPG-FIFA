import java.util.Scanner;
/**
 * Write a description of class Starter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starter
{   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declares and initializes scanner object with sc as the object reference
        System.out.println("Welcome to FIFA 16! You're the manager of St. Francis FC, and you need to do\n your best to "
        + " become the best team in your league! If you fail to get 1st \nplace, you lose! Are you ready to win! " 
        + "Enter anything to start!");
        //welcomes user to game and sets sules
        String readyToStart = sc.nextLine();
        //user nextLine method and initializes return value to string variable readyTostart
        System.out.println("Enter your name!");
        String name = sc.nextLine();
        System.out.println("Okay, " + name + " let's get started!");
        System.out.println();
        Game g = new Game(name);
        //creates instance of game class and runs methods of the class
        g.runDraft();
        g.runSeason();
        g.runEnding();
    }
}
