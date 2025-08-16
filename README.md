# PyContacts

A simple, cross-platform contact management application built with **Kotlin Multiplatform** and **Compose Multiplatform**.

![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20iOS%20%7C%20Desktop%20%7C%20Web-blue)

## ✨ Features
- **Shared Code:** A single codebase for business logic and UI across all platforms.
- **Modern UI:** Built with Jetpack Compose and Compose Multiplatform for a declarative and modern user interface.
- **Native Performance:** Targets Android, iOS (via Kotlin/Native), Desktop (via JVM), and Web (via WebAssembly).

---

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **JDK 17 or newer:** A full JDK is required for creating desktop packages. The one bundled with Android Studio is not sufficient.
  - We recommend [**Azul Zulu OpenJDK**](https://www.azul.com/downloads/?version=java-17-lts&os=windows&architecture=x86-64-bit&package=jdk#zulu).
1. **Android Studio:** The latest stable version.
2. **Xcode:** Required for running and building the iOS application.
3. **(Windows Only) WiX Toolset:** Required for building `.msi` installers for the desktop app. Download from the [WiX Toolset website](https://wixtoolset.org/releases/).

---

## 🚀 Running the App (Development)

You can run the application on each platform for development and testing.

### 📱 Android
1.  Open the project in Android Studio.
2.  Select the `composeApp` run configuration.
3.  Choose a target emulator or a physical device.
4.  Click the green 'Run' button (▶).

### 🖥️ Desktop (JVM)
Run the following command in the terminal to launch the desktop application:

### 🌐 Web (Wasm)
To run the web version in development mode with hot-reload:

This will start a local server. Open the URL provided in the terminal (usually `http://localhost:8080`) in your browser.

### 🍏 iOS
1.  Open the project in Android Studio.
2.  Select the `iosApp` run configuration.
3.  Choose a target iOS Simulator.
4.  Click the 'Run' button (▶).

---

## 📦 Building for Production

Here’s how to create distributable packages for each platform.

### 📱 Android (APK / AAB)
Use Android Studio's built-in tools to generate a signed release build.
1.  Go to **Build > Generate Signed Bundle / APK...**.
2.  Follow the on-screen instructions to create an **Android App Bundle (`.aab`)** (recommended) or an **APK (`.apk`)**.
3.  The output files will be located in `composeApp/build/outputs/`.

### 🖥️ Desktop (Native Installers)
Native installers bundle the JRE, so users don't need to install Java.

- **Windows (.msi):**

**Output Location:** The generated installers can be found in `composeApp/build/compose/binaries/main/dist/`.

### 🌐 Web (Static Files)
This command builds an optimized, production-ready set of files for your website../gradlew :composeApp:wasmJsBrowserDistribution**Output Location:** Upload the **entire contents** of the `composeApp/build/dist/wasmJs/productionExecutable/` directory to your static web hosting provider.

### 🍏 iOS
Building a release version for the App Store is done through **Xcode**.
1.  Open the `iosApp` directory in Xcode.
2.  Select a real device as the target.
3.  Use Xcode's "Product > Archive" feature to create and distribute the app.

---

## 📂 Project Structure

- **`./composeApp`**: The shared Kotlin Multiplatform module containing common logic and Compose UI.
  - `src/commonMain`: Code shared across all platforms (Android, iOS, Desktop, Web).
  - `src/androidMain`: Android-specific code and resources.
  - `src/jvmMain`: Desktop-specific code.
  - `src/iosMain`: iOS-specific code and interoperability.
  - `src/jsMain`: Web-specific code.
- **`./iosApp`**: The Xcode project for the iOS application entry point.

---

## ⚠️ Common Issues & Fixes

### ❌ Error: `Failed to check JDK distribution: 'jpackage.exe' is missing`
This error occurs when building the desktop app because Gradle is using the Java runtime bundled with Android Studio, which lacks the `jpackage` tool needed for creating native installers.

#### ✅ Fix: Set a Full JDK for Gradle
1.  **Install a full JDK** (like [Azul Zulu JDK 17+](https://www.azul.com/downloads/)).
2.  Open the `gradle.properties` file in the root of your project.
3.  Add the following line, replacing the path with the location of your installed JDK: