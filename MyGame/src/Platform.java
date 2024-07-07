


import java.awt.*;
import java.awt.image.BufferedImage;

public class Platform {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    BufferedImage image;

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Platform(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
