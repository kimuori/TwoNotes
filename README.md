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
* User

#### _.com.example.twonotes_ Package:
`Main` class is the main program to run the TwoNotes UI.

`MainController` class accompanies the aforementioned class. This has the button listeners whenever the end-user interacts with the program.

#### _Notes_ Package:
`Note` class has a constructor to build a note and has three instance variables, this accounts for one class that can be instantiated by the keyword new.

`NoteFolder` class works as a collection class for the note class. This class will instantiate a new arraylist that serves a collection for notes.

`Organizable` class works as the interface that is implemented by the note and notefolder class. This class will serve as a place where we can create more methods that needs to be implemented by the notes and the note folders classes.

#### _User_ Package:
`Admin` class serves to have more access to data compared to the customer. We plan to implement a database. The difference between customer and admin will be the amount of access to the database with the admin obviously having more access. This class can also be instantiated with the word new.

`Customer` class serves as our main, average user class. This class can also be instantiated by the word new.

`User` class serves as our abstract class that can instantiate an new user. A new user needs to have certain information given that both an admin and customer will need. This data will be stored within our database. This class also holds getter/setters that will be needed in our code going forward, especially needed for the implementation of our database.


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



