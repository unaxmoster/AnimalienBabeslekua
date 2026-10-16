
package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.controller.AnimaliaController;

public class EzabatuView extends VBox {

    public EzabatuView(
            AnimaliaController controller,
            Runnable onAnimaliaEzabatuta) {

        super(10);
        this.setPadding(new Insets(20));

        Label titulua = new Label("EZABATU ANIMALIA");

        TextField izena = new TextField();
        izena.setPromptText("Animaliaren izena");

        Button ezabatu = new Button("EZABATU");

        ezabatu.setOnAction(e -> {
            String izenaText = izena.getText().trim();

            if (izenaText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Abisua");
                alert.setHeaderText(null);
                alert.setContentText("Idatzi animaliaren izena.");
                alert.showAndWait();
                return;
            }

            boolean ezabatuta =
                    controller.ezabatuAnimalia(izenaText);

            if (ezabatuta) {
                onAnimaliaEzabatuta.run();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informazioa");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Ez da izen horretako animaliarik aurkitu."
                );
                alert.showAndWait();
            }
        });

        this.getChildren().addAll(titulua, izena, ezabatu);
    }
}
