package Geekbrains_Java3.Lesson_7;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // данная аннотация будет доступна в момент выполнения работы (runtime)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    int priority() default 5;
}
