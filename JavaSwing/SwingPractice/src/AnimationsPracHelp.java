import javax.swing.*;

public class AnimationsPracHelp extends JFrame {
    AnimationsPanel panel;
    AnimationsPracHelp(){
        panel = new AnimationsPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(panel);

        this.pack();
        this.setVisible(true);
    }
}
