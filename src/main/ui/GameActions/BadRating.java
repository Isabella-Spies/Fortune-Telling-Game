package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;
import model.Fortune;


public class BadRating extends GameAction {

    private Fortune fortune;
    public BadRating(FortuneGameApp fortuneGame, JComponent parent, Fortune fortune) {
        super(fortuneGame, parent);
        this.fortune = fortune;
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new BadRatingClickHandler(this.fortune));
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Bad");
        
    }

    private class BadRatingClickHandler implements ActionListener {

        Fortune fortune;
        public BadRatingClickHandler(Fortune fortune) {
            super();
            this.fortune = fortune;
        }
        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.giveBadRating(fortune);
        }
    }
    
}
