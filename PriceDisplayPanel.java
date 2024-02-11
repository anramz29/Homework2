import javax.swing.*;
import java.awt.*;

public class PriceDisplayPanel extends JPanel {
    // here im initializing all the elements in the price display section of GUI
    private JLabel totalPriceLabel = new JLabel("Total Price: $0.00");
    private JButton calculateButton;

    private JTextField offer;
    private ToppingsSelectionPanel toppingsSelectionPanel;
    private SizeSelectionPanel sizeSelectionPanel;

    // calling the Price Display Panel class, using inputs from other methods obtain info
    public PriceDisplayPanel(ToppingsSelectionPanel toppingsSelectionPanel, SizeSelectionPanel sizeSelectionPanel) {
        // We are now accessing instance variables
        this.sizeSelectionPanel = sizeSelectionPanel;
        this.toppingsSelectionPanel = toppingsSelectionPanel;
        // Create our Calculate Button
        calculateButton = new JButton("Calculate Price");
        // Create a new layout for the objects
        setLayout(new BorderLayout());
        // Creativity, I added a Deal of the Day that takes 5 dollars off a pizza
        offer = new JTextField("Deal of the Day: Get Five Dollars Off a Large Extra Cheese Pizza!");
        offer.setEditable(false); // setting these text fields as false
        offer.setOpaque(false);
        calculateButton.addActionListener(e -> calculatePrice());
        totalPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // make sure price is properly aligned


        // Here im building a panel to hold the calculate button in
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue()); // Need to specify create Horizontal glue twice
        buttonPanel.add(calculateButton);
        buttonPanel.add(Box.createHorizontalGlue());

        // Here I am specifying the locations of the bottom panels.
        add(buttonPanel, BorderLayout.CENTER);
        add(totalPriceLabel, BorderLayout.SOUTH);
        add(offer, BorderLayout.NORTH);
    }

    private void calculatePrice() {
        double basePrice = 0; // base price if nothing selected
        double toppingsPrice = 0; // base pizza price if toppings are not selected

        // Calculate base price based on selected size
        String selectedSize = sizeSelectionPanel.getSelectedSize();
        if ("Small".equals(selectedSize)) { // using else if statements to return selected size
            basePrice = 5;
        } else if ("Medium".equals(selectedSize)) {
            basePrice = 10;
        } else if ("Large".equals(selectedSize)) {
            basePrice = 15;
        } else if ("Super".equals(selectedSize)) {
            basePrice = 20;
        }
        // Calculate toppings price based on the number of toppings
        long selectedToppingsCount = toppingsSelectionPanel.getSelectedToppingsCount();
        // the first if statement is to filter out the deal of the day.
        if (selectedToppingsCount == 1 && toppingsSelectionPanel.isExtraCheeseSelected()) {
            toppingsPrice = -5.00;
        // The rest of these statements are calculating the price for each topping count
        } else if (selectedToppingsCount == 1) {
            toppingsPrice = 0.50;
        } else if (selectedToppingsCount == 2) {
            toppingsPrice = 1.00;
        } else if (selectedToppingsCount == 3) {
            // Checking if cheese is selected and removing that price from the final price
            boolean extraCheeseSelected = toppingsSelectionPanel.isExtraCheeseSelected();
            toppingsPrice = extraCheeseSelected ? 1.00 : 1.25; //Evaluates the boolean expression
        }

        // Calculate total price
        double totalPrice = basePrice + toppingsPrice;

        // Write total Price label, and rounds to two decimals
        totalPriceLabel.setText(String.format("Total Price: $%.2f", totalPrice));

    }
}