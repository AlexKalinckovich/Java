import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxHelp extends JFrame implements ActionListener {

    JComboBox comboBox;


    ComboBoxHelp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog","cat","bird"};
        comboBox = new JComboBox<>(animals);
        comboBox.addActionListener(this);
        comboBox.setEditable(true);
        comboBox.addItem("horse");
        comboBox.insertItemAt("pig",0);
        comboBox.setSelectedIndex(0);

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox){
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
