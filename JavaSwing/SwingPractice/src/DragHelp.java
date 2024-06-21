import javax.swing.*;

public class DragHelp extends JFrame {
    DragPanel dragPanel = new DragPanel();
    DragHelp(){

        this.add(dragPanel);
        this.setTitle("Drag&Drop demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
