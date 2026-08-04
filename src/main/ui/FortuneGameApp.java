package ui;

import model.CardReading;
import model.CoinFlip;
import model.Fortune;
import model.FortuneLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gameactions.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@ExcludeFromJacocoGeneratedReport
// Representation of the UI for the FortuneGame
public class FortuneGameApp {

    private static final String JSON_FILE = "./data/fortunelog.json";

    public static final int WIDTH = 550;
    public static final int HEIGHT = 370;
    public static final int CENTER_X = WIDTH / 2;
    public static final int CENTER_Y = HEIGHT / 2;
    public static final Color BG_COLOR = new Color(47, 36, 102);
    public static final Color TEXT_COLOR = new Color(255, 248, 212);

    public static final ImageIcon HEADS_IMAGE = new ImageIcon("./data/Images/Heads.png");
    public static final ImageIcon TAILS_IMAGE = new ImageIcon("./data/Images/Tails.png");

    private JFrame frame;
    private JPanel fortuneLogPanel;
    private JScrollPane fortuneScrollPane;
    private JPopupMenu addPopupMenu;

    private FortuneLog fortuneLog;
    private JsonReader jasonReader;
    private JsonWriter jasonWriter;
    private ArrayList<GameAction> gameActions;


    private String tempType;
    private Fortune tempFortune;



    public FortuneGameApp() {
        initializeFields();
        runFortuneGame();
    }

    // MODIFIES: this
    // EFFECTS: Initializes all fields
    private void initializeFields() {
        fortuneLog = new FortuneLog();
        jasonReader = new JsonReader(JSON_FILE);
        jasonWriter = new JsonWriter(JSON_FILE);
        frame = new JFrame("Fortune Game");
        gameActions = new ArrayList<GameAction>();
        fortuneLogPanel = new JPanel();
        fortuneScrollPane = new JScrollPane(fortuneLogPanel);
        tempType = "";
        tempFortune = null;
        initializeAddFortunePopup();
    }

    // EFFECTS: Starts the app
    private void runFortuneGame() {
        initializeStartingVeiw();
    }

    // EFFECTS: initializes the starting panel
    private void initializeStartingVeiw() {
        defaultGraphics();
        initializeFortuneArea();
        initializeGameActions();
        frame.revalidate();
    }

    // EFFECTS: initializes the fortune area
    private void initializeFortuneArea() {
        fortuneScrollPane.setPreferredSize(new Dimension(0, 0));
        fortuneScrollPane.setBorder(new LineBorder(Color.black));
        frame.add(fortuneScrollPane, BorderLayout.CENTER);
        fortuneLogPanel.setLayout(new BoxLayout(fortuneLogPanel, BoxLayout.Y_AXIS));
        fortuneLogPanel.setBackground(BG_COLOR);

        // initializeFortunes(fortuneLogPanel, fortuneLog.getFortuneList());
        doSeeAllFortunes();
    }

    // REQUIRES: parentPanel == FortuneLogPanel, 0 <= type <=2
    // MODIFIES: this
    // EFFECTS: creates the panels for the fortunes and adds them to the scrollPane
    private void initializeFortunes(JPanel parentPanel, ArrayList<Fortune> fortunes, int type) {
        parentPanel.removeAll();
        parentPanel.revalidate();
        parentPanel.repaint();

        for (Fortune fortune : fortunes) {
            initializeFortune(fortune, parentPanel, type);
            System.out.println(fortune.getTopic());
            System.out.println(fortunes.size());
        }
        parentPanel.revalidate();
    }

    // REQUIRES: fortune != null, parentPanel != null
    // MODIFIES: this
    // EFFECTS: creates the fortune UI
    private void initializeFortune(Fortune fortune, JPanel parentPanel, int type) {
        JPanel fortunePanel = new JPanel();
        determineBackgroundColor(fortunePanel, type);
        fortunePanel.setLayout(new BoxLayout(fortunePanel, BoxLayout.Y_AXIS));
        //fortunePanel.setPreferredSize(new Dimension(500, 5));
        fortunePanel.setBorder(new EtchedBorder());

        String topicString = fortune.getTopic();
        String resultString = fortune.getResult();
        JLabel topic = new JLabel("Topic: " + topicString);
        JLabel result = new JLabel("Result: " + resultString);
        fortunePanel.add(topic);
        fortunePanel.add(result);
        JLabel imageIcon = addImage(resultString);
        if (imageIcon != null) {
            fortunePanel.add(imageIcon);
        }
        parentPanel.add(fortunePanel);
    }

    // EFFECTS: Determines the background color
    private void determineBackgroundColor(JPanel fortunePanel, int type) {
        switch (type) {
            case 1:
                fortunePanel.setBackground(Color.GREEN);
                break;
            case 2:
                fortunePanel.setBackground(Color.RED);
                break;
            default:
                fortunePanel.setBackground(Color.WHITE);
                break;
        }
    }

    // EFFECTS: adds images to coin flips
    // TO DO: add logic for card readings
    private JLabel addImage(String result) {
        switch (result) {
            case "Heads":
                return new JLabel(HEADS_IMAGE);
            
            case "Tails":
                return new JLabel(TAILS_IMAGE);

            default:
                return null;
        }
    }


    // // EFFECTS: Initialize the main menu
    // private void initializeMainMenu() {

    // }

    // MODIFIES: this
    // EFFECTS: Facilitates adding a fortune
    public void doAddFortune() {
        initializeAddFortunePopup();
        addPopupMenu.show(frame, (CENTER_X - 175), 100);
    }

