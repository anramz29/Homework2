import javax.swing.*;
import java.awt.*;

public class PizzaOrderApp extends JFrame {
    public PizzaOrderApp() {
        // Creating Title, Setting Size, and Layout
        setTitle("BigY Store Pizza Order");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Initialize SizeSelectionPanel
        SizeSelectionPanel sizeSelectionPanel = new SizeSelectionPanel();

        sizeSelectionPanel.setBackground(new Color(235, 235, 235)); // Light gray

        // Initialize ToppingsSelectionPanel
        ToppingsSelectionPanel toppingsSelectionPanel = new ToppingsSelectionPanel();

        // initialized SizeSelectionPanel to PriceDisplayPanel Method
        PriceDisplayPanel priceDisplayPanel = new PriceDisplayPanel(toppingsSelectionPanel, sizeSelectionPanel);

        // create an instance of Pizza Photo Panel using an Image Path
        String imagePath = "/Users/adrian/Desktop/PizzaCartoon.jpeg";
        PizzaPhotoPanel pizzaPhotoPanel = new PizzaPhotoPanel(imagePath);
        toppingsSelectionPanel.setPreferredSize(new Dimension(toppingsSelectionPanel.getPreferredSize().width, 120));


        // Create a new panel for the NORTH region and add two components
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(priceDisplayPanel);
        southPanel.add(sizeSelectionPanel);


        // Methods to JFrame, and Use the Boarder Layout
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(pizzaPhotoPanel, BorderLayout.CENTER);
        this.add(toppingsSelectionPanel, BorderLayout.NORTH);
        setVisible(true);
    }
    // call main class
    public static void main(String[] args) {
        new PizzaOrderApp();
    }
}
