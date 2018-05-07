package com.locsysrepo.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONEncoder {
    private String type;
    private long timestamp;

    public JSONEncoder(String type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public JSONObject toJSON(JSONObject data) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("sensorType", type);
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
