package com.locsysrepo.sensors;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorReading {

    private InertialSensorManager.SensorEnum type;
    private float x, y, z;
    private long timestamp;
    private long sensor_timestamp;


    SensorReading(float x, float y, float z, long time, InertialSensorManager.SensorEnum type, long sensor_timestamp) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.timestamp = time;
        this.type = type;
        this.sensor_timestamp = sensor_timestamp;
    }

    public String toString() {
        return toJSON().toString();
    }

    private JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("sensorType", type.getTag());
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("xValue", x);
            jsonObject.put("yValue", y);
            jsonObject.put("zValue", z);
            jsonObject.put("sensorTimestamp", sensor_timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public InertialSensorManager.SensorEnum getType() {
        return type;
    }
}