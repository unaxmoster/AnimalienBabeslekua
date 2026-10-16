
package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.controller.AnimaliaController;
import org.example.model.Animalia;

public class AnimaliakView extends VBox {

    public AnimaliakView(AnimaliaController controller) {
        super(10);
        this.setPadding(new Insets(20));
        kargatuAnimaliak(controller);
    }

    public void kargatuAnimaliak(AnimaliaController controller) {
        this.getChildren().clear();

        Label titulua = new Label("ANIMALIAK");
        this.getChildren().add(titulua);

        for (Animalia animalia : controller.lortuAnimaliak()) {

            Label informacion = new Label(
                    animalia.getIzena()
                            + " | Adina: " + animalia.getAdina()
                            + " | Pisua: " + animalia.getPisua()
                            + " | Adoptatua: " + animalia.getAdoptatua()
            );

            Button soinua = new Button("SOINUA EGIN");
            Button ezabatu = new Button("EZABATU");
            Button adoptatu = new Button("ADOPTATU");

            soinua.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Soinua");
                alert.setHeaderText(animalia.getIzena());
                alert.setContentText(animalia.getSoinua());
                alert.showAndWait();
            });

            ezabatu.setOnAction(e -> {
                boolean ezabatuta =
                        controller.ezabatuAnimalia(animalia.getIzena());

                if (ezabatuta) {
                    kargatuAnimaliak(controller);
                } else {
                    erakutsiErrorea(
                            "Ezin izan da animalia ezabatu."
                    );
                }
            });

            adoptatu.setOnAction(e -> {
                boolean adoptatuta =
                        controller.adoptatuAnimalia(animalia.getIzena());

                if (adoptatuta) {
                    kargatuAnimaliak(controller);
                } else {
                    erakutsiErrorea(
                            "Ezin izan da animalia adoptatu."
                    );
                }
            });

            HBox animaliaLerroa = new HBox(10);
            animaliaLerroa.getChildren().addAll(
                    informacion, soinua, ezabatu, adoptatu
            );

            this.getChildren().add(animaliaLerroa);
        }
    }

    private void erakutsiErrorea(String mezua) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errorea");
        alert.setHeaderText(null);
        alert.setContentText(mezua);
        alert.showAndWait();
    }
}
