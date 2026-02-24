# WalkieTalkie (Nearby Connections)

Streaming audio and photo share between two devices via [Nearby Connections](https://developers.google.com/nearby/connections/overview). Use the Automatic build variant; when connected, hold volume keys to talk or tap Share to send a photo.

## Environment

- JDK 17
- Android SDK (platform 33, build-tools)

## Run

1. Set JDK 17: `export JAVA_HOME=$(/usr/libexec/java_home -v 17)` (or your JDK 17 path).

2. Set SDK: add `local.properties` with `sdk.dir=/path/to/Android/Sdk`, or set `ANDROID_HOME`. If needed, run `./setup_android_sdk.sh`.

3. Build: `./gradlew assembleAutomaticDebug`. APK: `app/build/outputs/apk/automatic/debug/app-automatic-debug.apk`.

4. Install the APK on two devices (or device + emulator with Google Play). Open app on both, wait for "Connected". Volume keys = talk; Share = send photo.

