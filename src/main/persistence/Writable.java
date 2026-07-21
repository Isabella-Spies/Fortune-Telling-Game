package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as a JSON Object
    // From JSON Serialization Demo
    JSONObject toJson();
}
