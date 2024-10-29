# Image Loader Application

## Overview
This project showcases an image loader application designed for Android. The app allows users to display images through three different methods: from local resources, from a URL, and from external storage. It offers a simple and intuitive interface.

## Features
- **Local Image Loading**: Users can display images that are included in the project resources.
- **URL Image Loading**: Users can load images directly from a specified URL using the Glide library.
- **External Storage Image Loading**: The app can access and display images stored on the device's external storage, with proper permission handling.

## Development
This project was developed as part of a mobile development course, guided by **[Mr. Nizar](https://github.com/NizarETH)** at **CMC School**.

## Usage
- Tap the **Local** button to display an image from the app's resources.
- Tap the **URL** button to load an image from a specified online URL.
- Tap the **Storage** button to load an image from the device's external storage. The app will request permission if necessary.

## Installation
1. **Open the Project**
   - Open the project in Android Studio.

2. **Add Dependencies**
   Make sure to include Glide in your `build.gradle` (Module: app) file:
   ```groovy
   implementation 'com.github.bumptech.glide:glide:4.12.0'
   annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
   ```

3. **Request Permissions**
   The app requires permission to read external storage. Ensure you have the following permission in your `AndroidManifest.xml`:
   ```xml
   <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
   ```

4. **Run the App**
   - Connect your Android device or start an emulator.
   - Run the app from Android Studio.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments
- [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android.
