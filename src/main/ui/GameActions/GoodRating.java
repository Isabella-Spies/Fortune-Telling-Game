package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;


public class GoodRating extends GameAction {

    public GoodRating(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new GoodRatingClickHandler());
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Good");
    }

    private class GoodRatingClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.giveGoodRating();
        }
    }
}
