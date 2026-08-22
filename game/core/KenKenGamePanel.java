package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.data.GridConfig;
import game.data.SolutionPage;
import game.ui.RoundedButtonUI;

public class KenKenGamePanel extends JPanel {

    private final JTextField[][] cells;
    private int selectedRow = -1, selectedCol = -1;

    private final LevelSelect levelSelect;
    private final int levelNumber;
    private final String difficulty;

    private final int gridSize;
    private final int[][] solution;

    // Timer
    private Timer countdownTimer;
    private int timeLeft; // seconds
    private JLabel timerLabel;

    // Level score
    private int levelScore;

    // Bottom panel
    private JPanel bottomPanel;

    public KenKenGamePanel(LevelSelect levelSelect, String difficulty, int levelNumber, Runnable onBack) {
        this.levelSelect = levelSelect;
        this.levelNumber = levelNumber;
        this.difficulty = difficulty.toLowerCase();

        this.gridSize = GridConfig.getGridSize(difficulty, levelNumber);
        this.cells = new JTextField[gridSize][gridSize];
        this.solution = SolutionPage.getSolution(difficulty, levelNumber);

        setLayout(new BorderLayout());
        setOpaque(false); // Transparent background

        initTopPanel(onBack);
        initGrid();
        initBottomPanel(onBack);

        initLevelScore(); // Initialize level score dynamically

        startCountdown();
    }

