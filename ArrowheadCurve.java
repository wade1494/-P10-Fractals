import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class ArrowheadCurve extends JPanel {
	private int maxRecursiveDepth;

    public ArrowheadCurve(int _maxRecursiveDepth) {
		this.maxRecursiveDepth = _maxRecursiveDepth;
		// Create a JFrame - a window that will appear on your screen
		JFrame f = new JFrame();
		
		// Tells the program to quit if you close the window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Puts your drawing into the window (the JFrame)
		f.add(new JScrollPane(this));
		
		// Changes the size of the window on the screen
		f.setSize(1500,1000);
		
		// Changes where the window will appear on your screen
		f.setLocation(200, 200);
		
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

	public void drawArrowhead(int currentDepth, Turtle turtle, boolean isX) {
		if (currentDepth == this.maxRecursiveDepth) {
			// Base Case
			pickColor(turtle);
			return;
		} 
		else 
		{
			if (isX) 
			{
				drawArrowhead(currentDepth+1, turtle, false);
				turtle.forward(1);
				turtle.left(60);
				
				drawArrowhead(currentDepth+1, turtle, true);
				turtle.forward(1);
				turtle.left(60);
				
				drawArrowhead(currentDepth+1, turtle, false);
			} 
			else 
			{
				drawArrowhead(currentDepth+1, turtle, true);
				turtle.forward(1);
				turtle.right(60);
				
				drawArrowhead(currentDepth+1, turtle, false);
				turtle.forward(1);
				turtle.right(60);
				drawArrowhead(currentDepth+1, turtle, true);
				
			}
		}
		
	}

    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
		
        turtle.setHeadingMode(2);
		turtle.setHeading(120);
		turtle.changeColor(Color.red);

        g.setColor(Color.BLACK);
        g.fillRect(-150, -200, 5000, 5000);

		drawArrowhead(0, turtle, true);
		turtle.forward(1);
    }

    public static void main(String[] args) {
        new ArrowheadCurve(Integer.parseInt(JOptionPane.showInputDialog(null, "Max recursive depth?")));
    }
}
