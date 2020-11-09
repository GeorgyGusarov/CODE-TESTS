package Geekbrains_Java2.Lesson_4.JavaFXExample;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 350, 385));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
