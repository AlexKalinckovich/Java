import javax.swing.*;

public class JOptionPanePrac {
    public static void main(String[] args) {
        // JOptionPane = pop up a standard dialog box that prompts users for a value
        //               of informs them of something

        // JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null,"This is some useless info","title",JOptionPane.ERROR_MESSAGE);

        // JOptionPane.showConfirmDialog(null,"bor, do you even code?","This is my title",JOptionPane.YES_NO_CANCEL_OPTION); also return a value!
        // String name = JOptionPane.showInputDialog("What is your name?");
        String[] responses = {"No,you're awesome","thank you","*blush*"};
        ImageIcon icon = new ImageIcon("errorLogo.png");
        JOptionPane.showOptionDialog(null,
                "You are awesome!",
                "secret message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,icon,
                responses,0);

    }
}
