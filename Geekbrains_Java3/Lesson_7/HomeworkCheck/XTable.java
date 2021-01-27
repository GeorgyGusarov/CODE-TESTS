package Geekbrains_Java3.Lesson_7.HomeworkCheck;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface XTable {
    String name();
}
