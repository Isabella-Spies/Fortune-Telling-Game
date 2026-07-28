package persistence;

import org.json.JSONObject;

// representation of an object that can be converted to JSON data to be written to file
public interface Writable {
    // EFFECTS: returns this as a JSON Object
    // From JSON Serialization Demo
    JSONObject toJson();
}
