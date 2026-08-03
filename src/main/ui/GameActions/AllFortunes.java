package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class AllFortunes extends GameAction {
    public AllFortunes(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("All Fortunes");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new GoodFortunesActionClickHandler());
    }

    private class GoodFortunesActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doSeeAllFortunes();
        }
    }
    
}
