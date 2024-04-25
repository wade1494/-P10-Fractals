import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class GosperCurve extends JPanel {
    private int maxRecursiveDepth;
    public GosperCurve(int _maxRecursiveDepth) {
        this.maxRecursiveDepth = _maxRecursiveDepth;
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(600, 600);
		f.setLocation(200, 200);
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
    public void gosperCurve(int currentDepth, Turtle turtle, boolean isX)
    {
        if (currentDepth == this.maxRecursiveDepth) {
			// Base Case
			pickColor(turtle);
			return;
		} 
        else
        {
            if (isX)
            {
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.right(60);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                turtle.right(120);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                turtle.left(60);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.left(120);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.left(60);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                turtle.right(60);
            }
            else
            {
                turtle.left(60);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.right(60);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                turtle.right(60);
                turtle.right(60);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
                turtle.right(60);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.left(120);
                gosperCurve(currentDepth+1, turtle, true);
                turtle.forward(0.3);
                turtle.left(60);
                gosperCurve(currentDepth+1, turtle, false);
                turtle.forward(0.3);
            }
        }
    }
    // What fractal are you drawing? Comment below
    // DragonCurve

    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
        turtle.setHeadingMode(Turtle.DEGREE);

        g.setColor(Color.BLACK);
        g.fillRect(-1000, 0, 3000, 3000);
        gosperCurve(0, turtle, true);
    }

    public static void main(String[] args) {
        new GosperCurve(Integer.parseInt(JOptionPane.showInputDialog(null, "Max recursive depth?")));
    }
}
