package persistence;

import model.Fortune;
import model.FortuneLog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a JSON Reader that reads a JSON representation of FortuneLog
// Made with help from the JSON Serialization Demo Project
public class JsonReader {

    // MODIFIES: this
    // EFFECTS: creates a JSON Reader that reads from given file
    public JsonReader(String file) {
        // stub
    }

    // EFFECTS: reads and returns a fortune log from file
    // Will throw an IOException if a data read error occurs
    public FortuneLog read() throws IOException {
        return null; // stub
    }

    

    
}
