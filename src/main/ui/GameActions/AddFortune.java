package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class AddFortune extends GameAction {

    public AddFortune(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add Fortune");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new AddFortuneClickHandler());
    }

    private class AddFortuneClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            fortuneGame.doAddFortune();
        }
    }
    
}
