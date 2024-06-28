# Notes App

A simple and efficient notes application built using Android's Room persistence library and the MVVM architectural pattern.

## Table of Contents
- Features
- Installation
- Usage
- Screenshots
- Architecture
- Dependencies
- FAQ

## Features
- Add, edit, and delete notes
- View notes in a list
- Search through notes
- Persist notes locally using Room database
- MVVM architecture for separation of concerns

## Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/notes-app.git
    ```
2. **Navigate to the project directory:**
    ```sh
    cd notes-app
    ```
3. **Open the project in Android Studio.**
4. **Build and run the project on your Android device or emulator.**

## Usage
1. **Add a Note:**
    - Click on the "+" button.
    - Enter the note details and click "Check Icon".

2. **Edit a Note:**
    - Click on an existing note from the list.
    - Modify the details and click "Check Icon".

3. **Delete a Note:**
    - Click on an existing note from the list.
    - Click the "Delete Icon" to delete.

4. **Search Notes:**
    - Use the search bar at the top to find notes by their content.

## Screenshots
<div style="display: flex; justify-content: space-between; margin-bottom: 20px;">
    <img src="https://i.postimg.cc/qM74wbpk/Screenshot-20240628-144251.png" alt="Screenshot 1" style="width: 25%; margin-right: 2%;" />
    <img src="https://i.postimg.cc/bwhXMmhD/Screenshot-20240628-144537.png" alt="Screenshot 2" style="width: 25%;" />
  <img src="https://i.postimg.cc/4dKFncGR/Screenshot-20240628-144349.png" alt="Screenshot 2" style="width: 25%;" />
</div>

## Download APK
You can download the APK from the links below:
[Download the App](https://github.com/faysalabir779/MyNotesMVVM/releases/download/1.1/Notes.apk)

## Architecture
The app follows the MVVM (Model-View-ViewModel) architecture, which ensures a clear separation of concerns, making the app easier to maintain and test.

- **Model:**
    - Represents the data layer of the app. Uses Room for local data persistence.
- **View:**
    - The UI layer that displays the data and interacts with the user.
- **ViewModel:**
    - Acts as a bridge between the Model and View, holding and managing UI-related data in a lifecycle-conscious way.

## Dependencies
- **Room:** For local database management
    ```gradle
    implementation "androidx.room:room-runtime:2.3.0"
    kapt "androidx.room:room-compiler:2.3.0"
    ```
- **Lifecycle:** For ViewModel and LiveData
    ```gradle
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    ```
- **RecyclerView:** For displaying the list of notes
    ```gradle
    implementation 'androidx.recyclerview:recyclerview:1.2.0'
    ```
- **Material Design:** For UI components
    ```gradle
    implementation 'com.google.android.material:material:1.3.0'
    ```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## FAQ
**Q: How do I backup my notes?**
A: Currently, the app does not support automatic backups. You can manually copy the database file from your device.

**Q: Can I use this app on multiple devices?**
A: The current implementation supports local storage only. Synchronization across multiple devices is not supported yet.

**Q: How do I contribute to this project?**
A: Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request.

---

