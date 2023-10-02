# TwoNotes Program 
By Mohamed Albatushi, Madeline Imhoff, Jet Lao, Jemina Maasin, and Collin Skogen

## Project Milestone 3
The code is structured in an efficient way that will minimize duplicate code. The code has 2 different folders excluding the controller and the main java classes. The main executes the code while the controller acts as a scene controller. There are two different packages based on the design of the program. 

#### Notes Package:
The **note class** has a constructor to build a note and has three instance variables, this accounts for one class that can be instantiated by the keyword new. 

The **note folder class** works as a collection class for the note class. This class will instantiate a new arraylist that serves a collection for notes.   

The **organizable class** works as the interface that is implemented by the note and notefolder class. This class will serve as a place where we can create more methods that needs to be implemented by the notes and the note folders classes.

#### User Package: 
The next package deals with users. This package includes the admin, customer, and user java classes. 

The **admin class** serves as class that will have more access to data compared to the customer. We plan to implement a database. The difference between customer and admin will be the amount of access to the database with the admin obviously having more access. This class can also be instantiated with the word new. 

The **customer class** serves as our main, average user class. This class can also be instantiated by the word new. 

The **user class** serves as our abstract class that can instantiate an new user. A new user needs to have certain information given that both an admin and customer will need. This data will be stored within our database. This class also holds getter/setters that will be needed in our code going forward, especially needed for the implementation of our database. 

### Conclusion:
#### Classes that can be instantiated with the keyword new: 
* Note
* NoteFolder
* Admin
* Customer
* User

#### Interface Class: 
* Organizable

#### Abstract Class: 
* User


## Installation Instructions
To run the application we have a run configuration that you can use in IntelliJ.

To set up the project environment for IntelliJ on your machine, go to "File" > "Settings" > 
"Build, Execution, Deployment" > "Build Tools" > "Gradle" under "Gradle Projects", click on the pane on the right near 
the bottom there is a dropdown menu labeled "Gradle JVM". Click on the dropdown, then on "+ Add SDK" -> "Download JDK". 
In the new popup select 17 for version and then for version select "Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4". 
If you have a Mac with Apple Silicon select "Eclipse Temurin (AdoptOpenJDK HotSpot) 17.0.4 aarch64".

This project uses Gradle through "Gradle Wrapper". This project requires JDK of version 17.
In `build.gradle`, ensure that the javafx version is `20.0.1`. If not, change it from `17.0.6` to `20.0.1`.