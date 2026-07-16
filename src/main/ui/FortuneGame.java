package ui;

import model.FortuneLog;
import model.Fortune;
import java.util.Scanner;

// Fortune game application
public class FortuneGame {
    private FortuneLog fortuneLog;
    private Scanner input;

    public FortuneGame() {
        fortuneLog = new FortuneLog();
        input = new Scanner(System.in);
        runFortuneGame();
    }

    // MODIFIES: this
    // EFFECTS: runs the fortune game and processes user input
    private void runFortuneGame() {
        boolean runGame = true;
        String command = null;

        displayWelcomeMessage();
        while(runGame) {
            displayMenu(); 
            command = input.next();
            command = command.toLowerCase();  
                     
            if (command.equals("q")) {
                runGame = false;
            } else {
                while (!validCommand(command)) {
                    System.out.println("invalid input. try again");
                    displayMenu();
                    command = input.next();
                    command = command.toLowerCase();
                }
                processUserInput(command);
            }
           
        }

        System.out.println("Thanks for playing!");
    }

    // MODIFIES: this
    // EFFECTS: displays the welcom message
    private void displayWelcomeMessage() {
        System.out.println("Welcome to The Fortune Game!");
        System.out.println("For those in need of a quick fortune.");
        System.out.println("Disclaimer: Fortunes not necessarily accurate.");
    }
    // MODIFIES: this
    // EFFECTS: displays a list of user options
    private void displayMenu() {
        System.out.println("Select:");
        System.out.println("a. Get your fortune told");
        System.out.println("s. See previous fortunes");
        System.out.println("d. See fortunes with good ratings");
        System.out.println("f. See fortunes with bad ratings");
        System.out.println("q. Quit");

    }

    // MODIFIES: this
    // EFFECTS: retruns true if given letter corresponds to a valid command
    private boolean validCommand(String command) {
        if(command.equals("a")) {
            return true;
        } else if (command.equals("s")){
            return true;
        } else if (command.equals("d")) {
            return true;
        } else if (command.equals("f")) {
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: makes a fortune and rolls result
    private void doFortuneTelling() {
        System.out.println("The fortune teller will answer by flipping a coin.");
        System.out.println("What is you question for the fortune teller?");
        String command = input.next();

        Fortune fortune = new Fortune(command);
        fortune.rollFortune();
        System.out.println("The result is " + fortune.getResult() + "!");
        fortuneLog.addFortune(fortune);
        rateFortuneResult(fortune);
    }

    private void rateFortuneResult(Fortune fortune) {
        System.out.println("Rate the result:");
        System.out.println("g. good");
        System.out.println("b. bad");

        input.nextLine();
        String rating = input.next();
        rating = rating.toLowerCase();
        if (rating.equals("g")) {
            fortune.setRating(true);
        } else {
            fortune.setRating(false);
        }
    }

    // MODIFIES: this
    // EFFECTS: displays all fortunes
    private void doSeeAllFortunes() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: Displays all good fortunes
    private void doSeeGoodFortunes() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: Displays all bad fortunes
    private void doSeeBadFortunes() {
        //stub
    }

    // REQUIRES: string != null
    // MODIFIES: this
    // EFFECTS: runs different processes based on given user input
    private void processUserInput(String command) {
        if (command.equals("a")){
            doFortuneTelling();
        } else if (command.equals("s")) {
            doSeeAllFortunes();
        } else if (command.equals("d")) {
            doSeeGoodFortunes();
        } else if (command.equals("f")) {
            doSeeBadFortunes();
        }
    }
}
