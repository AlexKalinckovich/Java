import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxHelp extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("errorLogo.png");
    ImageIcon checkIcon = new ImageIcon("complete.png");
    JCheckBox checkBox = new JCheckBox();
    JButton button = new JButton("Press me!");
    CheckBoxHelp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button.addActionListener(this);

        checkBox.setText("I'm not a robot!");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas",Font.PLAIN,35));
        checkBox.setIcon(checkIcon);
        checkBox.setSelectedIcon(icon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println(checkBox.isSelected());
        }
    }
}
