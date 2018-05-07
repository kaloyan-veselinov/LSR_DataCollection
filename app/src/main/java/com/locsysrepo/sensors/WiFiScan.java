package com.locsysrepo.sensors;

import android.net.wifi.ScanResult;
import android.support.annotation.NonNull;

import com.locsysrepo.android.R;
import com.locsysrepo.utils.WiFiChannel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by valentin
 */

public class WiFiScan {

    class WiFiRecord {
        String bssid;
        int signal;
        int channel;

        WiFiRecord(String bssid, int signal, int channel) {
            this.bssid = bssid;
            this.signal = signal;
            this.channel = channel;
        }

        JSONObject toJSON() {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("bssid", bssid);
                jsonObject.put("level", signal);
                jsonObject.put("channel", channel);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }

    private List<ScanResult> results;
    private long timestamp;

    WiFiScan(List<ScanResult> results) {
        this.results = new ArrayList<>(results);
        this.timestamp = System.currentTimeMillis();
    }

    public String toString() {
        return toJSON().toString();
    }

    JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("sensorType", "wifiAP");
            jsonObject.put("timestamp", timestamp);
            for (ScanResult scanResult : results) {
                WiFiRecord wiFiRecord = new WiFiRecord(scanResult.BSSID, scanResult.level, WiFiChannel.getChannel(scanResult.frequency));
                jsonArray.put(wiFiRecord.toJSON());
            }
            jsonObject.put("wifiAPData", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}