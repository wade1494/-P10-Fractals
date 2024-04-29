import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;
import java.awt.*;

public class FractalMilestone5 extends JPanel
{
    private int maxRecursiveDepth;
    public FractalMilestone5() {
        this.maxRecursiveDepth = 7;
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(600, 600);
		f.setLocation(200, 200);
		f.setVisible(true);
    }
    public void snowflake(int currentDepth, Turtle turtle)
    {
        if (currentDepth == this.maxRecursiveDepth) 
        {
            turtle.changeColor(Color.white);
            turtle.forward(10);
            return;
        }
        else
        {
            snowflake(currentDepth + 1, turtle);
            turtle.forward(2);
            turtle.left(60);
            snowflake(currentDepth + 1, turtle);
            turtle.forward(2);
            turtle.right(120);
            snowflake(currentDepth + 1, turtle);
            turtle.forward(2);
            turtle.left(60);
            snowflake(currentDepth + 1, turtle);
            turtle.forward(2);
            turtle.right(60);
        }
    }
    //Land
    public void hilbertCurve(int currentDepth, Turtle turtle, boolean isX)
    {
        if (currentDepth == 11) {
			// Base Case
            turtle.changeColor(new Color(139, 69, 19));
			return;
		} 
        else
        {
            if (isX)
            {
                turtle.left(90);
                hilbertCurve(currentDepth + 1, turtle, false);
                turtle.forward(0.3);
                turtle.left(90);
                hilbertCurve(currentDepth + 1, turtle, true);
                turtle.forward(0.3);
                hilbertCurve(currentDepth + 1, turtle, true);
                turtle.left(90);
                turtle.forward(0.3);
                hilbertCurve(currentDepth + 1, turtle, false);
                turtle.left(90);
            }
            else
                {
                    turtle.right(90);
                    hilbertCurve(currentDepth + 1, turtle, true);
                    turtle.forward(10);
                    turtle.right(90);
                    hilbertCurve(currentDepth + 1, turtle, false);
                    turtle.forward(10);
                    hilbertCurve(currentDepth + 1, turtle, false);
                    turtle.right(90);
                    turtle.forward(10);
                    hilbertCurve(currentDepth + 1, turtle, true);
                    turtle.right(90);
                }
            }
        }
        
        //I draw snowy day with a snowflake and a hilbert curve representing the ground.
        protected void paintComponent(Graphics g) 
        {
        super.paintComponent(g);
        Turtle turtle1 = new Turtle((Graphics2D) g, getBounds());
        Turtle turtle2 = new Turtle((Graphics2D) g, getBounds());
        Turtle turtle3 = new Turtle((Graphics2D) g, getBounds());
        Turtle turtle4 = new Turtle((Graphics2D) g, getBounds());
        Turtle turtle5 = new Turtle((Graphics2D) g, getBounds());
        Turtle turtleGround = new Turtle((Graphics2D) g, getBounds());
        turtle1.setHeadingMode(Turtle.DEGREE);
        turtle2.setHeadingMode(Turtle.DEGREE);
        turtle3.setHeadingMode(Turtle.DEGREE);
        turtle4.setHeadingMode(Turtle.DEGREE);
        turtle5.setHeadingMode(Turtle.DEGREE);
        turtleGround.setHeadingMode(Turtle.DEGREE);
        turtleGround.setHeading(180);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 5000, 5000);
        turtle1.setXY(-700, 300);
        turtle2.setXY(-1500, 200);
        turtle3.setXY(1500, 100);
        turtle4.setXY(400, 500);
        turtle5.setXY(300, 50);
        turtleGround.setXY(-1800, -700);
        snowflake(0, turtle1);
        snowflake(0, turtle2);
        snowflake(0, turtle3);
        snowflake(0, turtle4);
        snowflake(0, turtle5);
        hilbertCurve(0, turtleGround, false);
    }

    public static void main(String[] args) 
    {
        new FractalMilestone5();
    }
}