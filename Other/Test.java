package Other;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        // зеркальное отражение битов примитива. 0 = 1, 1 = 0
        int x = 342;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(~x) + "\n");

        // сдвиг битов направо на указанное кол-во знаков
        int x2 = -342;
        System.out.println(Integer.toBinaryString(x2));
        int y = x2 >> 2;
        System.out.println(Integer.toBinaryString(y) + "\n");

        // same, но заполняет нулями либо значением
        int x3 = -342;
        System.out.println(Integer.toBinaryString(x3));
        int y2 = x3 >>> 4;
        System.out.println(Integer.toBinaryString(y2) + "\n");

        // оператор контроля
        int height = 1;
        int weight = 1;
        assert (height > 0); // если выражение будет false - вернет ошибку
        assert (height > 0) : "height = " + height + "weight = " + weight;

        // связанные вызовы
        StringBuffer sb = new StringBuffer("весна");
        sb = sb.delete(3, 6).insert(2, "л").deleteCharAt(1);
        System.out.println("sb = " + sb);
        // простой пример
        StringBuffer sbEasy = new StringBuffer("весна");
        sbEasy = sbEasy.deleteCharAt(0);
        sbEasy = sbEasy.insert(0, "л");
        sbEasy = sbEasy.delete(2, 5);
        sbEasy = sbEasy.append("то");
        System.out.println("sbEasy = " + sbEasy);
    }
}

class TestAnonClass {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JButton button = new JButton("клик");
        frame.getContentPane().add(button);

        // анонимный вложенный класс
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
