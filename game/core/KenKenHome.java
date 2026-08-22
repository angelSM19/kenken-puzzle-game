package game.core;

import game.ui.RoundedButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.function.Consumer;
import javax.swing.*;

public class KenKenHome extends JPanel {

    private Consumer<String> callback; // save callback reference ********

    public KenKenHome(Consumer<String> cbChooseDiff) {
        this.callback = cbChooseDiff;

        // Layout and styling for the whole panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));

        // TITLE
        JLabel title = new JLabel("KenKen Craze");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        title.setFont((Font) UIManager.get("KenKen.titleFont"));
        add(title);
        add(Box.createVerticalStrut(24));

        // INTRO TEXT
        String intro = "Get ready to boost your brain power with KenKen Craze, the puzzle game that's fun, " +
                "challenging, and addictively clever.\n\n" +
                "Basic Rules of KenKen\n" +
                "- Each puzzle is a grid made up of cells (like Sudoku).\n" +
                "- No repeats in any row or column.\n" +
                "- The grid is divided into bold-outlined areas called \"cages\".\n" +
                "- Each cage has a target number and a math operation (+, -, x, /).\n" +
                "- Fill the cage so the numbers produce the target result using the operation.\n" +
                "Choose the difficulty below:";

        JTextArea introArea = new JTextArea(intro);
        introArea.setEditable(false);
        introArea.setLineWrap(true);
        introArea.setWrapStyleWord(true);
        introArea.setFont((Font) UIManager.get("TextArea.font"));
        introArea.setForeground(Color.WHITE);
        introArea.setOpaque(false);

        JScrollPane scroll = new JScrollPane(introArea);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        add(scroll);
        add(Box.createVerticalStrut(24));

        // DIFFICULTY BUTTONS
        String[] levels = {"easy", "medium", "hard"};
        String[] tooltips = {"Play 24 easy levels", "Play 24 medium levels", "Play 12 hard levels"};

        for (int i = 0; i < levels.length; i++) {
            String levelName = levels[i]; // important: final-like variable for inner class
            JButton button = new JButton(levelName.substring(0, 1).toUpperCase() + levelName.substring(1));
            
            // styling
            button.setUI(new RoundedButtonUI(25));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground((Color) UIManager.get("Button.background"));
            button.setForeground((Color) UIManager.get("Button.foreground"));
            button.setFont((Font) UIManager.get("TextArea.font"));
            button.setPreferredSize(new Dimension(200, 40));
            button.setMaximumSize(new Dimension(200, 40));
            button.setToolTipText(tooltips[i]);
            
            // action listener
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    callback.accept(levelName);
                }
            });
            
            add(button);
            add(Box.createVerticalStrut(16));
        }

        // RESET BUTTON (BOTTOM RIGHT) 
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setOpaque(false);

        JButton resetButton = new JButton("Reset");
        resetButton.setUI(new RoundedButtonUI(20));
        resetButton.setBackground((Color) UIManager.get("Button.background"));
        resetButton.setForeground((Color) UIManager.get("Button.foreground"));
        resetButton.setFont((Font) UIManager.get("KenKen.defaultFont"));
        resetButton.setPreferredSize(new Dimension(100, 35));

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame resetFrame = new JFrame("Reset Progress");
                resetFrame.setSize(250, 150);
                resetFrame.setLayout(new FlowLayout());
                resetFrame.setLocationRelativeTo(KenKenHome.this);

                JButton confirmReset = new JButton("Confirm Reset");
                confirmReset.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        ScoreManager.resetAllScores();

                        File progressFile = new File("kenken_progress.dat");
                        if (progressFile.exists()) {
                            progressFile.delete();
                        }

                        JOptionPane.showMessageDialog(resetFrame, "Progress and scores have been reset!");
                        resetFrame.dispose();
                    }
                });

                resetFrame.add(confirmReset);
                resetFrame.setVisible(true);
            }
        });

        bottomPanel.add(resetButton);
        add(Box.createVerticalGlue());
        add(bottomPanel);
    }
}