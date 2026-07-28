package model;

// represents a fortune as a coin flip
public class CoinFlip extends Fortune {


    // REQUIRES: topic has a non zero length
    // MODIFIES: this
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
    public CoinFlip(String topic) {
        super(topic);
    }


    // REQUIRES: topic and result has non zero length
    // MODIFIES: this
    // EFFECTS: Constructor to be used by Reader when initializing
    // from JSON data.
    // given parameters are set to their corresponding fields
    public CoinFlip(String topic, String result, boolean rating) {
        super(topic,result,rating);
    }
    
    // MODIFIES: this
    // EFFECTS: rolls and returns a random fortunes
    public void rollFortune() {
        int flip = random.nextInt(2);
        result = interpretFortune(flip);
    }

    // REQUIRES: flip >= 0
    // MODIFIES: this
    // EFFECTS: turns the flip result into a fortune
    public String interpretFortune(int flip) {
        if (flip == 1) {
            return "Tails";
        } else {
            return "Heads";
        }
    }
    
}
