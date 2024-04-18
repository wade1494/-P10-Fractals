import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class FractalChoice extends JPanel {
    private int maxRecursiveDepth;
    public FractalChoice(int _maxRecursiveDepth) {
        this.maxRecursiveDepth = _maxRecursiveDepth;
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(600, 600);
		f.setLocation(200, 200);
		f.setVisible(true);
    }

    // What fractal are you drawing? Comment below
    // ...
    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
        turtle.setHeadingMode(Turtle.DEGREE);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 900, 700);
    }

    public static void main(String[] args) {
        new FractalChoice(Integer.parseInt(JOptionPane.showInputDialog(null, "Max recursive depth?")));
    }
}
