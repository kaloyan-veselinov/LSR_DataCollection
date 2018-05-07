# LSR_DataCollection

Android app for sensor data collection to be used for the indoor localization project.

Remember to update the AndroidManifest with [your own Google Maps API key](https://developers.google.com/maps/documentation/android-api/signup).

A signed APK is available in `/app/release/`.

The application outputs data in a JSON-like format with one entry per line. All sensors output to the same file. The file is located on the external storage of your phone, under `/Localization`.

