# TwoNotes Program
**Authors:** Mohamed Albatushi, Madeline Imhoff, Jet Lao, Jemina Maasin, and Collin Skogen

## About TwoNotes
TwoNotes is an application for users to create, open, or delete folders or text files, and users can overwrite existing text files.

## Functional and Non-Functional
### 6 Functional Requirements
1. <u>**Open a text:**</u> User can open up an existing text file in their local directory.
2. <u>**Add a new folder:**</u> User can create a new folder within their local directory. 
3. <u>**Add a new note:**</u> User can create a new note within their local directory.
4. <u>**Delete existing folder:**</u> User can delete an existing folder in their directory. This will also delete the notes inside the UI.
   * NOTE: although this functionality handles exceptions, deleting files does not work currently.
5. <u>**Delete existing note:**</u> User can delete and existing note existing inside a folder in their directory.
6. <u>**Save existing note:**</u> User can save any added writes into an existing note.

### 4 Non-Functional Requirements
1. <u>**Data Retention:**</u> Retains data in the user's local directory.
2. <u>**Flexibility:**</u> For example, we have implemented an Interface that can be flexible to implement both NoteFolder.java and Note.java.
3. <u>**Stability:**</u> The application will remain constant and handle any exceptions to prevent from crashing.
4. <u>**Resilience:**</u> Any writes, reads, or deletion from the user will not cause the application to crash.

#### Interface Class:
* Organizable

#### Abstract Class:
* NoteAbstract

#### _.com.example.twonotes_ Package:
`Main` class is the main program to run the TwoNotes GUI.

`MainController` class accompanies the aforementioned class. This has the button listeners whenever the end-user interacts with the program.

#### _Notes_ Package:
`Note` class has a constructor to build a note and has three instance variables, this accounts for one class that can be instantiated by the keyword new.

`NoteFolder` class works as a collection class for the note class. This class will instantiate a new arraylist that serves a collection for notes.

`NoteAbstract` is an abstract class that has a concrete attribute to implement the Note class.

`Organizable` class works as the interface that is implemented by the Note and NoteFolder class. This class will serve as a place where we can create more methods that needs to be implemented by the notes and the note folders classes.


## Installation
To run the application, this guide will set up you configuration for IntelliJ.

Go to "File" > "Settings" > "Build, Execution, Deployment" > "Build Tools" > 
"Gradle" under "Gradle Projects", click on the pane on the right near the bottom 
there is a dropdown menu labeled "Gradle JVM". Click on the dropdown,
then on "+ Add SDK" -> "Download JDK". In the new popup select 17 for version and then for version select
"Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4". If you have a Mac with Apple Silicon select
"Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4 aarch64".

This project uses Gradle through "Gradle Wrapper". This project requires JDK of version 17.

In `build.gradle`, ensure that the javafx version is `20.0.1`. If not, change it from `17.0.6` to `20.0.1`.

**Run the TwoNotes program on the Main.java class.**

## References
Documentation and references used for this project.
1. [Oracle JavaFX UI FileChooser ](https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm)
   1. [JavaFX stage FileChooser](http://www.java2s.com/example/java-api/javafx/stage/filechooser/filechooser-0-1.html)
   2. [JavaFX FileChooser (Jenkov)](https://jenkov.com/tutorials/javafx/filechooser.html)
2. [Oracle JavaFX UI List View](https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/list-view.htm)
3. [Oracle setDisable a property](https://docs.oracle.com/javafx/2/api/javafx/scene/Node.html#setDisable(boolean))
4. [Get TextArea content and line breaks](https://stackoverflow.com/questions/41664796/how-to-get-text-from-textarea-in-javafx-saving-line-breaks)
5. [Text Editor (EdenCoding)](https://edencoding.com/how-to-open-edit-sync-and-save-a-text-file-in-javafx/)
6. [Oracle deleting a file](https://docs.oracle.com/javase/tutorial/essential/io/delete.html)