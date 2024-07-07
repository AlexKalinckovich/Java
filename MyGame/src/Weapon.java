
import javax.swing.*;
import java.util.ArrayList;

public class Weapon extends JLabel {

    private final static int WEAPON_WIDTH = 10;
    private final static int WEAPON_HEIGTH = 10;
    private final static int MAX_BULLET_COUNT = 6;
    private final ArrayList<Projectile> projectiles;
    private final int playerWidth;
    private final int playerHeight;
    private Timer reloadTimer;
    private int reloadProgess = 0;

    private int playerX;
    private int playerY;
    private int currentBulletCount;

    public Weapon(int x, int y, int width, int height) {

        this.playerX = x;
        this.playerY = y;
        this.playerWidth = width;
        this.playerHeight = height;

        this.projectiles = new ArrayList<>();

        currentBulletCount = MAX_BULLET_COUNT;


        this.setOpaque(false);
        this.setBounds(playerX, playerY, playerWidth, playerHeight);
        this.setLayout(null);
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void updatePosition(int x, int y) {
        this.playerX = x;
        this.playerY = y;
        setLocation(playerX, playerY);
    }

    public int getMaxBulletCount() {
        return MAX_BULLET_COUNT;
    }

    public void weaponFire(int cursorX, int cursorY) {
        if(currentBulletCount > 0) {
            int startX = playerX + playerWidth;
            int startY = playerY + playerHeight / 2;
            Projectile projectile = new Projectile(startX, startY, cursorX, cursorY);
            projectiles.add(projectile);
            currentBulletCount--;
        }
    }

    public int getCurrentBulletCount() {
        return currentBulletCount;
    }

    public void weaponReload(JProgressBar reloadProgressBar, GamePanel gamePanel){
        if (reloadTimer == null || !reloadTimer.isRunning()) {
            startReloading(reloadProgressBar,gamePanel);
        }
    }
    private void startReloading(JProgressBar reloadProgressBar,GamePanel gamePanel){
        reloadProgressBar.setValue(0);
        reloadTimer = new Timer(100, e -> {
            reloadProgess += 10;
            reloadProgressBar.setValue(reloadProgess);
            if(reloadProgess == 100){
                reloadProgess = 0;
                reloadTimer.stop();
                currentBulletCount = MAX_BULLET_COUNT;
                gamePanel.isReloading = false;
                gamePanel.remove(reloadProgressBar);
            }
        });
        reloadTimer.start();
    }
}
