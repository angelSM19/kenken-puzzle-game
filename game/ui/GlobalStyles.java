package game.ui;

import javax.swing.*;
import java.awt.*;
//import java.io.*; removed because original fonts (licensed) were deleted from resources/fonts

public class GlobalStyles {

    private Image backgroundImage;

    public GlobalStyles() {
        try {
            backgroundImage = new ImageIcon("resources/Background.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public LookAndFeel setGlobalStyles() { //modified to use standard fonts

        Font titleFont = new Font("Serif", Font.BOLD | Font.ITALIC, 36);
        Font defaultFont = new Font("SansSerif", Font.PLAIN, 24);
        Font userInput = new Font("SansSerif", Font.PLAIN, 64);

        UIManager.put("Button.font", defaultFont);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("TextField.font", defaultFont);
        UIManager.put("TextArea.font", defaultFont);
        UIManager.put("KenKen.defaultFont", defaultFont);
        UIManager.put("KenKen.UI", userInput);
        UIManager.put("KenKen.titleFont", titleFont);

        UIManager.put("Button.background", new Color(0xFF, 0xC1, 0x25));
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.focus", new Color(34, 139, 34));
        UIManager.put("Button.select", new Color(0, 128, 0));

        return UIManager.getLookAndFeel();
    }

    //Wraps a panel with a background image
    public JPanel wrapWithBackground(JPanel content) {
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        bgPanel.setLayout(new BorderLayout());
        content.setOpaque(false);  // Let the background show through
        bgPanel.add(content, BorderLayout.CENTER);
        return bgPanel;
    }
}
