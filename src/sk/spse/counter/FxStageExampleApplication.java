package sk.spse.counter;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FxStageExampleApplication extends Application {

    private Scene scene1;
    private Scene scene2;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        // Hlavne okno
        primaryStage.setTitle("Hlavný Sage - DECORATED");
        primaryStage.initStyle(StageStyle.DECORATED); // Predvolený štýl

        // Vytvorenie prvej scény
        VBox root1 = new VBox(20);
        root1.setAlignment(Pos.CENTER);
        root1.getChildren().addAll(
                new Label("Prvá Scéna - Modálne okná"),
                new Button("Otvor modálne okno (APPLICATION_MODAL)") {{
                    setOnAction(e -> openModalStage(primaryStage, Modality.APPLICATION_MODAL));
                }},
                new Button("Otvor modálne okno (WINDOW_MODAL)") {{
                    setOnAction(e -> openModalStage(primaryStage, Modality.WINDOW_MODAL));
                }},
                new Separator(Orientation.HORIZONTAL),
                new Button("Prepnúť na Druhú Scénu") {{
                    setOnAction(e -> primaryStage.setScene(scene2));
                }}
        );
        scene1 = new Scene(root1, 330, 200);

        // Vytvorenie druhej scény
        VBox root2 = new VBox(20);
        root2.setAlignment(Pos.CENTER);
        root2.getChildren().addAll(
                new Label("Druhá Scéna - Nemodálne okná"),
                new Button("Otvor nemodálne okno (DECORATED)") {{
                    setOnAction(e -> openNonmodalStage(primaryStage, StageStyle.DECORATED));
                }},
                new Button("Otvor nemodálne okno, (UNDECORATED)") {{
                    setOnAction(e -> openNonmodalStage(primaryStage, StageStyle.UNDECORATED));
                }},
                new Separator(Orientation.HORIZONTAL),
                new Button("Návrat na Prvú Scénu") {{
                    setOnAction(e -> primaryStage.setScene(scene1));
                }}
        );
        scene2 = new Scene(root2, 330, 200);

        // Nastavenie počiatočnej scény
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    private void openModalStage(Stage owner, Modality modality) {
        Stage stage = new Stage();
        stage.setTitle("Modálny Stage - DECORATED");
        stage.initModality(modality);
        stage.initStyle(StageStyle.DECORATED);

        VBox root = new VBox(20, new Label("Toto je modálne okno"),
                new Button("Otvor vnorené nemodálne okno") {{
                    setOnAction(e -> openNonmodalStage(stage, StageStyle.DECORATED));
                }}
        );
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 250, 150);
        stage.setScene(scene);

        stage.initOwner(owner); // Nastavenie vlastníka
        stage.show();

    }

    private void openNonmodalStage(Stage owner, StageStyle style) {
        Stage stage = new Stage();
        stage.setTitle("Nemodálny Stage");
        stage.initModality(Modality.NONE);
        stage.initStyle(style);

        VBox root = new VBox(20,
                new Label(String.format("Toto je nemodálne okno číslo %d", ++counter)),
                new Button("Zavrieť okno") {{
                    setOnAction(e -> stage.close());
                }}
        );
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 250, 150);
        stage.setScene(scene);

        stage.initOwner(owner); // Nastavenie vlastníka
        stage.show();
    }
}