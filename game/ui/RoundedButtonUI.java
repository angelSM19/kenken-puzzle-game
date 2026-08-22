package game.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class RoundedButtonUI extends BasicButtonUI {
    private final int cornerRadius;

    public RoundedButtonUI(int radius) {
        this.cornerRadius = radius;
    }

    @Override
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setOpaque(false); // we paint the background ourselves
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Use button's own background if set; otherwise fallback to default
        Color bg = b.getBackground() != null ? b.getBackground() : UIManager.getColor("Button.background");

        if (b.getModel().isPressed()) {
            g2.setColor(bg.darker());
        } else if (b.getModel().isRollover()) {
            g2.setColor(bg.brighter());
        } else {
            g2.setColor(bg);
        }

        // Draw rounded background
        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), cornerRadius, cornerRadius);

        // Draw text
        g2.setColor(b.getForeground() != null ? b.getForeground() : UIManager.getColor("Button.foreground"));
        FontMetrics fm = g2.getFontMetrics();
        int x = (c.getWidth() - fm.stringWidth(b.getText())) / 2;
        int y = (c.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2.drawString(b.getText(), x, y);

        g2.dispose();
    }
}
