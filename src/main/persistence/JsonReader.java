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

    private String file;

    // MODIFIES: this
    // EFFECTS: creates a JSON Reader that reads from given file
    public JsonReader(String file) {
        this.file = file;
    }

    // EFFECTS: reads and returns a fortune log from file
    // Will throw an IOException if a data read error occurs
    public FortuneLog read() throws IOException {
        String jsonData = readFile(file);
        JSONObject jsonObject= new JSONObject(jsonData);
        return parseFortuneLog(jsonObject); // stub
    }

    // EFFECTS: reads source file as string and returns it
    // from JSON Serilization Demo
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: Parses FortuneLOG from JSONObject and retuns it
    private FortuneLog parseFortuneLog(JSONObject jsonObject) {
        FortuneLog fortuneLog = new FortuneLog();
        addFortunes(fortuneLog, jsonObject);
        return fortuneLog;
    }

    // MODIFIES: fortuneLog
    // EFFECTS: parses Fortunes from JSONObject and adds them to FortuneLog
    private void addFortunes(FortuneLog fortuneLog, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("fortuneList");
        for (Object json : jsonArray) {
            JSONObject nextFortune = (JSONObject) json;
            addFortune(fortuneLog, nextFortune);
        }
    }

    // EFFETS: gets Fortune from JSONObject and adds it to FortuneList
    private void addFortune(FortuneLog fortuneLog, JSONObject jsonObject) {
        String topic = jsonObject.getString("topic");
        String result = jsonObject.getString("result");
        boolean rating = jsonObject.getBoolean("rating");
        Fortune newFortune = new Fortune(topic, result, rating);

        fortuneLog.addFortune(newFortune);
    }



    

    
}
