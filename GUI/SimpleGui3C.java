package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
    JFrame frame;
    JButton button;

    public static void main(String[] args) {
        SimpleGui3C gui3C = new SimpleGui3C();
        gui3C.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel3C drawPanel = new MyDrawPanel3C();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
        //button.setText("I've been pressed!");
        System.out.println("I've been pressed!");
    }
}

class MyDrawPanel3C extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }
}
