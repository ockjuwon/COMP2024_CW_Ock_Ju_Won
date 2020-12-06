# COMP2042_CW_Software_Maintenance
* Submitted in 12-19-2020
* Conducted by Ock Ju Won 20197749

## Environment
The project is conducted under the conditions below:

1. JavaFX 15.0.1
2. JDK 15.0.1
3. Intellij
4. Gradle

## The Frogger game
Based on the given legacy code, the frogger game is refactored to perform many different functions and 10 different level stages. When the user starts the game, it shows up the three different buttons which are: Start, Info, and the Exit. The Info includes the background information and the basic instructions to play the game. The user is available to go back to the main screen scene, and the start button allows the user to start the game.

The first two stages only consisted of Logs and turtles. And the third stage is as same as the ordinary frogger game stage. The next three stages are the speed up versions of the previous stages. Consequently, the four last stages are constructed by editing the speed values of the obstacles object from the stage 3 to make it more complicated.

## The Frogger game - added functions

1. 10 Lives
2. When the frog dies, it deducts 40 scores
3. When the frog proceeds, the user gains 10 scores
4. When the game is over or proceeds to the next stage, pop up shows up.
5. The pop up is showing the highest score and the status of the current stage.

## Refactoring

The Frogger game project is re-packaged under MVC pattern.

The refactored classes have been divided into three different packages which are: Model, View and Controller packages. Including the info class, every level class and the several classes, such as DigitPanel and ScoreBoard, are in the View package. The Controller package includes SceneController class, SceneFileAdder class and ImageProvider class. The rest of the classes are in the Model package.

To fulfil the goal of well sustainability and maintenance, mostly inheritance and several design patterns have been used.

## Refactoring Implementations & Design Patterns

1. Implemented SceneController with Singleton pattern
* To successfully deal with the Level, and children classes of the Level which are Level 1 to 10, and other different classes, the SceneController class has been implemented. If many scenes are added into one pane, then an error occurs. So the hashmap that includes the cache values of each scene class is implemented into the class.

2. Added ScoreBoard, ScoreFileAdder class - Dealing with the scores & Fixed wrong refresh.
* ScoreFileAdder saves the highest score into highscore.txt after each stage is done.

3. Added ImageProvider class with Builder pattern.
* Builder pattern is one of the patterns that is being used popular for creating objects more flexibly and easily visible. The new Image() is being called often, and it is replaced just by using this ImageProvider class to make the code more easily understandable.

4. Make many level classes inherit 'Level' base class using Strategy pattern to achieve abstraction and comfortable code reuse.
* The Level class consisted of many different methods, so the Level 1 to 10 classes are overriding certain methods by using the Strategy pattern. It led the program not to break one of the rules of SOLID, which is OCP, and solve the duplicated methods problem.

5. Added DigitPanel abstract class, which is a view class for the Digit class.

6. Added Focus method in ScoreBoard
* The Focus method changes the object, that the singleton instance variable pointing, to its own object. It makes the instance vary flexibly if the scene is changed.

7. WetTurtle class inherits the turtle class.

8. Level class inherits the World class.
