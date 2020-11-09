package Geekbrains_Java2.Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyWindow3 extends JFrame {
    public MyWindow3() {
        setTitle("Online Chat");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JTextArea textArea = new JTextArea();
        JTextField textField = new JTextField();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton button = new JButton("Send");

        bottomPanel.setBackground(Color.gray);
        centerPanel.setBackground(Color.lightGray);

        bottomPanel.setPreferredSize(new Dimension(1, 40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        bottomPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        bottomPanel.add(textField);
        bottomPanel.add(button);
        textField.setPreferredSize(new Dimension(300, 28));
        textArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
//                textField.grabFocus();
            }
        });
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println(1);
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
//                    textField.grabFocus();
                }
            }
        });

        setVisible(true);
    }
}

class MyWindow3Test {
    public static void main(String[] args) {
        new MyWindow3();
    }
}
