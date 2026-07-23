package ui;

import model.FortuneLog;
import model.Fortune;
import persistence.JsonReader;
import java.util.Scanner;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.ArrayList;


// Fortune game application
@ExcludeFromJacocoGeneratedReport
public class FortuneGame {
    private static final String JSON_FILE = "./data/fortunelog.json";
    private FortuneLog fortuneLog;
    private Scanner input;
    private JsonReader jasonReader;

    public FortuneGame() {
        fortuneLog = new FortuneLog();
        input = new Scanner(System.in);
        jasonReader = new JsonReader(JSON_FILE);
        runFortuneGame();
    }

    // MODIFIES: this
    // EFFECTS: runs the fortune game and processes user input
    private void runFortuneGame() {
        boolean runGame = true;
        String command = null;

        displayWelcomeMessage();
        while (runGame) {
            System.out.println();
            displayMenu(); 
            command = input.next();
            command = command.toLowerCase();  
                     
            if (command.equals("q")) {
                runGame = false;
            } else {
                while (!validCommand(command)) {
                    System.out.println();
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
        System.out.println("g. Remove a fortune from the log");
        System.out.println("q. Quit");

    }

    // MODIFIES: this
    // EFFECTS: retruns true if given letter corresponds to a valid command
    private boolean validCommand(String command) {
        if (command.equals("a")) {
            return true;
        } else if (command.equals("s")) {
            return true;
        } else if (command.equals("d")) {
            return true;
        } else if (command.equals("f")) {
            return true;
        } else if (command.equals("g")) {
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: makes a fortune and rolls result
    private void doFortuneTelling() {
        System.out.println("The fortune teller will answer by flipping a coin.");
        System.out.println("What is you question for the fortune teller?");
        input.nextLine();
        String command = input.nextLine();

        Fortune fortune = new Fortune(command);
        System.out.println();
        fortune.rollFortune();
        System.out.println("The result is " + fortune.getResult() + "!");
        fortuneLog.addFortune(fortune);
        rateFortuneResult(fortune);
    }

    private void rateFortuneResult(Fortune fortune) {
        System.out.println();
        System.out.println("Rate the result:");
        System.out.println("g. good");
        System.out.println("b. bad");

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
        int counter = 1;
        ArrayList<Fortune> listOfFortunes = fortuneLog.getFortuneList();
        if (listOfFortunes.size() > 0) {
            for (Fortune fortune: listOfFortunes) {
                System.out.println(counter + ". " + fortune.toString());
                counter++;
            }
        } else {
            System.out.println("There are no fortunes yet. Be brave, try it!");
        }
        
    }

    // MODIFIES: this
    // EFFECTS: Displays all good fortunes
    private void doSeeGoodFortunes() {
        int counter = 1;
        ArrayList<Fortune> listOfFortunes = fortuneLog.getGoodFortunes();
        if (listOfFortunes.size() > 0) {
            for (Fortune fortune: listOfFortunes) {
                System.out.println(counter + ". " + fortune.toString());
                counter++;
            }
        } else {
            System.out.println("There are no good fortunes yet... That is unfortunate.");
        }
    }

    // MODIFIES: this
    // EFFECTS: Displays all bad fortunes
    private void doSeeBadFortunes() {
        int counter = 1;
        ArrayList<Fortune> listOfFortunes = fortuneLog.getBadFortunes();
        if (listOfFortunes.size() > 0) {
            for (Fortune fortune: listOfFortunes) {
                System.out.println(counter + ". " + fortune.toString());
                counter++;
            }
        } else {
            System.out.println("There are no bad fortunes yet. Lucky you!");
        }
    }

    // MODIFIES: this
    // EFFECTS: Helps the user remove a fortune from FortuneLog
    private void doRemoveFortunes() {
        ArrayList<Fortune> listOfFortunes = fortuneLog.getFortuneList();
        if (listOfFortunes.size() > 0) {
            doSeeAllFortunes();
            boolean notValid = true;
            while (notValid) {
            System.out.println("Input the number of the fortune that you would like to remove:");
            input.nextLine();
            int index = input.nextInt();
            if (index >= 1 && index <= listOfFortunes.size()) {
                System.out.println("Fortune Number " + index + " was removed.");
                index--;
                fortuneLog.removeFortune(index);
                notValid = false;
            } else {
                System.out.println("Invalid number.");
                System.out.println("");
            }
            }
            

        } else {
            System.out.println("There are no fortunes to remove.");
        }
        

    }

    // MODIFIES: this
    // EFFECTS: Loads fortune log from JSON data
    private void doLoadFortuneLog() {
        try {
            fortuneLog = jasonReader.read();
            System.out.println("Loaded Previous Game from: " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("Unable to read from given file");
        }
    }

    // REQUIRES: string != null
    // MODIFIES: this
    // EFFECTS: runs different processes based on given user input
    private void processUserInput(String command) {
        System.out.println();
        if (command.equals("a")) {
            doFortuneTelling();
        } else if (command.equals("s")) {
            doSeeAllFortunes();
        } else if (command.equals("d")) {
            doSeeGoodFortunes();
        } else if (command.equals("f")) {
            doSeeBadFortunes();
        } else if (command.equals("g")) {
            doRemoveFortunes();
        } else if (command.equals("z")) {
            //Save Data
        } else if (command.equals("x")) {
            doLoadFortuneLog();
        }
    }
}
