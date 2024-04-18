import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class LevyCurve extends JPanel {
    private JFrame f;
    private int maxRecursiveDepth;

    public LevyCurve(int _maxRecursiveDepth) {
		// Create a JFrame - a window that will appear on your screen
		this.f = new JFrame();
		this.maxRecursiveDepth = _maxRecursiveDepth;
		// Tells the program to quit if you close the window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Puts your drawing into the window (the JFrame)
		f.add(new JScrollPane(this));
		
		// Changes the size of the window on the screen
		f.setSize(1024,600);
		
		// Changes where the window will appear on your screen
		f.setLocation(0,0);
		
		// Makes the window appear
		f.setVisible(true);
    }

    private void pickColor(Turtle t) {
        Random rng = new Random();
        int colorPicker = rng.nextInt(4);
        if (colorPicker == 0) {
            t.changeColor(Color.CYAN);
        } else if (colorPicker == 1) {
            t.changeColor(Color.YELLOW);
        } else if (colorPicker == 2) {
            t.changeColor(Color.MAGENTA);
        } else {
            t.changeColor(Color.GREEN);
        }
    }

    private void drawLevy(Turtle t, int currentDepth) {
        if (currentDepth == this.maxRecursiveDepth) {
            // Base case

            // Pick a new random color before we draw a line!
            pickColor(t);

            // In order to make the fractal "fit" in the window
            // as the recursive depth gets bigger, it is useful to make
            // the line length inversely proportional to the depth.
            // This will be a useful pattern to follow for the other
            // fractals.
            t.forward(100/this.maxRecursiveDepth);

            // return void method so that the recursion "unwinds"
            return;
        } else {
            t.left(45);
            drawLevy(t, currentDepth + 1);
            t.right(90);
            drawLevy(t, currentDepth + 1);
            t.left(45);
            // Complete the else statement for the recursive case.
            // Use the Lindenmayer system described in the doc.
            // Remember you must do the recursive call with the depth
            // variable moving towards the base case, otherwise you will
            // have infinite recursion!


        }
    }

    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
        turtle.setHeadingMode(Turtle.DEGREE);
        turtle.setxy(-150,-150);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, f.getWidth(), f.getHeight());
        turtle.changeColor(Color.white);
        
        drawLevy(turtle, 0);
        
    }

    public static void main(String[] args) {
        // Show a dialog asking for the desired max recursive depth.
        new LevyCurve(Integer.parseInt(JOptionPane.showInputDialog(null, "Max recursive depth?")));
    }
}
