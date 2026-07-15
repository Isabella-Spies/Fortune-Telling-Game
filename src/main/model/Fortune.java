package model;

import java.util.Random;

// Represents a fortune that has a topic, type, result, and rating
public class Fortune {
    private String topic;
    private int type;
    private String result;
    private boolean rating;
    private Random random = new Random();


    // REQUIRES: topic has a non zero length
    //           type must be >= 0
    // MODIFIES: this
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
    public Fortune(String topic) {
        this.topic = topic;
        this.type = 0;
        this.rating = false;
    }

    // MODIFIES: this
    // EFFECTS: rolls and returns a random fortune
    //          picks between 0 and 1 for heads or tails
    public void rollFortune(){
        int flip = random.nextInt(2);
        result = interpretFortune(flip);
    }

    // REQUIRES: flip >= 0
    // MODIFIES: this
    // EFFECTS: turns the flip result into a fortune
    public String interpretFortune(int flip){
       if (flip == 1){
            return "Tails";
        } else{
            return "Heads";
        }
    }

    public String getTopic(){
        // stub
        return topic;
    }

    public int getType(){
        // stub
        return type;
    }

    public String getResult(){
        // stub
        return result;
    }

    public boolean getRating(){
        // stub
        return rating;
    }

    public void setRating(boolean rating){
        this.rating = rating;
    }

    public void setResult(String result){
        this.result = result;
    }

    @Override
    public String toString(){
        return "Topic: [" + topic + "] Result: [" + result + "]";
    }

}
