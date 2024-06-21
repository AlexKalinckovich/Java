import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationsPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image error;
    Image backGround;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    AnimationsPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        backGround = new ImageIcon("EnterBackGround.png").getImage();
        error = new ImageIcon("errorLogo.png").getImage();
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backGround,0,0,null);
        g2D.drawImage(error,x,y,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= PANEL_WIDTH - error.getWidth(null) || (x < 0)){xVelocity *= - 1;}
        if(y >= PANEL_HEIGHT - error.getWidth(null) || (y < 0)){yVelocity *= - 1;}
        x += xVelocity;
        y += yVelocity;
        repaint();
    }
}
