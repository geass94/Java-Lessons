package ge.itstep.demo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.qos.logback.core.joran.action.ActionUtil;

public class ClassWork20 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Listener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        JButton button = new JButton("Click me");
        

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Button was clicked");
            }
        };

        button.addActionListener(listener);
        
        frame.add(button);
        frame.setVisible(true);

    }
}