    // REQUIRES: type != null
    // MODIFIES: this
    // EFFECTS: activates Question popup
    public void doAskQuestion(String type) {
        this.tempType = type;
        addPopupMenu.removeAll();
        JLabel question = new JLabel("You have chosen a " + type);
        JLabel prompt = new JLabel("What is your Question for the fortune teller?");

        addPopupMenu.add(question);
        addPopupMenu.add(prompt);
        UserQuestion userQuestion = new UserQuestion(this, addPopupMenu);
        
        addPopupMenu.revalidate();
        addPopupMenu.repaint();
    }

    // REQUIRES: user input != null
    // MODIFIES: this
    // EFFECTS: shows the result of the fortune roll and allows user to rate
    public void doShowResult(String userInput) {
        Fortune fortune;
        if (tempType.equals("Card Reading")) {
            fortune = new CardReading(userInput);
            this.tempType = null;
        } else {
            fortune = new CoinFlip(userInput);
            this.tempType = null;
        }

        fortune.rollFortune();
        fortuneLog.addFortune(fortune);
        tempFortune = fortune;

        addPopupMenu.removeAll();

        JLabel result = new JLabel("The result is: " + fortune.getResult());
        JLabel image = addImage(fortune.getResult());
        addPopupMenu.add(result);
        if (image != null) {
            addPopupMenu.add(image);
        }

        GoodRating goodRating = new GoodRating(this, addPopupMenu);
        BadRating badRating = new BadRating(this, addPopupMenu);

        addPopupMenu.revalidate();
        addPopupMenu.repaint();
    }

    // MODIFIES: this
    // EFFECTS: assigns fortune good rating, refreshes and closes popup, updates fortune list
    public void giveGoodRating() {
        tempFortune.setRating(true);
        tempFortune = null;

        addPopupMenu.removeAll();
        addPopupMenu.setVisible(false);

        initializeFortunes(fortuneLogPanel, fortuneLog.getFortuneList(), 0);
    }

    // MODIFIES: this
    // EFFECTS: assigns fortune a bad rating, refreshes and closes the popup, updates fortune list
    public void giveBadRating() {
        tempFortune.setRating(false);
        tempFortune = null;

        addPopupMenu.removeAll();
        addPopupMenu.setVisible(false);

        initializeFortunes(fortuneLogPanel, fortuneLog.getFortuneList(), 0);
    }

    // MODIFIES: this
    // EFFECTS: initializes the add fortune popup to be used
    private void initializeAddFortunePopup() {

        addPopupMenu = new JPopupMenu("Add Fortune");
        addPopupMenu.setPreferredSize(new Dimension(WIDTH - 200, HEIGHT - 200));

        addPopupMenu.removeAll();
        JLabel questionText = new JLabel("Would you like to do a card reading or coin flip?");
        addPopupMenu.add(questionText);
    
        CardReadingChoice cardReading = new CardReadingChoice(this, addPopupMenu);
        CoinFlipChoice coinFlip = new CoinFlipChoice(this, addPopupMenu);

        addPopupMenu.revalidate();
        addPopupMenu.repaint();
        
    }


    // private void doRemoveFortune() {

    // }

    // MODIFIES: Json file
    // EFFECTS: saves current state of game to JSON_FILE
    public void doSaveGame() {
        try {
            jasonWriter.open();
            jasonWriter.write(fortuneLog);
            jasonWriter.close();
            System.out.println("Saved game state");
            // TO DO: Add a popup menu
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to fiile :(");
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates the fortuneLogPanel to show only good rated fortunes
    public void doSeeGoodFortunes() {
        initializeFortunes(fortuneLogPanel, fortuneLog.getGoodFortunes(), 1);
    }

    // MODIFIES: this
    // EFFECTS: Updates the fortuneLogPanel to show only bad rated fortunes
    public void doSeeBadFortunes() {
        initializeFortunes(fortuneLogPanel, fortuneLog.getBadFortunes(), 2);
    }

    // MODIFIES: this
    // EFFECTS
    public void doSeeAllFortunes() {
        initializeFortunes(fortuneLogPanel, fortuneLog.getFortuneList(), 0);
    }

    // MODIFIES: this
    // EFFECTS: reads from JSON file and adds fortunes to fortune log
    // updates fortune UI
    public void doLoadGame() {
        try {
            fortuneLog = jasonReader.read();
            System.out.println("Loaded Previous Game from: " + JSON_FILE);
            doSeeAllFortunes();
        } catch (IOException e) {
            System.out.println("Unable to read from given file");
        }
    }

    // Adds avalible actions to the list of game actions
    // buttons of game actions are added to button panel
    private void initializeGameActions() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5));
        panel.setBackground(BG_COLOR);
        frame.add(panel, BorderLayout.PAGE_END);
        panel.setAlignmentY(SwingConstants.SOUTH);

        AllFortunes allFortunes = new AllFortunes(this, panel);
        gameActions.add(allFortunes);

        GoodFortunes goodFortunes = new GoodFortunes(this, panel);
        gameActions.add(goodFortunes);

        BadFortunes badFortunes = new BadFortunes(this, panel);
        gameActions.add(badFortunes);

        AddFortune addFortune = new AddFortune(this, panel);
        gameActions.add(addFortune);

        SaveGame saveGame =  new SaveGame(this, panel);
        gameActions.add(saveGame);

        LoadGame loadGame = new LoadGame(this, panel);
        gameActions.add(loadGame);



    }

    // EFFECTS: Initializes the graphics that don't change from panel to panel
    private void defaultGraphics() {
        frame.setLayout(new BorderLayout());
        frame.setSize(WIDTH, HEIGHT);
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel text = new JLabel("Welcome to The Fortune Game!");
        // text.setAlignmentX(SwingConstants.CENTER);
        // text.setAlignmentY(SwingConstants.TOP);
        
        frame.add(text, BorderLayout.PAGE_START);

    }
}
