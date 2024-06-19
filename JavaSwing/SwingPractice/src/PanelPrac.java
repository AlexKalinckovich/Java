import javax.swing.*;
import java.awt.*;

public class PanelPrac {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("errorLogo.png");
        JLabel label = new JLabel();
        label.setText("Hello");
        label.setForeground(Color.magenta);
        label.setIcon(icon);
        // label.setVerticalAlignment(JLabel.TOP);
        // label.setHorizontalAlignment(JLabel.RIGHT); this is if we use new BorderLayout
        label.setBounds(100,100,75,75);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);
        bluePanel.setLayout(new BorderLayout());

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.setLayout(null);


        JFrame frame = new JFrame();
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        greenPanel.add(label);

        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
}
