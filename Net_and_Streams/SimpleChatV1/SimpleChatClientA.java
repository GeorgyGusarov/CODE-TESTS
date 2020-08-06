package Net_and_Streams.SimpleChatV1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        SimpleChatClientA chat = new SimpleChatClientA();
        chat.go();
    }

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();

        outgoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetworking();

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setUpNetworking() {

        try {
            socket = new Socket("192.168.0.1", 4242);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                writer.println(outgoing.getText());
                writer.flush();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText(" ");
            outgoing.requestFocus();
        }
    }
}
