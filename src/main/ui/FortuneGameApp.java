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
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

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
        fortuneScrollPane = new JScrollPane(fortuneLogPanel);
        runFortuneGame();
    }

    // Starts the app
    private void runFortuneGame() {
        initializeStartingVeiw();
    }

    // EFFECTS: initializes the starting panel
    // See Diagram for button config
    private void initializeStartingVeiw() {
        defaultGraphics();
        initializeFortuneArea();
        initializeGameActions();
        frame.revalidate();
    }

    private void initializeFortuneArea() {
        fortuneScrollPane.setPreferredSize(new Dimension(0, 0));
        fortuneScrollPane.setBorder(new LineBorder(Color.black));
        frame.add(fortuneScrollPane, BorderLayout.CENTER);
        fortuneLogPanel.setLayout(new BoxLayout(fortuneLogPanel, BoxLayout.Y_AXIS));

        initializeFortunes(fortuneLogPanel);
    }

    // REQUIRES: parentPanel == FortuneLogPanel
    // MODIFIES: this
    // EFFECTS: creates the panels for the fortunes and adds them to the scrollPane
    private void initializeFortunes(JPanel parentPanel) {
        parentPanel.removeAll();

        for (Fortune fortune : fortuneLog.getFortuneList()) {
            initializeFortune(fortune, parentPanel);
            System.out.println(fortune.getTopic());
        }
    }

    private void initializeFortune(Fortune fortune, JPanel parentPanel) {
        JPanel fortunePanel = new JPanel();
        fortunePanel.setLayout(new BoxLayout(fortunePanel, BoxLayout.Y_AXIS));
        //fortunePanel.setPreferredSize(new Dimension(500, 5));
        fortunePanel.setBorder(new EtchedBorder());

        //String topicString = fortune.getTopic();
        //String resultString = fortune.getResult();
        JLabel topic = new JLabel("Hello");
        JLabel result = new JLabel("World");
        fortunePanel.add(topic);
        fortunePanel.add(result);
        parentPanel.add(fortunePanel);
        parentPanel.revalidate();
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
            initializeFortunes(fortuneLogPanel);
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
        panel.setAlignmentY(SwingConstants.SOUTH);

        LoadGame loadGame = new LoadGame(this, panel);
        gameActions.add(loadGame);

    }

    // EFFECTS: Initializes the graphics that don't change from panel to panel
    private void defaultGraphics() {
        frame.setLayout(new BorderLayout());
        frame.setBackground(BG_COLOR);
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
