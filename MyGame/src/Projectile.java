

import javax.swing.*;
import java.awt.*;

public class Projectile extends JLabel {
    private static final int SPEED = 5;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 500;

    private int x;
    private int y;

    private final double directionX;
    private final double directionY;

    public Projectile(int x, int y, int cursorX, int cursorY) {
        this.x = x;
        this.y = y;

        int deltaX = cursorX - x;
        int deltaY = cursorY - y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        this.directionX = deltaX / distance;
        this.directionY = deltaY / distance;

        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
    }

    public void move() {

        x += (int)(SPEED * directionX);
        y += (int)(SPEED * directionY);

        setLocation(x,y);
    }

    public boolean isOffScreen() {
        return x < 0 || x > GAME_WIDTH || y < 0 || y > GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
