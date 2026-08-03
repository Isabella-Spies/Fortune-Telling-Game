package ui.GameActions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import ui.FortuneGameApp;

public class SaveGame extends GameAction{

    public SaveGame(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Save Game");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new SaveGameActionClickHandler());

    }

    private class SaveGameActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doSaveGame();
        }
    }
    
}