    private void initTopPanel(Runnable onBack) {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JButton back = new JButton("Back");
        back.setUI(new RoundedButtonUI(25));
        back.setFocusPainted(false);
        back.addActionListener(e -> {
            if (countdownTimer != null) countdownTimer.stop();
            onBack.run();
        });

        JLabel title = new JLabel("Level " + levelNumber + " (" + difficulty.toUpperCase() + ")");
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        timerLabel = new JLabel("Time: 0:00");
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        topPanel.add(back, BorderLayout.WEST);
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(timerLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
    }

    private void initGrid() {
        int boxSize, inputSize;
        switch (difficulty) {
            case "easy": boxSize = 120; inputSize = boxSize / 2 + 20; break;
            case "medium": boxSize = 100; inputSize = boxSize / 2 + 10; break;
            case "hard": boxSize = 90; inputSize = boxSize / 2 + 5; break;
            default: boxSize = 80; inputSize = boxSize / 2 + 20;
        }

        JPanel grid = new JPanel(new GridLayout(gridSize, gridSize));
        grid.setOpaque(false);
        grid.setBorder(BorderFactory.createEmptyBorder(24, 24, 12, 24));

        String[][] hints = GridConfig.getHintLayout(difficulty, levelNumber);
        boolean[][][] borders = GridConfig.getCageBorders(difficulty, levelNumber);

        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                KenKenCell cell = new KenKenCell(hints[r][c], borders[r][c], boxSize, inputSize,
                        difficulty, levelNumber, r, c);
                cells[r][c] = cell.getTextField();

                final int rr = r, cc = c;
                cells[r][c].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        selectedRow = rr;
                        selectedCol = cc;
                    }
                });

                grid.add(cell);
            }
        }

        add(grid, BorderLayout.CENTER);
    }

    private void initBottomPanel(Runnable onBack) {
        bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(12, 24, 24, 24));

        JPanel numRow = new JPanel(new GridLayout(1, gridSize + 1, 12, 0));
        numRow.setOpaque(false); // transparent background

        for (int i = 1; i <= gridSize; i++) {
            JButton btn = createNumberButton(String.valueOf(i));
            final String num = String.valueOf(i);
            btn.addActionListener(e -> setCellValue(num));
            numRow.add(btn);
        }

        JButton backspace = createNumberButton("Backspace");
        backspace.addActionListener(e -> setCellValue(""));
        numRow.add(backspace);

        bottomPanel.add(numRow);
        bottomPanel.add(Box.createVerticalStrut(12));

        JButton check = new JButton("Check");
        check.setUI(new RoundedButtonUI(25));
        check.setFont((Font) UIManager.get("Button.font"));
        check.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.setBackground((Color) UIManager.get("Button.background"));
        check.setForeground((Color) UIManager.get("Button.foreground"));
        check.setPreferredSize(new Dimension(200, 40));
        check.setMaximumSize(new Dimension(200, 40));
        check.setFocusPainted(false);
        check.addActionListener(e -> handleCheck(onBack));

        bottomPanel.add(check);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JButton createNumberButton(String label) {
        JButton btn = new JButton(label);
        btn.setUI(new RoundedButtonUI(25));
        btn.setFont((Font) UIManager.get("Button.font"));
        btn.setBackground(new Color(0xFC, 0xAE, 0x1E));
        btn.setForeground((Color) UIManager.get("Button.foreground"));
        btn.setFocusPainted(false);
        return btn;
    }

    private void setCellValue(String value) {
        if (selectedRow != -1 && selectedCol != -1) {
            cells[selectedRow][selectedCol].setText(value);
        }
    }

    private void initLevelScore() {
        switch (difficulty) {
            case "easy": levelScore = 9; timeLeft = 300; break;
            case "medium": levelScore = 16; timeLeft = 180; break;
            case "hard": levelScore = 25; timeLeft = 120; break;
            default: levelScore = 0; timeLeft = 180;
        }

        // Load saved score if exists
        int savedScore = ScoreManager.getScore(difficulty, levelNumber);
        if (savedScore > 0) levelScore = savedScore;
    }

    private void calculateLevelScore() {
        // Example: score decreases 1 point every 10 seconds used
        int baseScore;
        switch (difficulty) {
            case "easy": baseScore = 9; break;
            case "medium": baseScore = 16; break;
            case "hard": baseScore = 25; break;
            default: baseScore = 0;
        }
        int elapsed = getTotalTime() - timeLeft;
        int penalty = elapsed / 10;
        levelScore = Math.max(0, baseScore - penalty);
    }

    private int getTotalTime() {
        switch (difficulty) {
            case "easy": return 300;
            case "medium": return 180;
            case "hard": return 120;
            default: return 180;
        }
    }

    private void handleCheck(Runnable onBack) {
        if (countdownTimer != null) countdownTimer.stop();

        calculateLevelScore(); // Update score dynamically

        if (isCorrect()) {
            ScoreManager.setScore(difficulty, levelNumber, levelScore);
            JOptionPane.showMessageDialog(this, "Correct! You solved it!");
            levelSelect.markCompletedAndRefresh(levelNumber); // Update LevelSelect score
            onBack.run();
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect! Keep trying.");
        }
    }

    private void startCountdown() {
        countdownTimer = new Timer(1000, e -> {
            timeLeft--;
            int minutes = timeLeft / 60;
            int seconds = timeLeft % 60;
            timerLabel.setText(String.format("Time: %d:%02d", minutes, seconds));

            if (timeLeft <= 0) {
                countdownTimer.stop();
                onTimeExpired();
            }
        });
        countdownTimer.start();
    }

    private void onTimeExpired() {
        lockGrid();
        calculateLevelScore();
        JOptionPane.showMessageDialog(this, "Time is up! Auto-checking your puzzle...");

        ScoreManager.setScore(difficulty, levelNumber, levelScore);

        if (isCorrect()) {
            JOptionPane.showMessageDialog(this, "Correct! You solved it just in time!");
        } else {
            JOptionPane.showMessageDialog(this, "Time’s up! Puzzle is not correct.");
        }

        levelSelect.markCompletedAndRefresh(levelNumber);
    }

    private void lockGrid() {
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                cells[r][c].setEditable(false);
            }
        }
    }

    private boolean isCorrect() {
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                String text = cells[r][c].getText().trim();
                if (!text.matches("[1-" + gridSize + "]")) return false;
                if (Integer.parseInt(text) != solution[r][c]) return false;
            }
        }
        return true;
    }
}
