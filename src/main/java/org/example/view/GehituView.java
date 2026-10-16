
package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.controller.AnimaliaController;
import org.example.model.Animalia;
import org.example.model.Katua;
import org.example.model.Txakurra;
import org.example.model.Untxia;

public class GehituView extends VBox {

    public GehituView(
            AnimaliaController controller,
            Runnable onAnimaliaGehituta) {

        super(10);
        this.setPadding(new Insets(20));

        Label titulua = new Label("GEHITU ANIMALIA");

        TextField izena = new TextField();
        izena.setPromptText("Izena");

        TextField adina = new TextField();
        adina.setPromptText("Adina");

        TextField pisua = new TextField();
        pisua.setPromptText("Pisua");

        ComboBox<String> mota = new ComboBox<>();
        mota.getItems().addAll("Katua", "Txakurra", "Untxia");
        mota.setValue("Katua");

        Button gehitu = new Button("GEHITU");

        gehitu.setOnAction(e -> {
            try {
                String izenaText = izena.getText().trim();

                if (izenaText.isEmpty()
                        || adina.getText().trim().isEmpty()
                        || pisua.getText().trim().isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Abisua");
                    alert.setHeaderText(null);
                    alert.setContentText("Bete eremu guztiak.");
                    alert.showAndWait();
                    return;
                }

                int adinaText = Integer.parseInt(adina.getText().trim());

                double pisuaText = Double.parseDouble(
                        pisua.getText().trim().replace(",", ".")
                );

                if (adinaText < 0 || pisuaText <= 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Abisua");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Adinak ezin du negatiboa izan, eta pisuak zero baino handiagoa izan behar du."
                    );
                    alert.showAndWait();
                    return;
                }

                Animalia animalia;

                if (mota.getValue().equals("Katua")) {
                    animalia = new Katua(
                            izenaText, adinaText, pisuaText
                    );
                } else if (mota.getValue().equals("Txakurra")) {
                    animalia = new Txakurra(
                            izenaText, adinaText, pisuaText
                    );
                } else {
                    animalia = new Untxia(
                            izenaText, adinaText, pisuaText
                    );
                }

                controller.gehituAnimalia(animalia);

                izena.clear();
                adina.clear();
                pisua.clear();

                onAnimaliaGehituta.run();

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errorea");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Adina zenbaki osoa izan behar da, eta pisua zenbaki bat."
                );
                alert.showAndWait();
            }
        });

        this.getChildren().addAll(
                titulua, izena, adina, pisua, mota, gehitu
        );
    }
}
