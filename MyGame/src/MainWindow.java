
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        int WIDTH = 800;
        int HEIGHT = 500;
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setBounds(0, 0, WIDTH, HEIGHT);
        this.add(gamePanel);

        this.setVisible(true);
    }
}
