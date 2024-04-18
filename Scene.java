import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lrdev.turtle.Turtle;

public class Scene extends JPanel {
    public Scene() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(600, 600);
		f.setLocation(200, 200);
		f.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        Turtle turtle = new Turtle((Graphics2D) g, getBounds());
        turtle.setHeadingMode(Turtle.DEGREE);

        // You can change the background color by changing the next line
        // Choices (Color.*): RED , GREEN , BLUE , MAGENTA , CYAN , YELLOW , BLACK , WHITE , GRAY , DARK_GRAY , LIGHT_GRAY , ORANGE , and PINK
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 900, 700);
    }

    public static void main(String[] args) {
        //  You do not need to ask for a recursive depth here
        new Scene();
    }
}
