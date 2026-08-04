package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class CardReadingChoice extends GameAction {

    public CardReadingChoice(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Card Reading");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new CardReadingClickHandler());
    }

    private class CardReadingClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doAskQuestion("Card Reading");
        }
    }
    
}
