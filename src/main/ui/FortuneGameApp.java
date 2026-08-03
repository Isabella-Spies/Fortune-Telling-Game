package ui;
import model.Fortune;
import model.FortuneLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.GameActions.GameAction;
import ui.GameActions.LoadGame;

import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

// Representation of the UI for the FortuneGame
public class FortuneGameApp {

    private static final String JSON_FILE = "./data/fortunelog.json";

    public static final int WIDTH = 550;
    public static final int HEIGHT = 370;
    public static final Color BG_COLOR = new Color(47, 36, 102);
    public static final Color TEXT_COLOR = new Color(255, 248, 212);

    private JFrame frame;
    private JPanel fortuneLogPanel;
    private JScrollPane fortuneScrollPane;

    private FortuneLog fortuneLog;
    private JsonReader jasonReader;
    private JsonWriter jasonWriter;
    private ArrayList<GameAction> gameActions;



    public FortuneGameApp() {
        fortuneLog = new FortuneLog();
        jasonReader = new JsonReader(JSON_FILE);
        jasonWriter = new JsonWriter(JSON_FILE);
        frame = new JFrame("Fortune Game");
        gameActions = new ArrayList<GameAction>();
        fortuneLogPanel = new JPanel();
        fortuneScrollPane = new JScrollPane();

        runFortuneGame();
    }

    // Starts the app
    private void runFortuneGame() {
        initializeGameActions();
        initializeStartingVeiw();
    }

    // EFFECTS: initializes the starting panel
    // See Diagram for button config
    private void initializeStartingVeiw() {
        defaultGraphics();
        initializeFortuneArea();
        initializeGameActions();
    }

    private void initializeFortuneArea() {
        fortuneLogPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        fortuneLogPanel.setLayout(new GridLayout(0, 1));
        fortuneLogPanel.setSize(new Dimension(0, 0));
        frame.add(fortuneLogPanel, BorderLayout.CENTER);
        fortuneLogPanel.add(fortuneScrollPane);
        fortuneScrollPane.setMaximumSize(new Dimension(0,0));
        updateFortuneArea();
    }

    private void updateFortuneArea() {
        fortuneScrollPane = initializeFortuneZone(fortuneScrollPane);
    }

    private JScrollPane initializeFortuneZone(JScrollPane scrollPane) {
        for (Fortune fortune: fortuneLog.getFortuneList()) {
            
            JLabel topicLabel = new JLabel(fortune.getTopic());
            JLabel resultLabel = new JLabel(fortune.getResult());
            
            scrollPane.add(topicLabel);
            scrollPane.add(resultLabel);
        }
        return scrollPane;
    }

    private JPanel initializeFortune(Fortune fortune) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //topicLabel.setMaximumSize(new Dimension(0, 0));
        // topicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel resultLabel = new JLabel(fortune.getResult());
        resultLabel.setMaximumSize(new Dimension(0,0));
        //topicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //panel.add(topicLabel);
        panel.add(resultLabel);

        return panel;
    }


    // // EFFECTS: Initialize the main menu
    // private void initializeMainMenu() {

    // }

    // EFFECTS: Facilitates adding a fortune
    // private void doAddFortune() {

    // }

    // private void doRemoveFortune() {

    // }

    // private void doSaveGame() {

    // }

    // MODIFIES: this
    // EFFECTS: reads from JSON file and adds fortunes to fortune log
    // updates fortune UI
    public void doLoadGame() {
        try {
            fortuneLog = jasonReader.read();
            System.out.println("Loaded Previous Game from: " + JSON_FILE);
            updateFortuneArea();
        } catch (IOException e) {
            System.out.println("Unable to read from given file");
        }
    }

    private void doQuitGame() {

    }

    // Adds avalible actions to the list of game actions
    // buttons of game actions are added to button panel
    private void initializeGameActions() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        frame.add(panel, BorderLayout.PAGE_END);

        LoadGame loadGame = new LoadGame(this, panel);
        gameActions.add(loadGame);

    }

    // EFFECTS: Initializes the graphics that don't change from panel to panel
    private void defaultGraphics() {
        frame.setLayout(new BorderLayout());
        frame.setBackground(BG_COLOR);
        frame.setSize(WIDTH, HEIGHT);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel text = new JLabel("Welcome to The Fortune Game!");
        
        frame.add(text, BorderLayout.PAGE_START);
    }
}
