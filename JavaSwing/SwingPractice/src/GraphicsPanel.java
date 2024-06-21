import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {

    Image img;
    GraphicsPanel(){
        img = new ImageIcon("errorLogo.png").getImage();
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.blue);
        g2D.setStroke(new BasicStroke(5));
        // g2D.drawLine(0,0,500,500);

        // g2D.drawRect(0,0,100,200);

        // g2D.fillRect(0,0,100,200);

        // g2D.drawOval(0,0,100,200);

        // g2D.fillOval(200,200,50,50);

        // g2D.setPaint(Color.red);
        // g2D.drawArc(100,100,100,100,0,180);
        // g2D.fillArc(100,100,100,100,0,180);
        // g2D.setPaint(Color.WHITE);
        // g2D.fillArc(100,100,100,100,180,180);

        // int[] xPoints = {150,250,350};
        // int[] yPoints = {300,150,300};
        // g2D.setPaint(Color.YELLOW);
        // g2D.drawPolygon(xPoints,yPoints,3);
        // g2D.fillPolygon(xPoints,yPoints,3);

        // g2D.setPaint(Color.magenta);
        // g2D.setFont(new Font("Ink Free",Font.BOLD,50));
        // g2D.drawString("You are a winner!:D",50,50);

        g2D.drawImage(img,0,0,null);
    }
}
