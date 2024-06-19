import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpBtPracClass extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    HelpBtPracClass(){

        ImageIcon icon = new ImageIcon("errorLogo.png");


        label = new JLabel();
        label.setIcon(icon);
        label.setBounds(200,200,200,50);
        label.setVisible(false);
        label.setText("I'm pressed!");

        button = new JButton();
        button.setBounds(100,100,200,100);
        button.addActionListener(this);
        button.setText("I'm a button!");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.magenta);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        this.setLayout(null);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Foo");
            label.setVisible(true);
        }
    }
}
