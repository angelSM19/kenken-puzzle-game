package game.core;

import javax.swing.*;
import java.awt.*;
import game.data.GridConfig; 

public class KenKenCell extends JPanel {
    private final JTextField inputField;
    private final String cageLabel;
    private final boolean isTopLeft;
    private final boolean top, right, bottom, left;
    private Color cageColor;


    public KenKenCell(String hint, boolean[] borders, int boxSize, int inputSize,
                      String difficulty, int level, int row, int col) {

        this.cageLabel = hint;
        this.isTopLeft = !hint.isEmpty();
        this.top = borders[0];
        this.right = borders[1];
        this.bottom = borders[2];
        this.left = borders[3];

        // Get color from GridConfig safely
        try {
            Color[][] colors = GridConfig.getCellColors(difficulty, level);
            this.cageColor = colors[row][col];
        } catch (Exception e) {
            this.cageColor = Color.WHITE; // fallback
        }

        setLayout(null);
        setBackground(cageColor);
        setPreferredSize(new Dimension(boxSize, boxSize));

        // Input field setup
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setBorder(null);
        inputField.setOpaque(true);
        inputField.setBackground(cageColor);

        // Safe font
        Font baseFont = (Font) UIManager.get("KenKen.UI");
        if (baseFont == null) baseFont = new Font("SansSerif", Font.PLAIN, 12);
        inputField.setFont(baseFont.deriveFont((float) inputSize - 2));

        // Position input field bottom-right
        int x = boxSize - inputSize - 5;
        int y = boxSize - inputSize - 5;
        inputField.setBounds(x, y, inputSize, inputSize);

        add(inputField);
    }

    public JTextField getTextField() { return inputField; }
    public String getInput() { return inputField.getText().trim(); }
    public void setInput(String value) { inputField.setText(value); }

    /** Dynamically change cage color at runtime */
    public void setCageColor(Color newColor) {
        if (newColor != null) {
            this.cageColor = newColor;
            setBackground(cageColor);
            inputField.setBackground(cageColor);
            repaint();
        }
    }

    public Color getCageColor() { return cageColor; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Draw hint in top-left
        if (isTopLeft && cageLabel != null && !cageLabel.isEmpty()) {
            Font baseFont = (Font) UIManager.get("KenKen.UI");
            if (baseFont == null) baseFont = new Font("SansSerif", Font.PLAIN, 12);
            g2.setFont(baseFont.deriveFont(25f));
            g2.setColor(Color.BLACK);
            g2.drawString(cageLabel, 5, 18);
        }

        // Draw bold cage borders
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        int w = getWidth(), h = getHeight();
        if (top) g2.drawLine(0, 0, w, 0);
        if (right) g2.drawLine(w - 1, 0, w - 1, h);
        if (bottom) g2.drawLine(0, h - 1, w, h - 1);
        if (left) g2.drawLine(0, 0, 0, h);

        g2.dispose();
    }
}
