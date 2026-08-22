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

## Project Structure

kenken_game/
├── MainApp.java
├── game/
│   ├── core/
│   │   ├── KenKenCell.java
│   │   ├── KenKenGamePanel.java
│   │   ├── KenKenHome.java
│   │   ├── LevelSelect.java
│   │   ├── ProgressManager.java
│   │   ├── ScoreManager.java
│   │   └── SplashScreen.java
│   │
│   ├── data/
│   │   ├── GridConfig.java
│   │   ├── PresetBank.java
│   │   └── SolutionPage.java
│   │
│   └── ui/
│       ├── BackgroundPanelUI.java
│       ├── GlobalStyles.java
│       └── RoundedButtonUI.java
│
├── resources/
│   ├── Background.png
│   └── icon_2.png
│
└── .gitignore

## Requirements
Java JDK 8 or higher

## Running the game
1. Clone the repository:
   git clone https://gitlab.com/ru-computer-science/cs-102-project-2025/team_16.git

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

Yanga Magaga– Team leader and core logic developer

Angel Masombuka – Documentation lead and UI developer

Masixole Mcoki  – UI and scoring system developer

Masixole Mcoki – Front-end developer

Rishile Ndlhovu – Tester

# References
KenKen was originally created by Tetsuya Miyamoto in 2004.

Johnson, D. (2024, September 3). What is KenKen puzzle? Games Learning Society. Link

KenKen, C. C. (2008). Educational Benefits of KenKen. KenKen Puzzle. Link

Oracle. (2023). Java Swing tutorial: Building graphical user interfaces. Link

Shortz, W. (2009, February 8). A New Puzzle Challenges Math Skills. The New York Times