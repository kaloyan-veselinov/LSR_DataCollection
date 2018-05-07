package com.locsysrepo.sensors;

public interface OnSensorDataCallback {
    void onSensorSample(SensorReading sample);
}