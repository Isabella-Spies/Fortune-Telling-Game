package ui.GameActions;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FortuneGameApp;

public class SubmitQuestion extends GameAction {

    JTextField textField;
    String type;
    public SubmitQuestion(FortuneGameApp fortuneGame, JComponent parent, JTextField submitField, String type) {
        super(fortuneGame, parent);
        this.textField = submitField;
        this.type = type;
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Load Game");
    }

    @Override
    protected void addListenter() {
        button.addActionListener(new SubmitQuestionClickHandler(textField, this.type));
    }

    private class SubmitQuestionClickHandler implements ActionListener {

        JTextField field;
        String type;

        public SubmitQuestionClickHandler(JTextField field, String type) {
            super();
            this.field = field;
            this.type = type;

        }
        // Effects: call the load game method in the fortune game app
        @Override
        public void actionPerformed(ActionEvent e) {
            String question = field.getText().trim();
            fortuneGame.doShowResult(question, this.type);
        }
    }
    
}
