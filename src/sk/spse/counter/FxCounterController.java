package sk.spse.counter;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller pre FXML súbor – obsahuje logiku počítadla
 */
public class FxCounterController {

    // Premenná počítadla (začína na 0)
    private int counter = 0;

    // Odkaz na TextField z FXML (musí mať rovnaké fx:id)
    @FXML
    private TextField counterField;

    /**
     * Metóda, ktorá sa automaticky zavolá po kliknutí na tlačidlo +
     * (onAction="#incrementCounter" v FXML)
     */
    @FXML
    private void incrementCounter() {
        counter++;                           // zvýšime počítadlo
        counterField.setText(String.valueOf(counter));  // aktualizujeme zobrazenie
    }
}