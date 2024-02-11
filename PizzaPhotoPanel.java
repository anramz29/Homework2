import javax.swing.JPanel; // Import JPanel for the GUI
import java.awt.Graphics; // Needed for drawing stuff
import javax.imageio.ImageIO; // This is for reading images
import java.io.File; // For file operations
import java.awt.image.BufferedImage; // To hold the image
import java.io.IOException; // For handling errors

public class PizzaPhotoPanel extends JPanel {
    BufferedImage pizzaImage; // This is where we'll store our image

    public PizzaPhotoPanel(String imagePath) {
        loadImage(imagePath); // Call loadImage when creating an instance
    }

    // I made a method to load images, kind of like using a library in Python
    public void loadImage(String imagePath) {
        try {
            File imageFile = new File(imagePath); // Make a File object
            pizzaImage = ImageIO.read(imageFile); // Read the image
        } catch (IOException e) {
            System.out.println("Error loading the image."); // Print an error message if something goes wrong
            e.printStackTrace(); // This prints more error info, saw it in a tutorial
        }
    }
    // Now we draw the photo on to the frame
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // I think this is like calling the base class in Python
        if (pizzaImage != null) {
            g.drawImage(pizzaImage, 0, 0, getWidth(), getHeight(), null); // Draw the image to fit the panel
        }
    }
}
