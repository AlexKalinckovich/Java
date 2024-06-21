import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerHelp extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon icon = new ImageIcon("errorLogo.png");

    KeyListenerHelp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.black);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setOpaque(true);
        label.setIcon(icon);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Invoke when a key is typed. Uses KeyChar, char output
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Invoke when a physical key is pressed down. Uses KeyCode, int output
        switch (e.getKeyCode()){
            case 37: label.setLocation(label.getX() - 10,label.getY());
                break;
            case 38: label.setLocation(label.getX(),label.getY() - 10);
                break;
            case 39: label.setLocation(label.getX() + 10,label.getY());
                break;
            case 40: label.setLocation(label.getX(),label.getY() + 10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // called whenever a button is released
        //System.out.println("You released key char:" + e.getKeyChar());
        //System.out.println("You released key code:" + e.getKeyCode());
    }
}
