package sk.spse.counter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxZOrderApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        // Tlačidlo 1 – najspodnejšie
        Button btn1 = new Button("Tlačidlo 1 (najspodnejšie)");
        btn1.setPrefSize(220, 80);
        btn1.setLayoutX(20);
        btn1.setLayoutY(20);

        // Tlačidlo 2 – uprostred
        Button btn2 = new Button("Tlačidlo 2 (stred)");
        btn2.setPrefSize(200, 90);
        btn2.setLayoutX(50);
        btn2.setLayoutY(70);

        // Tlačidlo 3 – najvrchnejšie
        Button btn3 = new Button("Tlačidlo 3 (najvrchnejšie)");
        btn3.setPrefSize(180, 100);
        btn3.setLayoutX(80);
        btn3.setLayoutY(120);

        // Pridávame v poradí odspodu nahor
        pane.getChildren().addAll(btn1, btn2, btn3);

        Scene scene = new Scene(pane, 300, 240);

        primaryStage.setTitle("Z-order – poradie vrstiev v Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
