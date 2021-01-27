package Geekbrains_Java3.Lesson_7;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class c = ReflectionCatTest.class;
        Field[] fields = c.getDeclaredFields();

        for (Field o: fields) {
            System.out.println(o);
        }

        ReflectionCatTest cat = new ReflectionCatTest("Felix", "white", 2);
        Class cc = ReflectionCatTest.class;
        cat.info1();
        Field field = cc.getDeclaredField("age");
        field.setAccessible(true);
        field.set(cat, 10);
        cat.info1();

        Method m = cc.getDeclaredMethod("info2");
        m.setAccessible(true);
        m.invoke(cat);

        Field field1 = cc.getDeclaredField("color");
        int modifiers = field1.getModifiers();
        if (Modifier.isPublic(modifiers)) System.out.println(cc.getSimpleName() + " is public.");

        Class cc2 = ReflectionCatTest.class;
        ReflectionCatTest cat2 = new ReflectionCatTest("Gerald", "green", 3);
        Method[] methods = cc2.getDeclaredMethods();
        for (Method o : methods) {
            if (o.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println(o.getAnnotation(MyAnnotation.class).priority());
                o.invoke(cat2); // аннотация есть только у info1(), поэтому вывод будет info1:....
            }
        }
    }
}
