# Two Notes Program 
#### By Mohamed Albatushi, Madeline Imhoff, Jet Lao, Jemina Maasin, and Collin Skogen

### Installation Instructions
This project uses Gradle through "Gradle Wrapper". This project requires JDK of version 17.

Go to "File" > "Settings" > "Build, Execution, Deployment" > "Build Tools" > "Gradle" under "Gradle Projects", 
click on the pane on the right near the bottom there is a dropdown menu labeled "Gradle JVM". Click on the dropdown, 
then on "+ Add SDK" -> "Download JDK". In the new popup select 17 for version and then for version select 
"Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4". If you have a Mac with Apple Silicon select 
"Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4 aarch64".

Then in build.gradle, ensure that the javafx version is '20.0.1'. If not, change it from '17.0.6' to '20.0.1'.


### Current Problems:
The project may show up "WARNING: Loading FXML document with JavaFX API of version 
20.0.1 by JavaFX runtime of version 17.0.6" on other people's systems.

### Miscellaneous notes:
This program references from YouTube channels such as:
* tookootek
    1. https://youtu.be/Ll2n9tGlCv0?si=gmE0SL-6qXmoEPww
    2. https://youtu.be/J0IE5LRyzx8?si=JGegmksUp0VqhpSv