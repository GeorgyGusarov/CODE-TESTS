package Geekbrains_Java2.Lesson_4.JavaFXExample;

import javafx.fxml.*;
import javafx.scene.control.*;

public class Controller {
    @FXML
    TextArea textArea;
    @FXML
    TextField textField;

    public void sendMessage() {
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
}
