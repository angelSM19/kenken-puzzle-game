import game.core.KenKenGamePanel;
import game.core.KenKenHome;
import game.core.LevelSelect;
import game.core.SplashScreen;
import game.ui.GlobalStyles;
import java.awt.*;
import javax.swing.*;

public class MainApp {

    private final JFrame frame = new JFrame("KenKen Craze");
    private final CardLayout cards = new CardLayout();
    private final JPanel content; // CardLayout container
    private final JPanel root;    // background wrapper

    private static final String HOME = "HOME";
    private static final String LVL = "LEVEL";
    private static final String GAME = "GAME";

    public MainApp() {
        GlobalStyles styles = new GlobalStyles();

        try {
            UIManager.setLookAndFeel(styles.setGlobalStyles());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // CardLayout container
        content = new JPanel(cards);
        content.setOpaque(false); // important: transparent

        // Add Home screen
        KenKenHome home = new KenKenHome(diff -> showLevelSelect(diff));
        content.add(home, HOME);

        // Wrap with background
        root = styles.wrapWithBackground(content);

        // Frame setup
        frame.setIconImage(new ImageIcon("resources/icon_2.png").getImage());
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.setVisible(true);
    }

    private void showLevelSelect(String difficulty) {
        LevelSelect[] lvlHolder = new LevelSelect[1];

        LevelSelect lvl = new LevelSelect(
            difficulty,
            lvlNum -> {
                try {
                    KenKenGamePanel game = new KenKenGamePanel(
                        lvlHolder[0],
                        difficulty,
                        lvlNum,
                        () -> cards.show(content, LVL)
                    );
                    content.add(game, GAME);
                    cards.show(content, GAME);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(frame, "This level isn’t wired up yet.");
                }
            },
            () -> cards.show(content, HOME)
        );

        lvlHolder[0] = lvl;
        content.add(lvl, LVL);
        cards.show(content, LVL);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplashScreen(() -> new MainApp()));
    }
}
