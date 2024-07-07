
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class GamePanel extends JPanel implements ActionListener, MouseListener {
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 500;
    private static final int BRICKS_AREA_Y = 350;
    private final ArrayList<Enemy> enemies;
    private final ArrayList<Platform> platforms = new ArrayList<>();

    private final Player player;
    private BufferedImage bricks;
    private BufferedImage sky;

    public boolean isReloading = false;
    JProgressBar reloadProgressBar;

    public GamePanel() {
        setLayout(null);
        player = Player.getInstance();
        enemies = new ArrayList<>();

        initIcons();
        initPlatforms();
        initTimers();
        initKeyBindings();
        initActions();


        add(player);
        addMouseListener(this);
    }

    private void initPlatforms(){
        Platform mainPlatform = new Platform(0, BRICKS_AREA_Y, GAME_WIDTH, GAME_HEIGHT,bricks);
        Platform leftPlatform = new Platform(100,BRICKS_AREA_Y - 150,100,50,bricks);
        Platform rightPlatform = new Platform(GAME_WIDTH - 300,BRICKS_AREA_Y - 100,100,50,bricks);
        platforms.add(mainPlatform);
        platforms.add(rightPlatform);
        platforms.add(leftPlatform);
    }


    private void initTimers(){
        new Timer(10, this).start();
        new Timer(2000, new EnemySpawner()).start();
    }

    private void initIcons() {
        try {
            bricks = ImageIO.read(new File("bricksIcon.png"));
            sky = ImageIO.read(new File("Sky.png"));
            BufferedImage crossHair = ImageIO.read(new File("cross-hair.png"));
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(crossHair, new Point(0, 0), "Crosshair"));
        } catch (IOException e) {
            bricks = null;
            sky = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sky, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);

        for(Platform platform : platforms){
            platform.draw(g);
        }

        for (int i = 0; i < player.weapon.getCurrentBulletCount(); i++) {
            g.drawImage(new ImageIcon("BulletIco.png").getImage(), 10 + i * 10, 35, 25, 20, null);
        }

        for(int i = 0; i < player.getCurrentHealth();i++){
            g.drawImage(new ImageIcon("heart.png").getImage(),10 + i * 20, 15,25,20,null);
        }

        for (Projectile projectile : player.weapon.getProjectiles()) {
            projectile.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        updatePlayerCollision();
        enemyWalk();
        updateProjectiles();
        if(isReloading){
            updateBarPos();
        }
        repaint();
    }

    private void enemyWalk(){
        for (Iterator<Enemy> it = enemies.iterator(); it.hasNext(); ) {
            Enemy enemy = it.next();
            enemy.moveTowardPlayer(player.getX(), player.getY());
            if (player.getBounds().intersects(enemy.getBounds())) {
                it.remove();
                player.setCurrentHealth(player.getCurrentHealth() - 1);
                remove(enemy);
            }
        }
    }

    private void updatePlayerCollision(){
        boolean collisionDetected = false;
        for(Platform platform:platforms){
            if(player.getBounds().intersects(platform.getBounds())){
                collisionDetected = true;

                int playerBottom = player.getY() + player.getHeight();
                int platformTop = platform.getY();
                int playerTop = player.getY();
                int platformBottom = platform.getY() + platform.getHeight();
                int playerRight = player.getX() + player.getWidth();
                int platformLeft = platform.getX();
                int playerLeft = player.getX();
                int platformRight = platform.getX() + platform.getWidth();

                // Detect collision direction
                if (playerBottom > platformTop && playerTop < platformTop && playerRight > platformLeft + 5 && playerLeft < platformRight - 5) {
                    // Collision from top
                    player.landOnGround(platformTop - player.getHeight());
                } else if (playerTop < platformBottom && playerBottom > platformBottom && playerRight > platformLeft + 5 && playerLeft < platformRight - 5) {
                    // Collision from bottom
                    player.setY(platformBottom);
                    player.setYVelocity(0);
                    player.setJumping(true);
                } else if (playerRight > platformLeft && playerLeft < platformLeft && playerBottom > platformTop && playerTop < platformBottom) {
                    player.setX(platformLeft - player.getWidth());
                    player.applyGravity();
                } else if (playerLeft < platformRight && playerRight > platformRight && playerBottom > platformTop && playerTop < platformBottom) {
                    // Collision from right
                    player.setX(platformRight);
                    player.applyGravity();
                }
            }
        }
        if(!collisionDetected){
            player.applyGravity();
        }
    }

    private void updateProjectiles(){
        for (Iterator<Projectile> it = player.weapon.getProjectiles().iterator(); it.hasNext(); ) {
            Projectile projectile = it.next();
            projectile.move();
            if (projectile.isOffScreen()) {
                it.remove();
                remove(projectile);
            } else {
                add(projectile);
                for (Iterator<Enemy> enemyIt = enemies.iterator(); enemyIt.hasNext(); ) {
                    Enemy enemy = enemyIt.next();
                    if (projectile.getBounds().intersects(enemy.getBounds())) {
                        it.remove();
                        enemyIt.remove();
                        remove(projectile);
                        remove(enemy);
                        break;
                    }
                }
            }
        }
    }
    private void updateBarPos(){
        reloadProgressBar.setLocation(player.getX() - 25,player.getY() - 20);
    }
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        int crossX = e.getX();
        int crossY = e.getY();
        player.weapon.weaponFire(crossX, crossY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private void initActions() {
        getActionMap().put("reload", new ReloadAction());
    }

    private void initKeyBindings() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("R"), "reload");
    }


    private class ReloadAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!isReloading && player.weapon.getCurrentBulletCount() < player.weapon.getMaxBulletCount()) {
                reloadingBar();
            }
        }
    }

    private void reloadingBar(){
        reloadProgressBar = new JProgressBar();
        reloadProgressBar.setBounds(player.getX() - 25, player.getY() - 20, 100, 10);
        reloadProgressBar.setValue(0);
        reloadProgressBar.setBackground(Color.yellow);
        reloadProgressBar.setStringPainted(true);
        this.add(reloadProgressBar);
        isReloading = true;
        player.weapon.weaponReload(reloadProgressBar,this);
    }

    private class EnemySpawner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (enemies.isEmpty()) {
                int spawnX = Math.random() > 0.5 ? 0 : GAME_WIDTH - 50;
                int spawnY = BRICKS_AREA_Y - 50;
                Enemy enemy = new Enemy(spawnX, spawnY, 2);
                enemies.add(enemy);
                add(enemy);
                repaint();
            }
        }
    }
}
