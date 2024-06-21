import javax.swing.*;
import java.awt.*;

public class GraphicsPracHelp extends JFrame {

    GraphicsPanel panel = new GraphicsPanel();
    GraphicsPracHelp(){
        this.setLocationRelativeTo(null);
        this.setSize(500,500);

        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
