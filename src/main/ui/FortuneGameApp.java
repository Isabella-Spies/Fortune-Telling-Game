package ui;
import model.Fortune;
import model.FortuneLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.GameActions.GameAction;

import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
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
        intitializeButtons();
    }

    private void initializeFortuneArea() {
        fortuneLogPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.add(fortuneLogPanel, BorderLayout.CENTER);
        fortuneLogPanel.add(fortuneScrollPane);
        updateFortuneArea();
    }

    private void updateFortuneArea() {
        fortuneScrollPane = initializeFortuneZone(fortuneScrollPane);
    }

    private void intitializeButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG_COLOR);
        panel.setSize(50, 50);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    private JScrollPane initializeFortuneZone(JScrollPane scrollPane) {
        for (Fortune fortune: fortuneLog.getFortuneList()) {
            JPanel panel = initializeFortune(fortune);
            scrollPane.add(panel);
        }
        return scrollPane;
    }

    private JPanel initializeFortune(Fortune fortune) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEtchedBorder(0));

        JLabel topicLabel = new JLabel(fortune.getTopic());
        JLabel resultLabel = new JLabel(fortune.getResult());
        panel.add(topicLabel);
        panel.add(resultLabel);

        return panel;
    }


    // EFFECTS: Initialize the main menu
    private void initializeMainMenu() {

    }

    // EFFECTS: Updates fortune log panel based on command
    private void updateFortuneLogPanel(String command) {

    }

    // EFFECTS: Facilitates adding a fortune
    private void doAddFortune() {

    }

    private void doRemoveFortune() {

    }

    private void doSaveGame() {

    }

    private void doLoadGame() {

    }

    private void doQuitGame() {

    }

    // Adds avalible actions to the list of game actions
    // buttons of game actions are added to button panel
    private void initializeGameActions() {

    }

    // EFFECTS: Initializes the graphics that don't change from panel to panel
    private void defaultGraphics() {
        frame.setLayout(new BorderLayout());
        frame.setBackground(BG_COLOR);
        frame.setSize(WIDTH, HEIGHT);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel text = new JLabel("Welcome to The Fortune Game!");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(text, BorderLayout.PAGE_START);
    }
}
