import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class Match here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Match
{
    Scanner sc;
    public Match() {
        sc = new Scanner(System.in);//initializes the scanner instance field;
    }

    public void askForRandomIn() {//takes a random input in order to save some space
        sc.next();
    }

    public void runPlayerMatch(Team user, Team other) {
        System.out.println("The match between " + user.name + " and " + other.name + " is about to start! \n Enter anything to see the rosters!");
        askForRandomIn();
        user.printRoster();
        System.out.println();
        other.printRoster();
        //prints rosters of each team using the printRoster method of the Team calss
        Random r = new Random();
        Fun_yet_extremely_useless fun = new Fun_yet_extremely_useless();
        fun.printField();
        //creates an instance of the fun class to print out an ASCII art field
        System.out.println("The ref blows the whistle... and the game starts! Enter anything to commence!");
        for (int i = 0; i<11;i++) {
            int randomCase = (r.nextInt(4)+1);
            runUserCase(randomCase, user, other);
            //utilizes a for loop to run through various situations 10 times, calls method referred by runUserCase to choose one of 4 cases for the game
        }
        findUserResults(user, other);
        //uses the findUserResults method to end the game
    }

    public void runCPUMatch(Team one, Team two) {
        //same as runPlayerMatch but with no inputs or print statements
        Random r = new Random();
        for (int i = 0; i<7;i++) {
            int randomCase = (r.nextInt(4)+1);
            runCPUCase(randomCase, one, two);
        }
        findCPUResults(one, two);
    }

    public void runCPUCase(int caseNum, Team one, Team two) {
        //see runUserCase for detailed information, this class is the same as that minus inputs and print statements
        Random gen = new Random();
        //initializes new instance of Random class
        switch (caseNum) {
            case 1:
            //player vs goalkeeper
            Player oneAttacker1 = one.returnOtherThanKeeper();
            Player twoKeeper1 = two.returnCertainPlayer("G");
            //creates two players, one for the attack team, one for the goalkeeper
            int input1 = oneOrTwoRandom();
            switch(input1) {
                case 1:
                int oneAttackR1 = (gen.nextInt(oneAttacker1.shooting)*2);
                int twoGKR1 = (gen.nextInt(twoKeeper1.shooting) + gen.nextInt(twoKeeper1.dribbling));
                //creates random ratings for each player based on their stats
                if (oneAttackR1>=twoGKR1) one.addGoal();                
                break;
                case 2:
                int oneAttackR2 = (gen.nextInt(oneAttacker1.passing));
                int twoGKR2 = (gen.nextInt(twoKeeper1.pace));
                if (oneAttackR2>twoGKR2) one.addGoal();                               
                break;
                default: break;
            }
            break;
            case 2:
            Player oneAttacker2 = one.returnOtherThanKeeper();
            Player twoDefender1 = two.returnCertainPlayer("G");
            int input2 = oneOrTwoRandom();
            switch(input2) {
                case 1:
                int oneAttackR2 = (gen.nextInt(oneAttacker2.dribbling)*2);
                int twoDefenderR1 = (gen.nextInt(twoDefender1.defending) + gen.nextInt(twoDefender1.pace));
                if (oneAttackR2>twoDefenderR1) {
                    Player twoKeeper2 = two.returnCertainPlayer("G");
                    int input3 = oneOrTwoRandom();
                    switch(input3) {
                        case 1:
                        int oneAttackR3 = (gen.nextInt(oneAttacker2.shooting)*2);
                        int twoGKR2 = (gen.nextInt(twoKeeper2.shooting) + gen.nextInt(twoKeeper2.dribbling));
                        if (oneAttackR3>=twoGKR2) one.addGoal();                
                        break;
                        case 2:
                        int oneAttackR4 = (gen.nextInt(oneAttacker2.passing));
                        int twoGKR3 = (gen.nextInt(twoKeeper2.pace));
                        if (oneAttackR4>twoGKR3) one.addGoal();                               
                        break;
                        default: break;
                    }
                }
                break;
                case 2:
                int oneAttackR5 = gen.nextInt(oneAttacker2.passing);
                int oneDefenderR2 = gen.nextInt(twoDefender1.defending);
                if(oneAttackR5>oneDefenderR2) one.addGoal();
                break;
                default: break;
            }
            break;
            case 3:
            Player twoAttacker1 = two.returnOtherThanKeeper();
            Player oneKeeper1 = one.returnCertainPlayer("G");
            int input4 = oneOrTwoRandom();
            switch(input4) {
                case 1:
                int twoAttackR1 = (gen.nextInt(twoAttacker1.shooting)*2);
                int oneGKR1 = (gen.nextInt(oneKeeper1.shooting) + gen.nextInt(oneKeeper1.dribbling));
                if (twoAttackR1>=oneGKR1) two.addGoal();                
                break;
                case 2:
                int twoAttackR2 = (gen.nextInt(twoAttacker1.passing));
                int oneGKR2 = (gen.nextInt(oneKeeper1.pace));
                if (twoAttackR2>oneGKR2) two.addGoal();                               
                break;
                default: break;
            }
            break;
            case 4:
            Player twoAttacker2 = two.returnOtherThanKeeper();
            Player oneDefender1 = one.returnCertainPlayer("G");
            int input5 = oneOrTwoRandom();
            switch(input5) {
                case 1:
                int twoAttackR2 = (gen.nextInt(twoAttacker2.dribbling)*2);
                int oneDefenderR1 = (gen.nextInt(oneDefender1.defending) + gen.nextInt(oneDefender1.pace));
                if (twoAttackR2>oneDefenderR1) {
                    Player oneKeeper2 = one.returnCertainPlayer("G");
                    int input6 = oneOrTwoRandom();
                    switch(input6) {
                        case 1:
                        int twoAttackR3 = (gen.nextInt(twoAttacker2.shooting)*2);
                        int oneGKR2 = (gen.nextInt(oneKeeper2.shooting) + gen.nextInt(oneKeeper2.dribbling));
                        if (twoAttackR3>=oneGKR2) two.addGoal();                
                        break;
                        case 2:
                        int twoAttackR4 = (gen.nextInt(twoAttacker2.passing));
                        int oneGKR3 = (gen.nextInt(oneKeeper2.pace));
                        if (twoAttackR4>oneGKR3) two.addGoal();                               
                        break;
                        default: break;
                    }
                }
                break;
                case 2:
                int twoAttackR5 = gen.nextInt(twoAttacker2.passing);
                int oneDefenderR2 = gen.nextInt(oneDefender1.defending);
                if(twoAttackR5>oneDefenderR2) two.addGoal();
                break;
                default: break;
            }
            break;
            default: break;
        }
    }
    public void runUserCase(int caseNum, Team user, Team other) {
        //4 various scenarios will be looped 4 times, so i will comment code one of the 4 sections. the other 3 are basically the same
        Random gen = new Random();
        //The user will be asked what they would like to do in various cases, and will choose the scenario
        switch (caseNum) {//switch statement to control which of the 4 cases are used, caseNum is a parameter variable which is an explicit parameter in this statement
            case 1:
            Player attacker1 = user.returnOtherThanKeeper();//uses the returnOtherThanKeeper method of the team class to return a random player other than the keepr
            Player keeper1 = other.returnCertainPlayer("G");//uses the returnCertainPlayer with "G" as the parameter variable to get a player with the G position, or goalie
            //this process will be repeated throughout this method to access various players
            System.out.println(attacker1.name + " is one on one with " + keeper1.name + "! \n What will you do! (Enter a number) \n1. Shoot \n2. Pass Across to a player");
            //gives the user options of what they want to do 
            int input1 = sc.nextInt();
            switch(input1) {
                case 1:
                int aRating1 = (gen.nextInt(attacker1.shooting)*2);
                int kRating1 = (gen.nextInt(keeper1.shooting) + gen.nextInt(keeper1.dribbling));
                //creates the stats of each player declared and initialized earlier specialized for the challenge
                if (aRating1>=kRating1) { //compares ratings of each player and acts accordingly
                    user.addGoal();//adds a goal to the user's team class tally
                    System.out.println(attacker1.name + " has SCORED! Well done! Enter anything to start kickoff again");

                    System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                    askForRandomIn();
                    //uses askRandominput method to ask the user to enter anything 
                }
                else {
                    System.out.println(keeper1.name + " SAVED the shot! Unlucky... Enter anything to resume play!");
                    askForRandomIn();
                }
                break;
                case 2:
               
                int aRating2 = (gen.nextInt(attacker1.passing));
                int kRating2 = (gen.nextInt(keeper1.pace));
                if (aRating2>=kRating2) {
                    user.addGoal();
                    System.out.println(attacker1.name + " passes it across net and his teammate SCORES! Enter anything to start kickoff again!");
                    System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                    askForRandomIn();
                }
                else {
                    System.out.println(keeper1.name + " was too fast and grabbed the ball! Enter anything to resume play...");
                    askForRandomIn();
                }
                break;
                default: break;
            }
            //one on one with defender next--
            //this whole method is a repeat of what happened in case 1, with the only differences being which stats are used and what situation there is
            break;
            case 2:
            Player attacker2 = user.returnOtherThanKeeper();
            Player defender1 = other.returnCertainPlayer("C");
            System.out.println(attacker2.name + " is one on one with " + defender1.name + ". What will you do! \n1. Dribble around him \n2. Try a give and go");
            int input2 = sc.nextInt();//calls nextInt method of the Scanner referenced by sc
            switch (input2) {
                case 1:
                int aRating2 = (gen.nextInt(attacker2.dribbling)*2);
                int dRating1 = (gen.nextInt(defender1.defending) + gen.nextInt(defender1.pace));
                if (aRating2>=dRating1) {
                    System.out.println(attacker2.name + " ran around " + defender1.name);
                    Player keeper2 = other.returnCertainPlayer("G");
                    System.out.println(attacker2.name + " is one on one with " + keeper2.name + "! \n What will you do! (Enter a number) \n1. Shoot \n2. Pass Across to a player");
                    int input3 = sc.nextInt();
                    switch(input3) {
                        case 1:
                        int aRating3 = (gen.nextInt(attacker2.shooting)*2);
                        int kRating3 = (gen.nextInt(keeper2.shooting) + gen.nextInt(keeper2.dribbling));
                        if (aRating3>=kRating3) {
                            user.addGoal();
                            System.out.println(attacker2.name + "has SCORED! Well done! Enter anything to start kickoff again");
                            System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                            askForRandomIn();
                        }
                        else {
                            System.out.println(keeper2.name + " SAVED the shot! Unlucky... Enter anything to resume play!");
                            askForRandomIn();
                        }
                        break;
                        case 2:
                        int aRating4 = (gen.nextInt(attacker2.passing));
                        int kRating4 = (gen.nextInt(keeper2.pace));
                        if (aRating4>=kRating4) {
                            user.addGoal();
                            System.out.println(attacker2.name + " passes it across net and his teammate SCORES! Enter anything to start kickoff again!");
                            System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                            askForRandomIn();
                        }
                        else {
                            System.out.println(keeper2.name + " was too fast and grabbed the ball! Enter anything to resume play...");
                            askForRandomIn();
                        }
                        break;
                        default: break;
                    }
                }
                else {
                    System.out.println("Unlucky, the defender caught you!.. enter anything to resume!");
                    askForRandomIn();
                }
                break;
                case 2:
                int aRating3 = (gen.nextInt(attacker2.passing)*2);
                int dRating2 = (gen.nextInt(defender1.defending)*2);
                if (aRating3>=dRating2) {
                    System.out.println(attacker2.name + " managed a give and go and SCORED! Enter anything to start kickoff again!");
                    user.addGoal();
                    System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());

                    askForRandomIn();
                }
                else {
                    System.out.println(defender1.name + " intercepted the play and started a counterattack! Enter anything to continue...");
                    askForRandomIn();
                }
                break;
                default: break;
            }
            break;
            case 3:
            Player cpuAttacker1 = other.returnOtherThanKeeper();
            Player userGK = user.returnCertainPlayer("G");
            System.out.println(cpuAttacker1.name + " is one on one with your keeper, " + userGK.name + "! See if he saves you by entering anything...");
            askForRandomIn();
            int cpuARating = (gen.nextInt(cpuAttacker1.shooting)*2);
            int userGKRating = (gen.nextInt(userGK.shooting) + gen.nextInt(userGK.dribbling));
            if (cpuARating>= userGKRating) {
                System.out.println("And they've scored... Enter anything to resume...");
                other.addGoal();
                System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());

                askForRandomIn();
            }
            else {
                System.out.println(userGK.name + " made a fine save! Enter anything to resume...");
                askForRandomIn();
            }

            break;
            case 4:
            Player cpuAttacker2 = other.returnOtherThanKeeper();
            Player userDefender = user.returnCertainPlayer("C");
            System.out.println(cpuAttacker2.name + " is one on one with your centerback, " + userDefender.name + "! What will you do... \n1. Slide Tackle \n2. Stay back and wait for him");
            int input3 = sc.nextInt();
            switch(input3) {
                case 1: 
                int cpuARating2 = (gen.nextInt(cpuAttacker2.dribbling) + gen.nextInt(cpuAttacker2.physical));
                int userDefRating = (gen.nextInt(userDefender.defending)*2);
                if (userDefRating>= cpuARating2) {
                    System.out.println(userDefender.name + " saved you! You're okay for now... Enter anything to resume!");
                    askForRandomIn();
                }
                else {
                    System.out.println("They got past you!");
                    userGK = user.returnCertainPlayer("G");
                    System.out.println(cpuAttacker2.name + " is one on one with your keeper, " + userGK.name + "! See if he saves you by entering anything...");
                    askForRandomIn();
                    int cpuARating3 = (gen.nextInt(cpuAttacker2.shooting)*2);
                    userGKRating = (gen.nextInt(userGK.shooting) + gen.nextInt(userGK.dribbling));
                    if (cpuARating3>= userGKRating) {
                        System.out.println("And they've scored... Enter anything to resume...");
                        other.addGoal();
                        System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                        askForRandomIn();
                    }
                    else {
                        System.out.println(userGK.name + " made a fine save! Enter anything to resume...");
                        askForRandomIn();
                    }
                }
                break;
                case 2:
                int cpuARating4 = (gen.nextInt(cpuAttacker2.dribbling) + gen.nextInt(cpuAttacker2.pace));
                int userDefRating2 = (gen.nextInt(userDefender.defending)*2);
                if (cpuARating4<userDefRating2) {
                    System.out.println(userDefender.name + " stood his ground well and stopped " + cpuAttacker2.name + ". Enter anything to resume");
                    askForRandomIn();
                }
                else {
                    System.out.println("They got past you!");
                    userGK = user.returnCertainPlayer("G");
                    System.out.println(cpuAttacker2.name + " is one on one with your keeper, " + userGK.name + "! See if he saves you by entering anything...");
                    askForRandomIn();
                    int cpuARating5 = (gen.nextInt(cpuAttacker2.shooting)*2);
                    userGKRating = (gen.nextInt(userGK.shooting) + gen.nextInt(userGK.dribbling));
                    if (cpuARating5>= userGKRating) {
                        System.out.println("And they've scored... Enter anything to resume...");
                        other.addGoal();
                        System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
                        askForRandomIn();
                    }
                    else {
                        System.out.println(userGK.name + " made a fine save! Enter anything to resume...");
                        askForRandomIn();
                    }
                }
                break;
                default: break;
            }
            break;
            default: break;
        }

    }

    public void findUserResults(Team user, Team other) {//this method ends the game, with Team variable user and other as parameter variables to be user later on
        System.out.println("The score is " + user.getGoals() + "-" + other.getGoals());
        if (user.getGoals()>other.getGoals()) {//uses the getGoals method which returns the number of goals a team has
            System.out.println("You WIN! Good Job! Enter anything to resume the season!");
            user.setPoints(3);//setPoints is a method that adds the number of points that it in the explicit parameter section
            askForRandomIn();
        }
        else if (other.getGoals() > user.getGoals()) {
            System.out.println("You lost... Enter anything to resume");
            other.setPoints(3);
            askForRandomIn();
        }
        else {
            System.out.println("It ends as a draw... Enter anything to continue!");
            other.setPoints(1);
            user.setPoints(1);
            askForRandomIn();
        }
        other.clearGoals();
        user.clearGoals();
        //clears the number of goals for each team in order to loop the match process multiple timesd
    }

    public void findCPUResults(Team one, Team two) {//the same as findUserResults except with no promps or prints
        if (one.getGoals()>two.getGoals()) {            
            one.setPoints(3);            
        }
        else if (two.getGoals() > one.getGoals()) {            
            two.setPoints(3);
        }
        else {
            one.setPoints(1);
            two.setPoints(1);
        }
        one.clearGoals();
        two.clearGoals();
    }

    public int oneOrTwoRandom() {//generates a random 1 or 2 to be used in the CPUCase method
        Random gen = new Random();
        return (gen.nextInt(2)+1);
    }
}
