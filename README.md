# 📰 Blog App (Vrid Internship Assignment)

This is a **blog reading app** built using **Kotlin and Jetpack Compose**, as part of the **Vrid Internship Assignment**. The app fetches blog posts from an API, displays them in a list, and allows users to read full blog articles in a **WebView**.

---

##  Features  

###  Core Features
-  **MVVM Architecture** - Ensures a clean and maintainable code structure.
-  **Jetpack Compose UI** - Modern, declarative UI with Compose.
-  **List of Blogs** - Fetches blog posts from API and displays them in a scrollable list.
-  **WebView Support** - Opens full blog posts inside the app.
-  **Navigation Component** - Manages smooth transitions between screens.

###  Additional Features
-  **Pagination (Infinite Scrolling)** - Automatically loads more blogs as the user scrolls.
-  **Offline Caching (SQLite - Room)** - Blogs are stored locally and accessible offline.
-  **Efficient Data Loading** - Uses `Flow` and `StateFlow` for optimized performance.
-  **Image Handling with Coil** - Loads blog images efficiently from URLs.
- **Offline Support** - Cached blogs are shown when there’s no internet.

---

## Screenshots  

| Blog List Screen | Blog Detail Screen |
|-----------------|------------------|
| *(Upload Screenshot Here)* | *(Upload Screenshot Here)* |




---

## Tech Stack  

| **Technology** | **Usage** |
|---------------|----------|
| **Kotlin** | Main programming language |
| **Jetpack Compose** | UI framework |
| **MVVM** | Architecture pattern (ViewModel, Repository) |
| **Retrofit** | API calls |
| **Room Database** | Local caching |
| **Hilt** | Dependency Injection |
| **Coil** | Image loading |
| **Navigation Component** | Handles screen navigation |

---

