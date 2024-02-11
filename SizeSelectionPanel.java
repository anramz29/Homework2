import javax.swing.*;


public class SizeSelectionPanel extends JPanel {
    // initialize a combo box, as it's better suited for the task
    private JComboBox<String> sizeBox;


    public SizeSelectionPanel() {
        // create and array of sizes
        String[] sizes = {"Small", "Medium", "Large", "Super"};
        // add them to the size box
        sizeBox = new JComboBox<>(sizes);
        add(sizeBox);
    }

// using get and set methods in order to return a private string, this will be used in the Price Display Panel
    public String getSelectedSize() {
        return (String) sizeBox.getSelectedItem();
    }
}

