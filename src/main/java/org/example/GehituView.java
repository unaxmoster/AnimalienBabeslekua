package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GehituView extends VBox {

    public GehituView(Babeslekua babeslekua, Runnable onAnimaliaGehituta) {
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
                String izenaText = izena.getText();
                int adinaText = Integer.parseInt(adina.getText());
                double pisuaText = Double.parseDouble(pisua.getText().replace(",", "."));

                Animalia animalia;
                if (mota.getValue().equals("Katua")) {
                    animalia = new Katua(izenaText, adinaText, pisuaText);
                } else if (mota.getValue().equals("Txakurra")) {
                    animalia = new Txakurra(izenaText, adinaText, pisuaText);
                } else {
                    animalia = new Untxia(izenaText, adinaText, pisuaText);
                }

                babeslekua.gehituAnimalia(animalia);
                izena.clear();
                adina.clear();
                pisua.clear();

                onAnimaliaGehituta.run();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errorea");
                alert.setHeaderText(null);
                alert.setContentText("Adina eta pisua zenbakiak izan behar dira.");
                alert.showAndWait();
            }
        });

        this.getChildren().addAll(titulua, izena, adina, pisua, mota, gehitu);
    }
}