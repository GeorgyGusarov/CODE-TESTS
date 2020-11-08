package Geekbrains_Java2.Lesson_4;

import javax.swing.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java Swing");
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        button1.setBounds(50,60,80,80);
        button2.setBounds(150,60,80,80);

        setResizable(false);

        add(button1);
        add(button2);
    }
}

class MyWindowTest {
    public static void main(String[] args) {
        new MyWindow();
    }
}