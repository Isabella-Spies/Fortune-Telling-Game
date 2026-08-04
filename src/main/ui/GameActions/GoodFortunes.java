package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

// button that shows all good fortunes in the fortune log
@ExcludeFromJacocoGeneratedReport
public class GoodFortunes extends GameAction {

    public GoodFortunes(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Good Fortunes");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new GoodFortunesActionClickHandler());
    }

    private class GoodFortunesActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doSeeGoodFortunes();
        }
    }
    
}
