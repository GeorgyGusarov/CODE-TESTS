package Other;

import java.util.Calendar;
import java.util.Date;

public class TestFormats {
    public static void main(String[] args) {
        String s = String.format("%, d", 1000000000); // %,d - вставляем запятые (пробел) и форматируем число как десятичное целое
        System.out.println(s);

        String s2 = String.format("Мне нужно исправить %.2f ошибки.", 476578.09876); // %.2f - форматируем число как дробное с двумя знаками после запятой
        System.out.println(s2);

        String s3 = String.format("Мне нужно исправить %,.2f ошибки", 476578.09876); // %,.2f - вставляем запятые (пробел) и форматируем число как дробное с точностью два десятичных знака
        System.out.println(s3);

        String s4 = String.format("%,6.1f", 42.000);
        System.out.println(s4);

        String s5 = String.format("%.2f", 42.000000);
        System.out.println(s5);

        String s6 = String.format("%x", 42);
        System.out.println(s6);

        String s7 = String.format("%c", 42);
        System.out.println(s7);

        int one = 20456654;
        double two = 100567890.248907;
        String s8 = String.format("Уровень %,d из %,.2f", one, two);
        System.out.println(s8);

        Date today = new Date(); // полная дата
        String.format("%tc", today);
        System.out.println(today);

        Date today2 = new Date(); // только время
        String.format("%tr", today2);
        System.out.println(today2);

        Date today3 = new Date(); // день недели, месяц и число
        String.format("%tA, %tB %td", today3, today3, today3);
        System.out.println(today3);

        Date today4 = new Date(); // тоже что и выше, но короче
        String.format("%tA, %<tB %<td", today4);
        System.out.println(today4);

        System.out.println(" ");
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime()); // получение текущей полной даты

        c.set(2004, 0, 7, 15, 40);
        System.out.println(" ");
        System.out.println("Установлена дата: " + c.getTime());

        long day1 = c.getTimeInMillis();
        day1 += 1000 * 60 * 60; // day1 = day1 + ...

        c.setTimeInMillis(day1);
        System.out.println("Новый час " + c.get(c.HOUR_OF_DAY));

        c.add(c.DATE, 35);
        System.out.println("Добавить 35 дней: " + c.getTime());

        c.roll(c.DATE, 35);
        System.out.println("Прокрутить 35 дней: " + c.getTime());

        c.set(c.DATE, 1);
        System.out.println("Установить дату в 1: " + c.getTime());
    }
}
