package game.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

public class BackgroundPanelUI extends BasicPanelUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        Image background = (Image) UIManager.get("backgroundImage");
        if (background != null) {
            g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), null);
        }
        super.paint(g, c);
    }
}
