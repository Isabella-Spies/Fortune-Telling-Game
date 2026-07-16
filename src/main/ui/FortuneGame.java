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
                     
            if (command == "q") {
                runGame = false;
            } else {
                while (invalidCommand(command)) {
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

    }

    // MODIFIES: this
    // EFFECTS: retruns true if given letter corresponds to a valid command
    private boolean invalidCommand(String command) {
        if(command == "a" || command == "s" || command == "d" || command == "f") {
            return false;
        }
        return true;
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

        String rating = input.next();
        rating = rating.toLowerCase();
        if (rating == "g") {
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
        if (command == "a"){
            doFortuneTelling();
        } else if (command == "s") {
            doSeeAllFortunes();
        } else if (command == "d") {
            doSeeGoodFortunes();
        } else if (command == "f") {
            doSeeBadFortunes();
        }
    }
}
