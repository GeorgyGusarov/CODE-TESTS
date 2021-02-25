package Geekbrains_Java2.Lesson_4_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow2 extends JFrame {
    public MyWindow2() throws HeadlessException {
        setTitle("Java Swing2");
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button1");
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button2");
            }
        });

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(button1);
        panel.add(button2);

        add(panel, BorderLayout.SOUTH);
    }
}

class MyWindow2Test {
    public static void main(String[] args) {
        new MyWindow2();
    }
}
