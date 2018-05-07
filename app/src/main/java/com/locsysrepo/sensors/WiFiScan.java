package com.locsysrepo.sensors;

import android.net.wifi.ScanResult;

import com.locsysrepo.utils.JSONEncoder;
import com.locsysrepo.utils.WiFiChannel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            for (ScanResult scanResult : results) {
                WiFiRecord wiFiRecord = new WiFiRecord(scanResult.BSSID, scanResult.level, WiFiChannel.getChannel(scanResult.frequency));
                jsonArray.put(wiFiRecord.toJSON());
            }
            data.put("wifiAPData", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONEncoder jsonEncoder = new JSONEncoder("wifiAP", timestamp);
        return jsonEncoder.toJSON(data);
    }
}