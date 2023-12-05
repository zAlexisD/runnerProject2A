# Run baby, run !

2nd Year Project - Java Runner

## Description
This project was undertaken as part of the second-year curriculum at ENSEA. The main objective was to create a Runner-style game using the Java programming language.

## Features
- **Runner Game:** This project is a simple runner game, where the main objective is to control a character through various obstacles.
- **Character Control:** The current features allow the character to run and jump.

## Improvements

- **Obstacles and Enemies:**
    - (WIP) Obstacles and enemies will be added to increase the game's complexity.

- **Camera and Background:**
    - (WIP) Bug fixes will be applied to the camera to follow the character smoothly or explore the possibility of making the character follow the camera.
    - (WIP) The background will be extended to create an infinite scrolling effect, enhancing the game environment.

- **Character Interaction:**
    - The character will interact with enemies and obstacles, resulting in a loss of life points.

- **Additional Character Controls:**
    - Additional character controls, including crouching, projectiles, and special interactions like dancing or transformation, will be implemented.

- **Menu Interface:**
    - A user-friendly menu interface will be included for a smoother gaming experience.

- **Character Selection:**
    - Users can choose their character from a selection before starting the game.

- **Game Over Animation and Retry:**
    - A game over animation will be managed, allowing players to retry the game after losing.

- **Sound Effects:**
    - Sound effects will be implemented to enhance the overall gaming experience.


## Dependencies
- [OpenJFX JavaFX Controls 16](https://openjfx.io/) - Used for implementing graphical user interface controls.
    - You can download and include the library in your project.
    - Example Maven dependency :
      ```xml
      <dependency>
          <groupId>org.openjfx</groupId>
          <artifactId>javafx-controls</artifactId>
          <version>16</version>
      </dependency>
      ```
    - Make sure to configure your project to use JDK 16.

## Installation
1. Clone this repository:
```bash
git clone https://github.com/zAlexisD/runnerProject2A.git
```
Ensure that you are in the correct directory and that Java is installed on your machine.
2. Compile the source code: 
```bash
javac --module-path /path/to/javafx-sdk-16/lib --add-modules javafx.controls Launcher.java
```
3. Run the game
```bash
java --module-path /path/to/javafx-sdk-16/lib --add-modules javafx.controls Launcher
```
Make sure to replace `/path/to/javafx-sdk-16` with the actual path to your JavaFX SDK 16 installation.

**Note :** You might need to adjust the commands based on your specific project structure and build setup. If you're using an IDE, you can also configure the project settings to include the JavaFX library and set the module path accordingly.


## Screenshots
_coming soon_

## License
This project is licensed under the [MIT License](LICENSE.md).

**Note: This project is an academic exercise and was developed for educational purposes as part of the curriculum at ENSEA.**