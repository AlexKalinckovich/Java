

import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int WINDOW_HEIGHT = 500;
    private static final int NEARBY_LOCATION = 200;
    private static final int JUMP_STRENGTH = -15;
    public static final int bricksAreaY = 350;
    private  static final double GRAVITY = 1;
    private  static final double TIME_STEP = 0.1;
    private double jumpTime = 0;
    private int yVelocity = 0;
    private boolean isJumping;
    int x;
    int y;
    int speed;
    Enemy(int x,int y,int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.setBounds(x,y,WIDTH,HEIGHT);
        this.setLocation(x,y);
        this.setOpaque(true);
        this.setBackground(Color.red);
    }

    private void enemyJump(){
        jumpTime += TIME_STEP;
        yVelocity += (int) (GRAVITY * jumpTime);
        y += yVelocity;
        if(y >= bricksAreaY - WIDTH){
            y = bricksAreaY - WIDTH;
            yVelocity = 0;
            isJumping = false;
        }
    }
    public void moveTowardPlayer(int playerX,int playerY){
        int deltaX = playerX - x;
        double distance = Math.sqrt(deltaX * deltaX);
        x += (int)(deltaX * speed / distance);
         if(!isJumping && playerY < y && Math.abs(deltaX + WIDTH) <= NEARBY_LOCATION){
            yVelocity = JUMP_STRENGTH;
            jumpTime = 0;
            isJumping = true;
        }
        if(isJumping){
            enemyJump();
        }
        this.setLocation(x,y);
    }
}
