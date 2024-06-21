import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerHelp extends JFrame implements MouseListener {

    JLabel label;
    ImageIcon error = new ImageIcon("errorLogo.png");
    ImageIcon notif = new ImageIcon("notif.png");
    ImageIcon complete = new ImageIcon("complete.png");
    MouseListenerHelp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.setOpaque(true);
        label.addMouseListener(this);
        label.setIcon(error);

        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setIcon(notif);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setIcon(complete);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setIcon(error);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
