

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class Player extends JPanel {
    private static Player player;
    private int currentHealth = 3;
    private int x;
    private int y;
    private final int width;
    private final int height;
    private double yVelocity = 0;
    private boolean isJumping = false;
    private boolean leftPress = false;
    private boolean rightPress = false;

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;
    private static final int JUMP_STRENGTH = -7;
    private static final double GRAVITY = 1;
    private static final double TIME_STEP = 0.1;

    public final Weapon weapon;

    private Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.weapon = new Weapon(x, y, width, height);

        initActions();
        initKeyBindings();

        this.setOpaque(true);
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(Color.BLUE);
        this.add(weapon);
    }

    public static Player getInstance(){
        if(player == null){
            player = new Player(200, 200);
        }
        return player;
    }

    private void initActions() {
        getActionMap().put("leftPress", new LeftActionPress());
        getActionMap().put("leftRelease", new LeftActionRelease());
        getActionMap().put("rightPress", new RightActionPress());
        getActionMap().put("rightRelease", new RightActionRelease());
        getActionMap().put("jump", new JumpAction());
    }

    private void initKeyBindings() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "leftPress");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "leftRelease");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "rightPress");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "rightRelease");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "jump");
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    private class LeftActionPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            leftPress = true;
        }
    }

    private class LeftActionRelease extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            leftPress = false;
        }
    }

    private class RightActionPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            rightPress = true;
        }
    }

    private class RightActionRelease extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            rightPress = false;
        }
    }

    private class JumpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!isJumping){
                yVelocity = JUMP_STRENGTH;
                isJumping = true;
            }
        }
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void applyGravity(){ // Прыжок игрока
        yVelocity += GRAVITY * TIME_STEP;
        y += (int)yVelocity;
        if (y >= WINDOW_HEIGHT - height) {
            y = WINDOW_HEIGHT - height;
            yVelocity = 0;
            isJumping = false;
        }
    }

    public void landOnGround(int groundY){ // Находится на земле
        yVelocity = 0;
        isJumping = false;
        y = groundY;
        setLocation(x,y);
    }

    public void update(){
        if(leftPress) x = Math.max(0, x - 5);
        if(rightPress) x = Math.min(WINDOW_WIDTH - width, x + 5);
        if(isJumping) applyGravity();

        setLocation(x, y);
        weapon.updatePosition(x, y);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height);
    }
}
