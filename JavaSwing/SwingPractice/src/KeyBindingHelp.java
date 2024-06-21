import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyBindingHelp {
    JFrame frame;
    JLabel label;
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    KeyBindingHelp(){
        frame = new JFrame("KeyBinding");
        frame.setSize(420,420);
        frame.setLayout(null);

        label = new JLabel();
        label.setBackground(Color.red);
        label.setBounds(100,100,100,100);
        label.setOpaque(true);

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
        label.getActionMap().put("upAction",upAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        label.getActionMap().put("downAction",downAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"leftAction");
        label.getActionMap().put("leftAction",leftAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"rightAction");
        label.getActionMap().put("rightAction",rightAction);

        frame.add(label);
        frame.setVisible(true);
    }

    public class   UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation(label.getX(),label.getY() - 5);
        }
    }

    public class   DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation(label.getX(),label.getY() + 5);
        }
    }

    public class   LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation(label.getX() - 5,label.getY());
        }
    }

    public class   RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation(label.getX() + 5,label.getY());
        }
    }
}
