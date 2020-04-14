import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import jdk.internal.org.objectweb.asm.tree.analysis.Frame;

public class Tests {
    TextField text = new TextField(20);
    Button b;
    private int numClicks = 0;



    public Tests(String title) {
        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());
        // addWindowListener(this);
        b = new Button("Click me");
        frame.add(b);
        frame.add(text);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
            }
        });
        frame.setSize(350,100);
        frame.setVisible(true);
    }

    // public void actionPerformed(ActionEvent e) {
    //     numClicks++;
    //     text.setText("Button Clicked " + numClicks + " times");
    // }

    // public void windowClosing(WindowEvent e) {
    //     dispose();
    //     System.exit(0);
    // }

    // public void windowOpened(WindowEvent e) {}
    // public void windowActivated(WindowEvent e) {}
    // public void windowIconified(WindowEvent e) {}
    // public void windowDeiconified(WindowEvent e) {}
    // public void windowDeactivated(WindowEvent e) {}
    // public void windowClosed(WindowEvent e) {}

    public static void main(String[] args) {
        Tests myWindow = new Tests("My first window");
    }
}