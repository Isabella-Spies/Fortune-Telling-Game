package ui.GameActions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.FortuneGameApp;

// A button that loads the save data from JSON file
@ExcludeFromJacocoGeneratedReport
public class LoadGame extends GameAction {

    public LoadGame(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Load Game");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new LoadGameActionClickHandler());
    }

    private class LoadGameActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doLoadGame();
        }
    }

   
}
