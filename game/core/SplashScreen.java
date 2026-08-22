package game.core;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    private JProgressBar progressBar;
    private JLabel percentLabel;

    public SplashScreen(Runnable onFinish) {
        // Basic frame setup
        setTitle("KenKen Loading...");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(39, 116, 174)); // UCLA blue
        setLayout(new BorderLayout());

        // Set window icon
        try {
            ImageIcon windowIcon = new ImageIcon("resources/icon_2.png");
            Image iconImage = windowIcon.getImage();
            setIconImage(iconImage);
        } catch (Exception e) {
            // Ignore if icon not found
        }

        // Center logo label 
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            ImageIcon logoIcon = new ImageIcon("resources/icon_2.png");
            Image originalImage = logoIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(scaledIcon);
        } catch (Exception e) {
            imageLabel.setText("KenKen Craze");
            imageLabel.setForeground(Color.WHITE);
            imageLabel.setFont(new Font("Arial", Font.BOLD, 32));
        }

        add(imageLabel, BorderLayout.CENTER);

        // Bottom panel with progress bar and percentage 
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setOpaque(false);

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        progressBar.setStringPainted(false);
        progressBar.setForeground(new Color(0, 200, 0)); // green
        progressBar.setPreferredSize(new Dimension(500, 30));
        bottomPanel.add(progressBar, BorderLayout.CENTER);

        percentLabel = new JLabel("0%", SwingConstants.CENTER);
        percentLabel.setForeground(Color.WHITE);
        percentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(percentLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Make visible 
        setVisible(true);

        // Loading simulation 
        Thread loadingThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(40); // adjust loading speed
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    final int currentProgress = i;

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            progressBar.setValue(currentProgress);
                            percentLabel.setText(currentProgress + "%");
                        }
                    });
                }

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        dispose();
                        onFinish.run();
                    }
                });
            }
        });

        loadingThread.start();
    }
}