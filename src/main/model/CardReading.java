package model;

import java.util.ArrayList;

public class CardReading extends Fortune {

    private static ArrayList<String> cardNames;

    // REQUIRES: topic has a non zero length
    // MODIFIES: this
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
    public CardReading(String topic) {
        super(topic);
        //TODO Auto-generated constructor stub
    }

    // REQUIRES: topic and result has non zero length
    // MODIFIES: this
    // EFFECTS: Constructor to be used by Reader when initializing
    // from JSON data.
    // given parameters are set to their corresponding fields
    public CardReading(String topic, String result, boolean rating) {
        super(topic,result,rating);
        initializeCardValues();
    }

    // MODIFIES: this
    // EFFECTS: rolls and sets result to the names of 3 major arcana cards
    public void rollFortune() {
        // stub
    }

    // REQUIRES: flip >= 0
    // MODIFIES: this
    // EFFECTS: Interprets given flip into card name
    public String interpretFortune(int flip) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: Initializes cardNames to be used
    private void initializeCardValues() {
        cardNames.add("The Fool");
        cardNames.add("The Magician");
    }

    // MODIFIES: this
    // EFFECTS: gets cardValues
    public ArrayList<String> getCardValues() {
        return null;
    }
    
}
