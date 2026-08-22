package game.core;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.function.Consumer;
import game.ui.RoundedButtonUI;

public class LevelSelect extends JPanel {

    private static final int EASY_LEVELS = 24;
    private static final int MEDIUM_LEVELS = 24;
    private static final int HARD_LEVELS = 12;

    private Map<Integer, JButton> levelButtons;
    private ProgressManager progressManager;
    private String difficulty;
    private int maxLevels;

    private Set<Integer> completedLevels;
    private JLabel scoreLabel;

    public LevelSelect(String diff, Consumer<Integer> onLevelChosen, Runnable onBack) {
        this.difficulty = diff.toLowerCase();
        this.progressManager = new ProgressManager();
        this.maxLevels = getMaxLevels(this.difficulty);
        this.levelButtons = new HashMap<>();

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
        setOpaque(false);

        // Top panel 
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Select Level - " + capitalize(this.difficulty));
        titleLabel.setForeground(Color.WHITE);
        Font titleFont = titleLabel.getFont();
        titleLabel.setFont(titleFont.deriveFont(Font.BOLD, 24f));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        topPanel.add(titleLabel, BorderLayout.WEST);

        scoreLabel = new JLabel();
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        topPanel.add(scoreLabel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        updateScoreDisplay();

        // Levels grid 
        JPanel levelsPanel = new JPanel();
        levelsPanel.setLayout(new GridLayout(0, 6, 12, 12));
        levelsPanel.setOpaque(false);

        completedLevels = progressManager.getCompletedLevels(this.difficulty, maxLevels);

        for (int i = 1; i <= maxLevels; i++) {
            final int lvl = i;
            JButton btn = new JButton();
            btn.setText(String.valueOf(i));
            btn.setFocusPainted(false);
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.setUI(new RoundedButtonUI(20));

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (btn.isEnabled()) {
                        onLevelChosen.accept(lvl);
                    }
                }
            });

            levelButtons.put(i, btn);
            levelsPanel.add(btn);
        }

        JScrollPane scrollPane = new JScrollPane(levelsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);

        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setUI(new RoundedButtonUI(25));
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setBackground(new Color(0xFF, 0x66, 0x33));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBack.run();
            }
        });

        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshLevelButtons();
    }

    private int getMaxLevels(String diff) {
        if (diff.equals("easy")) return EASY_LEVELS;
        if (diff.equals("medium")) return MEDIUM_LEVELS;
        if (diff.equals("hard")) return HARD_LEVELS;
        return 0;
    }

    public void markCompletedAndRefresh(int levelNum) {
        progressManager.markCompleted(difficulty, levelNum);
        completedLevels = progressManager.getCompletedLevels(difficulty, maxLevels);
        updateScoreDisplay();
        refreshLevelButtons();
    }

    private void updateScoreDisplay() {
        scoreLabel.setText(" Score: " + ScoreManager.getGlobalScore());
    }

    private void refreshLevelButtons() {
        for (int i = 1; i <= maxLevels; i++) {
            JButton btn = levelButtons.get(i);

            boolean unlocked = false;
            if (i == 1) {
                unlocked = true;
            } else if (completedLevels.contains(i - 1)) {
                unlocked = true;
            }

            if (completedLevels.contains(i)) {
                btn.setBackground(new Color(0x4CAF50));
                btn.setForeground(Color.WHITE);
                btn.setEnabled(true);
            } else if (unlocked) {
                btn.setBackground(new Color(0x2196F3));
                btn.setForeground(Color.WHITE);
                btn.setEnabled(true);
            } else {
                btn.setBackground(new Color(0x9E9E9E));
                btn.setForeground(Color.WHITE);
                btn.setEnabled(false);
            }

            btn.setOpaque(true);
            btn.setBorderPainted(false);
        }
    }

    private String capitalize(String txt) {
        if (txt == null) 
            return null;

        if (txt.length() == 0)
            return "";
            
        String first = txt.substring(0, 1).toUpperCase();
        String rest = txt.substring(1).toLowerCase();
        return first + rest;
    }

    public void resetScoreDisplay() {
        updateScoreDisplay();
    }
}