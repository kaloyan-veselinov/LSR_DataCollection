package com.locsysrepo.sensors;

import com.locsysrepo.utils.JSONEncoder;

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
        JSONObject data = new JSONObject();
        try {
            data.put("xValue", x);
            data.put("yValue", y);
            data.put("zValue", z);
            data.put("sensorTimestamp", sensor_timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONEncoder jsonEncoder = new JSONEncoder(type.getTag(), timestamp);
        return jsonEncoder.toJSON(data);
    }

    public InertialSensorManager.SensorEnum getType() {
        return type;
    }
}