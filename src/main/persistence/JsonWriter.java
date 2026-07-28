package persistence;

import model.FortuneLog;
import org.json.JSONObject;

import java.io.*;

import org.json.*;

// Represents a JSON Writer that writes a representation of FortuneList to JSON
// built with help from the JSON Serialization Demo
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;
    
    // EFFECTS: contructs a writer to write to the given destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throw FileNotFoundException if the given file can
    // not be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: write a JSON representation of Fortune log to the file
    public void write(FortuneLog fortuneLog) {
        JSONObject json = fortuneLog.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
