# KenKen Craze
A Java-based digital KenKen puzzle game developed as a team project for Computer Science.

## Description
KenKen Craze is a digital numerical logic puzzle game inspired by the original KenKen puzzle, created by Tetsuya Miyamoto in 2004. Players fill numbers into an N×N grid (3×3, 4×4, or 5×5) without repeating numbers in any row or column while satisfying arithmetic conditions in “cages” (addition, subtraction, multiplication, or division).  

The game challenges players’ problem-solving and arithmetic skills and includes multiple difficulty levels, automated puzzle progression, a scoring system and a countdown timer to enhance gameplay. The UI is designed to be user-friendly, responsive and visually appealing.  

## Features
- 3×3, 4×4, and 5×5 puzzle grids
- Easy, Medium, and Hard difficulty levels
- Multiple puzzle levels
- Row and column validation
- Cage arithmetic validation
- Countdown timer
- Scoring system
- Progress tracking
- Interactive graphical user interface
- Puzzle progression between levels
- Custom game background and interface styling

## Technologies
- Java
- Java Swing
- Object-oriented programming
- File I/O for saving game progress and scores

## Requirements
Java JDK 8 or higher

## Running the game
1. Clone the repository:
   git clone https://github.com/angelSM19/kenken-puzzle-game.git

2. Navigate to the project folder:
   cd kenken_game

3. Compile the project:
   javac MainApp.java game/core/*.java game/data/*.java game/ui/*.java

4. Run the main application:
   java MainApp

# How to play
1. Launch the game using MainApp.
2. Select a difficulty level: Easy, Medium, Hard
3. Select a puzzle level.
4. Fill the grid with numbers according to the KenKen rules.
5. Complete each cage according to its target and arithmetic operation.
6. Complete the puzzle before the timer expires.
7. Continue progressing through available levels and track your score.

# Project Members

This project was developed collaboratively as a team project for our Computer Science course 

**Yanga Magaga– Team leader and core logic developer**
   - Led the development and coordination of the project.
   - Developed the core KenKen gameplay and game panel.
   - Implemented the level selection structure.
   - Developed the game cells and puzzle solutions.
   - Contributed to the core puzzle logic and game functionality.

**Angel Masombuka – Documentation lead and UI developer**
   - Led the project's documentation, including the README and supporting documentation.
   - Developed the main application and home screen.
   - Designed the overall visual theme of the game.
   - Developed the colour scheme, backgrounds, fonts and other visual styling.
   - Contributed to the overall user interface and presentation of the game.

**Masixole Mcoki  – UI and scoring system developer**
   - Contributed to the game's visual design and colour scheme.
   - Developed the scoring system used during gameplay.
   - Implemented player scores and game data.

**Nhlanhla Msiza – Front-end Developer**
   - Developed the game's loading/splash screen.
   - Contributed to the front-end presentation and user experience.


# References
KenKen was originally created by Tetsuya Miyamoto in 2004.

Johnson, D. (2024, September 3). What is KenKen puzzle? Games Learning Society.

KenKen, C. C. (2008). Educational Benefits of KenKen. KenKen Puzzle.

Oracle. (2023). Java Swing tutorial: Building graphical user interfaces.

Shortz, W. (2009, February 8). A New Puzzle Challenges Math Skills. The New York Times
