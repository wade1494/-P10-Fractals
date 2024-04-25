import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class ZOrderCurve extends JPanel {
    private int maxRecursiveDepth;
    public ZOrderCurve(int _maxRecursiveDepth) {
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
    // 
    public void zOrderCurve(int currentDepth, Turtle turtle, boolean isX)
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
                zOrderCurve(currentDepth+1, turtle, true);
                turtle.left(45);
                turtle.forward(10);
                zOrderCurve(currentDepth+1, turtle, true);
                turtle.right(45);
                turtle.forward(10);
                zOrderCurve(currentDepth+1, turtle, false);
            }
            else
            {
                
            }
            
        }
    }
    // What fractal are you drawing? Comment below
    // DragonCurve

    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
        turtle.setHeadingMode(Turtle.DEGREE);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 3000, 3000);
        zOrderCurve(0, turtle);

    }

    public static void main(String[] args) {
        new ZOrderCurve(Integer.parseInt(JOptionPane.showInputDialog(null, "Max recursive depth?")));
    }
}
