import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.Timer;
public class SnakeGame extends JPanel implements ActionListener,KeyListener{
    private class Tile{
        int x;
        int y;
        Tile(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    int tileSize = 25;
    int boardWidth;
    int boardHeight;
    Tile snakeHead; // Snake
    ArrayList<Tile> snakeBody;
    Tile food; //Food
    Random random;
    Timer gameLoop; //Game logic
    int velocityX;
    int velocityY;
    boolean gameOver = false;
    SnakeGame(int boardWidth,int boardHeight){
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);


        snakeHead = new Tile(5,5);
        snakeBody = new ArrayList<Tile>();
        food = new Tile(10,10);
        random = new Random();
        placeFood();

        velocityX = 0;
        velocityY = 1;

        gameLoop = new Timer(100,this);
        gameLoop.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics entityHead){
        // Food
        entityHead.setColor(Color.red);
 //       entityHead.fillRect(food.x * tileSize,food.y * tileSize,tileSize,tileSize);
        entityHead.fill3DRect(food.x * tileSize,food.y * tileSize,tileSize,tileSize,true);
        // Snake head
        entityHead.setColor(Color.green);
    //    entityHead.fillRect(snakeHead.x * tileSize,snakeHead.y * tileSize,tileSize,tileSize);
        entityHead.fill3DRect(snakeHead.x * tileSize,snakeHead.y * tileSize,tileSize,tileSize,true);
        // Snake body
        for(int i = 0; i < snakeBody.size();i++){
            Tile snakePart = snakeBody.get(i);
            entityHead.fill3DRect(snakePart.x * tileSize,snakePart.y * tileSize,tileSize,tileSize,true);
        }
        // Score
        entityHead.setFont(new Font("Arial",Font.PLAIN,16));
        if(gameOver){
            entityHead.setColor(Color.red);
            entityHead.drawString("Game Over:" + String.valueOf(snakeBody.size()),tileSize - 16,tileSize);
        }else{
            entityHead.drawString("Score: " + String.valueOf(snakeBody.size()),tileSize - 16, tileSize);
        }
    }
    public void placeFood(){ // Random food position
        food.x = random.nextInt(boardWidth/tileSize);
        food.y = random.nextInt(boardHeight/tileSize);
    }

    public boolean collision(Tile tile1, Tile tile2){
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }
    public void moveSnake(){
        if(collision(snakeHead,food)){
            snakeBody.add(new Tile(food.x,food.y));
            placeFood();
        }
        // Move body
        for(int i = snakeBody.size() - 1;i >= 0;i--){
            Tile snakePart = snakeBody.get(i);
            if(i == 0){
                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;
            }else{
                Tile prevSnakeBody = snakeBody.get(i - 1);
                snakePart.x = prevSnakeBody.x;
                snakePart.y = prevSnakeBody.y;
            }
        }
        // Move head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
        // Game over
        for(int i = 0;i < snakeBody.size();i++){
            Tile snakePart = snakeBody.get(i);
            if(collision(snakePart,snakeHead)){
                gameOver = true;
            }
        }
        if(snakeHead.x * tileSize < 0 || snakeHead.x * tileSize > boardWidth || snakeHead.y * tileSize > boardHeight || snakeHead.y * tileSize < 0){
            gameOver = true;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
        if(gameOver){
            gameLoop.stop();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP && velocityY != 1){
            velocityX = 0;
            velocityY = -1;
        } else if (keyCode == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (keyCode == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (keyCode == KeyEvent.VK_RIGHT && velocityX != -1){
            velocityX = 1;
            velocityY = 0;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}