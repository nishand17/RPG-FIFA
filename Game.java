import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    String clear = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    private String userManagerName;
    private Team userTeam;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team team5;
    private Team team6;
    private ArrayList<Team> teamList;
    private ArrayList<Player> playerList;
    //various instance fields including a team and player Arraylist for the whole game
    public Game(String userManName) {
        //initializes the instance fields, and adds teams and players to their respective arrayLists
        userManagerName = userManName;
        userTeam = new Team("St. Francis FC", userManName);
        team2 = new Team("London Lightning", "William");
        team3 = new Team("Los Angeles Bulldogs", "Christopher");
        team4 = new Team("New York Bulls", "Jackson");
        team5 = new Team("Roma FC", "Didier Deschamps");
        team6 = new Team("Manchester United", "Nishan D'Souza");
        teamList = new ArrayList<Team>();
        teamList.add(userTeam);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);
        teamList.add(team5);
        teamList.add(team6);
        playerList = new ArrayList<Player>();
        //overall pace shooting dribbling passing defense physical
        //overall pace, diving, reflexes, passing, positioning, handling
        playerList.add(new Player("Lionel Messi", "W", 94, 95, 92, 96, 88, 30, 70));
        playerList.add(new Player("Cristiano Ronaldo", "W", 93, 92, 93, 90, 80, 33, 78));
        playerList.add(new Player("Manuel Neuer", "G", 90, 50, 80, 90, 58, 85, 80));
        playerList.add(new Player("Luis(Biter) Suarez", "S", 90, 88, 94, 90, 72, 38, 90));
        playerList.add(new Player("Arjen Robben", "W", 90, 92, 82, 93, 88, 40, 60));
        playerList.add(new Player("Sergio Aguero", "S", 89, 89, 89, 89, 80, 50, 29));
        playerList.add(new Player("Robert Lewandowski", "S", 89, 83, 89, 85, 80, 40, 78));
        playerList.add(new Player("Franck Ribery", "W", 88, 89, 80, 90, 80, 40, 53));
        playerList.add(new Player("Thiago Silva", "C", 88, 74, 51, 60, 70, 90, 90));
        playerList.add(new Player("David De Gea", "G", 88, 60, 84, 88, 55, 90, 75));
        playerList.add(new Player("Andres Iniesta", "M", 88, 75, 70, 90, 93, 58, 50));
        playerList.add(new Player("Sergio Ramos", "C", 88, 79, 68, 50, 70, 88, 93));
        playerList.add(new Player("Eden Hazard", "W", 88, 88, 89, 90, 80, 19, 40));
        playerList.add(new Player("James Rodriguez", "M", 88, 80, 83, 85, 82, 72, 80));
        playerList.add(new Player("Bastian Schweinsteger", "M", 87, 70, 76, 77, 86, 83, 80));
        playerList.add(new Player("Luca Modric", "M", 87, 79, 82, 88, 83, 60, 45));
        playerList.add(new Player("Jerome Boateng", "C", 87, 80, 30, 50, 50, 88, 88));
        playerList.add(new Player("Giorgio Chiellini", "C", 87, 76, 30, 40, 50, 89, 90));
        playerList.add(new Player("Anthony Martial", "S", 86, 88, 83, 88, 70, 50, 70));
        playerList.add(new Player("Thibaut Courtois", "G", 86, 68, 82, 80, 70, 84, 84));
        playerList.add(new Player("Wayne Rooney", "S", 86, 82, 90, 78, 80, 60, 78));
        playerList.add(new Player("Arturo Vidal", "M", 86, 80, 79, 82, 80, 75, 84));
        playerList.add(new Player("Vincent Kompany", "C", 86, 80, 40, 20, 37, 86, 85));
        playerList.add(new Player("Karim Benzema", "S", 85, 83, 86, 80, 68, 30, 70));
        playerList.add(new Player("Yaya Toure", "M", 85, 80, 83, 82, 80, 70, 95));
        playerList.add(new Player("Angel Di Maria", "W", 85, 90, 82, 90, 70, 70, 61));
        playerList.add(new Player("Petr Cech", "G", 85, 50, 81, 82, 58, 75, 70));
        playerList.add(new Player("Iker Casillas", "G", 84, 60, 87, 79, 30, 79, 80));
        playerList.add(new Player("Chris Smalling", "C", 84, 80, 40, 50, 58, 84, 87));
        playerList.add(new Player("Claudio Bravo", "G", 83, 50, 80, 85, 60, 75, 80));
    }

    public void runDraft() {
        Scanner sc = new Scanner(System.in);
        Draft d = new Draft();//creates new instance of the draft calss
        System.out.print("Okay, let's start the draft! This will be in a format in which if you are 6th, \n you will be last in every round, and your position is...");        
        Collections.shuffle(teamList);//shuffles the teamList so that it is fully random for the draft. Collections is a static class with shuffle a static method to randomize the parameter
        int userPos = 0;
        //the following is a for loop that find the user's team and declared and initializes an integer method variable to the index of the user team
        for (int i = 0; i<teamList.size();i++) {
            if (teamList.get(i).name.substring(0,1).equals("S")) {
                userPos = i;
            }
        }        
        System.out.println(userPos+1);//tells the user their position
        System.out.println("Enter anything to start!"); 
        String input = sc.nextLine();
        System.out.println(clear);
        for (int i = 1; i <6;i++) {
            for (int j = 1; j < 7;j++) {
                if (userPos == j-1) {//user 2 nested for loops, 1 to interate through the teams, one to iterate through the draft round
                    System.out.println("Players remaining: ");//if the positions is the users, it uses the userPick method of the draft class, if not uses the cpuPick
                    printPlayerList();
                    d.userPick(playerList, teamList.get(j-1));
                    System.out.println(clear);
                }
                else {
                    d.cpuPick(playerList, teamList.get(j-1));
                }
            }
        }
        System.out.println("So that's the draft! Enter anything to see the list of teams!");
        String st = sc.nextLine();
        Team temporary = teamList.get(0);
        teamList.set(0,teamList.get(userPos));
        teamList.set(userPos,temporary);
        //the previous code is in order to have the user's team first when rosters are printed later on in the for loop
        for (int i = 0; i<teamList.size();i++) {
            if (teamList.get(i).name.substring(0,1).equals("S")) {
                userPos = i;
            }
        }   
        for (int i = 0; i < teamList.size(); i++) {
            if (i != userPos) {
                System.out.println("Team " + (i+1) + ": " + teamList.get(i).name);
            }
            else {
                System.out.println("Your team...");
            }
            teamList.get(i).printRoster();
            System.out.println("");
        }
        //prints all the rosters
    }

    public void runSeason() {
        Scanner sc = new Scanner(System.in);
        Match m = new Match();
        int gameNum = 1;
        boolean continueSeason = true;
        System.out.println("The Season starts now! Enter anything to start!");
        sc.next();
        System.out.println(clear);
        while (continueSeason == true) {
            System.out.println("Choose what you want to do, " + userManagerName + "! \n 1. Play a Game \n 2. See your roster \n 3. See the standings");
            int response = sc.nextInt();//gives user choices and saves that choice in a integer value
            switch (response) {
                case 1: 
                System.out.println(clear);
                switch (gameNum) {
                    case 1://if the user wants to play a game, based on the number they've played already, will play matchday 1, 2, etc.
                    System.out.println("Matchday 1!");
                    askUserForPrompt();
                    m.runPlayerMatch(teamList.get(0), teamList.get(1));//creates a Match class earlier and uses the runPlayerMatch and runCpuMatch methods to play a game
                    m.runCPUMatch(teamList.get(2), teamList.get(3));
                    m.runCPUMatch(teamList.get(4), teamList.get(5));
                    gameNum++;
                    System.out.println(clear);
                    break;
                    case 2:
                    System.out.println("Matchday 2!");
                    askUserForPrompt();
                    m.runPlayerMatch(teamList.get(0), teamList.get(2));
                    m.runCPUMatch(teamList.get(1), teamList.get(4));
                    m.runCPUMatch(teamList.get(3), teamList.get(5));
                    gameNum++;
                    System.out.println(clear);
                    break;
                    case 3:
                    System.out.println("Matchday 3!");
                    askUserForPrompt();
                    m.runPlayerMatch(teamList.get(0), teamList.get(3));
                    m.runCPUMatch(teamList.get(1), teamList.get(5));
                    m.runCPUMatch(teamList.get(2), teamList.get(4));
                    gameNum++;
                    System.out.println(clear);
                    break;
                    case 4:
                    System.out.println("Matchday 4!");
                    askUserForPrompt();
                    m.runPlayerMatch(teamList.get(0), teamList.get(4));
                    m.runCPUMatch(teamList.get(1), teamList.get(3));
                    m.runCPUMatch(teamList.get(2), teamList.get(5));
                    gameNum++;
                    System.out.println(clear);
                    break;
                    case 5:
                    System.out.println("Time for the final matchday!");
                    askUserForPrompt();
                    m.runPlayerMatch(teamList.get(0), teamList.get(5));
                    m.runCPUMatch(teamList.get(1), teamList.get(2));
                    m.runCPUMatch(teamList.get(3), teamList.get(4));
                    System.out.println(clear);
                    continueSeason = false;
                    break;
                }
                break;

                case 2: 
                teamList.get(0).printRoster();
                askUserForPrompt();
                break;

                case 3: 
                printStandings();
                System.out.println("Press anything to go back!");
                sc.next();
                break;
            }            
        }
        System.out.println("That's the season! Let's see the standings!");
        printStandings();
        askUserForPrompt();
    }

    public void runEnding() {
        ArrayList<Team> finalStandings = printStandings();
        if (finalStandings.get(0).name.substring(0,1).equals("S")) { //checks if the first team in the sorted list is the user's team, if it is the user wins and the fun class does some ASCII art, or else the user loses
            Fun_yet_extremely_useless f = new Fun_yet_extremely_useless();
            f.fun();
        }
        else {
            System.out.println("YOU LOST!!!! :( :( :( YOU'RE THE WORST MANAGER EVAR! YOU'RE FIRED! (Goodbye)");
        }
    }

    public ArrayList<Team> printStandings() {
        //extremely logic-heavy method... the logic behind it is this:
        //I have an array of teams in the first place, but they need to be sorted for the standings. Collections.sort only creates an array of increasing value
        //First, i declare and initialize an empty arrayList to be modified. for each new team to be added, its points value is compared to the team in front
        //if the team in front is higher, you iterate the loop by one. if the team in front is lower, your team goes before it
        //this is accomplished through a nested for loop
        ArrayList<Team> newTeamList = new ArrayList<Team>();
        newTeamList.add(teamList.get(0));
        for (int i = 1; i < teamList.size(); i++) {
            for (int j = 0; j < newTeamList.size(); j++) {
                if (j == newTeamList.size()-1 && teamList.get(i).getPoints() < newTeamList.get(j).getPoints()) {
                    newTeamList.add(teamList.get(i));
                    break;
                }
                else if (teamList.get(i).getPoints() >= newTeamList.get(j).getPoints()) {
                    newTeamList.add(j, teamList.get(i));
                    break;
                }             
            }
        }
        System.out.println("Standings:");
        System.out.println("-----------------------------");
        for (int i = 0; i < newTeamList.size();i++) {
            System.out.println((i+1) + ". " + newTeamList.get(i).name + ": Points: " + newTeamList.get(i).getPoints()); //prints the teams in order of points
        }
        return newTeamList;
    }

    public Player getPlayerFromList(int index) {
        return playerList.get(index);
    }

    public void askUserForPrompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter anything to continue!");
        sc.next();
        System.out.println(clear);
    }

    public void printPlayerList () {
        for (int i = 0; i <playerList.size(); i++) {
            System.out.println((i+1) +". Name: " + playerList.get(i).name + " Rating: " + playerList.get(i).overallRating + " Position " + playerList.get(i).position);
        }
    }
}
