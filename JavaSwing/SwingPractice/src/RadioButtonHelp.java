import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonHelp extends JFrame implements ActionListener {
    ImageIcon errorIcon = new ImageIcon("errorLogo.png");
    ImageIcon notif = new ImageIcon("notif.png");
    ImageIcon complete = new ImageIcon("complete.png");
    JRadioButton radioButton1 = new JRadioButton("Error");
    JRadioButton radioButton2 = new JRadioButton("Notification");
    JRadioButton radioButton3 = new JRadioButton("Complete");
    RadioButtonHelp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        radioButton1.addActionListener(this);
        radioButton1.setIcon(errorIcon);

        radioButton2.addActionListener(this);
        radioButton2.setIcon(notif);

        radioButton3.addActionListener(this);
        radioButton3.setIcon(complete);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2); // To only select one item!
        group.add(radioButton3);

        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == radioButton1){
            System.out.println("Error");
        } else if (e.getSource() == radioButton2) {
            System.out.println("Notification");
        }else{
            System.out.println("Complete");
        }
    }
}
