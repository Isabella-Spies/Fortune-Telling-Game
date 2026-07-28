package model;

import java.util.ArrayList;
import persistence.JsonReader;

// represents a Fortune as a card reading
public class CardReading extends Fortune {

    private static String FILE_PATH = "./data/cardList.json";
    private ArrayList<String> cardNames;
    private JsonReader reader;
    private ArrayList<Integer> resultNums;

    // REQUIRES: topic has a non zero length
    // MODIFIES: this
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
    public CardReading(String topic) {
        super(topic);
        reader = new JsonReader(FILE_PATH);
        resultNums = new ArrayList<Integer>();
        cardNames = reader.readCards();
    
    }

    // REQUIRES: topic and result has non zero length
    // MODIFIES: this
    // EFFECTS: Constructor to be used by Reader when initializing
    // from JSON data.
    // given parameters are set to their corresponding fields
    public CardReading(String topic, String result, boolean rating) {
        super(topic,result,rating);
    }

    // MODIFIES: this
    // EFFECTS: rolls and sets result to the names of 3 major arcana cards
    public void rollFortune() {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            int roll = makeRoll(results);
            results.add(roll);
        }
        this.resultNums = results;
        this.result = interpretResults(results);
    }

    // MODIFIES: this
    // rolls the fortune and re-rolls if it is a duplicate
    public Integer makeRoll(ArrayList<Integer> results) {
        int roll = random.nextInt(22);
        if (results.contains(roll)) {
            return makeRoll(results);
        } else {
            return roll;
        }
    }


    // REQUIRES: results.size() > 0
    // MODIFIES: this
    // EFFECTS: given numerical results, returns concatonated string
    // of corresponding card names
    private String interpretResults(ArrayList<Integer> results) {
        String fortune = interpretFortune(results.get(0));
        for (int i = 1; i < results.size(); i++) {

            fortune += ", " + interpretFortune(results.get(i));
        }
        return fortune;
    }

    // REQUIRES: flip >= 0
    // MODIFIES: this
    // EFFECTS: Interprets given flip into card name
    public String interpretFortune(int flip) {
        return cardNames.get(flip); // stub
    }

    

    // MODIFIES: this
    // EFFECTS: gets cardValues
    public ArrayList<String> getCardNames() {
        return this.cardNames;
    }

    public ArrayList<Integer> getResultNums() {
        return resultNums;
    }
    
}
