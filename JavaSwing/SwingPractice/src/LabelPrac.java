import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LabelPrac {
    public static void main(String[] args) {

        ImageIcon labelImage = new ImageIcon("errorLogo.png");
        Border border = BorderFactory.createLineBorder(Color.green,3); // Устанавливает границу какого-либо компонента

        JLabel label = new JLabel(); // create a label
        label.setText("Some  very very big text!"); // set text of label
        label.setIcon(labelImage);
        label.setHorizontalTextPosition(JLabel.CENTER); //Set text LEFT,CENTER,RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.BOTTOM); // Set text TOP,CENTER or BOTTOM
        label.setForeground(Color.green); // Set color for text
        label.setFont(new Font("Mv Boli",Font.PLAIN,20)); // Set font for text
        label.setIconTextGap(-10); // set gap (расстояние от изображения) of image
        label.setBackground(Color.black);
        label.setOpaque(true); // Display background color
        label.setBorder(border); // set border to component
        label.setVerticalAlignment(JLabel.CENTER); // set position within text + icon (vertical)
        label.setHorizontalAlignment(JLabel.CENTER); // same but horizontal
        //label.setBounds(100, 100, 250, 250); // set label coordinates (x,y)


        JFrame frame = new JFrame("My cool frame!"); // creates a frame
        frame.setTitle("This is also title"); // also set title!
        frame.setSize(500,500);// sets x-dimension and y-dimension (размер)
        frame.setVisible(true); // make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true); // prevent frame from being resized
        //frame.setLayout(null); // LayoutManager (контроль над масштабом)

        ImageIcon image = new ImageIcon("errorLogo.png"); // create a image icon
        frame.setIconImage(image.getImage()); // change icon of frame
        frame.getContentPane().setBackground(new Color(0x567483)); // change color of background

        frame.add(label);
        frame.pack(); // Size to fit all components
    }
}