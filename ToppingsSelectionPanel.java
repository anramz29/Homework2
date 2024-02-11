import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class ToppingsSelectionPanel extends JPanel {
    // creating an array list that will append to the Toppings Selection Panel below
    private final List<JCheckBox> toppingCheckBoxes = new ArrayList<>();
    // Creating another list that I will iterate over and append
    private static final String[] TOPPINGS = {"Olives", "Mushrooms", "Pepperoni",
            "Bacon", "Sausage", "Green Onions", "Onions", "Pineapple", "Barbecue Sauce",
            "Basil", "Prosciutto","Margarita","Extra Cheese"};
    // I'll specify amount of max toppings
    private static final int MAX_TOPPINGS = 3;
    // create a warning label that is trigger if toppings > max toppings
    private JLabel warningLabel = new JLabel("");
    // Specify the index of cheese so that we can feed it into the Price Display class accordingly
    private final int extraCheeseIndex = TOPPINGS.length - 1;


    public ToppingsSelectionPanel() {
        setLayout(new GridLayout(2, 1)); // Set layout to GridLayout
        // for loop over toppings array
        for (String topping : TOPPINGS) {
            JCheckBox checkBox = new JCheckBox(topping);
            // I'm personally a big fan of lambda expressions,
            // State Change Returns the type of state change (selected or deselected).
            // documentation used : https://docs.oracle.com/javase/8/docs/api/java/awt/event/ItemEvent.html
            checkBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED || e.getStateChange() == ItemEvent.DESELECTED) {
                    checkToppingsCount();
                }
            });
            toppingCheckBoxes.add(checkBox); // here we appending the checked boxes to
            add(checkBox); // adding up the checked boxes to be used in latter classes
        }
        add(warningLabel); // getting the warning label to be used in checkToppings count
    }

    private void checkToppingsCount() {
        warningLabel.setForeground(Color.RED);
        // using the dot stream and count to continuously check length of toppings count
        byte selectedCount = (byte) toppingCheckBoxes.stream().filter(AbstractButton::isSelected).count();
        if (selectedCount > MAX_TOPPINGS) { // Self Explanatory
            warningLabel.setText("Too many toppings! Only 3 allowed.");
        } else {
            warningLabel.setText("");
        }
    }

    // Now we check if the extra cheese index is in the toppingsCheckBoxes Array so that we can call
    public boolean isExtraCheeseSelected() {
        return toppingCheckBoxes.get(extraCheeseIndex).isSelected();
    }

    // return a byte of the number of toppings selected
    public byte getSelectedToppingsCount() {
        return (byte) toppingCheckBoxes.stream().filter(AbstractButton::isSelected).count();
    }
}
