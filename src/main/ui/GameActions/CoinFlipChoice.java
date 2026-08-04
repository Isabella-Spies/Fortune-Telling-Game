package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class CoinFlipChoice extends GameAction {

    public CoinFlipChoice(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Coin Flip");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new CardReadingClickHandler());
    }

    // CHANGE REST TO CARD READING MAKE NEW CLASS FOR COIN FLIP
    private class CardReadingClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doAskQuestion("Coin Flip");
        }
    }
    
}

