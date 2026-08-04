package ui.gameactions;

import javax.swing.JButton;
import javax.swing.JComponent;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

// button that give a fortune result a bad rating
@ExcludeFromJacocoGeneratedReport
public class BadRating extends GameAction {


    public BadRating(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new BadRatingClickHandler());
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Bad");
        
    }

    private class BadRatingClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.giveBadRating();
        }
    }
    
}
