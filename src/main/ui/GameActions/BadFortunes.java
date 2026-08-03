package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class BadFortunes extends GameAction {
    public BadFortunes(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Bad Fortunes");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new GoodFortunesActionClickHandler());
    }

    private class GoodFortunesActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doSeeBadFortunes();
        }
    }
}
