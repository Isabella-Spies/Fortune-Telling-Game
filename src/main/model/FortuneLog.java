package model;

import java.util.ArrayList;

// Represents a log of previous Fortunes 
public class FortuneLog {
    private ArrayList<Fortune> fortuneList;

    // MODIFIES: this
    // EFFECTS: Creates an empty fortuneList 
    public FortuneLog() {
        fortuneList = new ArrayList<Fortune>();
    }


    // MODIFIES: this
    // EFFECTS: Adds a fortune to the list
    public void addFortune(Fortune fortune) {
        fortuneList.add(fortune);
    }

    // REQUIRES: index >= 0
    // MODIFIES: this
    // EFFECTS: Gives the topic and result of a fortune at the given index
    public String getFortune(int index) {
        return fortuneList.get(index).toString();
    }

    // MODIFIES: this
    // EFFECTS: gives a list of of all fortunes with a good rating
    public ArrayList<Fortune> getGoodFortunes() {
        ArrayList<Fortune> goodFortunes = new ArrayList<>();
        for (Fortune fortune : fortuneList) {
            if (fortune.getRating() == true) {
                goodFortunes.add(fortune);
            }
        }
        return goodFortunes;
    }

    // MODIFIES: this
    // EFFECTS: gives a list of of all fortunes with a bad rating
    public ArrayList<Fortune> getBadFortunes() {
        ArrayList<Fortune> badFortunes = new ArrayList<>();
        for (Fortune fortune : fortuneList) {
            if (fortune.getRating() == false) {
                badFortunes.add(fortune);
            }
        }
        return badFortunes;
    }

    public ArrayList<Fortune> getFortuneList() {
        return fortuneList;
    }
    
}
