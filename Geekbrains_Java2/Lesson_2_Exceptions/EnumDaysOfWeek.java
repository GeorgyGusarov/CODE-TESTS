package Geekbrains_Java2.Lesson_2_Exceptions;

public class EnumDaysOfWeek {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        System.out.println(getWorkingHours(dayOfWeek));
    }

    public static String getWorkingHours(DayOfWeek dayOfWeek) {
        int workDays = 5 - dayOfWeek.ordinal();  // 5 - количество рабочих дней
        return (workDays > 0) ? String.valueOf(workDays * 8) + " hours" : "Weekend!";
        // если num > 0, то * на 8 и получаем кол-во дней иначе - выходной
    }
}

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
