# LSR_DataCollection

Android app for sensor data collection to be used for the indoor localization project.

Remember to update the AndroidManifest with [your own Google Maps API key](https://developers.google.com/maps/documentation/android-api/signup).

An APK is available in `/app/release/`.

## Data format

The application outputs data in a JSON-like format with one entry per line. All sensors output to the same file. The file is located on the external storage of your phone, under `Android/data/com.ilrepo.displayloc/files/Localization`.

### Sample Outputs

```JSON
{
  "sensorType":"accelerometer",
  "timestamp":1528835210957,
  "data":{
    "xValue":0.3064578175544739,
    "yValue":5.822698593139648,
    "zValue":6.426037311553955,
    "sensorTimestamp":47746742823018
  }
}
```

A sample reading from the accelerometer

```JSON
{
  "sensorType":"magnetometer",
  "timestamp":1528835211192,
  "data":{
    "xValue":-22.5,
    "yValue":-32.52000045776367,
    "zValue":-9.359999656677246,
    "sensorTimestamp":47746785269007
  }
}
```

A sample reading from the magnetometer

```JSON
{
  "sensorType":"wifiAP",
  "timestamp":1526392917389,
  "data":{
    "wifiAPData":[
        {"bssid":"9c:1c:12:24:af:31","level":-54,"channel":11},     
        {"bssid":"9c:1c:12:24:af:39","level":-46,"channel":52}
      ]
  }
}
```

A sample WiFi scan

