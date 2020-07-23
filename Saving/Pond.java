package Saving;

import java.io.*;
public class Pond implements Serializable {

    transient private Duck duck = new Duck(); // transient позволяет пропустить объект при сериализации

    public static void main(String[] args) {
        Pond pond = new Pond();

        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(pond); // при сериализации pond сериализуется и Duck, но если Duck не implements Serializable, то будет ошибка
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}