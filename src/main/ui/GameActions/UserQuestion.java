package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class UserQuestion extends GameAction{

    private JTextField myField;
    private UserQuestionActionClickHandler listener;

    public UserQuestion(FortuneGameApp fortuneGame, JComponent parent) {
        super(fortuneGame, parent);
    }

    @Override
    protected void addToParent(JComponent parent) {
        myField = new JTextField();
        parent.add(myField);
        parent.add(button);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Submit");
    }

    @Override
    protected void addListenter() {
        listener = new UserQuestionActionClickHandler();
        button.addActionListener(listener);
    }

    private class UserQuestionActionClickHandler implements ActionListener {

        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            String topic = myField.getText().trim();
            fortuneGame.doShowResult(topic);
        }
    }
    
    
}
