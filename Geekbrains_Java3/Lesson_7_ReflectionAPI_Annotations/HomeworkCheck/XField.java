package Geekbrains_Java3.Lesson_7_ReflectionAPI_Annotations.HomeworkCheck;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XField {

}
