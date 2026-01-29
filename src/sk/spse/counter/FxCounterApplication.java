package sk.spse.counter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxCounter extends Application {

    private int counter = 0;

    @Override
    public void start(Stage stage) {

        // Label
        Label label = new Label("Counter:");
        label.setStyle("-fx-font-size: 24px;");

        // TextField
        TextField textField = new TextField("0");
        textField.setEditable(false);
        textField.setPrefColumnCount(4);
        textField.setStyle("""
            -fx-font-size: 24px;
            -fx-padding: 10 20 10 20;
        """);

        // Button
        Button button = new Button("+");
        button.setStyle("-fx-font-size: 24px;");

        button.setOnAction(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });

        // Layout: zľava doprava
        HBox root = new HBox(20, label, textField, button);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root);
        stage.setTitle("JavaFX Counter");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void start(String[] args) {
        launch(args);
    }

    public static void main(final String[] args) {
        FxCounter.start(args);
    }

}
