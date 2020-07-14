package GUI;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        /**
         * отрисовка квадрата
         */
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);

        /**
         * отрисовка картинки
         */
        Image image = new ImageIcon("example.jpg").getImage();
        g.drawImage(image, 3, 4, this);

        /**
         * отрисовка круга на чёрном фоне
         */
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);

        /**
         * отрисовка градиентного круга Graphics2D
         */
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150 ,150, Color.orange);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);

        /**
         * то же, что и выше, но цвета для градиента рандомны
         */
        Graphics2D graphics2D = (Graphics2D) g;
        int red2 = (int) (Math.random() * 255);
        int green2 = (int) (Math.random() * 255);
        int blue2 = (int) (Math.random() * 255);
        Color startColor = new Color(red2, green2, blue2);
        red2 = (int) (Math.random() * 255);
        green2 = (int) (Math.random() * 255);
        blue2 = (int) (Math.random() * 255);
        Color endColor = new Color(red2, green2, blue2);
        GradientPaint gradientPaint = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillOval(70, 70, 100, 100);
    }
}
