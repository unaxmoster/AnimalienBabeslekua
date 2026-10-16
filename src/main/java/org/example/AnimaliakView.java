package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AnimaliakView extends VBox {

    public AnimaliakView(Babeslekua babeslekua) {
        super(10);
        this.setPadding(new Insets(20));
        kargatuAnimaliak(babeslekua);
    }

    public void kargatuAnimaliak(Babeslekua babeslekua) {
        this.getChildren().clear();
        Label titulua = new Label("ANIMALIAK");
        this.getChildren().add(titulua);

        for (Animalia animalia : babeslekua.getAnimaliak()) {
            Label informacion = new Label(
                    animalia.getIzena() + " | Adina: " + animalia.getAdina() +
                            " | Pisua: " + animalia.getPisua() + " | Adoptatua: " + animalia.getAdoptatua()
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
                babeslekua.ezabatuAnimalia(animalia.getIzena());
                kargatuAnimaliak(babeslekua);
            });

            adoptatu.setOnAction(e -> {
                babeslekua.adoptatuAnimalia(animalia.getIzena());
                kargatuAnimaliak(babeslekua);
            });

            HBox animaliaLerroa = new HBox(10);
            animaliaLerroa.getChildren().addAll(informacion, soinua, ezabatu, adoptatu);
            this.getChildren().add(animaliaLerroa);
        }
    }
}