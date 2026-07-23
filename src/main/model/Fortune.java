package model;

import java.util.Random;

import org.json.JSONObject;

import persistence.Writable;

// Represents a fortune that has a topic, type, result, and rating
public abstract class Fortune implements Writable{
    protected String topic;
    protected String result;
    protected boolean rating;
    protected Random random = new Random();


    // REQUIRES: topic has a non zero length
    // MODIFIES: this
    // EFFECTS: given topic is set to fortune topic, 
    //          given type is set to fortune type, result is empty
    //          rating starts as false
    public Fortune(String topic) {
        this.topic = topic;
        this.rating = false;
    }

    // REQUIRES: topic and result has non zero length
    // MODIFIES: this
    // EFFECTS: Constructor to be used by Reader when initializing
    // from JSON data.
    // given parameters are set to their corresponding fields
    public Fortune(String topic, String result, boolean rating) {
        this.topic = topic;
        this.result = result;
        this.rating = rating;
    }

    // MODIFIES: this
    // EFFECTS: rolls and returns a random fortunes
    public abstract void rollFortune();

    // REQUIRES: flip >= 0
    // MODIFIES: this
    // EFFECTS: turns the flip result into a fortune
    public abstract String interpretFortune(int flip);

    public String getTopic() {
        // stub
        return topic;
    }

    public String getResult() {
        // stub
        return result;
    }

    public boolean getRating() {
        // stub
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Topic: [" + topic + "] Result: [" + result + "]";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("topic", topic);
        json.put("result", result);
        json.put("rating", rating);
        return json;
    }


}
