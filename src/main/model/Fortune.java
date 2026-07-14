package model;

// Represents a fortune that has a topic, type, result, and rating
public class Fortune {
    private String topic;
    // a type where 0 means coin flip, 1 means card draw
    private int type;
    private String result;
    private boolean rating;

    // 
    // REQUIRES: topic has a non zero length
    //           type must be >= 0
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
 
    public Fortune(String topic, int type) {
        // stub
    }

    // Do I need a requires for this?
    // MODIFIES: this
    // EFFECTS: rolls and returns a random fortune
    //          picks between 0 and 1 for heads or tails
    //          picks three numbers between 0 and 21 with no repeating numbers
    public void rollFortune(){
        // stub
    }

    public String getTopic(){
        // stub
        return null;
    }

    public int getType(){
        // stub
        return -1;
    }

    public String getResult(){
        // stub
        return null;
    }

    public boolean getRating(){
        // stub
        return false;
    }

    public void setRating(boolean rating){
        // stub
    }

    public void setResult(String result){
        // stub
    }

}
