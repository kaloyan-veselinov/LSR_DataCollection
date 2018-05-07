package com.locsysrepo.components;

import com.google.android.gms.maps.model.LatLng;
import com.locsysrepo.utils.JSONEncoder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by valentin
 */

public class Location {
    public static final byte SOURCE_USER_INPUT = 1;
    public static final byte SOURCE_PDR_ESTIMATION = 2;
//    public static final byte SOURCE_WIFI_ESTIMATION = 3;
    public static final byte SOURCE_PDR_WIFI_ESTIMATION = 4;
//    public static final byte SOURCE_CLOUD_PROVIDED = 5;


    /**
     * coordinate representation of the position using Point3D
     */
    private Point3D point;

    private double certainty = 1.0;
    private double accuracyRange = 0;	// in meters
    private byte source;
    private long timestamp;				// timestamp when user was at position

    public Location(Point3D point, long timestamp, byte source) {
        this.point = point;
        this.timestamp = timestamp;
        this.source = source;
    }

    public Point3D getPoint() {
        return this.point;
    }
    public LatLng getLatLng() { return new LatLng(point.getLat(), point.getLng()); }

    public void setCertainty(double certainty) {
        this.certainty = certainty;
    }
    public double getCertainty() {
        return this.certainty;
    }

    public void setRange(double range) {
        this.accuracyRange = range;
    }
    public double getRange() {
        return this.accuracyRange;
    }

    public void setSource(byte source) {
        this.source = source;
    }
    public byte getSource() {
        return source;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

	public String toString() {
        return toJSON().toString();
    }

    private JSONObject toJSON() {
        JSONObject data = new JSONObject();
        try {
            data.put("latitude", point.getLat());
            data.put("longitude", point.getLng());
            data.put("source", source);
            data.put("certainty", certainty);
            data.put("accuracyRange", accuracyRange);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONEncoder jsonEncoder = new JSONEncoder("GPS", timestamp);
        return jsonEncoder.toJSON(data);
    }
}
