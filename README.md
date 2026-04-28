# Recipes fot You App (Vol. 2) - Fragment Edition 

This is an advanced version of the Cooking Recipes application, focusing on modern Android Architecture components like Fragments and adaptive layouts.

## Advanced Features
* **Fragment-Based Architecture:** Uses a single-activity, multiple-fragment approach for better performance and modularity.
* **Adaptive Master-Detail Flow:** * **Portrait:** Dynamic navigation between Category, List, and Details fragments using the Fragment Manager.
    * **Landscape (Multi-Pane):** Displays up to 3 fragments simultaneously (Categories, Recipe List, and Details) for a tablet-like experience.
* **Robust State Management:** Implements `onSaveInstanceState` to retain the user's selection (category and specific recipe) across screen rotations.
* **UX Optimization:** Merged the Welcome and Guest access flows into a single, high-conversion entry screen.
* **Responsive UI:** Dedicated `layout-land` resource files to optimize image scaling and button placement on horizontal screens.

## Technical Implementation
* **Communication:** Inter-fragment communication via Activity casting and method calls.
* **Backstack Handling:** Manual management of the Fragment backstack to ensure the system "Back" button works intuitively.
* **Layouts:** Extensive use of `LinearLayout` weights and `ScrollView` for seamless content flow.

## Adaptive UI Preview
* **Mobile (Portrait):** Smooth transitions with Backstack support.
* **Landscape:** Side-by-side view for quick browsing.

---
*Developed as an advanced project to demonstrate Android Layout Qualifiers and Fragment Lifecycle.*
