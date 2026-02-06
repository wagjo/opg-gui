package sk.spse.counter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxCounterFxmlApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Načítame FXML súbor
        FXMLLoader fxmlLoader = new FXMLLoader(FxCounterFxmlApplication.class.getResource("counter-view.fxml"));

        // root bude HBox definovaný vo FXML
        Parent root = fxmlLoader.load();

        // Vytvoríme scénu
        Scene scene = new Scene(root);

        // Nastavenia okna
        stage.setTitle("JavaFX FXML Counter");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(325);

        // Zobrazíme okno
        stage.show();
        stage.setMinHeight(165);
    }
}