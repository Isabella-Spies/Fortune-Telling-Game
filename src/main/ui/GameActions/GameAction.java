package ui.GameActions;

import javax.swing.*;

import ui.FortuneGameApp;

// Representation of a possible user interaction with a button
// Designed with help from SimpleDrawingPlayer
public abstract class GameAction {
    
    protected FortuneGameApp fortuneGame;
    protected JButton button;


    // EFFECTS: Constructs a game action associated with the given game
    // adds its button to the given parent to be used
    public GameAction(FortuneGameApp fortuneGame, JComponent parent) {
        this.fortuneGame = fortuneGame;
        createButton(parent);
        addToParent(parent);
        addListenter();
    }

    // Creates button to add to parent
    protected abstract void createButton(JComponent parent);

    protected abstract void addListenter();

    // Adds button to parent
    protected void addToParent(JComponent parent) {
        parent.add(button);
    }







    
}
