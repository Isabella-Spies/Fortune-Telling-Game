package persistence;
import model.FortuneLog;
import org.json.JSONObject;

import java.io.FileNotFoundException;

import org.json.*;

// Represents a JSON Writer that writes a representation of FortuneList to JSON
// built with help from the JSON Serialization Demo
public class JsonWriter {
    
    // EFFECTS: contructs a writer to write to the given destination file
    public JsonWriter(String destination) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throw FileNotFoundException if the given file can
    // not be opened for writing
    public void open() throws FileNotFoundException {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: write a JSON representation of Fortune log to the file
    public void write(FortuneLog fortuneLog) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        // stub
    }
}
