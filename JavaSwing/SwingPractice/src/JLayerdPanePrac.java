import javax.swing.*;
import java.awt.*;

public class JLayerdPanePrac {
    public static void main(String[] args) {
        // JLayeredPane = Swing container that provides a
        //                third dimension for positioning components
        //                ex. depth z-index

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50,50,200,200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100,100,200,200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150,150,200,200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500); // Порядок наложения, от самого ближнего,до самого дальнего по z
        layeredPane.add(label1,Integer.valueOf(0));                              // Drag -> PopUp -> Modal -> Palette -> Default
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(1));


        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(layeredPane);
        frame.setVisible(true);
    }
}
