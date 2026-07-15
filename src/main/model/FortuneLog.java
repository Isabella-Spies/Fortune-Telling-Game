package model;

import java.util.ArrayList;
// Represents a log of previous Fortunes 
public class FortuneLog {

    private ArrayList<Fortune> fortuneList;

    // TODO
    // MODIFIES: this
    // EFFECTS: Creates an empty fortuneList 
    public FortuneLog(){
        //stub
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: Adds a fortune to the list
    public void addFortune(Fortune fortune){
        //stub
    }

    // TODO
    // REQUIRES: index >= 0
    // MODIFIES: this
    // EFFECTS: Gives the name of a fortune at the given index
    public String getFortuneName(int index){
        // stub
        return null;
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: gives a list of of all fortunes with a good rating
    public ArrayList<String> getGoodFortunes(){
        return null;
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: gives a list of of all fortunes with a bad rating
    public ArrayList<String> getBadFortunes(){
        return null;
    }
    
}
